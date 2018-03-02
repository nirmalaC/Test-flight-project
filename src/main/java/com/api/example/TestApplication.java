package com.api.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.api.example.config.ExampleTestConfig;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by daniel on 23/11/2016.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:environments/${environment}.properties")
public class TestApplication {

//    protected static Logger LOG = LogManager.getLogger(TestApplication.class);

    @Autowired
    private ExampleTestConfig config;

    /**
     * autowires the datasource needed to connect to the api database, the specific details of configuration are
     * taken from the spring managed ExampleTestConfig class
     *
     * @return a bean of DriverManagerDataSource with the correct configuration to connect to api
     */
    @Bean(name = "exampleDataSource")
    public DriverManagerDataSource exampleDataSource() {
        addMicrosoftJdbcDriverToClasspath();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(config.getExampleDbDriver());
        dataSource.setUrl(config.getExampleDbConnectionUrl());
        dataSource.setUsername(config.getExampleDbUserName());
        dataSource.setPassword(config.getExampleDbPassword());
        return dataSource;
    }

    /**
     * autowires the datasource needed to connect to the otherdb database, the specific details of configuration are taken
     * taken from the spring managed ExampleTestConfig class
     * @return a bean of DriverManagerDataSource with the correct configuration to connect to otherdb
     */
    @Bean(name = "otherdbDataSource")
    public DriverManagerDataSource otherdbDataSource() {
        addMicrosoftJdbcDriverToClasspath();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl(config.getOtherDbConnectionUrl());
        dataSource.setUsername(config.getOtherDbUserName());
        dataSource.setPassword(config.getOtherDbPassword());
        return dataSource;
    }

    /**
     * autowires the jersey client which is used for all service calls
     * @return Client Jersey Client which is configured using config from ExampleTestConfig
     */
    @Bean
    public Client client() {
        Logger logger = Logger.getLogger(getClass().getName());
        Feature feature = new LoggingFeature(logger, Level.INFO, null, 16384);
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new ApacheConnectorProvider());
        JacksonJsonProvider jacksonJsonProvider =
                new JacksonJaxbJsonProvider()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Client client = ClientBuilder.newClient(cc).register(jacksonJsonProvider);
        client.property(ClientProperties.CONNECT_TIMEOUT, config.getExampleTimeout()); //30 seconds
        client.property(ClientProperties.READ_TIMEOUT, config.getExampleTimeout()); //30 seconds
        client.register(feature);
        return client;
    }

    private void addMicrosoftJdbcDriverToClasspath() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
