package com.media.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import com.media.service.constant.Constants;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.external.TMDBServiceDAO;
import com.media.service.helper.TMDBDetailsHelper;

@RunWith(MockitoJUnitRunner.class)
public class TMDBDetailsHelperTest {
	
	@Mock TMDBServiceDAO tmdbServiceDAOMock;
	
	@InjectMocks private TMDBDetailsHelper tmdbDetailsHelper;
	
	@Mock Environment env;
	
	private String id_error = "Mandatory field Id not provided";
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGetMovieDetailsPositive() {
		 when(tmdbServiceDAOMock.getMovieDetails(Mockito.any(GenericReqParameters.class))).
		 thenReturn(new MediaDetail());
		 MediaDetail media = tmdbDetailsHelper.getMovieDetails("234");
		 verify(tmdbServiceDAOMock).getMovieDetails(Mockito.
				 any(GenericReqParameters.class));
		 assertThat(media, is(notNullValue()));
	}
	
	
	@Test 
	public void testGetTVDetailsPositive() {
		when(tmdbServiceDAOMock.getTVDetails(Mockito.any(GenericReqParameters.class))).
		 thenReturn(new TVDetail());
		TVDetail tvDetail = tmdbDetailsHelper.getTVDetails("345");
		verify(tmdbServiceDAOMock).getTVDetails(Mockito.
				 any(GenericReqParameters.class));
		 assertThat(tvDetail, is(notNullValue()));
	}
	
	@Test
	public void testGetMovieDetailsNegative() {
		 when(env.getProperty(Constants.ID_ERROR)).thenReturn(id_error);
		 String blanKVal = null;
		 MediaDetail media = tmdbDetailsHelper.getMovieDetails(blanKVal);
		 assertThat(media.getHttpStatus(), is(400));
	}
	
	@Test
	public void testGetTVDetailsNegative() {
		when(env.getProperty(Constants.ID_ERROR)).thenReturn(id_error);
		String blanKVal = null;
		TVDetail tvDetail = tmdbDetailsHelper.getTVDetails(blanKVal);
		assertThat(tvDetail.getHttpStatus(), is(400));
	}
	
	
	
	

}
