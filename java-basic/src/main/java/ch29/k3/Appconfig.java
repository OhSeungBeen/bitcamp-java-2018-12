package ch29.k3;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@PropertySource("classpath:ch29/k3/jdbc.properties")
public class Appconfig {

  @Autowired
  Environment env;

  @Value("${jdbc.driver}") String jdbcDriver;
  @Value("${jdbc.url}") String jdbcUrl;
  @Value("${jdbc.username}") String jdbcUsername;
  @Value("${jdbc.password}") String jdbcPassword;


  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }
  
  @Bean
  public PlatformTransactionManager transactionManger() {
    
  }
  
  
  
}
