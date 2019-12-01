package searchlinks.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@ComponentScan(basePackages = "searchlinks")
@Configuration
@EnableJpaRepositories(basePackages = "searchlinks.dao")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceUnitName("TestPersistenceUnit");
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
