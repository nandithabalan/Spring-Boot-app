package com.media.service.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media.service.dto.Credit;
import com.media.service.dto.GenericMediaSearchResponse;
import com.media.service.dto.GenericSearchRequest;
import com.media.service.dto.MediaDetail;
import com.media.service.dto.TVDetail;
import com.media.service.helper.TMDBDetailsHelper;
import com.media.service.helper.TMDBGenericSearchHelper;

@Service
public class TMDBServiceImpl implements TMDBService {
	
	
	@Autowired
	TMDBGenericSearchHelper tmdbHelper;
	
	@Autowired
	TMDBDetailsHelper tmdbDetailHelper;

	@Override
	public GenericMediaSearchResponse searchMultiMedia(GenericSearchRequest searchReq) {
		 return tmdbHelper.genericSearch(searchReq);
	}

	@Override
	public MediaDetail getMovieDetails(String Id) {
		return tmdbDetailHelper.getMovieDetails(Id);
	}

	@Override
	public TVDetail getTVProgramDetails(String Id) {
		return tmdbDetailHelper.getTVDetails(Id);
	}
	
	@Override
	public Credit getCredits(String Id, String mediaType) {
		return tmdbDetailHelper.getCredits(Id, mediaType);
	}

}
