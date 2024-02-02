package com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PdExternalData {
    public static final int EXTERNAL_DATA_ROUTE_CHARGE_PLAN = 0;
    public static final int EXTERNAL_DATA_TYPE_INVALID = -1;
    public static final String KEY_HIGHWAY_DIS = "key_highway_dis";
    public static final String KEY_ROUTE_PATH_COST = "key_route_path_cost_dis";
    public static final String KEY_ROUTE_POINTS = "key_route_points";
    public static final String KEY_ROUTE_REMAIN_DIS = "key_route_remain_dis";
    private HashMap<String, Object> mDataMap = new HashMap<>();
    private int mType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ExternalType {
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof PdExternalData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PdExternalData) {
            PdExternalData pdExternalData = (PdExternalData) obj;
            if (pdExternalData.canEqual(this) && getType() == pdExternalData.getType()) {
                HashMap<String, Object> dataMap = getDataMap();
                HashMap<String, Object> dataMap2 = pdExternalData.getDataMap();
                return dataMap != null ? dataMap.equals(dataMap2) : dataMap2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        HashMap<String, Object> dataMap = getDataMap();
        return ((getType() + 59) * 59) + (dataMap == null ? 43 : dataMap.hashCode());
    }

    public void setDataMap(HashMap<String, Object> hashMap) {
        this.mDataMap = hashMap;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toString() {
        return "PdExternalData(mType=" + getType() + ", mDataMap=" + getDataMap() + ")";
    }

    public int getType() {
        return this.mType;
    }

    public HashMap<String, Object> getDataMap() {
        return this.mDataMap;
    }

    public PdExternalData(int i) {
        this.mType = i;
    }

    public void putData(String str, Object obj) {
        this.mDataMap.put(str, obj);
    }

    public Object getData(String str) {
        return this.mDataMap.get(str);
    }
}
