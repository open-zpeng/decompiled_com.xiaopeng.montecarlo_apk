package com.xiaopeng.montecarlo.navcore.powerdistance.navi;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
/* loaded from: classes2.dex */
interface INaviOnLinePdContract {

    /* loaded from: classes2.dex */
    public interface LogicView {
        void onUpdateRemainDis(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface Presenter {
        void changePath(IPathResult iPathResult, IVariantPath iVariantPath);

        void close();

        long getPathId();

        void init();

        void stop();

        void updateNaviInfo(@NonNull XPNaviInfo xPNaviInfo);
    }
}
