package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ElecPathInfo implements Serializable {
    public EnergyConsume mEnergyConsume;
    public int mEnergySum;
    public int mEnergyUnit;
    public boolean mIsElecRoute;
    public ArrayList<Integer> mLinkConsume;
    public ArrayList<Long> mLinkDistance;
    public int mLinkNum;
    public int mPathFlag;
    public int mTrafficInfo;
    public ArrayList<ViaPointInfo> mViaInfo;
    public boolean mlinkConsumeSizeWord;

    public ElecPathInfo() {
        this.mIsElecRoute = false;
        this.mlinkConsumeSizeWord = false;
        this.mTrafficInfo = 0;
        this.mEnergyUnit = 0;
        this.mPathFlag = 0;
        this.mEnergySum = 0;
        this.mLinkNum = 0;
        this.mLinkConsume = new ArrayList<>();
        this.mLinkDistance = new ArrayList<>();
        this.mViaInfo = new ArrayList<>();
        this.mEnergyConsume = new EnergyConsume();
    }

    public ElecPathInfo(boolean z, boolean z2, int i, int i2, int i3, int i4, int i5, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, ArrayList<ViaPointInfo> arrayList3, EnergyConsume energyConsume) {
        this.mIsElecRoute = z;
        this.mlinkConsumeSizeWord = z2;
        this.mTrafficInfo = i;
        this.mEnergyUnit = i2;
        this.mPathFlag = i3;
        this.mEnergySum = i4;
        this.mLinkNum = i5;
        this.mLinkConsume = arrayList;
        this.mLinkDistance = arrayList2;
        this.mViaInfo = arrayList3;
        this.mEnergyConsume = energyConsume;
    }
}
