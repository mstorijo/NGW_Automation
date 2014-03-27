package com.gu.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

public class HttpMock {

	private final WireMockServer wireMockServer;
	private final Configuration config;

	public HttpMock(Configuration config) {
		this.config = config;

		wireMockServer = new WireMockServer(new WireMockConfiguration().port(8080));
	}

	public void start() {
		wireMockServer.start();
		stubFor(any(urlMatching(".*")).willReturn(aResponse().proxiedFrom(config.baseUrl())));
	}

	public void stop() {
		wireMockServer.stop();
	}

	public void assertGetRequest(String beacon) {
		verify(getRequestedFor(urlEqualTo(beacon)));
	}
}
