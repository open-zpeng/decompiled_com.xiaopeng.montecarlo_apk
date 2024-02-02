package com.xiaopeng.montecarlo.navcore.download.callback;

import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface IDownloadDataChangeCallback {
    void onCityDataFetched();

    default void onCityDataGenerated() {
    }

    void onCityListCreated();

    void onDownLoadStatus(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum);

    void onOperated(OperationTypeEnum operationTypeEnum, ArrayList<Integer> arrayList);

    void onPercent(Integer num, Integer num2, Float f);
}
