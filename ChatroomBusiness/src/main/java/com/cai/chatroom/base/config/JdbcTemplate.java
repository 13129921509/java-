package com.cai.chatroom.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;


public class JdbcTemplate extends org.springframework.jdbc.core.JdbcTemplate {
    private ThreadLocal<TransactionStatus> transactions = new ThreadLocal();
    private DefaultTransactionDefinition definition;
    private PlatformTransactionManager transactionManager;

    public JdbcTemplate() {
    }

    public JdbcTemplate(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.afterPropertiesSet();
    }
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        this.definition = new DefaultTransactionDefinition();
        this.definition.setIsolationLevel(2);
        this.definition.setPropagationBehavior(0);
        this.transactionManager = new DataSourceTransactionManager(this.getDataSource());
    }

    public void beginTransaction() {
        TransactionStatus tmp = this.transactionManager.getTransaction(this.definition);
        this.transactions.set(tmp);
    }

    public void commit() {
        TransactionStatus tmp = (TransactionStatus)this.transactions.get();
        if (tmp == null) {
            throw new RuntimeException("no transaction to commit");
        } else {
            this.transactionManager.commit(tmp);
            this.transactions.remove();
        }
    }

    public void rollback() {
        TransactionStatus tmp = (TransactionStatus)this.transactions.get();
        if (tmp == null) {
            throw new RuntimeException("no transaction to rollback");
        } else {
            this.transactionManager.rollback(tmp);
            this.transactions.remove();
        }
    }

    public void withTransaction(TransactionAction action) {
        try {
            this.beginTransaction();
            action.action(this);
            this.commit();
        } catch (Throwable var3) {
            this.rollback();
            throw var3;
        }
    }
    

}

