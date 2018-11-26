package com.media.service.external;

import com.media.service.dto.Credit;
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;

public interface TMDBService {
	
	public GenericMediaSearchResponse searchMultiMedia(GenericSearchRequest searchReq);
	
	public MediaDetail getMovieDetails(String Id);
	
	public TVDetail getTVProgramDetails(String Id);
	
	public Credit getCredits(String Id, String mediaType);

}
