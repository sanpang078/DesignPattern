package org.example.structure.proxy;

public class UserControllerProxy implements IUserController{//优先使用实现相同接口的方式，假如没有接口且无法改动源码则采用继承。
    private IUserController userController;
    private MetricsCollector metricsCollector ;
    public UserControllerProxy(IUserController userController){
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }
    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        //委托
        UserVo userVo = userController.login(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInof requestInof = new RequestInof("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInof);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        //委托
        UserVo userVo = userController.register(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInof requestInof = new RequestInof("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInof);
        return userVo;
    }
}
