package com.alibaba.android.ark;
/* loaded from: classes.dex */
public final class AIMSearchHighlightRange {
    public long length;
    public long start;

    public AIMSearchHighlightRange(long j, long j2) {
        this.start = 0L;
        this.length = 0L;
        this.start = j;
        this.length = j2;
    }

    public AIMSearchHighlightRange() {
        this.start = 0L;
        this.length = 0L;
    }

    public long getStart() {
        return this.start;
    }

    public long getLength() {
        return this.length;
    }

    public String toString() {
        return "AIMSearchHighlightRange{start=" + this.start + ",length=" + this.length + "}";
    }
}
