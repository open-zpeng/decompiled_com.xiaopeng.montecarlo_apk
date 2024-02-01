package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GReStrictedAreaDataRes implements Serializable {
    public GReStrictedAreaDataCityAllRuleRes mCityAllRule;
    public GReStrictedAreaDataCityListRes mDataCityList;
    public GReStrictedAreaDataRuleRes mDataRule;
    public int mType;

    public GReStrictedAreaDataRes() {
        this.mType = 0;
        this.mDataRule = new GReStrictedAreaDataRuleRes();
        this.mCityAllRule = new GReStrictedAreaDataCityAllRuleRes();
        this.mDataCityList = new GReStrictedAreaDataCityListRes();
    }

    public GReStrictedAreaDataRes(int i, GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes, GReStrictedAreaDataCityAllRuleRes gReStrictedAreaDataCityAllRuleRes, GReStrictedAreaDataCityListRes gReStrictedAreaDataCityListRes) {
        this.mType = i;
        this.mDataRule = gReStrictedAreaDataRuleRes;
        this.mCityAllRule = gReStrictedAreaDataCityAllRuleRes;
        this.mDataCityList = gReStrictedAreaDataCityListRes;
    }
}
