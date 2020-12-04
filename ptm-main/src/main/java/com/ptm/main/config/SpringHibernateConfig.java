package com.ptm.main.config;

import static com.ptm.main.common.constant.StringConstants.APP_ENV_DEV;
import static com.ptm.main.common.constant.StringConstants.APP_ENV_PROD;
import static com.ptm.main.common.constant.StringConstants.APP_ENV_TEST;
import static com.ptm.main.common.constant.StringConstants.HIBERNATE_ENTITY_DIR;
import static com.ptm.main.common.constant.StringConstants.HIBERNATE_PROPERTIES_FILE;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component
public class SpringHibernateConfig {

	private static Logger logger = LogManager.getLogger(SpringHibernateConfig.class);
	@Autowired private Environment environment;


	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(HIBERNATE_ENTITY_DIR);
		factoryBean.setHibernateProperties(getHibernateProperties());
		setDataSourceEnv(factoryBean);
		return factoryBean;
	}

	@Profile("dev")
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSourceDev() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Profile("test")
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSourceTest() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Profile("prod")
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSourceProd() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(HIBERNATE_PROPERTIES_FILE);
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("File hibernate.properties not found");
			e.printStackTrace();
		}
		return properties;
	}

	private void setDataSourceEnv(LocalSessionFactoryBean factoryBean) {
		String [] envs = environment.getActiveProfiles();
		System.out.println("----profile name: " + environment.getProperty("spring.profiles.active"));
		if(envs == null || envs.length == 0 ) {
			logger.info("---- No profile is provided ------");
			throw new RuntimeException("No profile mentioned. Please run application with spring.profiles.active=<Value> | Possible <Value> are dev | test | prod");
		} else if(APP_ENV_DEV.equalsIgnoreCase(envs[0])) {
			factoryBean.setDataSource(dataSourceDev());
			logger.info("---- dev profile is activated------");
		} if(APP_ENV_TEST.equalsIgnoreCase(envs[0])) {
			factoryBean.setDataSource(dataSourceTest());
			logger.info("---- test profile is activated-----");
		} else if(APP_ENV_PROD.equalsIgnoreCase(envs[0])) {
			factoryBean.setDataSource(dataSourceProd());
			logger.info("---- prod profile is activated------");
		} 
	}
		
	/*
	 * @Bean(destroyMethod="") public DataSource jndiDataSource() throws
	 * IllegalArgumentException, NamingException {
	 * System.out.println("----jndi name: " +
	 * environment.getProperty(APP_JNDI_KEY_NAME)); JndiObjectFactoryBean bean = new
	 * JndiObjectFactoryBean();
	 * bean.setJndiName(environment.getProperty(APP_JNDI_KEY_NAME));
	 * bean.setProxyInterface(DataSource.class); bean.setLookupOnStartup(false);
	 * bean.afterPropertiesSet(); return (DataSource)bean.getObject(); }
	 */
}
