package com.vaibhavmojidra.notificationdemo.SendNotificationPack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(

            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAG9QnMos:APA91bFNfrqdgoxop3BWdv0dgybirxSBm3f_lZTcokW0ftC_9mMCbS11u2BtV9cvs9KaSfKmexUHt45uGW7UJrx3NwRpR_brGDcP8vGpphBx7oP17FtuRIiWHknCl-yEzqKWeG5yihME" // Your server key refer to video for finding your server key
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotifcation(@Body NotificationSender body);
}

