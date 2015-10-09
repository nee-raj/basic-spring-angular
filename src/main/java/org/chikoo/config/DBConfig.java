package org.chikoo.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.chikoo.core.repository")
@EnableTransactionManagement
public class DBConfig {
	 @Bean
	  public BasicDataSource dataSource() {
	   BasicDataSource datasource = new BasicDataSource();
	   datasource.setUsername("sa");
	   datasource.setPassword("sa");
	   datasource.setUrl("jdbc:h2:mem:test");
	   datasource.setDriverClassName("org.h2.Driver");
	   return datasource;	   
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setShowSql(true);
	    
	    HashMap<String,String> hibernateProperties = new HashMap<String, String>();
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "create-drop");
	    
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("org.chikoo.core.model.entity");
	    factory.setJpaPropertyMap(hibernateProperties);
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();
	    return factory.getObject();
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }	
}
