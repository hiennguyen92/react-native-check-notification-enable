package com.upket.notification.check;

import android.support.v4.app.NotificationManagerCompat;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import javax.annotation.Nonnull;

public class CheckNotificationModule extends ReactContextBaseJavaModule {

    public CheckNotificationModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nonnull
    @Override
    public String getName() {
        return "CheckNotification";
    }

    @ReactMethod
    public void isEnabled(final Promise promise) {
        try {
            Boolean areEnabled = NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled();
            promise.resolve(areEnabled);
        }catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}
