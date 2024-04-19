package com.xiaopeng.montecarlo.navcore.download.bean;

import com.xiaopeng.montecarlo.navcore.download.constant.ProvinceTypeEnum;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ProvinceDataBean {
    private static final L.Tag TAG = new L.Tag("ProvinceDataBean");
    private int mCityNumbers;
    private ArrayList<CityDataBean> mContainCityList;
    private boolean mIsAllCityUpToDate = true;
    private String mName;
    private ProvinceTypeEnum mProvinceBeanType;
    private long mRemainSize;
    private long mTotalSize;

    public int getCityNumbers() {
        return this.mCityNumbers;
    }

    public long getRemainSize() {
        return this.mRemainSize;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public ProvinceTypeEnum getProvinceBeanType() {
        return this.mProvinceBeanType;
    }

    public boolean isAllCityUpToDate() {
        return this.mIsAllCityUpToDate;
    }

    public String getName() {
        return this.mName;
    }

    public ArrayList<CityDataBean> getContainCityList() {
        return this.mContainCityList;
    }

    public ProvinceDataBean(ProvinceTypeEnum provinceTypeEnum, String str) {
        this.mProvinceBeanType = provinceTypeEnum;
        this.mName = str;
    }

    public void setContainCityDataBeanList(ArrayList<CityDataBean> arrayList) {
        this.mContainCityList = arrayList;
        refreshData();
    }

    public void refreshData() {
        ArrayList<CityDataBean> arrayList = this.mContainCityList;
        if (arrayList == null) {
            return;
        }
        Iterator<CityDataBean> it = arrayList.iterator();
        long j = 0;
        int i = 0;
        long j2 = 0;
        while (it.hasNext()) {
            CityDataBean next = it.next();
            j2 += next.getDataPatchSize();
            j += next.getDataFullSize();
            if (!next.isFinish()) {
                i++;
            }
        }
        if (i > 0) {
            this.mIsAllCityUpToDate = false;
        } else {
            this.mIsAllCityUpToDate = true;
        }
        this.mCityNumbers = this.mContainCityList.size();
        this.mTotalSize = j;
        this.mRemainSize = j2;
    }

    public boolean isNormalProvince() {
        return ProvinceTypeEnum.PROVINCE_TYPE_PROVINCE == this.mProvinceBeanType;
    }
}
