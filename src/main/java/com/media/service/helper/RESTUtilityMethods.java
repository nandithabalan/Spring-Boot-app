package com.media.service.helper;



import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.media.service.constant.Constants;
import com.media.service.dto.GenericReqParameters;

@Component
public class RESTUtilityMethods {
	
	@Value( "${tmdb.url}" )
	private String baseUrl;
	
	@Value( "${tmdb.apiKey}" )
	private String apiKey;
	
	private Client client = ClientBuilder.newClient();
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public String buildUrl(GenericReqParameters reqParams) {
		StringBuilder urlString = new StringBuilder();
		urlString.append(baseUrl).append(appendPathParams(reqParams)).append
			(buildQueryParams(reqParams));
		return urlString.toString();
	}
	
	public String buildQueryParams(GenericReqParameters reqParams) {
		StringBuilder urlString = new StringBuilder();
		if(reqParams.getQueryParams() != null) {
			urlString.append(Constants.DELIM_ONE);
			urlString.append(Constants.API_KEY).append(Constants.DELIM_EQUALS).append(apiKey);
			reqParams.getQueryParams().forEach((k, v) -> {urlString.
				append(Constants.DELIM_TWO).append(k).append(Constants.DELIM_EQUALS).append(v);});
		}
		return urlString.toString();
	}
	
	public String appendPathParams(GenericReqParameters reqParams) {
		StringBuilder urlString = new StringBuilder();
		if(reqParams.getPathParams() != null) {
			reqParams.getPathParams().forEach((k, v) -> {urlString.
				append(Constants.FORWARD_SLASH).append(v);});
		}
		return urlString.toString();
	}
	
	public void addApiKey(GenericReqParameters reqParams) {
		reqParams.addQueryParams(Constants.API_KEY, apiKey);
	}
	
	
	public WebTarget getJerseyWebTarget(GenericReqParameters reqParams) {
		addApiKey(reqParams);
		Map<String, String> queryMap = reqParams.getQueryParams();
		WebTarget webTarget = client.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
	            .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "WARNING").target(baseUrl).path(appendPathParams(reqParams));
	    if (queryMap != null)
	        for (Map.Entry<String, String> entry: queryMap.entrySet())
	            webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
	    return webTarget;
	}
	
	
	public String getAPIKey() {
		String apiKey = "";
		return apiKey;
	}

}
