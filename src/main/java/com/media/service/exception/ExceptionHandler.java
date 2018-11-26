package com.media.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.media.service.constant.Constants;
import com.media.service.dto.GenericResponse;

public class ExceptionHandler {
	
	public static void handleBackEndException(WebApplicationException wa, GenericResponse genResponse) {
		Response resp = wa.getResponse();
		if(resp != null) {
			genResponse.setHttpStatus(resp.getStatus());
			genResponse.setErrorMessage(resp.getStatusInfo() != null?
					resp.getStatusInfo().getReasonPhrase() : Constants.APPLICATION_ERROR);
		} else {
			genResponse.setHttpStatus(Constants.APP_ERR_500);
			genResponse.setErrorMessage(Constants.APPLICATION_ERROR);
		}
	}

}
