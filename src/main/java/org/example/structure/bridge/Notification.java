package org.example.structure.bridge;

import java.util.List;

public class Notification {
    private List<String> emailAddress;
    private List<String> telephones;
    private List<String> wechatIds;

    public Notification(){}

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTelephones(List<String> telephones){
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds){
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message){
        if ( level.equals(NotificationEmergencyLevel.SEVERE) ) {
            //电话告警
            for ( String telephones: telephones ) {
                System.out.println("电话告警： " + telephones + ": " + message);
            }
            
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //微信告警
            for ( String wechatId: wechatIds ) {
                System.out.println("微信告警： " + wechatId + ": " + message);
            }
            
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //邮件告警
            for ( String emailAddres: emailAddress ) {
                System.out.println("邮箱告警： " + emailAddres + ": " + message);
            }

        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //邮件告警
            for ( String emailAddres: emailAddress ) {
                System.out.println("邮箱告警： " + emailAddres + ": " + message);
            }

        }
    }

}
