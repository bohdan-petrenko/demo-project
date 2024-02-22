package com.bp.dp.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@Slf4j
public class MongoConfiguration extends AbstractMongoClientConfiguration {
	@Value("${mongodb.host}")
	private String host;
	@Value("${mongodb.port}")
	private long port;
	@Value("${mongodb.databaseName}")
	private String databaseName;
	@Value("${mongodb.userName}")
	private String userName;
	@Value("${mongodb.password}")
	private String password;


	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	public MongoClient mongoClient() {
		String connectionString = new StringBuilder()
				.append("mongodb://")
				.append(userName)
				.append(":")
				.append(password)
				.append("@")
				.append(host)
				.append(":")
				.append(port)
				.append("/")
				.append(databaseName)
				.toString();
		log.info("Connecting to MongoDB at {}", connectionString);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString))
				.build();

		return MongoClients.create(mongoClientSettings);
	}
}
