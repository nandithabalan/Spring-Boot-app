package com.media.service.helper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.media.service.constant.Constants;
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.GenericResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.external.TMDBServiceDAO;


/*
 * This class is used for all generic search methods like searching for person, 
 * TV programs and movies
 */
@Component
public class TMDBGenericSearchHelper extends GenericHelper {
	
	@Autowired
	TMDBServiceDAO tmdbServiceDAO;
	
	@Autowired
	private Environment env;
		
	
	
	public GenericMediaSearchResponse genericSearch(GenericSearchRequest searchReq) {
		GenericMediaSearchResponse response = new GenericMediaSearchResponse();
		if(validateSearchKey(searchReq, response)) {
			GenericReqParameters reqParams = new GenericReqParameters();
			buildReqParamObj(searchReq, reqParams);
			buildPathParamObj(reqParams);
			response = tmdbServiceDAO.genericSeach(reqParams);
		} 
		return response;
	}
	
	public boolean validateSearchKey(GenericSearchRequest searchReq, 
			GenericResponse response) {
		boolean isValid = true;
		if(StringUtils.isBlank(searchReq.getSearchKey())) {
			isValid = false;
			setValidationError(env.getProperty(Constants.SEARCH_KEY_ERROR), response);
		}
		return isValid;
	}
	
	private void buildReqParamObj(GenericSearchRequest searchReq, GenericReqParameters reqParams) {
		reqParams.addQueryParams(Constants.SEARCH_KEY, searchReq.getSearchKey());
		if(StringUtils.isNotBlank(searchReq.getLanguage())) {
			reqParams.addQueryParams(Constants.LANGUAGE, searchReq.getLanguage());
		}
		if(searchReq.getPage() != null) {
			reqParams.addQueryParams(Constants.PAGE, searchReq.getPage());
		}
	}
	
	private void buildPathParamObj(GenericReqParameters reqParams) {
		reqParams.addPathParams(Constants.GENERIC_SEARCH, Constants.GENERIC_SEARCH_PATH);
	}
	
	

}
