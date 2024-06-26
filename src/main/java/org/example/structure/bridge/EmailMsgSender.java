package org.example.structure.bridge;

import java.util.List;

public class EmailMsgSender implements MsgSender{
    private List<String> emailAddresses;
    public EmailMsgSender(List<String> emailAddresses){
        this.emailAddresses = emailAddresses;
    }
    @Override
    public void send(String message) {
        for (String emailAddress : emailAddresses) {
            System.out.println("电话告警： " + emailAddress + ": " + message);
        }
    }
}
