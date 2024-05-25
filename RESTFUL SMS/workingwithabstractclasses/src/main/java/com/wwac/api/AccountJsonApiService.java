package com.wwac.api;

import java.io.InputStream;

import com.wwac.dto.Account;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import jakarta.ws.rs.Path;

@Path("/json/account")
public class AccountJsonApiService extends AccountApiService {

	@Override
	protected Account buildAccount(InputStream in) throws Throwable {
		Account account = null;
		JsonParser jsonParser = Json.createParser(in);
		if (jsonParser.hasNext()) {
			jsonParser.next();
			JsonObject jsonObject = jsonParser.getObject();
			account = new Account();
			account.setAccountHolderName(jsonObject.getString("accountHolderName"));
			account.setMobileNo(jsonObject.getString("mobileNo"));
			account.setAccountType(jsonObject.getString("accountType"));
			account.setBalance(jsonObject.getJsonNumber("balance").doubleValue());
		}

		return account;
	}

	@Override
	protected String toAccount(Account account) {
		return "{'accountNo':'" + account.getAccountNo() + "', 'accountHolderName':'" + account.getAccountHolderName()
				+ "', 'mobileNo':'" + account.getMobileNo() + "', 'balance':'" + account.getBalance() + "'}";
	}

}
