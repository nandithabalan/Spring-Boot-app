package com.media.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.external.TMDBService;

@Path("/search")
public class MediaService {
	
	@Autowired
	TMDBService tmdbService;
	
	
	
	@Path("/multimedia")
	@POST
	@Produces("application/json")
	public Response genericSearch(GenericSearchRequest searchReq) {
		return Response.status(200).
                entity(tmdbService.searchMultiMedia(searchReq)).
                header("yourHeaderName", "yourHeaderValue").build();
	}
	
	@GET
	@Path("/movieDetails/{id}")
	@Produces("application/json")
	public Response getMovieDetails(@PathParam("id") final String identifier) {
		return Response.status(200).
                entity(tmdbService.getMovieDetails(identifier)).
               build();
	
	}
	
	@GET
	@Path("/tvDetails/{id}")
	@Produces("application/json")
	public Response getTVDetails(@PathParam("id") final String identifier) {
		return Response.status(200).
                entity(tmdbService.getTVProgramDetails(identifier)).
               build();
	}
	
	@GET
	@Path("/credits/{id}/{mediaType}")
	@Produces("application/json")
	public Response getCredits(@PathParam("id") final String identifier,
			@PathParam("mediaType") final String mediaType) {
		return Response.status(200).
                entity(tmdbService.getCredits(identifier, mediaType)).
               build();
	}
	
	

}
