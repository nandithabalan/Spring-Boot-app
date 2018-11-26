package com.media.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.external.TMDBServiceDAO;
import com.media.service.helper.RESTUtilityMethods;

@RunWith(MockitoJUnitRunner.class)
public class TMDBServiceDAOTest {
	
	@Mock RESTUtilityMethods restMethodsMock;
	
	@InjectMocks private TMDBServiceDAO tmdbServiceDAO;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGenericSearchPositive() {
		 Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(GenericMediaSearchResponse.class)).
		 thenReturn(new GenericMediaSearchResponse());
		 GenericMediaSearchResponse genResp = tmdbServiceDAO.genericSeach(new GenericReqParameters());
		 assertThat(genResp,is(notNullValue()));
	}
	
	@Test
	public void testGetMovieDetailsPositive() {
		Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(MediaDetail.class)).
		 thenReturn(new MediaDetail());
		 MediaDetail mediaDetail = tmdbServiceDAO.getMovieDetails(new GenericReqParameters());
		 assertThat(mediaDetail,is(notNullValue()));
	}
	
	@Test
	public void testGetTVDetailsPositive() {
		Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(TVDetail.class)).
		 thenReturn(new TVDetail());
		 TVDetail tvDetail = tmdbServiceDAO.getTVDetails(new GenericReqParameters());
		 assertThat(tvDetail,is(notNullValue()));
	}
	
	@Test
	public void testGenericSearchNegative() {
		Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(GenericMediaSearchResponse.class)).
		 thenThrow(new WebApplicationException(getErrorResponse()));
		 GenericMediaSearchResponse genResp = tmdbServiceDAO.genericSeach(new GenericReqParameters());
		 assertThat(genResp.getHttpStatus(),is(500));
	}
	
	@Test
	public void testGetMovieDetailsNegative() {
		Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(MediaDetail.class)).
		 thenThrow(new WebApplicationException(getErrorResponse()));
		 MediaDetail genResp = tmdbServiceDAO.getMovieDetails(new GenericReqParameters());
		 assertThat(genResp.getHttpStatus(),is(500));
	}
	
	@Test
	public void testGetTVDetailsNegative() {
		Invocation.Builder builder =  Mockito.mock(Invocation.Builder.class);
		 WebTarget target =  Mockito.mock(WebTarget.class);
		 when(restMethodsMock.getJerseyWebTarget(Mockito.any(GenericReqParameters.class))).
		 thenReturn(target);
		 when(target.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
		 when(builder.get(TVDetail.class)).
		 thenThrow(new WebApplicationException(getErrorResponse()));
		 TVDetail genResp = tmdbServiceDAO.getTVDetails(new GenericReqParameters());
		 assertThat(genResp.getHttpStatus(),is(500));
	}
	
	private Response getErrorResponse() {
		return Response.status(500).entity("error").build();
	}
	
	

}
