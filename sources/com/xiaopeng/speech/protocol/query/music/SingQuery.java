package com.xiaopeng.speech.protocol.query.music;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.QuerySingEvent;
/* loaded from: classes3.dex */
public class SingQuery extends SpeechQuery<ISingQueryCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QuerySingEvent.GET_SING_STATUS_QUERY)
    public int getSingStatus(String str, String str2) {
        return ((ISingQueryCaller) this.mQueryCaller).getSingStatus(str2);
    }
}
