package com.nike.mm

import org.dozer.DozerBeanMapper
import org.dozer.Mapper
import org.jasypt.util.text.StrongTextEncryptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoFactoryBean
import org.springframework.data.web.config.EnableSpringDataWebSupport

@Configuration
@EnableSpringDataWebSupport
class AppConfig {
	
	@Value('${mm.encrypt.password}')
	String encryptPassword;

	/*
	 * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
	 */
	 @Bean MongoFactoryBean mongo() {
          MongoFactoryBean mongo = new MongoFactoryBean();
          mongo.setHost("localhost");
          return mongo;
     }
	 
	 @Bean StrongTextEncryptor strongTextEncryptor() {
		 StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
		 textEncryptor.setPassword(this.encryptPassword);
		 return textEncryptor;
	 }
	 
	 @Bean Mapper dozerBeanMapper() {
		 return new DozerBeanMapper()
	 }
}