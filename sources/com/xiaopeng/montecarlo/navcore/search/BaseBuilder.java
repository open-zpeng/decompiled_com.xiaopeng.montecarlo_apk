package com.xiaopeng.montecarlo.navcore.search;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.search.RequestFactory;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseBuilder implements RequestFactory.IBuilder<BaseBuilder> {
    private int mRequestId;
    private int mRequestType;
    private int mSearchMode = -1;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder areaCode(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder batteryState(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder category(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder chargeType(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder cityCode(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder index(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder keyword(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder needDis(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder orderPolicy(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder page(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder pageSize(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder pathList(List<String> list) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder poiId(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder poiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder poiName(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder radius(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder remainDistance(int i) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder searchType(String str) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder setBaseParameter(BaseParameter baseParameter) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder showDetail(boolean z) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder stations(List<RecommendChargerBean> list) {
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public BaseBuilder strategy(int i) {
        return this;
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public /* bridge */ /* synthetic */ BaseBuilder pathList(List list) {
        return pathList((List<String>) list);
    }

    @Override // com.xiaopeng.montecarlo.navcore.search.RequestFactory.IBuilder
    public /* bridge */ /* synthetic */ BaseBuilder stations(List list) {
        return stations((List<RecommendChargerBean>) list);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void setRequestType(int i) {
        this.mRequestType = i;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public BaseBuilder searchMode(int i) {
        this.mSearchMode = i;
        return this;
    }

    public BaseBuilder requestId(int i) {
        this.mRequestId = i;
        return this;
    }

    public int getRequestId() {
        return this.mRequestId;
    }
}
