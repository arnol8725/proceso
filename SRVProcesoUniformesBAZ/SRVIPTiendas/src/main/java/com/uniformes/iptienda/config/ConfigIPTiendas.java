package com.uniformes.iptienda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:E:/Users/kortizl/wildfly-12.0.0.Final/standalone/config/SRVIPTiendas.properties")
public class ConfigIPTiendas {
	@Value("${DATASORACLE}")
	public String DATASORACLE;
	@Value("${CRON_EXP_IP_TIENDAS}")
	public String CRON_EXP_IP_TIENDAS;
	@Value("${FN_CONS_REM}")
	public String FN_CONS_REM;
}
