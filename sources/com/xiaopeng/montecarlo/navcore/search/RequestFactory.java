package com.xiaopeng.montecarlo.navcore.search;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes3.dex */
public class RequestFactory {
    public static final int TYPE_ALONGWAY_SEARCH = 2;
    public static final int TYPE_CHARGE_GENERAL_SEARCH = 10;
    public static final int TYPE_CHARGE_SEARCH = 7;
    public static final int TYPE_DEEPINFO_SEARCH = 6;
    public static final int TYPE_DETAIL_SEARCH = 3;
    public static final int TYPE_DIANPING_SEARCH = 8;
    public static final int TYPE_FOOD_SEARCH = 11;
    public static final int TYPE_KEYWORD_SEARCH = 1;
    public static final int TYPE_NAVI_SEARCH = 9;
    public static final int TYPE_NEAREST_SEARCH = 5;
    public static final int TYPE_SUGGEST_SEARCH = 4;
    private int mRequestType;

    /* loaded from: classes3.dex */
    public interface IBuilder<I> {
        I areaCode(String str);

        I batteryState(String str);

        Request build();

        I category(String str);

        I chargeType(int i);

        I cityCode(String str);

        I index(int i);

        I keyword(String str);

        I needDis(int i);

        I orderPolicy(String str);

        I page(int i);

        I pageSize(int i);

        I pathList(List<String> list);

        I poiId(String str);

        I poiLocation(XPCoordinate2DDouble xPCoordinate2DDouble);

        I poiName(String str);

        I radius(String str);

        I remainDistance(int i);

        I searchType(String str);

        I setBaseParameter(BaseParameter baseParameter);

        I showDetail(boolean z);

        I stations(List<RecommendChargerBean> list);

        I strategy(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RequestType {
    }

    public RequestFactory(int i) {
        this.mRequestType = 1;
        this.mRequestType = i;
    }

    public BaseBuilder newBuilder() {
        return SearchClient.getInstance().getRequestBuilder(this.mRequestType);
    }
}
