package com.example.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
@ConfigurationProperties(prefix = "sandboxbbapi")
public class ApiFactoryProperties {

	private String uriBase;
	private String chaveGwDevApp;

	public ApiFactoryProperties() {
	}

	public ApiFactoryProperties(String uriBase, String chaveGwDevApp) {
		this.uriBase = uriBase;
		this.chaveGwDevApp = chaveGwDevApp;
	}

	public String getUriBase() {
		return uriBase;
	}

	public String getChaveGwDevApp() {
		return chaveGwDevApp;
	}

	public void setUriBase(String uriBase) {
		this.uriBase = uriBase;
	}

	public void setChaveGwDevApp(String chaveGwDevApp) {
		this.chaveGwDevApp = chaveGwDevApp;
	}

}
