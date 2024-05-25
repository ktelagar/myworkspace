package com.bankingservice.api;

import java.io.InputStream;
import java.util.UUID;

import com.bankingservice.dto.AccountDetailsDto;
import com.bankingservice.dto.OpenAccountDto;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.StreamingOutput;

@Path("/account")
public class AccountApiService {

	@POST
	@Path("/new")
	public StreamingOutput openAccount(InputStream in) {
		OpenAccountDto openAccountDto = null;
		
		final AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
		final Jsonb jsonb = JsonbBuilder.create();
		openAccountDto = jsonb.fromJson(in, OpenAccountDto.class);

		// perform operation in creating the account
		accountDetailsDto.setAccountNo(UUID.randomUUID().toString().substring(0, 10).replaceAll("-", "8"));
		accountDetailsDto.setAccountHolderName(openAccountDto.getFirstName() + " " + openAccountDto.getLastName());
		accountDetailsDto.setAccountType("savings");
		accountDetailsDto.setBranch("Ameerpet");
		accountDetailsDto.setIfscCode("icic00000040");
		accountDetailsDto.setRegisteredEmailAddress(openAccountDto.getEmailAddress());
		accountDetailsDto.setRegisteredMobileNo(openAccountDto.getMobileNo());
		accountDetailsDto.setBalance(1000);
		accountDetailsDto.setStatus("Active");

		return (out) -> {
			jsonb.toJson(accountDetailsDto, out);
			out.close();
		};
	}
}
