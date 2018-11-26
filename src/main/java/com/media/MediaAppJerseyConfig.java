package com.media;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.media.service.CORSFilter;
import com.media.service.MediaService;

@Configuration
@ApplicationPath("/media")
public class MediaAppJerseyConfig extends ResourceConfig {
	
	
	public MediaAppJerseyConfig() {
		register(CORSFilter.class);
		register(MediaService.class);
		register(LoggingFeature.class);
    }


}
