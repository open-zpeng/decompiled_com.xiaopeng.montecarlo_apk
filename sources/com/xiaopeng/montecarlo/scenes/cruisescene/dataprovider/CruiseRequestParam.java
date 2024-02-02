package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class CruiseRequestParam extends BaseParameter {
    public static final int CRUISE_TYPE_AI_CAR_GREETING = 6;
    public static final int CRUISE_TYPE_COMMUTINGFORECAST = 0;
    public static final int CRUISE_TYPE_GET_LICENSE_PLATE = 4;
    private static final int CRUISE_TYPE_INVALID = -1;
    public static final int CRUISE_TYPE_LOAD_DISTANCE = 1;
    public static final int CRUISE_TYPE_RECOGNITION_COMPANY = 3;
    public static final int CRUISE_TYPE_RECOGNITION_HOME = 2;
    public static final int CRUISE_TYPE_SEARCH_CHARGE = 5;
    protected int mCruiseType = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CruiseType {
    }

    public int getCruiseType() {
        return this.mCruiseType;
    }

    public void setCruiseType(int i) {
        this.mCruiseType = i;
    }
}
