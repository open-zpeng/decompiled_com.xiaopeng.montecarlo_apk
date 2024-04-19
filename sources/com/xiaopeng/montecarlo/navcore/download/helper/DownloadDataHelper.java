package com.xiaopeng.montecarlo.navcore.download.helper;

import androidx.annotation.NonNull;
import com.autonavi.gbl.data.model.Area;
import com.autonavi.gbl.data.model.CityDownLoadItem;
import com.autonavi.gbl.data.model.CityItemInfo;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.download.bean.ProvinceDataBean;
import com.xiaopeng.montecarlo.navcore.download.constant.CityTypeEnum;
import com.xiaopeng.montecarlo.navcore.download.constant.ProvinceTypeEnum;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class DownloadDataHelper {
    private static final L.Tag TAG = new L.Tag("DownloadDataHelper");
    private final Map<Integer, CityDataBean> mAllCityDataBeanMap = new ConcurrentHashMap();
    private final Map<String, ProvinceDataBean> mAllProvinceDataBeanMap = new ConcurrentHashMap();
    private MapDataManager mMapDataManager;

    public DownloadDataHelper(@NonNull MapDataManager mapDataManager) {
        this.mMapDataManager = mapDataManager;
    }

    public void generateAllCityData() {
        L.i(TAG, "generateAllCityData");
        this.mAllCityDataBeanMap.clear();
        initCityData(0);
        initCityData(1);
        initCityData(2);
        initCityData(3);
        initCityData(4);
    }

    public void generateAllProvinceData() {
        this.mAllProvinceDataBeanMap.clear();
        initNormalProvData();
        initNearbyProvData();
        initDirectOrSpecialCityData(ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY);
        initDirectOrSpecialCityData(ProvinceTypeEnum.PROVINCE_TYPE_SPECIAL_CITY);
    }

    private void initCityData(int i) {
        List<Integer> adcodeList = this.mMapDataManager.getAdcodeList(i);
        if (adcodeList == null) {
            L.Tag tag = TAG;
            L.e(tag, "initCityData adCodeLst is null  areaType:" + i);
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "initCityData size: " + adcodeList.size());
        if (adcodeList.size() <= 0) {
            return;
        }
        for (Integer num : adcodeList) {
            int intValue = num.intValue();
            int urcodeByAdcode = this.mMapDataManager.getUrcodeByAdcode(intValue);
            CityItemInfo cityInfo = this.mMapDataManager.getCityInfo(intValue);
            CityDownLoadItem cityDownLoadItem = this.mMapDataManager.getCityDownLoadItem(intValue);
            Area area = this.mMapDataManager.getArea(intValue);
            if (cityInfo != null && cityDownLoadItem != null) {
                this.mAllCityDataBeanMap.put(Integer.valueOf(intValue), new CityDataBean(cityInfo, cityDownLoadItem, area.vecNearAdcodeList, urcodeByAdcode));
            } else {
                L.Tag tag3 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(cityInfo == null);
                sb.append(",");
                sb.append(cityDownLoadItem == null);
                L.w(tag3, sb.toString());
            }
        }
    }

    private void initNearbyProvData() {
        ProvinceDataBean provinceDataBean = new ProvinceDataBean(ProvinceTypeEnum.PROVINCE_TYPE_NEARBY_CITY, ContextUtils.getString(R.string.map_data_nearby_city));
        this.mAllProvinceDataBeanMap.put(provinceDataBean.getName(), provinceDataBean);
    }

    public void setContainCitiesListForNearbyProvince(ProvinceDataBean provinceDataBean, List<Integer> list) {
        if (provinceDataBean.getProvinceBeanType() != ProvinceTypeEnum.PROVINCE_TYPE_NEARBY_CITY) {
            return;
        }
        ArrayList<CityDataBean> arrayList = new ArrayList<>();
        for (Integer num : list) {
            arrayList.add(getRealCityDataBean(num.intValue()));
        }
        provinceDataBean.setContainCityDataBeanList(arrayList);
        this.mAllProvinceDataBeanMap.put(provinceDataBean.getName(), provinceDataBean);
    }

    private void initNormalProvData() {
        List<Integer> adcodeList = this.mMapDataManager.getAdcodeList(ProvinceTypeEnum.PROVINCE_TYPE_PROVINCE.getId());
        if (adcodeList == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "initAllProvData, provinceList size: " + adcodeList.size());
        for (Integer num : adcodeList) {
            Area area = this.mMapDataManager.getArea(num.intValue());
            if (area == null) {
                L.w(TAG, "initAllProvData, area is null");
                return;
            }
            ProvinceDataBean provinceDataBean = new ProvinceDataBean(ProvinceTypeEnum.PROVINCE_TYPE_PROVINCE, area.name);
            if (area.vecLowerAdcodeList != null) {
                ArrayList<CityDataBean> arrayList = new ArrayList<>();
                Iterator<Integer> it = area.vecLowerAdcodeList.iterator();
                while (it.hasNext()) {
                    CityDataBean cityDataBean = this.mAllCityDataBeanMap.get(Integer.valueOf(it.next().intValue()));
                    cityDataBean.setProvinceDataBean(provinceDataBean);
                    arrayList.add(cityDataBean);
                }
                provinceDataBean.setContainCityDataBeanList(arrayList);
            }
            this.mAllProvinceDataBeanMap.put(provinceDataBean.getName(), provinceDataBean);
        }
    }

    private void initDirectOrSpecialCityData(ProvinceTypeEnum provinceTypeEnum) {
        ProvinceDataBean provinceDataBean;
        if (provinceTypeEnum != ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY && provinceTypeEnum != ProvinceTypeEnum.PROVINCE_TYPE_SPECIAL_CITY) {
            L.i(TAG, "initDirectOrSpecialCityData, type error");
            return;
        }
        if (ProvinceTypeEnum.PROVINCE_TYPE_DIRECT_CITY == provinceTypeEnum) {
            provinceDataBean = new ProvinceDataBean(provinceTypeEnum, ContextUtils.getString(R.string.map_data_direct_province));
        } else {
            provinceDataBean = new ProvinceDataBean(provinceTypeEnum, ContextUtils.getString(R.string.map_data_special_province));
        }
        List<Integer> adcodeList = this.mMapDataManager.getAdcodeList(provinceTypeEnum.getId());
        ArrayList<CityDataBean> arrayList = new ArrayList<>();
        if (adcodeList != null) {
            for (Integer num : adcodeList) {
                CityDataBean cityDataBean = this.mAllCityDataBeanMap.get(num);
                if (cityDataBean == null) {
                    L.Tag tag = TAG;
                    L.w(tag, "AllCityDataBeanMap.get null:" + num);
                } else {
                    cityDataBean.setProvinceDataBean(provinceDataBean);
                    arrayList.add(cityDataBean);
                }
            }
        }
        provinceDataBean.setContainCityDataBeanList(arrayList);
        this.mAllProvinceDataBeanMap.put(provinceDataBean.getName(), provinceDataBean);
    }

    public ProvinceDataBean getRealProvinceDataBean(String str) {
        return this.mAllProvinceDataBeanMap.get(str);
    }

    public CityDataBean getRealCityDataBean(int i) {
        CityDataBean cityDataBean = this.mAllCityDataBeanMap.get(Integer.valueOf(i));
        return cityDataBean != null ? cityDataBean : this.mAllCityDataBeanMap.get(Integer.valueOf((i / 100) * 100));
    }

    public Map<Integer, CityDataBean> getCityDataBeanList() {
        return this.mAllCityDataBeanMap;
    }

    public Map<String, ProvinceDataBean> getProvinceDataBeanList() {
        return this.mAllProvinceDataBeanMap;
    }

    public CityTypeEnum getCityTypeByAdcode(int i) {
        if (i == MapDataManager.getInstance().getCurrentCityAdCode()) {
            return CityTypeEnum.CITY_TYPE_CURRENT_CITY;
        }
        if (i == 0) {
            return CityTypeEnum.CITY_TYPE_BASE_CITY;
        }
        List<Integer> nearbyCityAdCodeList = MapDataManager.getInstance().getNearbyCityAdCodeList();
        if (nearbyCityAdCodeList != null && nearbyCityAdCodeList.contains(Integer.valueOf(i))) {
            return CityTypeEnum.CITY_TYPE_NEARBY_CITY;
        }
        return CityTypeEnum.CITY_TYPE_NORMAL_CITY;
    }

    public CityDataBean getCityDataBeanByUrId(int i) {
        for (Map.Entry<Integer, CityDataBean> entry : this.mAllCityDataBeanMap.entrySet()) {
            if (i == entry.getValue().getUrcode()) {
                return entry.getValue();
            }
        }
        return null;
    }
}
