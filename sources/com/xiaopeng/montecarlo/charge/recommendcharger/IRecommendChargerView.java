package com.xiaopeng.montecarlo.charge.recommendcharger;

import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import java.util.List;
/* loaded from: classes.dex */
public interface IRecommendChargerView {
    void updateRecommendChargerView(List<RecommendChargerBean> list);

    void updateTypeIcon();
}
