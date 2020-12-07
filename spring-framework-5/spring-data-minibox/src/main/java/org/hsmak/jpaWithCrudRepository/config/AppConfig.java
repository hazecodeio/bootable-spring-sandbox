package org.hsmak.jpaWithCrudRepository.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:jpa/db.properties")
@EnableTransactionManagement
@EnableJpaRepositories("org.hsmak.jpaWithCrudRepository.repository")
@ComponentScan("org.hsmak.jpaWithCrudRepository")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //Alternatively, you can use Spring's:
        //DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    // It's ver important that the method/bean's name is "entityManagerFactory" otherwise @EnableJpaRepositories will fail
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("org.hsmak.jpaWithCrudRepository.entity");

        // link: https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-data-access
        Properties props = new Properties();
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.generate-ddl", env.getProperty("hibernate.generate-ddl", Boolean.class));
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql", Boolean.class));
        factoryBean.setJpaProperties(props);

        //Setting the Hibernate Adapter
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setGenerateDdl(env.getProperty("hibernate.generate-ddl", Boolean.class));
//        hibernateJpaVendorAdapter.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));
        factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        return factoryBean;
    }

    @Bean
    // It's ver important that the method/bean's name is "transactionManager" otherwise @EnableJpaRepositories will fail
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
