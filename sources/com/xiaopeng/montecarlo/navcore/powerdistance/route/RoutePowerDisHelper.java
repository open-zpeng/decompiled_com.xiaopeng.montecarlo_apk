package com.xiaopeng.montecarlo.navcore.powerdistance.route;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.powerdistance.IExternalDataListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RoutePowerDisHelper implements IRoutePdContract.LogicView {
    public static final L.Tag TAG = new L.Tag("RoutePowerDisHelper");
    private boolean mClosed;
    private int mDisToTarget;
    private boolean mDisposed;
    private IExternalDataListener mExternalDataListener;
    private boolean mIsNotifyExternalData;
    private double mK;
    private final List<Coord2DDouble> mKeyRoutePoints;
    private final OnUpdateRemainDisListener mListener;
    private IVariantPath mPath;
    private long mPathId;
    private IPathResult mPathResult;
    private PdExternalData mPdExternalData;
    private final IRoutePdContract.Presenter mPresenter;
    private int mStartLinkIndex;
    private int mStartSegIndex;
    private long mStartTime;

    public RoutePowerDisHelper(@NonNull OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this(onUpdateRemainDisListener, false, false);
    }

    public RoutePowerDisHelper(@NonNull OnUpdateRemainDisListener onUpdateRemainDisListener, boolean z, boolean z2) {
        this(null, null, null, onUpdateRemainDisListener, z, z2, null);
    }

    public RoutePowerDisHelper(XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this(xPNaviInfo, iVariantPath, iPathResult, onUpdateRemainDisListener, false, false, null);
    }

    public RoutePowerDisHelper(XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener, boolean z, boolean z2) {
        this(xPNaviInfo, iVariantPath, iPathResult, onUpdateRemainDisListener, z, z2, null);
    }

    public RoutePowerDisHelper(XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener, IExternalDataListener iExternalDataListener) {
        this(xPNaviInfo, iVariantPath, iPathResult, onUpdateRemainDisListener, false, false, iExternalDataListener);
    }

    public RoutePowerDisHelper(XPNaviInfo xPNaviInfo, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult, @NonNull OnUpdateRemainDisListener onUpdateRemainDisListener, boolean z, boolean z2, IExternalDataListener iExternalDataListener) {
        this.mKeyRoutePoints = new ArrayList();
        this.mK = 1.0d;
        this.mClosed = false;
        this.mDisposed = false;
        this.mIsNotifyExternalData = false;
        this.mExternalDataListener = iExternalDataListener;
        if (xPNaviInfo != null) {
            this.mStartSegIndex = xPNaviInfo.mCurSegIdx;
            this.mStartLinkIndex = xPNaviInfo.mCurLinkIdx;
            this.mDisToTarget = (int) xPNaviInfo.mRouteRemainDist;
        } else if (iVariantPath != null) {
            this.mStartSegIndex = 0;
            this.mStartLinkIndex = 0;
            this.mDisToTarget = (int) iVariantPath.getPathLength();
        }
        this.mPath = iVariantPath;
        this.mPathResult = iPathResult;
        IPathResult iPathResult2 = this.mPathResult;
        if (iPathResult2 != null) {
            iPathResult2.addRef();
            IVariantPath iVariantPath2 = this.mPath;
            if (iVariantPath2 != null) {
                this.mPathId = iVariantPath2.getPathId();
            }
        }
        this.mDisposed = z2;
        this.mListener = onUpdateRemainDisListener;
        this.mPresenter = new RoutePdPresenter(this, z);
    }

    public void updateRemainDis(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult) {
        if (iVariantPath == null || this.mClosed) {
            return;
        }
        this.mStartSegIndex = i;
        this.mStartLinkIndex = i2;
        this.mDisToTarget = i3;
        IPathResult iPathResult2 = this.mPathResult;
        if (iPathResult != iPathResult2) {
            if (iPathResult2 != null) {
                iPathResult2.delRef();
            }
            this.mPathResult = iPathResult;
            IPathResult iPathResult3 = this.mPathResult;
            if (iPathResult3 != null) {
                iPathResult3.addRef();
            }
        }
        if (iVariantPath != null && iVariantPath != this.mPath) {
            this.mPathId = iVariantPath.getPathId();
        }
        this.mPath = iVariantPath;
        updateRemainDis();
    }

    public void updateRemainDis() {
        updateRemainDis(false);
    }

    public void updateRemainDis(boolean z) {
        if (this.mClosed) {
            L.i(TAG, " updateRemainDis has closed");
            return;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mPathId = this.mPath.getPathId();
        L.Tag tag = TAG;
        L.i(tag, " updateRemainDis mPathId：" + this.mPathId + " isReturnExternalData:" + z);
        this.mPresenter.refreshOnlineK(this.mStartSegIndex, this.mStartLinkIndex, this.mDisToTarget, this.mPath, this.mPathResult, z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.LogicView
    public void onSuccess(double d) {
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance() - ((int) (this.mDisToTarget * d));
        this.mK = d;
        if (carRemainDistance <= 0) {
            carRemainDistance = 0;
        }
        onUpdateRemainDis(carRemainDistance, (int) (d * this.mDisToTarget));
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.LogicView
    public void onError() {
        handleError();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.LogicView
    public void onUpdateRemainDis(int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        sb.append("onSuccess dumpRemainInfo ");
        sb.append("-pathId:-" + this.mPathId);
        sb.append(" mK:" + this.mK);
        sb.append("-carRemain:-" + CarServiceManager.getInstance().getCarRemainDistance());
        sb.append(" routeRemain:" + this.mDisToTarget);
        sb.append("  kRouteRemainDes:" + (this.mK * ((double) this.mDisToTarget)));
        sb.append(" remainDis:" + i);
        sb.append("   th:" + Thread.currentThread().getName());
        sb.append("   taketime:" + takeTime());
        sb.append(" callThread:  " + Thread.currentThread().getName());
        L.i(TAG, sb.toString());
        OnUpdateRemainDisListener onUpdateRemainDisListener = this.mListener;
        if (onUpdateRemainDisListener != null) {
            onUpdateRemainDisListener.onUpdateRemainDis(this.mPathId, this.mDisToTarget, i);
        }
        notifyExternalData(i, i2);
        if (this.mDisposed) {
            close();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.IRoutePdContract.LogicView
    public void onExternalDataFetched(PdExternalData pdExternalData) {
        String str;
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ROUTE_CHARGE onExternalDataFetched: ");
        if (pdExternalData == null) {
            str = "";
        } else {
            str = "not null, path: " + this.mPathId;
        }
        sb.append(str);
        L.i(tag, sb.toString());
        this.mPdExternalData = pdExternalData;
    }

    private void handleError() {
        L.i(TAG, "  handleError refreshWithOfflineK---");
        this.mPresenter.refreshWithOfflineK(this.mStartSegIndex, this.mStartLinkIndex, this.mDisToTarget, this.mPath, this.mPathResult);
    }

    private long takeTime() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public void close() {
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mPresenter.close();
        IPathResult iPathResult = this.mPathResult;
        if (iPathResult != null) {
            iPathResult.delRef();
        }
        this.mKeyRoutePoints.clear();
        L.Tag tag = TAG;
        L.i(tag, "  close pathId:" + this.mPathId + " callThread:  " + Thread.currentThread().getName());
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public double getK() {
        return this.mK;
    }

    public long getPathId() {
        return this.mPathId;
    }

    private void notifyExternalData(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "ROUTE_CHARGE notifyExternalData remainDis: " + i + ", path: " + this.mPathId + ", mIsNotifyExternalData: " + this.mIsNotifyExternalData + ", costDis: " + i2);
        if (this.mIsNotifyExternalData) {
            return;
        }
        this.mIsNotifyExternalData = true;
        PdExternalData pdExternalData = this.mPdExternalData;
        if (pdExternalData != null) {
            if (i <= 0) {
                i = 0;
            }
            pdExternalData.putData(PdExternalData.KEY_ROUTE_REMAIN_DIS, Integer.valueOf(i));
            this.mPdExternalData.putData(PdExternalData.KEY_ROUTE_PATH_COST, Integer.valueOf(i2));
            this.mExternalDataListener.onExternalDataFetched(this.mPathId, this.mPdExternalData);
        }
        this.mPdExternalData = null;
    }
}
