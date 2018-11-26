package com.media.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericMediaSearchResponse extends Response {
	
	private List<MediaObj> results;

	public List<MediaObj> getResults() {
		return results;
	}

	public void setResults(List<MediaObj> results) {
		this.results = results;
	}
}
