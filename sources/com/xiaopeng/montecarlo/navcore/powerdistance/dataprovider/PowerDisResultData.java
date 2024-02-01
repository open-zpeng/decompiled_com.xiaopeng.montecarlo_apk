package com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider;

import com.xiaopeng.montecarlo.navcore.powerdistance.EnergyInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import java.util.List;
/* loaded from: classes3.dex */
public class PowerDisResultData extends BaseResultData {
    public static final int REFRESH_ONLINE_K_ERROR = -1;
    private int mCostDis;
    private List<EnergyInfo> mEnergyInfoList;
    private PdExternalData mExternalData;
    private double mK;
    private int mParamType = -1;
    private int mRemainDis;

    public double getK() {
        return this.mK;
    }

    public void setK(double d) {
        this.mK = d;
    }

    public int getParamType() {
        return this.mParamType;
    }

    public void setParamType(int i) {
        this.mParamType = i;
    }

    public int getRemainDis() {
        return this.mRemainDis;
    }

    public void setRemainDis(int i) {
        this.mRemainDis = i;
    }

    public int getCostDis() {
        return this.mCostDis;
    }

    public void setCostDis(int i) {
        this.mCostDis = i;
    }

    public List<EnergyInfo> getEnergyInfoList() {
        return this.mEnergyInfoList;
    }

    public void setEnergyInfoList(List<EnergyInfo> list) {
        this.mEnergyInfoList = list;
    }

    public PdExternalData getExternalData() {
        return this.mExternalData;
    }

    public void setExternalData(PdExternalData pdExternalData) {
        this.mExternalData = pdExternalData;
    }
}
