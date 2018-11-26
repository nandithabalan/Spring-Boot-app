package com.media.service.dto;

public class GenericSearchRequest {
	
	private String searchKey;
	private String page;
	private String language;
	private boolean includeAdult;
	
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isIncludeAdult() {
		return includeAdult;
	}
	public void setIncludeAdult(boolean includeAdult) {
		this.includeAdult = includeAdult;
	}
}
