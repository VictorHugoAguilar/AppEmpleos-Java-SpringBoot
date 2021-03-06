package com.app.empleos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${empleosapp.ruta.imagenes}")
	private String rutaImagenes;

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/logos/**").addResourceLocations("file:" + rutaImagenes).resourceChain(true)
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));

	}
}
