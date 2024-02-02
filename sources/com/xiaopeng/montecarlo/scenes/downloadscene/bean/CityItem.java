package com.xiaopeng.montecarlo.scenes.downloadscene.bean;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class CityItem extends BaseItem {
    private static final L.Tag TAG = new L.Tag("CityItem");
    private ChildPositionInfo mChildPositionInfo;
    private CityDataBean mCityDataBean;
    private boolean mIsCurrentCity;
    public boolean mIsLastItem = false;
    private String mLastPatchSize;
    private int mPercent;
    private ProvinceItem mProvinceItem;
    private int mTaskState;

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isParent() {
        return false;
    }

    public CityItem setChildPositionInfo(ChildPositionInfo childPositionInfo) {
        this.mChildPositionInfo = childPositionInfo;
        return this;
    }

    public boolean isCurrentCity() {
        return this.mIsCurrentCity;
    }

    public String getLastPatchSize() {
        return this.mLastPatchSize;
    }

    public ProvinceItem getProvinceItem() {
        return this.mProvinceItem;
    }

    public CityItem setProvinceItem(ProvinceItem provinceItem) {
        this.mProvinceItem = provinceItem;
        return this;
    }

    public int getPercent() {
        return this.mPercent;
    }

    public CityItem setPercent(int i) {
        this.mPercent = i;
        return this;
    }

    public int getTaskState() {
        return this.mTaskState;
    }

    public CityItem setTaskState(int i) {
        this.mTaskState = i;
        return this;
    }

    public boolean isLastItem() {
        return this.mIsLastItem;
    }

    public CityItem setLastItem(boolean z) {
        this.mIsLastItem = z;
        return this;
    }

    public CityItem(@NonNull CityDataBean cityDataBean) {
        this.mIsCurrentCity = false;
        this.mCityDataBean = cityDataBean;
        this.mTaskState = cityDataBean.getTaskState();
        this.mPercent = (int) cityDataBean.getPercent();
        this.mLastPatchSize = RootUtil.getFormatSize(this.mCityDataBean.getDataPatchSize());
        if (this.mCityDataBean.getAdcode() == MapDataManager.getInstance().getCurrentCityAdCode()) {
            this.mIsCurrentCity = true;
        }
    }

    public int getDataFullSize() {
        return this.mCityDataBean.getDataFullSize();
    }

    public String getCityTitle() {
        if (getAdcode() == 0) {
            return ContextUtils.getString(R.string.download_base_map_title);
        }
        return this.mCityDataBean.getCityTitle();
    }

    public long getDataPatchSize() {
        return this.mCityDataBean.getDataPatchSize();
    }

    public int getAdcode() {
        return this.mCityDataBean.getAdcode();
    }

    public boolean isNeedShowProgressBar() {
        if (MapDataManager.getInstance().isCompletedInitialized()) {
            int i = this.mTaskState;
            return 2 == i || 3 == i || 1 == i || i == 0 || 10 == i;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getGroupPosition() {
        ChildPositionInfo childPositionInfo = this.mChildPositionInfo;
        if (childPositionInfo != null) {
            return childPositionInfo.getGroupPosition();
        }
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getChildPosition() {
        ChildPositionInfo childPositionInfo = this.mChildPositionInfo;
        if (childPositionInfo != null) {
            return childPositionInfo.getChildPosition();
        }
        return -1;
    }

    public List<Integer> getNearbyCityAdcodeList() {
        return this.mCityDataBean.getNearbyCityList();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isGrayColor() {
        return !MapDataManager.getInstance().isCompletedInitialized() || isReady() || isFinish();
    }

    public boolean isReady() {
        if (3 == this.mTaskState && this.mPercent == 0) {
            return true;
        }
        int i = this.mTaskState;
        if (10 != i) {
            return i == 0;
        }
        L.Tag tag = TAG;
        L.i(tag, this.mCityDataBean.getCityTitle() + " is error, remain " + RootUtil.getFormatSize(this.mCityDataBean.getDataPatchSize()));
        return true;
    }

    public boolean isDownloading() {
        return 2 == this.mTaskState;
    }

    public boolean isPaused() {
        return 3 == this.mTaskState;
    }

    public boolean isWaiting() {
        return 1 == this.mTaskState;
    }

    public boolean isError() {
        return 10 == this.mTaskState;
    }

    public boolean isFinish() {
        return 9 == this.mTaskState;
    }

    public boolean isUnZipping() {
        int i = this.mTaskState;
        return 7 == i || 4 == i;
    }

    public boolean isUnZipped() {
        return 8 == this.mTaskState;
    }

    public int getDownloadPercent() {
        if (isReady()) {
            return 100;
        }
        return this.mPercent;
    }

    public void refreshData() {
        this.mPercent = (int) this.mCityDataBean.getPercent();
        this.mTaskState = this.mCityDataBean.getTaskState();
    }

    public String toString() {
        return getCityTitle();
    }
}
