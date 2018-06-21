//package com.kovacic.configs;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.kovacic", entityManagerFactoryRef = "localContainerEntityManagerFactoryBean")
//@ComponentScan("com.kovacic")
//public class PersistenceJPAConfig {
//
//   private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PersistenceJPAConfig.class);
//
//   @Bean
//   @DependsOn("dataSource")
//   public JdbcTemplate jdbcTemplate() {
//      return new JdbcTemplate(dataSource());
//   }
//
//   @Bean
//   @DependsOn("dataSource")
//   public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//      return new NamedParameterJdbcTemplate(dataSource());
//   }
//
////   @Bean
////   public MailSender mailSender(){
////      final MailSenderImpl mailSenderImpl = new MailSenderImpl();
////      mailSenderImpl.setDataSource(dataSource());
////      return mailSenderImpl;
////   }
//
//   @Bean
//   public DataSource dataSource() {
//      HikariConfig config = new HikariConfig();
//      config.setDriverClassName("com.mysql.jdbc.Driver");
//      config.setJdbcUrl("jdbc:mysql://localhost/data?useSSL=false");
//      config.setUsername("iKovacic");
//      config.setPassword("kovacic100.");
//      config.setPoolName("HikariCpConnectionPool");
//
////      config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////      config.setJdbcUrl("jdbc:sqlserver://localhost;DatabaseName=mydb");
////      config.setUsername("user");
////      config.setPassword("pass");
////      config.setPoolName("HikariCpConnectionPool");
//      config.setMaximumPoolSize(50);
//      config.setMinimumIdle(2);
//      return new HikariDataSource(config);
//   }
//
//   @Bean
//   @DependsOn({"dataSource"})
//   public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
//      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(dataSource());
//      em.setPackagesToScan(new String[]{
//         "com.kovacic.**.*"
//      });
//      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//      em.setJpaProperties(additionalProperties());
//      return em;
//   }
//
//   @Bean
//   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//      return new PersistenceExceptionTranslationPostProcessor();
//   }
//
//   @Bean
//   public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//      return new JpaTransactionManager(entityManagerFactory);
//   }
//
//   private Properties additionalProperties() {
//      Properties properties = new Properties();
//      properties.setProperty("hibernate.hbm2ddl.auto", "update");
//      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//      properties.setProperty("hibernate.show_sql", "true");
//      properties.setProperty("hibernate.format_sql", "true");
//      properties.setProperty("hibernate.use_sql_comments", "true");
//      properties.setProperty("hibernate.id.new_generator_mappings", "false");
//      properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
//      properties.setProperty("hibernate.generate_statistics", "false");
//      return properties;
//   }
//
//}