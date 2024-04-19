package com.xiaopeng.montecarlo.navcore.apirouter;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.JsonObject;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes2.dex */
public class IpcRouterUtil {
    public static final String KEY_SENDER_PACKAGE_NAME = "senderPackageName";
    private static final L.Tag TAG = new L.Tag("IpcRouterService");

    public static void sendData(int i, Bundle bundle, String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(KEY_SENDER_PACKAGE_NAME, ContextUtils.getContext().getPackageName());
        if (bundle != null) {
            if (bundle.containsKey(IpcConfig.IPCKey.BOOLEAN_VALUE)) {
                Object obj = bundle.get(IpcConfig.IPCKey.BOOLEAN_VALUE);
                if (obj instanceof Boolean) {
                    jsonObject.addProperty(IpcConfig.IPCKey.BOOLEAN_VALUE, (Boolean) obj);
                }
            }
            if (bundle.containsKey(IpcConfig.IPCKey.STRING_MSG)) {
                Object obj2 = bundle.get(IpcConfig.IPCKey.STRING_MSG);
                if (obj2 instanceof String) {
                    jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, (String) obj2);
                }
            }
            if (bundle.containsKey(IpcConfig.IPCKey.SOUND_MODE)) {
                Object obj3 = bundle.get(IpcConfig.IPCKey.SOUND_MODE);
                if (obj3 instanceof Integer) {
                    jsonObject.addProperty(IpcConfig.IPCKey.SOUND_MODE, (Integer) obj3);
                }
            }
            if (bundle.containsKey(IpcConfig.IPCKey.INT_VALUE)) {
                Object obj4 = bundle.get(IpcConfig.IPCKey.INT_VALUE);
                if (obj4 instanceof Integer) {
                    jsonObject.addProperty(IpcConfig.IPCKey.INT_VALUE, (Integer) obj4);
                }
            }
        }
        sendData(i, jsonObject.toString(), str);
    }

    public static void sendData(final int i, final String str, final String str2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendData id:" + i + ",bundle:" + str + ",pkgName:" + str2);
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Uri.Builder builder = new Uri.Builder();
                try {
                    ApiRouter.route(builder.authority(str2 + ".IpcRouterService").path("onReceiverData").appendQueryParameter(VuiConstants.ELEMENT_ID, String.valueOf(i)).appendQueryParameter("bundle", str).build());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* loaded from: classes2.dex */
    public static class IpcRouterEvent {
        private int mMsgID;
        private Bundle mPayloadData;
        private String mSenderPkgName;

        public int getMsgID() {
            return this.mMsgID;
        }

        public Bundle getPayloadData() {
            return this.mPayloadData;
        }

        public String getSenderPkgName() {
            return this.mSenderPkgName;
        }

        public IpcRouterEvent(int i, Bundle bundle, String str) {
            this.mMsgID = i;
            this.mPayloadData = bundle;
            this.mSenderPkgName = str;
        }
    }
}
