package com.autonavi.gbl.route.model;

import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.Slope;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ConsisSegmentUnit implements Serializable {
    public ArrayList<ConsisLinkUnit> links;
    @AssistantAction.AssistantAction1
    public int mAssistantAction;
    public String mCrossingName;
    public String mExitName;
    public String mGuideBoardName;
    public boolean mHasCrossImage;
    public boolean mIsEndOfRoad;
    @Slope.Slope1
    public int mSlope;
    public long mTollDist;

    public ConsisSegmentUnit() {
        this.mTollDist = 0L;
        this.mSlope = 0;
        this.mHasCrossImage = false;
        this.mIsEndOfRoad = false;
        this.mAssistantAction = 0;
        this.mCrossingName = "";
        this.mGuideBoardName = "";
        this.mExitName = "";
        this.links = new ArrayList<>();
    }

    public ConsisSegmentUnit(long j, @Slope.Slope1 int i, boolean z, boolean z2, @AssistantAction.AssistantAction1 int i2, String str, String str2, String str3, ArrayList<ConsisLinkUnit> arrayList) {
        this.mTollDist = j;
        this.mSlope = i;
        this.mHasCrossImage = z;
        this.mIsEndOfRoad = z2;
        this.mAssistantAction = i2;
        this.mCrossingName = str;
        this.mGuideBoardName = str2;
        this.mExitName = str3;
        this.links = arrayList;
    }
}
