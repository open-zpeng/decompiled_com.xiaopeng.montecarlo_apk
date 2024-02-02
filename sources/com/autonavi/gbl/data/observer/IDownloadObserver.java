package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.router.DownloadObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = DownloadObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IDownloadObserver {
    void onDownLoadStatus(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @TaskStatusCode.TaskStatusCode1 int i4, @OperationErrCode.OperationErrCode1 int i5);

    void onOperated(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationType.OperationType1 int i3, ArrayList<Integer> arrayList);

    void onPercent(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4, float f);
}
