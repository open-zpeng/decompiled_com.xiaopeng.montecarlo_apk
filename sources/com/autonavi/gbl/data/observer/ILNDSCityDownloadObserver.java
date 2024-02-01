package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDSFileRecoverStatus;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.router.LNDSCityDownloadObserverRouter;
@IntfAuto(target = LNDSCityDownloadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSCityDownloadObserver {
    default void onDownloadError(int i, int i2) {
    }

    default void onDownloadProgress(int i, long j, float f) {
    }

    default void onDownloadStatus(int i, @TaskStatusCode.TaskStatusCode1 int i2) {
    }

    default void onDownloadVersion(int i, String str) {
    }

    default void onFileRecoverStatus(@LNDSFileRecoverStatus.LNDSFileRecoverStatus1 int i) {
    }

    default void onMergeProgress(int i, float f) {
    }
}
