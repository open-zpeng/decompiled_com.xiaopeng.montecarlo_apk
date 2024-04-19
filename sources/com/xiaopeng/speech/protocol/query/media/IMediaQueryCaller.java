package com.xiaopeng.speech.protocol.query.media;

import com.xiaopeng.speech.IQueryCaller;
/* loaded from: classes3.dex */
public interface IMediaQueryCaller extends IQueryCaller {
    default String getMediaInfo() {
        return null;
    }
}
