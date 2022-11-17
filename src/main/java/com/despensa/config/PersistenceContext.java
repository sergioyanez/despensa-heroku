//package com.despensa.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.activation.DataSource;
//
///**
// * Clase de configuración.
// *
// * @author  Elva Kheler: mekdy.20@gmail.com
// *          Héctor Liceaga: lice2187@gmail.com
// *          Nicolás Carsaniga: nikitobombero@gmail.com
// *          Sergio Yañez: sergiomyanez02@gmail.com
// * @version 1.0
// * @since 25/06/2022
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"com.despensa.repository"})
//public class PersistenceContext {
//    @Bean(destroyMethod = "close")
//    DataSource dataSource(Environment env){
//        HikariConfig dataSourceConfig = new HikariConfig();
//        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
//        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
//        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
//        dataSourceConfig.setPassword((env.getRequiredProperty("db.password")));
//
//        return (DataSource) new HikariDataSource(dataSourceConfig);
//    }
//}
