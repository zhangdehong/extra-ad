package com.hong.extrad.service;

import com.hong.extrad.ExtraAdApplication;
import com.hong.extrad.exception.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create in  12:02 上午 2020/7/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExtraAdApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TransactionTest {

    @Autowired
    private ISpringTransaction springTransaction;

    @Test
    public void testCatchExceptionCanNotRollBack () {
        springTransaction.catchExceptionCanNotRollBack();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollBack () throws CustomException {
        springTransaction.notRuntimeExceptionCanNotRollBack();
    }

    @Test
    public void testRuntimeExceptionCamRollBack () {
        springTransaction.RuntimeExceptionCamRollBack();
    }

    @Test
    public void testAssignExceptionCanRollback () throws CustomException {
        springTransaction.AssignExceptionCanRollback();
    }

    @Test
    public void testRollBackOnlyCallBack () throws CustomException {
        springTransaction.RollBackOnlyCallBack();
    }

    @Test
    public void testNonTransationCanNotRollBack(){
        springTransaction.NonTransationCanNotRollBack();
    }
}
