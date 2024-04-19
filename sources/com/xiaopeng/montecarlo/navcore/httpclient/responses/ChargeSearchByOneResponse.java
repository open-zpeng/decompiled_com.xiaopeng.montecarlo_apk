package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.util.List;
/* loaded from: classes2.dex */
public class ChargeSearchByOneResponse {
    @SerializedName(SpeechWidget.TYPE_LIST)
    List<GeneralChargeInfo> mList;
    @SerializedName("totalNum")
    int mTotalNum;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeSearchByOneResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeSearchByOneResponse) {
            ChargeSearchByOneResponse chargeSearchByOneResponse = (ChargeSearchByOneResponse) obj;
            if (chargeSearchByOneResponse.canEqual(this) && getTotalNum() == chargeSearchByOneResponse.getTotalNum()) {
                List<GeneralChargeInfo> list = getList();
                List<GeneralChargeInfo> list2 = chargeSearchByOneResponse.getList();
                return list != null ? list.equals(list2) : list2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<GeneralChargeInfo> list = getList();
        return ((getTotalNum() + 59) * 59) + (list == null ? 43 : list.hashCode());
    }

    public ChargeSearchByOneResponse setList(List<GeneralChargeInfo> list) {
        this.mList = list;
        return this;
    }

    public ChargeSearchByOneResponse setTotalNum(int i) {
        this.mTotalNum = i;
        return this;
    }

    public String toString() {
        return "ChargeSearchByOneResponse(mTotalNum=" + getTotalNum() + ", mList=" + getList() + ")";
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public List<GeneralChargeInfo> getList() {
        return this.mList;
    }
}
