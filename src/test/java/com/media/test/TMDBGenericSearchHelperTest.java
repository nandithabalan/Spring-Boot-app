package com.media.test;

import static org.junit.Assert.assertThat;

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
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.external.TMDBServiceDAO;
import com.media.service.helper.TMDBGenericSearchHelper;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TMDBGenericSearchHelperTest {
	
	@Mock TMDBServiceDAO tmdbServiceDAOMock;
	
	@Mock Environment env;
	
	@InjectMocks private TMDBGenericSearchHelper tmdbSearchHelper;
	
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private String search_error = "Mandatory field search query not provided";
	
	@Test
	public void testGenericSearchPositive() {
		 when(tmdbServiceDAOMock.genericSeach(Mockito.any(GenericReqParameters.class))).
		 thenReturn(new GenericMediaSearchResponse());
		 GenericMediaSearchResponse genResp = tmdbSearchHelper.genericSearch(createValidSearchReq());
		 verify(tmdbServiceDAOMock).genericSeach(Mockito.any(GenericReqParameters.class));
		 assertThat(genResp,is(notNullValue()));
	}
	
	@Test
	public void testGenericSearchNegative() {
		when(env.getProperty(Constants.SEARCH_KEY_ERROR)).thenReturn(search_error);
		GenericMediaSearchResponse genResp = tmdbSearchHelper.genericSearch(createInvalidSearchReq());
		assertThat(genResp.getHttpStatus(), is(Constants.APP_ERR_400));
	}
	
	private GenericSearchRequest createValidSearchReq() {
		GenericSearchRequest genSearchReq = new GenericSearchRequest();
		genSearchReq.setSearchKey("Har");
		return genSearchReq;
	}
	
	private GenericSearchRequest createInvalidSearchReq() {
		GenericSearchRequest genSearchReq = new GenericSearchRequest();
		genSearchReq.setSearchKey(null);
		return genSearchReq;
	}

}
