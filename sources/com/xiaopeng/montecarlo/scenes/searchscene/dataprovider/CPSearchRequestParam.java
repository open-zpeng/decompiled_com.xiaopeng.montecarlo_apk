package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
/* loaded from: classes3.dex */
public class CPSearchRequestParam extends SearchRequestParam {
    private GeneralChargeRequestParam mGeneralChargeRequestParam;

    public CPSearchRequestParam(GeneralChargeRequestParam generalChargeRequestParam) {
        this.mGeneralChargeRequestParam = generalChargeRequestParam;
    }

    public GeneralChargeRequestParam getGeneralChargeRequestParam() {
        return this.mGeneralChargeRequestParam;
    }

    public void setGeneralChargeRequestParam(GeneralChargeRequestParam generalChargeRequestParam) {
        this.mGeneralChargeRequestParam = generalChargeRequestParam;
    }
}
