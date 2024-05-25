package com.wwac.api;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.wwac.dto.Account;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public abstract class AccountApiService {
	private Map<String, Account> accountMap;

	public AccountApiService() {
		accountMap = new HashMap<>();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String openAccount(InputStream in) throws Throwable {
		String accountNo = null;
		Account account = null;

		account = buildAccount(in);
		accountNo = UUID.randomUUID().toString().substring(0, 8);
		account.setAccountNo(accountNo);
		accountMap.put(accountNo, account);

		return accountNo;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{accountNo}/details")
	public String getAccount(@PathParam("accountNo") String accountNo) {
		Account account = null;

		if (accountMap.containsKey(accountNo) == false) {
			throw new NotFoundException();
		}
		account = accountMap.get(accountNo);
		return toAccount(account);
	}

	abstract protected Account buildAccount(InputStream in) throws Throwable;

	abstract protected String toAccount(Account account);
}
