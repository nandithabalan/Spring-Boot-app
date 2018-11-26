package com.media.service.helper;

import com.media.service.constant.Constants;
import com.media.service.dto.GenericReqParameters;
import com.media.service.dto.GenericResponse;

public class GenericHelper {
	
	public void setValidationError(String errorMessage, GenericResponse genResp) {
		genResp.setHttpStatus(Constants.APP_ERR_400);
		genResp.setErrorMessage(errorMessage);
	}
	
	public void addPathParamForDetail(String pathKey, String pathVal, 
			String mediaKey, String mediaVal, 
			GenericReqParameters reqParams) {
		reqParams.addPathParams(pathKey, pathVal);
		reqParams.addPathParams(mediaKey, mediaVal);
	}

}
