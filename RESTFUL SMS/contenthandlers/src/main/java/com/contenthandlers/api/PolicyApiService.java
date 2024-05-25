package com.contenthandlers.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import com.contenthandlers.dto.PolicyDto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.StreamingOutput;

@Path("/policy")
public class PolicyApiService {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/in")
	public byte[] addPolicy(InputStream in) throws IOException {
		int c = 0;
		StringBuffer buffer = new StringBuffer();
		while ((c = in.read()) != -1) {
			buffer.append((char) c);
		}
		return buffer.toString().getBytes();
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/reader")
	public String addPolicy(Reader reader) throws IOException {
		char[] buffer = new char[10];
		StringBuilder builder = new StringBuilder();

		while (reader.read(buffer) != -1) {
			builder.append(buffer);
		}
		return builder.toString();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/upload")
	public String addPolicy(File file) throws IOException {
		int c = 0;
		FileInputStream fis = new FileInputStream(file);
		StringBuilder builder = new StringBuilder();
		while ((c = fis.read()) != -1) {
			builder.append((char) c);
		}
		return builder.toString();
	}

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/{policyNo}/download")
	public File downloadPolicy(@PathParam("policyNo") int policyNo) {
		File policyFile = new File("D:\\transcripts\\jsp\\page-directive.txt");
		return policyFile;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPolicy(MultivaluedMap<String, String> formData) {
		StringBuffer buffer = new StringBuffer();

		for (String paramName : formData.keySet()) {
			buffer.append(paramName + ":" + formData.getFirst(paramName));
		}
		return buffer.toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{policyNo}/so")
	public StreamingOutput getPolicy(@PathParam("policyNo") String policyNo) {
		PolicyDto dto = new PolicyDto();
		// business logic and build policy object
		dto.setPolicyNo(policyNo);
		dto.setPlanName("Lifesaver Plan");
		dto.setPolicyHolderName("Mathew");
		dto.setTenure(23);
		dto.setPremiumAmount(23039);
		return new PolicyInfoStreamingOutput(dto);
	}

	private class PolicyInfoStreamingOutput implements StreamingOutput {
		private PolicyDto policy;

		public PolicyInfoStreamingOutput(PolicyDto policy) {
			this.policy = policy;
		}

		@Override
		public void write(OutputStream output) throws IOException, WebApplicationException {
			StringBuffer buffer = new StringBuffer();
			buffer.append("policyNo:").append(policy.getPolicyNo()).append(" planName:").append(policy.getPlanName())
					.append(" policyHolderName: ").append(policy.getPolicyHolderName()).append(" tenure:")
					.append(policy.getTenure()).append(" premiumAmount:").append(policy.getPremiumAmount());
			output.write(buffer.toString().getBytes());
			output.close();
		}

	}

}
