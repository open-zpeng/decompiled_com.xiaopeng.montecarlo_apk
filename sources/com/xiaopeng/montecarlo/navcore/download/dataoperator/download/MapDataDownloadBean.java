package com.xiaopeng.montecarlo.navcore.download.dataoperator.download;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import java.util.Comparator;
import java.util.Objects;
/* loaded from: classes2.dex */
public class MapDataDownloadBean {
    public static final int DOWNLOAD_PRIORITY_COUNTRY = 11;
    public static final int DOWNLOAD_PRIORITY_CRUISE = 8;
    public static final int DOWNLOAD_PRIORITY_CURRENT_CITY = 10;
    public static final int DOWNLOAD_PRIORITY_NAVI = 9;
    public static final int DOWNLOAD_PRIORITY_NEARBY = 5;
    public static final int DOWNLOAD_PRIORITY_PUSH_OPERATE = 7;
    public static final int DOWNLOAD_PRIORITY_UPDATE = 6;
    public static final Comparator<MapDataDownloadBean> sComparator = new Comparator() { // from class: com.xiaopeng.montecarlo.navcore.download.dataoperator.download.-$$Lambda$MapDataDownloadBean$dR13ZaXlAJqJp2zI-Bc40FRcxRg
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compare;
            MapDataDownloadBean mapDataDownloadBean = (MapDataDownloadBean) obj;
            MapDataDownloadBean mapDataDownloadBean2 = (MapDataDownloadBean) obj2;
            compare = Long.compare(mapDataDownloadBean2.mPriority, mapDataDownloadBean.mPriority);
            return compare;
        }
    };
    CityDataBean mCityDataBean;
    int mPriority;

    public MapDataDownloadBean(int i, @NonNull CityDataBean cityDataBean) {
        this.mPriority = i;
        this.mCityDataBean = cityDataBean;
    }

    public int getAdCode() {
        return this.mCityDataBean.getAdcode();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public CityDataBean getCityDataBean() {
        return this.mCityDataBean;
    }

    public static MapDataDownloadBean create(int i, int i2) {
        CityDataBean cityDataBean = MapDataManager.getInstance().getCityDataBean(i);
        if (cityDataBean != null) {
            return new MapDataDownloadBean(i2, cityDataBean);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MapDataDownloadBean mapDataDownloadBean = (MapDataDownloadBean) obj;
        return this.mPriority == mapDataDownloadBean.mPriority && getAdCode() == mapDataDownloadBean.getAdCode();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mPriority), Integer.valueOf(getAdCode()));
    }

    @io.reactivex.annotations.NonNull
    public String toString() {
        return "MapDataDownloadBean{mPriority=" + this.mPriority + ", CityAdCode=" + this.mCityDataBean.getAdcode() + ", CityUrCode=" + this.mCityDataBean.getUrcode() + ", CityTitle=" + this.mCityDataBean.getCityTitle() + '}';
    }
}
