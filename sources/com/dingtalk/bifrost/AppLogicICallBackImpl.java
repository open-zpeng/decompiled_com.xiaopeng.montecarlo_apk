package com.dingtalk.bifrost;

import android.content.Context;
import android.os.Build;
import com.dingtalk.mars.app.AppLogic;
import com.dingtalk.mobile.common.netsdkextdependapi.deviceinfo.DeviceInfoUtil;
/* loaded from: classes2.dex */
public class AppLogicICallBackImpl implements AppLogic.ICallBack {
    private static AppLogicICallBackImpl instance;
    private Context context;
    private String deviceName;
    private String deviceType;
    private String userId = "";

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public int getClientVersion() {
        return 0;
    }

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public String getCurLanguage() {
        return "Cn";
    }

    public static AppLogicICallBackImpl getInstance() {
        AppLogicICallBackImpl appLogicICallBackImpl = instance;
        if (appLogicICallBackImpl != null) {
            return appLogicICallBackImpl;
        }
        synchronized (AppLogicICallBackImpl.class) {
            if (instance != null) {
                return instance;
            }
            instance = new AppLogicICallBackImpl();
            return instance;
        }
    }

    public void register(Context context) {
        this.context = context;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public String getAppFilePath() {
        Context context = this.context;
        return context != null ? context.getFilesDir().getAbsolutePath() : "";
    }

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public AppLogic.AccountInfo getAccountInfo() {
        long j;
        try {
            j = Long.parseLong(this.userId);
        } catch (Throwable unused) {
            j = 0;
        }
        return new AppLogic.AccountInfo(j, this.userId);
    }

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public AppLogic.DeviceInfo getDeviceType() {
        return new AppLogic.DeviceInfo(this.deviceName, this.deviceType);
    }

    @Override // com.dingtalk.mars.app.AppLogic.ICallBack
    public String getUtdid() {
        return DeviceInfoUtil.getDeviceId();
    }

    private AppLogicICallBackImpl() {
        this.deviceType = "";
        this.deviceName = "";
        try {
            this.deviceType = Build.BRAND;
            this.deviceName = Build.MODEL;
        } catch (Throwable unused) {
        }
    }
}
