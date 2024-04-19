package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.path.model.Camera;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.Ownership;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.common.path.model.RoadFacility;
import com.autonavi.gbl.common.path.model.SlopeInfo;
import com.autonavi.gbl.common.path.model.TurnInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ConsisLinkUnit implements Serializable {
    public long mAdcode;
    public ArrayList<Camera> mCameras;
    @Formway.Formway1
    public int mFormway;
    public boolean mIsOverHead;
    public boolean mIsToll;
    public long mLaneNum;
    public short mLinkDirection;
    @LinkType.LinkType1
    public int mLinkType;
    @Ownership.Ownership1
    public int mOwnership;
    @RoadClass.RoadClass1
    public int mRoadClass;
    public ArrayList<RoadFacility> mRoadFacility;
    public String mRoadName;
    public ArrayList<SlopeInfo> mSlopeInfo;
    public short mSpeedLimit;
    public ArrayList<TurnInfo> mTurnInfo;

    public ConsisLinkUnit() {
        this.mRoadClass = -1;
        this.mFormway = -1;
        this.mLinkType = -1;
        this.mIsOverHead = false;
        this.mIsToll = false;
        this.mLinkDirection = (short) 0;
        this.mOwnership = 0;
        this.mSpeedLimit = (short) 0;
        this.mSlopeInfo = new ArrayList<>();
        this.mCameras = new ArrayList<>();
        this.mRoadFacility = new ArrayList<>();
        this.mTurnInfo = new ArrayList<>();
        this.mRoadName = "";
        this.mAdcode = 0L;
        this.mLaneNum = 0L;
    }

    public ConsisLinkUnit(@RoadClass.RoadClass1 int i, @Formway.Formway1 int i2, @LinkType.LinkType1 int i3, boolean z, boolean z2, short s, @Ownership.Ownership1 int i4, short s2, ArrayList<SlopeInfo> arrayList, ArrayList<Camera> arrayList2, ArrayList<RoadFacility> arrayList3, ArrayList<TurnInfo> arrayList4, String str, long j, long j2) {
        this.mRoadClass = i;
        this.mFormway = i2;
        this.mLinkType = i3;
        this.mIsOverHead = z;
        this.mIsToll = z2;
        this.mLinkDirection = s;
        this.mOwnership = i4;
        this.mSpeedLimit = s2;
        this.mSlopeInfo = arrayList;
        this.mCameras = arrayList2;
        this.mRoadFacility = arrayList3;
        this.mTurnInfo = arrayList4;
        this.mRoadName = str;
        this.mAdcode = j;
        this.mLaneNum = j2;
    }
}
