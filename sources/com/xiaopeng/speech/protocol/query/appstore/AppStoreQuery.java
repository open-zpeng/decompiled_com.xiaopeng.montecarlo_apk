package com.xiaopeng.speech.protocol.query.appstore;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.QueryAppStoreEvent;
/* loaded from: classes3.dex */
public class AppStoreQuery extends SpeechQuery<IAppStoreCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryAppStoreEvent.GET_OPEN_STATUS)
    public int getOpenStatus(String str, String str2) {
        return ((IAppStoreCaller) this.mQueryCaller).getOpenStatus(str2);
    }
}
