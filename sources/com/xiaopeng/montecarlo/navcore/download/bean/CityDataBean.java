package com.xiaopeng.montecarlo.navcore.download.bean;

import android.os.SystemClock;
import com.autonavi.gbl.data.model.CityDownLoadItem;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CityDataBean {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INVALID_STRING = "";
    public static final long INVALID_UNZIPPING_START_TIME = Long.MAX_VALUE;
    public static final long UNZIPPING_BLOCKING_TIME = 300000;
    private CityDownLoadItem mCityDownLoadItem;
    private CityItemInfo mCityItemInfo;
    private List<Integer> mNearbyCityList;
    private float mPercent;
    private ProvinceDataBean mProvinceDataBean;
    private long mUnzippingStartTime = Long.MAX_VALUE;
    private int mUrcode;

    public float getPercent() {
        return this.mPercent;
    }

    public long getUnzippingStartTime() {
        return this.mUnzippingStartTime;
    }

    public int getUrcode() {
        return this.mUrcode;
    }

    public ProvinceDataBean getProvinceDataBean() {
        return this.mProvinceDataBean;
    }

    public void setProvinceDataBean(ProvinceDataBean provinceDataBean) {
        this.mProvinceDataBean = provinceDataBean;
    }

    public List<Integer> getNearbyCityList() {
        return this.mNearbyCityList;
    }

    public CityDataBean(CityItemInfo cityItemInfo, CityDownLoadItem cityDownLoadItem, List<Integer> list, int i) {
        this.mCityItemInfo = cityItemInfo;
        this.mCityDownLoadItem = cityDownLoadItem;
        this.mPercent = this.mCityDownLoadItem.percent;
        this.mUrcode = i;
        this.mNearbyCityList = new ArrayList(list);
    }

    public void refreshData(CityDownLoadItem cityDownLoadItem) {
        if (cityDownLoadItem != null && getAdcode() == cityDownLoadItem.adcode) {
            this.mCityDownLoadItem = cityDownLoadItem;
            this.mPercent = this.mCityDownLoadItem.percent;
            TaskStatusCodeEnum parse = TaskStatusCodeEnum.parse(this.mCityDownLoadItem.taskState);
            if (parse == TaskStatusCodeEnum.TASK_STATUS_CODE_UNZIPPING) {
                this.mUnzippingStartTime = SystemClock.elapsedRealtime();
            } else if (parse == TaskStatusCodeEnum.TASK_STATUS_CODE_SUCCESS) {
                this.mUnzippingStartTime = Long.MAX_VALUE;
            }
        }
    }

    public void refreshPercent(float f) {
        this.mPercent = f;
    }

    public String getCityTitle() {
        CityItemInfo cityItemInfo = this.mCityItemInfo;
        return cityItemInfo != null ? cityItemInfo.cityName : "";
    }

    public long getDataPatchSize() {
        if (isFinish()) {
            return 0L;
        }
        return getRealDataPatchSize();
    }

    public long getRealDataPatchSize() {
        if (this.mCityDownLoadItem.bIsDataUsed) {
            return this.mCityDownLoadItem.nZipSize.longValue();
        }
        return this.mCityDownLoadItem.nFullZipSize.longValue();
    }

    public int getDataFullSize() {
        return this.mCityDownLoadItem.nFullZipSize.intValue();
    }

    public int getAdcode() {
        return this.mCityDownLoadItem.adcode;
    }

    public int getTaskState() {
        return this.mCityDownLoadItem.taskState;
    }

    public boolean isReady() {
        return getTaskState() == 0;
    }

    public boolean isDownloading() {
        return 2 == getTaskState();
    }

    public boolean isPaused() {
        return 3 == getTaskState();
    }

    public boolean isWaiting() {
        return 1 == getTaskState();
    }

    public boolean isError() {
        return 10 == getTaskState();
    }

    public boolean isFinish() {
        return 9 == getTaskState();
    }

    public String toString() {
        return getCityTitle();
    }
}
