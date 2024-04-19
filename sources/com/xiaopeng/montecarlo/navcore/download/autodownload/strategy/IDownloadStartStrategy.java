package com.xiaopeng.montecarlo.navcore.download.autodownload.strategy;

import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
/* loaded from: classes2.dex */
public interface IDownloadStartStrategy {
    void execute();

    void interrupt();

    void onCityDataStatusChange(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum);

    void onOperated(OperationTypeEnum operationTypeEnum, Integer num);
}
