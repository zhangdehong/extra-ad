package com.hong.extrad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhang-dehong
 * @Describe: TODO
 * @Date Create by  4:34 下午 2021/4/17
 */
@Service
public class AnotherTransaction {

    private final ISpringTransactionImpl springTransaction;

    @Autowired
    public AnotherTransaction (ISpringTransactionImpl springTransaction) {this.springTransaction = springTransaction;}

    public void transactionalCanRollback () {
        springTransaction.anotherOneSaveMethod();
    }
}
