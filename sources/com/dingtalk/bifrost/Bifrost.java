package com.dingtalk.bifrost;

import android.content.Context;
import com.dingtalk.mars.app.AppLogic;
import com.dingtalk.mars.sdt.SdtLogic;
import com.dingtalk.mars.stn.StnLogic;
import com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager;
import com.dingtalk.mobile.common.amnetcore.DftAmnetSwitchManager;
import com.dingtalk.mobile.common.utils.load.BifrostLibraryLoadUtils;
/* loaded from: classes2.dex */
public class Bifrost {
    private static AmnetSwitchManager swchmng = new DftAmnetSwitchManager();

    public static void loadLibrary(Context context) {
        BifrostLibraryLoadUtils.loadLibrary("stlport_shared", false);
        BifrostLibraryLoadUtils.loadLibrary("Bifrost", false);
        init(context);
    }

    public static void init(Context context) {
        StnLogic.checkLibrary();
        SdtLogic.checkLibrary();
        if (BifrostEnvUtils.getContext() == null && context != null) {
            BifrostEnvUtils.setContext(context);
        }
        AppLogicICallBackImpl.getInstance().register(BifrostEnvUtils.getContext());
        AppLogic.setCallBack(AppLogicICallBackImpl.getInstance());
        BifrostNetworkConnReceiver.instance(BifrostEnvUtils.getContext()).register();
        BifrostObject.readProxyConfig();
    }

    public static AmnetSwitchManager getSwchmng() {
        return swchmng;
    }

    public static void setSwchmng(AmnetSwitchManager amnetSwitchManager) {
        if (amnetSwitchManager == null) {
            return;
        }
        swchmng = amnetSwitchManager;
    }
}
