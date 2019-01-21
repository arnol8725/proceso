package com.uniformes.distribucionSPPI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/*E:\Users\kortizl\wildfly-12.0.0.Final\standalone   ${jboss.server.base.dir}*/
@PropertySource("file:E:/Users/kortizl/wildfly-12.0.0.Final/standalone/config/SRVDistribucionSPPI.properties")
public class ConfigSPPI {
	@Value("${DATASORACLE}")
	public String DATASORACLE;
	@Value("${CRON_EXPRESSION_SPPI}")
	public String CRON_EXPRESSION_SPPI;
	@Value("${SPCONSULTAPENDIENTESSPPI}")
	public String SPCONSULTAPENDIENTESSPPI;
}
