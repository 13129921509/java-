package com.cai.chatroom.base.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(JdbcConfiguration.class)
public class JpaConfiguration implements ApplicationContextAware {
    ConfigurableApplicationContext applicationContext;
    DefaultListableBeanFactory beanFactory;

    @Bean
    JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(false);
        adapter.setDatabase(Database.MYSQL);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        adapter.setShowSql(true);
        return adapter;
    }


    @Bean
    JpaDialect jpaDialect(){
        return new HibernateJpaDialect();
    }


    @Primary
    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, JpaDialect jpaDialect, DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.cai.chatroom.**");
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactoryBean.setJpaVendorAdapter(adapter);
        entityManagerFactoryBean.setJpaDialect(jpaDialect);
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        // 显示sql语句
        properties.put("hibernate.show_sql", true);
        // 格式化sql语句
        properties.put("hibernate.format_sql", true);
        // 方言
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        // 自动生成表
        properties.put("hibernate.hbm2ddl.auto", "update");
        //设置事务提交模式
//        properties.put("hibernate.connection.autocommit",false);
//        properties.put("org.hibernate.flushMode", "COMMIT");
//        properties.put("hibernate.enable_lazy_load_no_trans",true);
        return properties;
    }



//    @Bean("txTransactionManager")//注意这个bean 事务管理器的名字是 tx ，后面方法用的时候记得加上这个名字
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory);
//        return txManager;
//    }

    @Autowired
    DataSource dataSource;

//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager tm =
//                new JpaTransactionManager();
//        tm.setEntityManagerFactory(emf);
//        tm.setDataSource(dataSource);
//        return tm;
//    }

    @Bean
    LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }
    @Bean("transactionManager")
    public HibernateTransactionManager transactionManager(SessionFactory factoryBean){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean);
        return transactionManager;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
        this.beanFactory = (DefaultListableBeanFactory) this.applicationContext.getBeanFactory();
    }
}
