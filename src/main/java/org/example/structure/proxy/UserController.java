package org.example.structure.proxy;

import static java.lang.Thread.sleep;

public class UserController implements IUserController{
    private MetricsCollector metricsCollector; //依赖注入

    public UserVo login(String telephone, String password) {

        // 简单处理login逻辑
        UserVo userVo = new UserVo();
        try {
            Thread.sleep(888);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return userVo;
    }

    public UserVo register(String telephone, String password)  {

        //简单处理register逻辑
        UserVo userVo = new UserVo();
        try {
            Thread.sleep(777);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return userVo;
    }


}

