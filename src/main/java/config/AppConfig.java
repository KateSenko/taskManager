package config;

/**
 * Created by Kate on 15.11.2015.
 */
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import dao.TaskDao;
import dao.TaskDaoImpl;
import entity.Tasks;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public TaskDao personDao() {
        return new TaskDaoImpl();
    }
    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(Tasks.class)
                .buildSessionFactory();
    }
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/concretepage");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
    @Bean
    public HibernateTransactionManager hibTransMan(){
        return new HibernateTransactionManager(sessionFactory());
    }
}