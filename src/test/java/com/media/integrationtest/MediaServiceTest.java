package com.media.integrationtest;


import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.media.MediaAppJerseyConfig;
import com.media.service.MediaService;
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;

public class MediaServiceTest  extends JerseyTest {
	
	private String searchPath = "search/multimedia";
	private String movieDetailPath = "search/movieDetails/984";
	private String tvDetailPath = "search/tvDetails/60585";
	
	@Override
    protected Application configure() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        return new MediaAppJerseyConfig().property("contextConfig",
                context);
    }
 	
 	@Test
 	public void testGenericSearch() {
 		GenericSearchRequest genSearch =  genericSearchRequest();
 		Response response = target(searchPath).request(MediaType.APPLICATION_JSON_TYPE)
 		        .post(Entity.entity(genSearch, MediaType.APPLICATION_JSON_TYPE));
 		GenericMediaSearchResponse genResp = response.readEntity(GenericMediaSearchResponse.class);
 		assertNotNull(genResp.getResults());
 	}
 	
 	@Test
 	public void testGetMovieDetails() {
 		MediaDetail movieDetail = target(movieDetailPath).request(MediaType.APPLICATION_JSON_TYPE)
 		        .get(MediaDetail.class);
 		assertNotNull(movieDetail);
 	}
 	
 	@Test
 	public void testGetTVDetails() {
 		TVDetail tvDetail = target(tvDetailPath).request(MediaType.APPLICATION_JSON_TYPE)
 		        .get(TVDetail.class);
 		assertNotNull(tvDetail);
 		
 	}
 	
 	private GenericSearchRequest genericSearchRequest() {
 		GenericSearchRequest genSearch = new GenericSearchRequest();
 		genSearch.setSearchKey("Har");
 		genSearch.setPage("1");
 		return genSearch;
 	}
}
