package com.xiaopeng.montecarlo.aimessage;

import android.os.Bundle;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IpcRouterService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("IpcRouterService");

    @Publish
    public void onReceiverData(final int i, final String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onReceiverData id:" + i + ",bundle:" + str);
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.aimessage.IpcRouterService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Bundle bundle = new Bundle();
                    bundle.putString(IpcConfig.IPCKey.STRING_MSG, jSONObject.optString(IpcConfig.IPCKey.STRING_MSG));
                    bundle.putInt(IpcConfig.IPCKey.INT_VALUE, jSONObject.optInt(IpcConfig.IPCKey.INT_VALUE));
                    bundle.putBoolean(IpcConfig.IPCKey.BOOLEAN_VALUE, jSONObject.optBoolean(IpcConfig.IPCKey.BOOLEAN_VALUE));
                    bundle.putInt(IpcConfig.IPCKey.SOUND_MODE, jSONObject.optInt(IpcConfig.IPCKey.SOUND_MODE));
                    IpcRouterUtil.IpcRouterEvent ipcRouterEvent = new IpcRouterUtil.IpcRouterEvent(i, bundle, jSONObject.optString(IpcRouterUtil.KEY_SENDER_PACKAGE_NAME));
                    if (EventBus.getDefault().hasSubscriberForEvent(IpcRouterUtil.IpcRouterEvent.class)) {
                        EventBus.getDefault().post(ipcRouterEvent);
                    } else {
                        EventBus.getDefault().postSticky(ipcRouterEvent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
