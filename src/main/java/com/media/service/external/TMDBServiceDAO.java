package com.media.service.external;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.media.service.dto.Credit;
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.exception.ExceptionHandler;
import com.media.service.helper.RESTUtilityMethods;



@Service
public class TMDBServiceDAO {
	
	private  Logger logger = Logger.getLogger(TMDBServiceDAO.class.getName());

	
	@Autowired
	RESTUtilityMethods restMethods;
	
    
	
	public GenericMediaSearchResponse genericSeach(GenericReqParameters reqParams) {
		GenericMediaSearchResponse genericSearchResp = null;
		try {
			genericSearchResp = restMethods.getJerseyWebTarget(reqParams).
			request(MediaType.APPLICATION_JSON).get(GenericMediaSearchResponse.class);
		}catch(WebApplicationException wa) {
			logger.log(Level.SEVERE, wa.getMessage(), wa.getCause());
			genericSearchResp = new GenericMediaSearchResponse();
			ExceptionHandler.handleBackEndException(wa, genericSearchResp);
		}
		return genericSearchResp;	
	}
	
	public MediaDetail getMovieDetails(GenericReqParameters reqParams) {
		MediaDetail mediaDtl = null;
		try {
			mediaDtl = restMethods.getJerseyWebTarget(reqParams).
			request(MediaType.APPLICATION_JSON).get(MediaDetail.class);
		}catch(WebApplicationException wa) {
			logger.log(Level.SEVERE, wa.getMessage(), wa.getCause());
			mediaDtl = new MediaDetail();
			ExceptionHandler.handleBackEndException(wa, mediaDtl);
		}
		return mediaDtl;	
	}
	
	public TVDetail getTVDetails(GenericReqParameters reqParams) {
		TVDetail tvDetail = null;
		try {
			tvDetail =  restMethods.getJerseyWebTarget(reqParams).
					request(MediaType.APPLICATION_JSON).get(TVDetail.class);
		}catch(WebApplicationException wa) {
			logger.log(Level.SEVERE, wa.getMessage(), wa.getCause());
			tvDetail = new TVDetail();
			ExceptionHandler.handleBackEndException(wa, tvDetail);
		}
		return tvDetail;
		
	}
	
	public Credit getCredits(GenericReqParameters reqParams) {
		Credit credit = null;
		try {
			credit =  restMethods.getJerseyWebTarget(reqParams).
					request(MediaType.APPLICATION_JSON).get(Credit.class);
		}catch(WebApplicationException wa) {
			logger.log(Level.SEVERE, wa.getMessage(), wa.getCause());
			credit = new Credit();
			ExceptionHandler.handleBackEndException(wa, credit);
		}
		return credit;
		
	}
	
	
	
	

}
