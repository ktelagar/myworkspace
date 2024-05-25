package com.jaxrsinjection.uriinfo.api;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.PathSegment;
import jakarta.ws.rs.core.UriInfo;

@Path("/cab")
public class CabApiService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{source}/{destination}/available")
	public String getAvailableCabs(@Context UriInfo uriInfo) {
		StringBuilder builder = null;
		List<PathSegment> pathSegments = null;

		builder = new StringBuilder();
		pathSegments = uriInfo.getPathSegments();

		for (PathSegment pathSegment : pathSegments) {
			builder.append("/").append(pathSegment.getPath());
			MultivaluedMap<String, String> matrixParameters = pathSegment.getMatrixParameters();
			builder.append(extractMultiValuedMap(matrixParameters, ";"));
		}
		MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
		builder.append("?").append(extractMultiValuedMap(queryParameters, "&"));

		return builder.toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{source}/{destination}/estimate")
	public String getEstimatedTripAmount(@PathParam("source") String source,
			@PathParam("destination") String destination, @Context HttpHeaders httpHeaders) {
		StringBuilder builder = new StringBuilder();
		builder.append(source).append("/").append(destination);
		MultivaluedMap<String, String> headers = httpHeaders.getRequestHeaders();
		builder.append("headers : ").append(extractMultiValuedMap(headers, ";"));
		return builder.toString();

	}

	private String extractMultiValuedMap(MultivaluedMap<String, String> multivaluedMap, String separator) {
		StringBuilder builder = new StringBuilder();
		for (String paramName : multivaluedMap.keySet()) {
			List<String> paramValues = multivaluedMap.get(paramName);
			builder.append(separator).append(paramName).append("=")
					.append(paramValues.stream().collect(Collectors.joining(",")));
		}

		return builder.toString();
	}
}
