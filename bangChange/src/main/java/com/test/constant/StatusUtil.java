package com.test.constant;

/*
*状态常量定义表
 */
public class StatusUtil {


    /*
    * 账号存在
    * */
    public static final int EXISTS=2000;

    /*
    * 账号不存在
    * */
    public static final int NOT_EXISTS=2000;
    public static final String NOT_EXISTS_MSG="目标账号不存在";
    /*
    *表示激活
     */
    public static final int FREEZON=2104;

    /*
    * 冻结
    * */
    public static final int NOT_FREEZON=2100;
    public static final String NOT_FREEZON_MSG="已经被冻结";
    /*
    * 不够
    * */

    public static final int NOT_ENOUGH=2400;
    public static final String NOT_ENOUGH_MSG="钱不够";

    /*
    * 成功
    * */
    public static final int SUCCESS=2500;
    public static final String SUCCESS_MSG="成功";
}
