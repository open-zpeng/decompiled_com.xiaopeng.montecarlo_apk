package com.xiaopeng.montecarlo.navcore.download.autodownload.strategy;

import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class DownloadStrategyNoNet implements IDownloadStartStrategy {
    private static final L.Tag TAG = new L.Tag("DownloadStrategyNoNet");

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onOperated(OperationTypeEnum operationTypeEnum, Integer num) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void execute() {
        L.i(TAG, "execute");
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void interrupt() {
        L.i(TAG, "interrupt");
    }

    @Override // com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.IDownloadStartStrategy
    public void onCityDataStatusChange(int i, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        L.i(TAG, "onCityDataStatusChange");
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
