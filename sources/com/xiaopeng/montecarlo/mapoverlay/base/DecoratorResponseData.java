package com.xiaopeng.montecarlo.mapoverlay.base;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import java.util.List;
/* loaded from: classes2.dex */
public class DecoratorResponseData extends BaseResultData {
    private List<XPPoiInfo> mList;
    private String mSearchPoiId;
    private int mSearchType;

    public void setList(List<XPPoiInfo> list) {
        this.mList = list;
    }

    public List<XPPoiInfo> getList() {
        return this.mList;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public void setSearchPoiId(String str) {
        this.mSearchPoiId = str;
    }

    public String getSearchPoiId() {
        return this.mSearchPoiId;
    }
}
