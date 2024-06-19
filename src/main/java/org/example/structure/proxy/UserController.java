package org.example.structure.proxy;

import static java.lang.Thread.sleep;

public class UserController implements IUserController{
    private MetricsCollector metricsCollector; //依赖注入

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 简单处理login逻辑
        UserVo userVo = new UserVo();
        try {
            Thread.sleep(888);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInof requestInof = new RequestInof("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInof);

        return userVo;
    }

    public UserVo register(String telephone, String password)  {
        long startTimestamp = System.currentTimeMillis();
        //简单处理register逻辑
        UserVo userVo = new UserVo();
        try {
            Thread.sleep(777);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInof requestInof = new RequestInof("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInof);

        return userVo;
    }


}

