// IdmetaAndroidRnModule.java

package com.reactlibrary;
import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class IdmetaAndroidRnModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public IdmetaAndroidRnModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "IdmetaAndroidRnModule";
    }

    @ReactMethod
    public void startIdmetaFlow(String flowId, String userToken) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(currentActivity, IdmetaStarterActivity.class);
                    intent.putExtra("flowId", flowId);
                    intent.putExtra("userToken", userToken);
                    currentActivity.startActivity(intent);
                }
            });
        }
    }
}
