package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationErrCodeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.OperationTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.ProvinceTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.TaskStatusCodeEnum;
import com.xiaopeng.montecarlo.root.IWorkCallback;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ChildPositionInfo;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.EmptyItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
/* loaded from: classes3.dex */
public class MapDataAdapterProvider {
    private static final L.Tag TAG = new L.Tag("MapDataAdapterProvider");
    private final List<BaseItem> mRecyclerViewData = new ArrayList();
    private final Map<Integer, CityItem> mAdcode2CityItemMap = new ConcurrentHashMap();
    private volatile boolean mIsRecycleViewDataReady = false;
    private Semaphore mLock = new Semaphore(1, true);

    public boolean isRecycleViewDataReady() {
        return this.mIsRecycleViewDataReady;
    }

    @NonNull
    public List<BaseItem> getRecyclerViewData() {
        return this.mRecyclerViewData;
    }

    public int getRecyclerViewDataSize() {
        return this.mRecyclerViewData.size();
    }

    @WorkerThread
    public void generateRecycleViewData(final IWorkCallback iWorkCallback) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.adapter.-$$Lambda$MapDataAdapterProvider$eVZvTwJbSpcnlseXuVb72R1dmz8
            @Override // java.lang.Runnable
            public final void run() {
                MapDataAdapterProvider.this.lambda$generateRecycleViewData$0$MapDataAdapterProvider(iWorkCallback);
            }
        });
    }

    public /* synthetic */ void lambda$generateRecycleViewData$0$MapDataAdapterProvider(IWorkCallback iWorkCallback) {
        L.i(TAG, "generateRecycleViewData");
        try {
            try {
                this.mLock.acquire();
            } catch (InterruptedException e) {
                L.printStackTrace(TAG, e);
            }
            if (!MapDataManager.getInstance().isCityListReady()) {
                L.Tag tag = TAG;
                L.i(tag, "generateRecycleViewData, mIsRecycleViewDataReady=" + this.mIsRecycleViewDataReady);
                return;
            }
            this.mIsRecycleViewDataReady = false;
            createAdcode2CityItemMap();
            realCreateRecycleViewDataList();
            this.mIsRecycleViewDataReady = true;
        } finally {
            this.mLock.release();
            iWorkCallback.onFinish();
        }
    }

    private void createAdcode2CityItemMap() {
        if (!MapDataManager.getInstance().isCityListReady()) {
            L.i(TAG, "createAdcode2CityItemMap failed");
            return;
        }
        Map<Integer, CityDataBean> cityDataBeanMap = MapDataManager.getInstance().getCityDataBeanMap();
        if (cityDataBeanMap != null) {
            this.mAdcode2CityItemMap.clear();
            L.Tag tag = TAG;
            L.i(tag, "createAdcode2CityItemMap, allCityDataBeanList size=" + cityDataBeanMap.size());
            for (Map.Entry<Integer, CityDataBean> entry : cityDataBeanMap.entrySet()) {
                this.mAdcode2CityItemMap.put(entry.getKey(), new CityItem(entry.getValue()));
            }
        }
    }

    public void onDownLoadStatus(Integer num, TaskStatusCodeEnum taskStatusCodeEnum, OperationErrCodeEnum operationErrCodeEnum) {
        CityItem cityItem = this.mAdcode2CityItemMap.get(num);
        if (cityItem != null) {
            cityItem.setTaskState(taskStatusCodeEnum.getId());
        }
    }

    public void onOperated(OperationTypeEnum operationTypeEnum, Integer num) {
        CityItem cityItem = this.mAdcode2CityItemMap.get(num);
        if (cityItem != null) {
            cityItem.refreshData();
        }
    }

    public void onPercent(Integer num, Integer num2, Float f) {
        CityItem cityItem = this.mAdcode2CityItemMap.get(num);
        if (cityItem != null) {
            cityItem.setPercent(Math.round(f.floatValue()));
        }
    }

    @WorkerThread
    private void realCreateRecycleViewDataList() {
        L.i(TAG, "realCreateRecycleViewDataList start");
        this.mRecyclerViewData.clear();
        int initDirectOrSpecialCityData = initDirectOrSpecialCityData(ProvinceTypeEnum.PROVINCE_TYPE_SPECIAL_CITY, initNormalProvData(initDirectOrSpecialCityData(ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY, initCountryData(initNearbyCityData(initCurrentCityData(0))))));
        this.mRecyclerViewData.add(new EmptyItem());
        L.Tag tag = TAG;
        L.i(tag, "realCreateRecycleViewDataList end, groupPosition=" + initDirectOrSpecialCityData);
    }

    private int initCurrentCityData(int i) {
        int currentCityAdCode = MapDataManager.getInstance().getCurrentCityAdCode();
        CityItem cityItem = this.mAdcode2CityItemMap.get(Integer.valueOf(currentCityAdCode));
        if (cityItem != null) {
            cityItem.setChildPositionInfo(new ChildPositionInfo(i, 0, currentCityAdCode));
            this.mRecyclerViewData.add(cityItem);
            return i + 1;
        }
        return i;
    }

    private int initNearbyCityData(int i) {
        L.i(TAG, "initNearbyCityData");
        CityItem cityItem = this.mAdcode2CityItemMap.get(Integer.valueOf(MapDataManager.getInstance().getCurrentCityAdCode()));
        if (cityItem == null) {
            return i;
        }
        List<Integer> nearbyCityAdcodeList = cityItem.getNearbyCityAdcodeList();
        ProvinceDataBean provinceDataBean = MapDataManager.getInstance().getProvinceDataBean(ContextUtils.getString(R.string.download_map_data_nearby_city));
        if (provinceDataBean == null) {
            if (RootUtil.isUserVersion()) {
                return i;
            }
            MapDataManager.getInstance().printAllProvince();
            throw new NullPointerException();
        }
        MapDataManager.getInstance().setContainCitiesListForNearbyProvince(provinceDataBean, nearbyCityAdcodeList);
        ProvinceItem provinceItem = new ProvinceItem(provinceDataBean);
        ArrayList<CityItem> arrayList = new ArrayList<>();
        for (Integer num : nearbyCityAdcodeList) {
            CityItem cityItem2 = this.mAdcode2CityItemMap.get(num);
            if (cityItem2 != null) {
                arrayList.add(cityItem2);
            }
        }
        provinceItem.setContainCities(arrayList);
        provinceItem.setGroupPosition(i);
        this.mRecyclerViewData.add(provinceItem);
        return i + 1;
    }

    private int initNormalProvData(int i) {
        Map<String, ProvinceDataBean> provinceDataBeanList = MapDataManager.getInstance().getProvinceDataBeanList();
        if (provinceDataBeanList == null) {
            return i;
        }
        for (ProvinceDataBean provinceDataBean : provinceDataBeanList.values()) {
            if (provinceDataBean.isNormalProvince()) {
                ProvinceItem provinceItem = new ProvinceItem(provinceDataBean);
                int i2 = 0;
                ArrayList<CityItem> arrayList = new ArrayList<>();
                Iterator<CityDataBean> it = provinceDataBean.getContainCityList().iterator();
                while (it.hasNext()) {
                    CityDataBean next = it.next();
                    CityItem cityItem = this.mAdcode2CityItemMap.get(Integer.valueOf(next.getAdcode()));
                    if (cityItem != null) {
                        cityItem.setChildPositionInfo(new ChildPositionInfo(i, i2, cityItem.getAdcode())).setProvinceItem(provinceItem);
                        arrayList.add(cityItem);
                        i2++;
                    } else {
                        L.Tag tag = TAG;
                        L.w(tag, "initNormalProvData, cityItem is null, adcode = " + next.getAdcode());
                    }
                }
                provinceItem.setContainCities(arrayList);
                provinceItem.setGroupPosition(i);
                this.mRecyclerViewData.add(provinceItem);
                i++;
            }
        }
        return i;
    }

    private int initCountryData(int i) {
        CityItem cityItem = this.mAdcode2CityItemMap.get(0);
        if (cityItem != null) {
            cityItem.setChildPositionInfo(new ChildPositionInfo(i, 0, 0));
            this.mRecyclerViewData.add(cityItem);
            return i + 1;
        }
        L.w(TAG, "initCountryData, cityItem is null, adcode = 0");
        return i;
    }

    private int initDirectOrSpecialCityData(ProvinceTypeEnum provinceTypeEnum, int i) {
        ProvinceDataBean provinceDataBean;
        if (provinceTypeEnum != ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY && provinceTypeEnum != ProvinceTypeEnum.PROVINCE_TYPE_SPECIAL_CITY) {
            L.i(TAG, "initDirectOrSpecialCityData, type error");
            return i;
        }
        if (ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY == provinceTypeEnum) {
            provinceDataBean = MapDataManager.getInstance().getProvinceDataBean(ContextUtils.getString(R.string.download_direct_citie_title));
        } else {
            provinceDataBean = MapDataManager.getInstance().getProvinceDataBean(ContextUtils.getString(R.string.download_special_citie_title));
        }
        if (provinceDataBean == null) {
            return i;
        }
        ProvinceItem provinceItem = new ProvinceItem(provinceDataBean);
        int i2 = 0;
        ArrayList<CityItem> arrayList = new ArrayList<>();
        Iterator<CityDataBean> it = provinceDataBean.getContainCityList().iterator();
        while (it.hasNext()) {
            CityDataBean next = it.next();
            CityItem cityItem = this.mAdcode2CityItemMap.get(Integer.valueOf(next.getAdcode()));
            if (cityItem != null) {
                cityItem.setChildPositionInfo(new ChildPositionInfo(i, i2, cityItem.getAdcode()));
                cityItem.setProvinceItem(provinceItem);
                arrayList.add(cityItem);
                i2++;
            } else {
                L.Tag tag = TAG;
                L.w(tag, "initDirectOrSpecialCityData, cityItem is null, adcode = " + next.getAdcode());
            }
        }
        provinceItem.setContainCities(arrayList);
        provinceItem.setGroupPosition(i);
        this.mRecyclerViewData.add(provinceItem);
        return i + 1;
    }

    public CityItem getCityItem(Integer num) {
        return this.mAdcode2CityItemMap.get(num);
    }
}
