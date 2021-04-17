package com.hong.extrad.service.impl;

import com.hong.extrad.dao.ExtraAdDao;
import com.hong.extrad.entity.ExtraAd;
import com.hong.extrad.exception.CustomException;
import com.hong.extrad.service.ISpringTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create in  11:50 下午 2020/7/26
 */
@Slf4j
@Service
public class ISpringTransactionImpl implements ISpringTransaction {

    private final ExtraAdDao extraAdDao;

    @Autowired
    public ISpringTransactionImpl (ExtraAdDao extraAdDao) {this.extraAdDao = extraAdDao;}

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void catchExceptionCanNotRollBack () {
        try {
            extraAdDao.save(new ExtraAd("dh444444422"));
            throw new IOException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    @Transactional
    public void notRuntimeExceptionCanNotRollBack () throws CustomException {
        try {
            extraAdDao.save(new ExtraAd("dh2222"));
            throw new RuntimeException();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void RuntimeExceptionCamRollBack () {
        extraAdDao.save(new ExtraAd("dh2"));
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void AssignExceptionCanRollback () throws CustomException {
        try {
            extraAdDao.save(new ExtraAd("dh3"));
            throw new RuntimeException();
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void RollBackOnlyCallBack () throws CustomException {
        oneSaveMethod();
        try {
            extraAdDao.save(new ExtraAd());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public void oneSaveMethod () {
        extraAdDao.save(new ExtraAd("dh4"));
    }

    @Override
    @Transactional
    public void NonTransationCanNotRollBack () {
        anotherOneSaveMethod();
        throw new RuntimeException();
    }

    public void anotherOneSaveMethod () {
        extraAdDao.save(new ExtraAd("dh4"));
        throw new RuntimeException();
    }
}
