package com.xiaopeng.montecarlo.root.datalog;

import java.util.Map;
/* loaded from: classes3.dex */
public class DataLogMessage {
    String mButtonId;
    String mEventName;
    int mLevel;
    String mPageId;
    Map<String, Object> mParaMap;

    public DataLogMessage(String str, String str2, String str3, int i) {
        this.mEventName = str;
        this.mPageId = str2;
        this.mButtonId = str3;
        this.mLevel = i;
    }

    public String getEventName() {
        return this.mEventName;
    }

    public String getPageId() {
        return this.mPageId;
    }

    public String getButtonId() {
        return this.mButtonId;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public Map<String, Object> getParaMap() {
        return this.mParaMap;
    }

    public void setParaMap(Map<String, Object> map) {
        this.mParaMap = map;
    }
}
