package com.codestates.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;


public class AtomikosJtaPlatform extends AbstractJtaPlatform {
    static TransactionManager transactionManager;
    static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager(){
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction(){
        return transaction;
    }
}
