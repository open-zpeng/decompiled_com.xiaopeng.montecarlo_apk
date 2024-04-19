package com.xiaopeng.montecarlo.scenes.mapscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
import java.util.List;
/* loaded from: classes3.dex */
public class MapSceneResultData extends BaseResultData {
    private List<XPPoiInfo> mList;
    private int mScaleLevel;
    protected int mSearchType;
    private boolean mSuccess;

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public List<XPPoiInfo> getList() {
        return this.mList;
    }

    public void setList(List<XPPoiInfo> list) {
        this.mList = list;
    }

    public boolean getSuccess() {
        return this.mSuccess;
    }

    public void setSuccess(boolean z) {
        this.mSuccess = z;
    }

    public int getScaleLevel() {
        return this.mScaleLevel;
    }

    public void setScaleLevel(int i) {
        this.mScaleLevel = i;
    }
}
