package com.sanpang.structure.proxy;

public interface IUserController {
    public UserVo login(String telephone, String password) ;
    public UserVo register(String telephone, String password) ;
}
