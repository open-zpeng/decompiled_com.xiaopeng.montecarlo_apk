package com.xiaopeng.montecarlo.scenes.mapscene.dataprovider;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes3.dex */
public class MapSceneRequestParam extends BaseParameter {
    public static final int API_TYPE_INIT_FAVORITE_OVERLAY = 4;
    public static final int API_TYPE_INVALID = -1;
    public static final int API_TYPE_QUERY_CACHE = 2;
    public static final int API_TYPE_QUERY_CLOUD = 3;
    public static final int API_TYPE_QUERY_DB = 1;
    public static final int API_TYPE_QUERY_DB_PRE = 0;
    public static final int API_TYPE_QUERY_VPA_FROM_DB = 5;
    private Coord2DDouble[] mQueryBox;
    private List<XPPoiInfo> mQueryList;
    private int mScaleLevel;
    private int mSearchId;
    private int mSearchType = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SearchType {
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(int i) {
        this.mSearchType = i;
    }

    public int getSearchId() {
        return this.mSearchId;
    }

    public void setSearchId(int i) {
        this.mSearchId = i;
    }

    public Coord2DDouble[] getQueryBox() {
        return this.mQueryBox;
    }

    public void setQueryBox(Coord2DDouble[] coord2DDoubleArr) {
        this.mQueryBox = coord2DDoubleArr;
    }

    public List<XPPoiInfo> getQueryList() {
        return this.mQueryList;
    }

    public void setQueryList(List<XPPoiInfo> list) {
        this.mQueryList = list;
    }

    public int getScaleLevel() {
        return this.mScaleLevel;
    }

    public void setScaleLevel(int i) {
        this.mScaleLevel = i;
    }
}
