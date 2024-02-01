package com.xiaopeng.montecarlo.scenes.downloadscene.bean;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.ProvinceTypeEnum;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ProvinceItem extends BaseItem {
    private int mGroupPosition;
    private ProvinceDataBean mProvinceDataBean;
    private String mProvinceTitle;
    private boolean mIsExpand = false;
    private ArrayList<CityItem> mCityItemList = new ArrayList<>();
    private boolean mIsCurrentProvince = false;

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getChildPosition() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isParent() {
        return true;
    }

    public String getProvinceTitle() {
        return this.mProvinceTitle;
    }

    public boolean isExpand() {
        return this.mIsExpand;
    }

    public ArrayList<CityItem> getCityItemList() {
        return this.mCityItemList;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getGroupPosition() {
        return this.mGroupPosition;
    }

    public void setGroupPosition(int i) {
        this.mGroupPosition = i;
    }

    public boolean isCurrentProvince() {
        return this.mIsCurrentProvince;
    }

    public ProvinceItem(@NonNull ProvinceDataBean provinceDataBean) {
        this.mProvinceDataBean = provinceDataBean;
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum[provinceDataBean.getProvinceBeanType().ordinal()];
        if (i == 1) {
            this.mProvinceTitle = String.format(Locale.CHINA, ContextUtils.getString(R.string.download_nearby_city_recommend), Integer.valueOf(this.mProvinceDataBean.getCityNumbers()));
        } else if (i == 2 || i == 3 || i == 4) {
            this.mProvinceTitle = this.mProvinceDataBean.getName();
        }
        if (ProvinceTypeEnum.PROVINCE_TYPE_NEARBY_CITY == this.mProvinceDataBean.getProvinceBeanType()) {
            this.mProvinceTitle = String.format(Locale.CHINA, ContextUtils.getString(R.string.download_nearby_city_recommend), Integer.valueOf(this.mProvinceDataBean.getCityNumbers()));
        }
    }

    /* renamed from: com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum = new int[ProvinceTypeEnum.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum[ProvinceTypeEnum.PROVINCE_TYPE_NEARBY_CITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum[ProvinceTypeEnum.PROVINCE_TYPE_PROVINCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum[ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$download$constant$ProvinceTypeEnum[ProvinceTypeEnum.PROVINCE_TYPE_SPECIAL_CITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isGrayColor() {
        if (MapDataManager.getInstance().isCompletedInitialized()) {
            return isAllCityUpToDate();
        }
        return true;
    }

    public long getTotalSize() {
        return this.mProvinceDataBean.getTotalSize();
    }

    public boolean hasChilds() {
        return !this.mCityItemList.isEmpty();
    }

    public long getRemainSize() {
        return this.mProvinceDataBean.getRemainSize();
    }

    public boolean isAllCityUpToDate() {
        return this.mProvinceDataBean.isAllCityUpToDate();
    }

    public void setContainCities(@NonNull ArrayList<CityItem> arrayList) {
        this.mCityItemList = arrayList;
        Iterator<CityItem> it = this.mCityItemList.iterator();
        while (it.hasNext()) {
            if (it.next().isCurrentCity()) {
                this.mIsCurrentProvince = true;
            }
        }
    }

    public String toString() {
        return getProvinceTitle();
    }

    public boolean equals(Object obj) {
        String provinceTitle;
        if ((obj instanceof ProvinceItem) && (provinceTitle = getProvinceTitle()) != null && provinceTitle.equals(((ProvinceItem) obj).getProvinceTitle())) {
            return true;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String provinceTitle = getProvinceTitle();
        if (provinceTitle != null) {
            return provinceTitle.hashCode();
        }
        return super.hashCode();
    }

    public void onExpand() {
        this.mIsExpand = !this.mIsExpand;
    }
}
