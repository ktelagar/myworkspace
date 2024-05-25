package com.restfulcache.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.restfulcache.dto.Account;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.EntityTag;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/account")
public class AccountApiService {
	private static Map<String, Account> accountDbMap = new ConcurrentHashMap<>();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newAccount(Account account) throws URISyntaxException {
		String accountNo = null;

		accountNo = UUID.randomUUID().toString().substring(0, 12).replace("-", "0");
		account.setAccountNo(accountNo);
		accountDbMap.put(accountNo, account);
		return Response.created(new URI("account/" + accountNo + "/details")).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{accountNo}/details")
	public Response getAccount(@PathParam("accountNo") String accountNo, Request request) {
		Account account = null;
		Response response = null;
		EntityTag entityTag = null;
		CacheControl cacheControl = null;

		System.out.println("account no: " + accountNo);
		if (accountDbMap.containsKey(accountNo) == false) {
			throw new NotFoundException("no resource found with accountNo:" + accountNo);
		}
		account = accountDbMap.get(accountNo);
		entityTag = new EntityTag(String.valueOf(account.hashCode()));

		ResponseBuilder builder = request.evaluatePreconditions(entityTag);
		if (builder != null) {
			return builder.build();
		}

		cacheControl = new CacheControl();
		cacheControl.setMaxAge(1000 * 60);

		response = Response.ok(account).cacheControl(cacheControl).tag(entityTag).build();

		return response;
	}

	@PUT
	@Path("/{accountNo}/{amount}/deposite")
	public Response deposite(@PathParam("accountNo") String accountNo, @PathParam("amount") double amount) {
		Response response = null;
		Account account = null;
		if (accountDbMap.containsKey(accountNo) == false) {
			throw new NotFoundException("no resource found with accountNo:" + accountNo);
		}
		account = accountDbMap.get(accountNo);
		account.setBalance(account.getBalance() + amount);
		return Response.noContent().build();
	}

}
