package com.media.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends KeyValue {
	
	private String logo_path;
	private String origin_country;
	
	
	public String getLogo_path() {
		return logo_path;
	}
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	public String getOrigin_country() {
		return origin_country;
	}
	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}
}
