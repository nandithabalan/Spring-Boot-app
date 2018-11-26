package com.media.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaDetail extends MediaObj {
	
	private String budget;
	private String imdb_id;
	private String revenue;
	private String runtime;
	private String status;
	private String tagline;
	private List<Company> production_companies;
	private List<KeyValue> genres;
	private List<Language> spoken_languages;
	private List<Country> production_countries;
	
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public List<Company> getProduction_companies() {
		return production_companies;
	}
	public void setProduction_companies(List<Company> production_companies) {
		this.production_companies = production_companies;
	}
	public List<KeyValue> getGenres() {
		return genres;
	}
	public void setGenres(List<KeyValue> genres) {
		this.genres = genres;
	}
	public List<Language> getSpoken_languages() {
		return spoken_languages;
	}
	public void setSpoken_languages(List<Language> spoken_languages) {
		this.spoken_languages = spoken_languages;
	}
	public List<Country> getProduction_countries() {
		return production_countries;
	}
	public void setProduction_countries(List<Country> production_countries) {
		this.production_countries = production_countries;
	}
}
