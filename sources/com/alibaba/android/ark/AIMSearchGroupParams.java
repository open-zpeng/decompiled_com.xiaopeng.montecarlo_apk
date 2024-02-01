package com.alibaba.android.ark;
/* loaded from: classes.dex */
public final class AIMSearchGroupParams {
    public long endTime;
    public boolean isAsc;
    public String keyword;
    public int maxNum;
    public int offset;
    public long startTime;

    public AIMSearchGroupParams(String str, int i, int i2, long j, long j2, boolean z) {
        this.offset = 0;
        this.maxNum = 20;
        this.startTime = 0L;
        this.endTime = Long.MAX_VALUE;
        this.isAsc = true;
        this.keyword = str;
        this.offset = i;
        this.maxNum = i2;
        this.startTime = j;
        this.endTime = j2;
        this.isAsc = z;
    }

    public AIMSearchGroupParams() {
        this.offset = 0;
        this.maxNum = 20;
        this.startTime = 0L;
        this.endTime = Long.MAX_VALUE;
        this.isAsc = true;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public boolean getIsAsc() {
        return this.isAsc;
    }

    public String toString() {
        return "AIMSearchGroupParams{keyword=" + this.keyword + ",offset=" + this.offset + ",maxNum=" + this.maxNum + ",startTime=" + this.startTime + ",endTime=" + this.endTime + ",isAsc=" + this.isAsc + "}";
    }
}
