package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.NonNull;
/* loaded from: classes3.dex */
public class RouteChargeResultData extends BaseResultData {
    public static final int CHARGE_STATUS_FIRST_UNREACHABLE = 2;
    public static final int CHARGE_STATUS_LOW_POWER = 0;
    public static final int CHARGE_STATUS_SAFE = 3;
    public static final int CHARGE_STATUS_WARNING = 1;
    public static Parcelable.Creator<RouteChargeResultData> CREATOR = new Parcelable.Creator<RouteChargeResultData>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeResultData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteChargeResultData createFromParcel(Parcel parcel) {
            return new RouteChargeResultData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteChargeResultData[] newArray(int i) {
            return new RouteChargeResultData[i];
        }
    };
    private static final float DISTANCE_PERCENT = 0.01f;
    private List<GeneralChargeInfo> mCharges;
    private LinkedHashMap<String, GeneralChargeInfo> mChargesMap;
    private long mPathId;
    private int mStatus;

    public void setChargesMap(LinkedHashMap<String, GeneralChargeInfo> linkedHashMap) {
        this.mChargesMap = linkedHashMap;
    }

    public void setPathId(long j) {
        this.mPathId = j;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public long getPathId() {
        return this.mPathId;
    }

    public LinkedHashMap<String, GeneralChargeInfo> getChargesMap() {
        return this.mChargesMap;
    }

    public List<GeneralChargeInfo> getCharges() {
        return this.mCharges;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public RouteChargeResultData(long j) {
        this.mChargesMap = new LinkedHashMap<>();
        this.mStatus = -1;
        this.mPathId = j;
    }

    public RouteChargeResultData(long j, LinkedHashMap<String, GeneralChargeInfo> linkedHashMap) {
        this.mChargesMap = new LinkedHashMap<>();
        this.mStatus = -1;
        this.mChargesMap = linkedHashMap;
        this.mPathId = j;
    }

    private RouteChargeResultData(Parcel parcel) {
        this.mChargesMap = new LinkedHashMap<>();
        this.mStatus = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int parseStatus() {
        if (CollectionUtils.isEmpty(this.mCharges)) {
            return 0;
        }
        if (this.mCharges.get(0).getCostDistance() * 1.01f > CarServiceManager.getInstance().getCarRemainDistance()) {
            return 2;
        }
        for (int i = 1; i < this.mCharges.size(); i++) {
            if (this.mCharges.get(i).getCostDistance() - this.mCharges.get(i - 1).getCostDistance() > RouteChargeHelper.getMaxRemainAfterCharge()) {
                return 1;
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralChargeInfo getCharge(String str) {
        if (CollectionUtils.isEmpty(this.mChargesMap)) {
            return null;
        }
        return this.mChargesMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralChargeInfo getCharge(int i) {
        if (CollectionUtils.isEmpty(this.mCharges)) {
            return null;
        }
        return this.mCharges.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChargeSize() {
        if (CollectionUtils.isEmpty(this.mChargesMap)) {
            return 0;
        }
        return this.mChargesMap.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCharges(@NonNull List<GeneralChargeInfo> list) {
        if (list == null) {
            throw new NullPointerException("charges is marked non-null but is null");
        }
        this.mCharges = list;
        Collections.sort(list, new Comparator<GeneralChargeInfo>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeResultData.2
            @Override // java.util.Comparator
            public int compare(GeneralChargeInfo generalChargeInfo, GeneralChargeInfo generalChargeInfo2) {
                return Long.compare(generalChargeInfo.getDistance(), generalChargeInfo2.getDistance());
            }
        });
        this.mChargesMap.clear();
        for (GeneralChargeInfo generalChargeInfo : list) {
            this.mChargesMap.put(generalChargeInfo.getStationId(), generalChargeInfo);
        }
    }
}
