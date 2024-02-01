package com.xiaopeng.montecarlo.navcore.location;

import java.util.Map;
/* loaded from: classes3.dex */
public class DRRecordEntry<Long, String> implements Map.Entry<Long, String> {
    private final Long mKey;
    private String mValue;

    public DRRecordEntry(Long r1, String string) {
        this.mKey = r1;
        this.mValue = string;
    }

    @Override // java.util.Map.Entry
    public Long getKey() {
        return this.mKey;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return this.mValue;
    }

    @Override // java.util.Map.Entry
    public String setValue(String string) {
        String string2 = this.mValue;
        this.mValue = string;
        return string2;
    }
}
