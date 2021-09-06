package com.cdwmmc.notifacationsevice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

@SuppressLint("OverrideAbstract")
public class NLService extends NotificationListenerService{
    @Override
    public void onListenerConnected() {
        //当连接成功时调用，一般在开启监听后会回调一次该方法
        System.out.println("----------------onListenerConnected--------->");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        //当收到一条消息时回调，sbn里面带有这条消息的具体信息
        System.out.println("----------------onNotificationPosted--------->");
        System.out.println("----------------onNotificatsssionPosted----1----->" + sbn.getPackageName());
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString(Notification.EXTRA_TITLE); //通知title
        String content = extras.getString(Notification.EXTRA_TEXT); //通知内容
        int smallIconId = extras.getInt(Notification.EXTRA_SMALL_ICON); //通知小图标id
       /* Bitmap largeIcon =  extras.getParcelable(Notification.EXTRA_LARGE_ICON); //通知的大图标，注意和获取小图标的区别*/
        PendingIntent pendingIntent = sbn.getNotification().contentIntent; //获取通知的PendingIntent
        System.out.println("----------------onNotificationPosted----1--1--->" + extras);
        System.out.println("----------------onNotificationPosted----2----->" + title);
        System.out.println("----------------onNotificationPosted----3----->" + content);
        System.out.println("----------------onNotificationPosted----4----->" + smallIconId);
    /*    System.out.println("----------------onNotificationPosted----5----->" + largeIcon);*/
        System.out.println("----------------onNotificationPosted----6----->" + pendingIntent);


    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        //当移除一条消息的时候回调，sbn是被移除的消息
        System.out.println("----------------onNotificationRemoved--------->");
    }

}