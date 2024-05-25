package com.ecommerce.resources;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ecommerce.bean.Merchant;
import com.ecommerce.dto.NewMerchantRequest;
import com.ecommerce.dto.NewMerchantResponse;
import com.ecommerce.dto.UpdateMerchantRequest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/merchant")
public class MerchantResource {
	private static Map<Integer, Merchant> merchantMap = new ConcurrentHashMap<>(); // in-memory database

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String newMerchant(InputStream in) throws ParserConfigurationException, SAXException, IOException {
		NewMerchantRequest newMerchantRequest = null;
		NewMerchantResponse merchantResponse = null;
		Merchant merchant = null;

		newMerchantRequest = buildNewMerchantRequestFromInputStream(in);
		merchant = Merchant.builder().businessName(newMerchantRequest.getBusinessName())
				.businessType(newMerchantRequest.getBusinessType()).contactNo(newMerchantRequest.getContactNo())
				.establishedDate(newMerchantRequest.getEstablishedDate()).licenseNo(newMerchantRequest.getLicenseNo())
				.registeredOwnerName(newMerchantRequest.getRegisteredOwnerName())
				.contactNo(newMerchantRequest.getContactNo()).openedDate(LocalDate.now()).status("Active")
				.merchantAccountNo(new SecureRandom().nextInt(100000)).build();
		merchantMap.put(merchant.getMerchantAccountNo(), merchant);

		merchantResponse = NewMerchantResponse.builder().merchantAccountNo(merchant.getMerchantAccountNo())
				.openedDate(merchant.getOpenedDate()).status(merchant.getStatus()).build();

		return buildXmlFromNewMerchantResponse(merchantResponse);
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getMerchant(@QueryParam("accountNo") int merchantAccountNo) {
		Merchant merchant = null;

		if (merchantMap.containsKey(merchantAccountNo) == false) {
			throw new NotFoundException("accountNo not found");
		}
		merchant = merchantMap.get(merchantAccountNo);
		return buildXmlFromMerchant(merchant);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateMerchant(InputStream in) throws SAXException, IOException, ParserConfigurationException {
		UpdateMerchantRequest updateMerchantRequest = null;
		Merchant merchant = null;

		updateMerchantRequest = buildUpdateMerchantRequestFromInputStream(in);

		if (merchantMap.containsKey(updateMerchantRequest.getMerchantAccountNo()) == false) {
			throw new NotFoundException("merchant account no not found");
		}
		merchant = merchantMap.get(updateMerchantRequest.getMerchantAccountNo());

		if (updateMerchantRequest.getBusinessName() != null) {
			merchant.setBusinessName(updateMerchantRequest.getBusinessName());
		}
		if (updateMerchantRequest.getContactNo() != null) {
			merchant.setContactNo(updateMerchantRequest.getContactNo());
		}
		if (updateMerchantRequest.getRegisteredOwnerName() != null) {
			merchant.setRegisteredOwnerName(updateMerchantRequest.getRegisteredOwnerName());
		}
		return UUID.randomUUID().toString().substring(0, 7);
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String closeMerchant(@QueryParam("accountNo") int merchantAccountNo) {
		if (merchantMap.containsKey(merchantAccountNo) == false) {
			throw new NotFoundException("merchant account no not found");
		}
		merchantMap.remove(merchantAccountNo);
		return UUID.randomUUID().toString().substring(0, 7);
	}

	private NewMerchantRequest buildNewMerchantRequestFromInputStream(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		NewMerchantRequest request = null;
		NodeList children = null;
		Node rootNode = null;
		Document doc = null;
		String nodeValue = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		doc = documentBuilder.parse(in);

		rootNode = doc.getFirstChild();
		children = rootNode.getChildNodes();

		request = new NewMerchantRequest();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			String nodeName = child.getNodeName();
			if (child.hasChildNodes() == true) {
				nodeValue = child.getFirstChild().getNodeValue();
			}

			if (nodeName.equals("business-name")) {
				request.setBusinessName(nodeValue);
			} else if (nodeName.equals("established-date")) {
				request.setEstablishedDate(LocalDate.parse(nodeValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			} else if (nodeName.equals("business-type")) {
				request.setBusinessType(nodeValue);
			} else if (nodeName.equals("registered-owner-name")) {
				request.setRegisteredOwnerName(nodeValue);
			} else if (nodeName.equals("license-no")) {
				request.setLicenseNo(nodeValue);
			} else if (nodeName.equals("contact-no")) {
				request.setContactNo(nodeValue);
			}
		}

		return request;
	}

	private UpdateMerchantRequest buildUpdateMerchantRequestFromInputStream(InputStream in)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory documentBuilderFactory = null;
		UpdateMerchantRequest updateMerchantRequest = null;
		DocumentBuilder documentBuilder = null;
		Document doc = null;
		Node rootNode = null;
		NodeList children = null;
		String nodeValue = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		doc = documentBuilder.parse(in);
		rootNode = doc.getFirstChild();
		children = rootNode.getChildNodes();
		updateMerchantRequest = new UpdateMerchantRequest();

		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			String nodeName = child.getNodeName();
			if (child.hasChildNodes()) {
				nodeValue = child.getFirstChild().getNodeValue();
			}

			if (nodeName.equals("merchant-account-no")) {
				updateMerchantRequest.setMerchantAccountNo(Integer.parseInt(nodeValue));
			} else if (nodeName.equals("business-name")) {
				updateMerchantRequest.setBusinessName(nodeValue);
			} else if (nodeName.equals("registered-owner-name")) {
				updateMerchantRequest.setRegisteredOwnerName(nodeValue);
			} else if (nodeName.equals("contact-no")) {
				updateMerchantRequest.setContactNo(nodeValue);
			}
		}

		return updateMerchantRequest;
	}

	private String buildXmlFromNewMerchantResponse(NewMerchantResponse newMerchantResponse) {
		StringBuilder builder = new StringBuilder();
		builder.append("<merchant-details><merchant-account-no>").append(newMerchantResponse.getMerchantAccountNo())
				.append("</merchant-account-no><opened-date>")
				.append(newMerchantResponse.getOpenedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
				.append("</opened-date><status>").append(newMerchantResponse.getStatus())
				.append("</status></merchant-details>");
		return builder.toString();
	}

	private String buildXmlFromMerchant(Merchant merchant) {
		StringBuilder builder = new StringBuilder();

		builder.append("<merchant><merchant-account-no>").append(merchant.getMerchantAccountNo())
				.append("</merchant-account-no><business-name>").append(merchant.getBusinessName())
				.append("</business-name><established-date>")
				.append(merchant.getEstablishedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
				.append("</established-date><registered-owner-name>").append(merchant.getRegisteredOwnerName())
				.append("</registered-owner-name><business-type>").append(merchant.getBusinessType())
				.append("</business-type><license-no>").append(merchant.getLicenseNo())
				.append("</license-no><opened-date>")
				.append(merchant.getOpenedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
				.append("</opened-date><contact-no>").append(merchant.getContactNo()).append("</contact-no><status>")
				.append(merchant.getStatus()).append("</status></merchant>");

		return builder.toString();
	}
}
