package com.xiaopeng.montecarlo.navcore.powerdistance.navi;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class NaviPowerDisHelper implements INaviOnLinePdContract.LogicView {
    private static final L.Tag TAG = new L.Tag("NaviPowerDisHelper");
    private final OnUpdateRemainDisListener mOnUpdateRemainDisListener;
    private final NaviPdPresenter mPresenter;
    private int mRemainDis;

    public NaviPowerDisHelper(boolean z, OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this(null, null, z, onUpdateRemainDisListener);
    }

    public NaviPowerDisHelper(IPathResult iPathResult, IVariantPath iVariantPath, boolean z, OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this.mRemainDis = 0;
        this.mOnUpdateRemainDisListener = onUpdateRemainDisListener;
        this.mPresenter = new NaviPdPresenter(iPathResult, iVariantPath, z, this);
        this.mPresenter.init();
    }

    public boolean isRunning() {
        return this.mPresenter.isRunning();
    }

    public void stop() {
        this.mPresenter.stop();
    }

    public void close() {
        this.mPresenter.close();
    }

    public int getRemainDis() {
        return this.mRemainDis;
    }

    public long getPathId() {
        return this.mPresenter.getPathId();
    }

    public void changePath(IPathResult iPathResult, IVariantPath iVariantPath) {
        this.mPresenter.changePath(iPathResult, iVariantPath);
    }

    public void updateNaviInfo(@NonNull XPNaviInfo xPNaviInfo) {
        this.mPresenter.updateNaviInfo(xPNaviInfo);
    }

    public void refreshRemainDis() {
        this.mPresenter.updateRemainDis();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.navi.INaviOnLinePdContract.LogicView
    public void onUpdateRemainDis(int i, int i2) {
        this.mRemainDis = i2;
        this.mOnUpdateRemainDisListener.onUpdateRemainDis(this.mPresenter.getPathId(), i, i2);
    }
}
