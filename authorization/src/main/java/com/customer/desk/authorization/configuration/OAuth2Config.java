package com.customer.desk.authorization.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	private String clientid = "myapp";
	private String clientSecret = "my-app-sec";
	private String privateKey ="AAAAB3NzaC1yc2EAAAABJQAAAQEAl1+EMHjEZk39miGyS/Cews8tLLWCHoYVW7kF\r\n" + 
			"TYgnGS79fxzWvgT478psT9T1JzXNn8QBL6Xjc9FiUz6K+Ru9FOSkIIaMxt4jMXn0\r\n" + 
			"HUsukByiw9pdg+MDhhLrHBMfCt+xXmFDsT8f1gejjU426a8XjosYYcVi7E0qeH1u\r\n" + 
			"qYHLlMoyAozehsjQVfT2jSYmQSfWFE7wtjLsVrtGpuBDUUzQn/c3VgbV0LEbf6MK\r\n" + 
			"lehBQAY5K8T6F6OAvhzkLMWGbSBCDJRcNqprW65v63lrxNGPC2IV0n1xmZyGS/LH\r\n" + 
			"I+bzX4YTPabKNjsqgRQT1fFvBmU0BTUgr+dHPGXygHpmlUivfw==\r\n" + 
			"Private-Lines: 14\r\n" + 
			"AAABAAQXVpmGuTMyilBGGZNZh8ATb+xzm7uiwk6WTEBdoDEc8hgxNjx8rMg150Bt\r\n" + 
			"ihXRBY6yRTijnl0TfzKuqc9hnVOXeg63h0OlI4u3MBx3p1AAxiD4EF2CrRF2Iget\r\n" + 
			"fWEoo+3LRwTKWs5u6L6hP8EgaGui5Pu5OgZi809dVgSUziado4EDI5to9BMnHjD+\r\n" + 
			"kYsQOAzOX4HTNcLhBa5JbKi9YLtlKIbw1BoPC0rS9NhVcIbq4EE+PLAweezoQ1qa\r\n" + 
			"dZrNYnbcC76yjar8rTELQODUJzcamgCleNYoKBMYTXMFPed99xP7p2F/DuiRYY7J\r\n" + 
			"W3NY412JyZRJxC4lYub5NgGSl2UAAACBAOyH4yiTaZ6N98KTdXLpNPROn10CeJxw\r\n" + 
			"Y/hXEc/rBHq8TAbfO0d+ELyXWKcALeB+rJHVp9yDL39kBkvCItUj9EFRTYDjmOxw\r\n" + 
			"X5WMPmhKhPoYh2zmViy9r7ai1alFPPToCqVvPbruY6wEdghVwVFLZxdAzfaaeySO\r\n" + 
			"H2mRywt0NU5dAAAAgQCj1TWQfTPrA1XW5OWqPprH69vF8DOKu9F8HzG/AulazgxU\r\n" + 
			"9fzmjnO9F80AUWEdQWc96B5YHXJiHITcUk+x6XzFjXkow0MFNMnSSJqi+6Lp/AJm\r\n" + 
			"1DzN6B8E5pnsPugMAka36wneMHpW35rx3RXmDyVAP30HpsLIAt89jKqM5uN/iwAA\r\n" + 
			"AIBmAb8/16cIb8UxFYXOs4Vxz3LofSMTpg6HC0pZCO9iii9sZXh2GQbvdWPn4DpC\r\n" + 
			"vQKaRoYsx4Lq/6avwadlWxdDb2IU1uvvq5wva/nd3DodXVJkAl8qvzEZqBEDwElt\r\n" + 
			"hKnNt30z4PWiZ7PKyHHL2IelYoM+JqYHUvuBOxrwT/Siuw==\r\n" + 
			"Private-MAC: d7f89e8c61e7aa1b56abed3abcf560681d079537";
	private String publicKey = "AAAAB3NzaC1yc2EAAAABJQAAAQEAl1+EMHjEZk39miGyS/Cews8tLLWCHoYVW7kFTYgnGS79fxzWvgT478psT9T1JzXNn8QBL6Xjc9FiUz6K+Ru9FOSkIIaMxt4jMXn0HUsukByiw9pdg+MDhhLrHBMfCt+xXmFDsT8f1gejjU426a8XjosYYcVi7E0qeH1uqYHLlMoyAozehsjQVfT2jSYmQSfWFE7wtjLsVrtGpuBDUUzQn/c3VgbV0LEbf6MKlehBQAY5K8T6F6OAvhzkLMWGbSBCDJRcNqprW65v63lrxNGPC2IV0n1xmZyGS/LHI+bzX4YTPabKNjsqgRQT1fFvBmU0BTUgr+dHPGXygHpmlUivfw== rsa-key-20190711";

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(20000)
				.refreshTokenValiditySeconds(20000);
	}
	
	
	
}