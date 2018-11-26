package com.media.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TVDetail extends MediaObj {
	
	private String first_air_date;
	private List<String> languages;
	private Episode last_episode_to_air;
	private String name;
	private String next_episode_to_air;
	private List<Company> networks;
	private String number_of_episodes;
	private String number_of_seasons;
	private List<Company> production_companies;
	private List<Episode> seasons;
	private String status;
	private String type;
	private String homepage;
	
	public String getFirst_air_date() {
		return first_air_date;
	}
	public void setFirst_air_date(String first_air_date) {
		this.first_air_date = first_air_date;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public Episode getLast_episode_to_air() {
		return last_episode_to_air;
	}
	public void setLast_episode_to_air(Episode last_episode_to_air) {
		this.last_episode_to_air = last_episode_to_air;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNext_episode_to_air() {
		return next_episode_to_air;
	}
	public void setNext_episode_to_air(String next_episode_to_air) {
		this.next_episode_to_air = next_episode_to_air;
	}
	public List<Company> getNetworks() {
		return networks;
	}
	public void setNetworks(List<Company> networks) {
		this.networks = networks;
	}
	public String getNumber_of_episodes() {
		return number_of_episodes;
	}
	public void setNumber_of_episodes(String number_of_episodes) {
		this.number_of_episodes = number_of_episodes;
	}
	public String getNumber_of_seasons() {
		return number_of_seasons;
	}
	public void setNumber_of_seasons(String number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
	}
	public List<Company> getProduction_companies() {
		return production_companies;
	}
	public void setProduction_companies(List<Company> production_companies) {
		this.production_companies = production_companies;
	}
	public List<Episode> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<Episode> seasons) {
		this.seasons = seasons;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

}
