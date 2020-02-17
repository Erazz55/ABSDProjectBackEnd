package com.eatMore.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.eatMore" ,entityManagerFactoryRef = "entityManagerFactoryBean")
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds,JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(ds);
        lcemfb.setPackagesToScan("com.eatMore.entity");
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
        return lcemfb;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/absdProject");
        ds.setUsername("root");
        ds.setPassword("Oshada231#");
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
        adapter.setDatabase(Database.MYSQL);
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory em){
        return new JpaTransactionManager(em);
    }
}
