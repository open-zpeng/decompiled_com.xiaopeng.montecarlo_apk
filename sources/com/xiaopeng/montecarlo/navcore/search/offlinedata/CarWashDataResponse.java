package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CarWashInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes3.dex */
public class CarWashDataResponse {
    public static final String RESPONSE_CODE_OK = "0";
    private static final L.Tag TAG = new L.Tag("CarWashDataResponse");
    @SerializedName("data")
    private List<CarWashInfo> mData;
    @SerializedName("retCode")
    private String mRetCode;
    @SerializedName("retMsg")
    private String mRetMsg;

    protected boolean canEqual(Object obj) {
        return obj instanceof CarWashDataResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CarWashDataResponse) {
            CarWashDataResponse carWashDataResponse = (CarWashDataResponse) obj;
            if (carWashDataResponse.canEqual(this)) {
                String retCode = getRetCode();
                String retCode2 = carWashDataResponse.getRetCode();
                if (retCode != null ? retCode.equals(retCode2) : retCode2 == null) {
                    String retMsg = getRetMsg();
                    String retMsg2 = carWashDataResponse.getRetMsg();
                    if (retMsg != null ? retMsg.equals(retMsg2) : retMsg2 == null) {
                        List<CarWashInfo> data = getData();
                        List<CarWashInfo> data2 = carWashDataResponse.getData();
                        return data != null ? data.equals(data2) : data2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String retCode = getRetCode();
        int hashCode = retCode == null ? 43 : retCode.hashCode();
        String retMsg = getRetMsg();
        int hashCode2 = ((hashCode + 59) * 59) + (retMsg == null ? 43 : retMsg.hashCode());
        List<CarWashInfo> data = getData();
        return (hashCode2 * 59) + (data != null ? data.hashCode() : 43);
    }

    public void setData(List<CarWashInfo> list) {
        this.mData = list;
    }

    public void setRetCode(String str) {
        this.mRetCode = str;
    }

    public void setRetMsg(String str) {
        this.mRetMsg = str;
    }

    public String toString() {
        return "CarWashDataResponse(mRetCode=" + getRetCode() + ", mRetMsg=" + getRetMsg() + ", mData=" + getData() + ")";
    }

    public String getRetCode() {
        return this.mRetCode;
    }

    public String getRetMsg() {
        return this.mRetMsg;
    }

    public List<CarWashInfo> getData() {
        return this.mData;
    }
}
