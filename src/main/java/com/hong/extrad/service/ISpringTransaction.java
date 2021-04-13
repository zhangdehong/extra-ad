package com.hong.extrad.service;

import com.hong.extrad.exception.CustomException;

/**
 * <h1>spring事务测试接口定义</h1>
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create in  11:46 下午 2020/7/26
 */
public interface ISpringTransaction {

    /**
     * <h2>主动捕获异常  事务不能回滚</h2>
     */
    void catchExceptionCanNotRollBack ();

    /**
     * <h2>不是unchecked异常  事务不能回滚</h2>
     *
     * @throws CustomException
     */
    void notRuntimeExceptionCanNotRollBack () throws CustomException;

    /**
     * <h2>unchecked 异常 事务可以回滚</h2>
     */
    void RuntimeExceptionCamRollBack ();

    /**
     * 指定异常  事务可以回滚
     *
     * @throws CustomException
     */
    void AssignExceptionCanRollback () throws CustomException;

    /**
     * <h2>RollBack Only 事务可以回滚</h2>
     *
     * @throws CustomException
     */
    void RollBackOnlyCallBack () throws CustomException;

    /**
     *<h2>同一个类中  一个不标注事务的方法去调用标注了事务的方法，事务会失效</h2>
     */
    void NonTransationCanNotRollBack();
}
