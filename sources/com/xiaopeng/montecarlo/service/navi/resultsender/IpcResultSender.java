package com.xiaopeng.montecarlo.service.navi.resultsender;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.service.navi.type.Request;
import com.xiaopeng.montecarlo.service.navi.type.Result;
/* loaded from: classes3.dex */
public class IpcResultSender implements IResultSender {
    private static final int IPC_BACKRESULT_MSG_ID = 2000;

    @Override // com.xiaopeng.montecarlo.service.navi.resultsender.IResultSender
    public void sendResult(@NonNull Context context, @NonNull Request request, @NonNull Result result) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(result));
        if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
            IpcRouterUtil.sendData(2000, bundle, request.getApp_id());
            return;
        }
        IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        if (iIpcService != null) {
            iIpcService.sendData(2000, bundle, request.getApp_id());
        }
    }
}
