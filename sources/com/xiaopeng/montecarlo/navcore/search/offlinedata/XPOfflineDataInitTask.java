package com.xiaopeng.montecarlo.navcore.search.offlinedata;
/* loaded from: classes3.dex */
public class XPOfflineDataInitTask {
    public static final int DEFAULT_RETRY_TIMES = 5;
    public static final int TASK_STATUS_FAIL = 1;
    public static final int TASK_STATUS_NOT_START = -1;
    public static final int TASK_STATUS_SUCCESS = 0;
    public static final int TASK_TYPE_INIT_CHARGE_DATA = 4;
    public static final int TASK_TYPE_INIT_KEYWORD_DATA = 1;
    public static final int TASK_TYPE_INIT_LCC_GEO_FENCE_DATA = 7;
    public static final int TASK_TYPE_INIT_SCRATCH_SPOT_DATA = 3;
    public static final int TASK_TYPE_INIT_SEAMLESS_DATA = 5;
    public static final int TASK_TYPE_INIT_SERVICE_CENTER_DATA = 2;
    public static final int TASK_TYPE_INIT_SR_CAR_MODEL_DATA = 6;
    private int mRemainTryTimes = 5;
    private int mTaskStatus = -1;
    private int mTaskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XPOfflineDataInitTask(int i) {
        this.mTaskType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void setTaskType(int i) {
        this.mTaskType = i;
    }

    public int getRemainTryTimes() {
        return this.mRemainTryTimes;
    }

    public void setRemainTryTimes(int i) {
        this.mRemainTryTimes = i;
    }

    public int getTaskStatus() {
        return this.mTaskStatus;
    }

    public void setTaskStatus(int i) {
        this.mTaskStatus = i;
    }
}
