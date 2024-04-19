package com.xiaopeng.montecarlo.navcore.event;

import androidx.annotation.Nullable;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
/* loaded from: classes2.dex */
public class ParallelRoadEvent {
    public static final int PAPALLEL_ROAD_SWITCH_FINISH = 1;
    public static final int PARALLEL_ROAD_UPDATE = 0;
    @Nullable
    public LocParallelRoadInfo mLocParallelRoadInfo;
    private int mType;

    public ParallelRoadEvent(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
