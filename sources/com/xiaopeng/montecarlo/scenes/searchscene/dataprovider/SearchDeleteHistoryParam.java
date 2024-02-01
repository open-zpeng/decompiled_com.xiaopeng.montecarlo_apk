package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
/* loaded from: classes3.dex */
public class SearchDeleteHistoryParam extends SearchRequestParam {
    private HistoryRecordInfo mHistoryRecordInfo;
    private int mPosition;

    public HistoryRecordInfo getHistoryRecordInfo() {
        return this.mHistoryRecordInfo;
    }

    public void setHistoryRecordInfo(HistoryRecordInfo historyRecordInfo) {
        this.mHistoryRecordInfo = historyRecordInfo;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }
}
