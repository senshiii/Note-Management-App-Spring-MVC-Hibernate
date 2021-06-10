package com.sayandas.firstproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = { "com.sayandas.firstproject" })
public class AppMvcConfig implements WebMvcConfigurer {

	private static final String JDBC_DRIVER = "jdbc.driver";
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_USER = "jdbc.user";
	private static final String JDBC_PASSWORD = "jdbc.password";

	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String HIBERNATE_PACKAGES_TO_SCAN = "hibernate.packagesToScan";

	private static final String STATIC_ASSETS_FOLDER_NAME = "assets";

	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/" + STATIC_ASSETS_FOLDER_NAME + "/**")
			.addResourceLocations("/" + STATIC_ASSETS_FOLDER_NAME + "/");
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(@Autowired DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(env.getRequiredProperty(HIBERNATE_PACKAGES_TO_SCAN));

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
		hibernateProperties.setProperty(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(JDBC_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(JDBC_URL));
		dataSource.setUsername(env.getRequiredProperty(JDBC_USER));
		dataSource.setPassword(env.getRequiredProperty(JDBC_PASSWORD));
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}
