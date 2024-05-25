package com.wwac.api;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.wwac.dto.Account;

import jakarta.ws.rs.Path;

@Path("/xml/account")
public class AccountXMLApiService extends AccountApiService {

	@Override
	protected Account buildAccount(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		Account account = null;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document doc = builder.parse(in);
		Node rootNode = doc.getFirstChild();
		NodeList children = rootNode.getChildNodes();
		account = new Account();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = node.getNodeName();
				String nodeValue = node.getFirstChild().getNodeValue();

				if (nodeName.equals("accountHolderName")) {
					account.setAccountHolderName(nodeValue);
				} else if (nodeName.equals("accountType")) {
					account.setAccountType(nodeValue);
				} else if (nodeName.equals("balance")) {
					account.setBalance(Double.parseDouble(nodeValue));
				} else if (nodeName.equals("mobileNo")) {
					account.setMobileNo(nodeValue);
				}
			}
		}
		return account;
	}

	@Override
	protected String toAccount(Account account) {
		return "<account><accountNo>" + account.getAccountNo() + "</accountNo><accountHolderName>"
				+ account.getAccountHolderName() + "</accountHolderName><mobileNo>" + account.getMobileNo()
				+ "</mobileNo><balance>" + account.getBalance() + "</balance></account>";
	}

}
