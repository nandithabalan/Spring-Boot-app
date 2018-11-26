package com.media.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit extends Response {
	
	private List<Person> cast;
	private List<Person> crew;
	public List<Person> getCast() {
		return cast;
	}
	public void setCast(List<Person> cast) {
		this.cast = cast;
	}
	public List<Person> getCrew() {
		return crew;
	}
	public void setCrew(List<Person> crew) {
		this.crew = crew;
	}
	
	

}
