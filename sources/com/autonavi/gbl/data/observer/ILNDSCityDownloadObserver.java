package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDSFileRecoverStatus;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.router.LNDSCityDownloadObserverRouter;
@IntfAuto(target = LNDSCityDownloadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSCityDownloadObserver {
    void onDownloadError(int i, @OperationErrCode.OperationErrCode1 int i2);

    void onDownloadProgress(int i, long j, float f);

    void onDownloadStatus(int i, @TaskStatusCode.TaskStatusCode1 int i2);

    void onDownloadVersion(int i, String str);

    void onFileRecoverStatus(@LNDSFileRecoverStatus.LNDSFileRecoverStatus1 int i);

    void onMergeProgress(int i, float f);
}
