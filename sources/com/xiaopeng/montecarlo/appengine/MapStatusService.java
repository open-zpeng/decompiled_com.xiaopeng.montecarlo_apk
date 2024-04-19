package com.xiaopeng.montecarlo.appengine;

import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
/* loaded from: classes2.dex */
public class MapStatusService implements IServicePublisher {
    private static final String AUTHORITY = "com.xiaopeng.aiassistant.AiassistantService";
    private static final String PARAMETER_IS_DREW = "isDrew";
    private static final String PATH = "isMapFirstFrameDrew";
    public static final L.Tag TAG = new L.Tag("MapStatusService");

    public static void noticeMapFirstFrameDrawStatus(final boolean z) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.appengine.MapStatusService.1
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = MapStatusService.TAG;
                L.i(tag, "noticeMapFirstFrameDrawStatus isDrew:" + z);
                Uri.Builder builder = new Uri.Builder();
                builder.authority(MapStatusService.AUTHORITY).path(MapStatusService.PATH).appendQueryParameter(MapStatusService.PARAMETER_IS_DREW, String.valueOf(z));
                try {
                    ApiRouter.route(builder.build());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Publish
    public boolean isMapFirstFrameDrew() {
        boolean z = NaviUtil.sIsMapFirstFrameDrew;
        L.Tag tag = TAG;
        L.i(tag, "isMapFirstFrameDrawn isDrew:" + z);
        return NaviUtil.sIsMapFirstFrameDrew;
    }
}
