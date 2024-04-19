package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params;

import com.autonavi.gbl.user.account.model.AccountAosResult;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
/* loaded from: classes3.dex */
public class LinkSeamlessLoginAmapByQrcodeParam extends LinkSeamlessRequestParam {
    AccountAosResult mResult;

    public LinkSeamlessLoginAmapByQrcodeParam(AccountAosResult accountAosResult) {
        this.mResult = accountAosResult;
    }

    public AccountAosResult getResult() {
        return this.mResult;
    }

    public void setResult(AccountAosResult accountAosResult) {
        this.mResult = accountAosResult;
    }
}
