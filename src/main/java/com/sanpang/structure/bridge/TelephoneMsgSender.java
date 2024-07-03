package com.sanpang.structure.bridge;

import java.util.List;

public class TelephoneMsgSender implements MsgSender{
    private List<String> telephones;
    public TelephoneMsgSender(List<String> telephones){
        this.telephones = telephones;
    }
    @Override
    public void send(String message) {
        for (String telephone : telephones) {
            System.out.println("电话告警： " + telephone + ": " + message);
        }
    }
}
