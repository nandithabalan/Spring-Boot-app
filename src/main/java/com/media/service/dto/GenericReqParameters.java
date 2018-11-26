package com.media.service.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GenericReqParameters {
	
	private Map<String, String> queryParams = null;
	private Map<String, String> pathParams = null;
	
	
	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}

	public Map<String, String> getPathParams() {
		return pathParams;
	}

	public void setPathParams(Map<String, String> pathParams) {
		this.pathParams = pathParams;
	}

	public Map<String, String> addQueryParams(String key, String value) {
		if(queryParams == null) {
			queryParams = new HashMap<String, String>();
		} 
		queryParams.put(key, value);
		return queryParams;
	}
	
	public Map<String, String> addPathParams(String key, String value) {
		if(pathParams == null) {
			pathParams = new LinkedHashMap<String, String>();
		}
		pathParams.put(key, value);
		return pathParams;
	}

}
