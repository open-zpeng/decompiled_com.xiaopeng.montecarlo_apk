package com.xiaopeng.montecarlo.scenes.restrictscene;

import com.autonavi.gbl.layer.model.BizRouteRestrictInfo;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPRectDouble;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public interface IRestrictContract {

    /* loaded from: classes2.dex */
    public interface LogicView extends IMapLogicView<RestrictScenePresenter> {
        void bindView();

        void drawRules(BizRouteRestrictInfo bizRouteRestrictInfo);

        void exitRestrictScene();

        void onInitView();

        void preDrawRestrict(XPRectDouble xPRectDouble, boolean z);

        void showRestrictedDetail(ArrayList<XPGRestrictCity> arrayList);

        void unBindView();
    }

    /* loaded from: classes2.dex */
    public interface Presenter extends IBasePresenter {
    }
}
