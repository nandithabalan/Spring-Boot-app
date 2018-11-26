package com.media.service.helper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.media.service.constant.Constants;
import com.media.service.dto.Credit;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.GenericResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.external.TMDBServiceDAO;

@Component
public class TMDBDetailsHelper extends GenericHelper {
	
	@Autowired
	TMDBServiceDAO tmdbServiceDAO;
	
	@Autowired
	Environment env;
	
	
	public MediaDetail getMovieDetails(String Id) {
		MediaDetail mediaDetail = new MediaDetail();
		if(isValidInput(mediaDetail, Id)) {
			GenericReqParameters reqParams = new GenericReqParameters();
			addPathParamForDetail(Constants.MOVIE_DETAIL, Constants.MOVIE_DETAIL_PATH,
					Constants.MOVIE_ID, Id, reqParams);
			mediaDetail = tmdbServiceDAO.getMovieDetails(reqParams);
		}
		return mediaDetail;
	}
	
	
	
	public TVDetail getTVDetails(String Id) {
		TVDetail tvDetail = new TVDetail();
		if(isValidInput(tvDetail, Id)) {
			GenericReqParameters reqParams = new GenericReqParameters();
			addPathParamForDetail(Constants.TV_DETAIL, Constants.TV_DETAIL_PATH,
					Constants.TV_ID, Id, reqParams);
			tvDetail = tmdbServiceDAO.getTVDetails(reqParams);
		}
		return tvDetail;
	}
	
	public Credit getCredits(String Id, String mediaType) {
		Credit credit = new Credit();
		GenericReqParameters reqParams = new GenericReqParameters();
		if(Constants.MOVIE_DETAIL.equals(mediaType)) {
			addPathParamForDetail(Constants.MOVIE_DETAIL, Constants.MOVIE_DETAIL_PATH,
					Constants.MOVIE_ID, Id, reqParams);
		} else {
			addPathParamForDetail(Constants.TV_DETAIL, Constants.TV_DETAIL_PATH,
					Constants.TV_ID, Id, reqParams);
		}
		reqParams.addPathParams(Constants.CREDITS, Constants.CREDITS);
		credit = tmdbServiceDAO.getCredits(reqParams);
		return credit;
	}
	
	
	public boolean isValidInput(GenericResponse resp, String Id) {
		boolean isValid = true;
		if(StringUtils.isBlank(Id)) {
			isValid = false;
			setValidationError(env.getProperty(Constants.ID_ERROR), resp);
		}
		return isValid;
	}
	
	

}
