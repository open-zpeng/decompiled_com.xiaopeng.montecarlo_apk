package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.guide.model.NaviPath;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class XPNaviPath implements INaviPath {
    private NaviPath mNaviPath;
    private IPathResult mPathResult;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public int getNaviPathCount() {
        NaviPath naviPath = this.mNaviPath;
        if (naviPath != null) {
            return naviPath.getVecPaths().size();
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public long getPathId(int i) {
        IVariantPath path;
        IPathResult iPathResult = this.mPathResult;
        if (iPathResult == null || (path = iPathResult.getPath(i)) == null) {
            return -1L;
        }
        return path.getPathId();
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public IVariantPath getVariantPath(long j) {
        IPathResult iPathResult = this.mPathResult;
        if (iPathResult != null) {
            return iPathResult.getPath(j);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public void recycle() {
        NaviPath naviPath = this.mNaviPath;
        if (naviPath != null && naviPath.getPoint() != null) {
            POIForRequest point = this.mNaviPath.getPoint();
            if (point != null) {
                POIForRequest.destroy(point);
            }
            NaviPath naviPath2 = this.mNaviPath;
            if (naviPath2 != null) {
                naviPath2.delete();
            }
        }
        this.mPathResult = null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public void setNaviPathType(int i) {
        NaviPath naviPath = this.mNaviPath;
        if (naviPath != null) {
            naviPath.setType(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public void setNaviPathStrategy(int i) {
        NaviPath naviPath = this.mNaviPath;
        if (naviPath != null) {
            naviPath.setStrategy(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public void createNaviPathPoint(@NonNull RouteParams routeParams) {
        NaviPath naviPath = this.mNaviPath;
        if (naviPath != null) {
            naviPath.setPoint(getPOIForRequest(routeParams));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath
    public void createNaviPath(@NonNull IPathResult iPathResult, @NonNull RouteParams routeParams, int i) {
        recycle();
        this.mPathResult = iPathResult;
        this.mNaviPath = new NaviPath();
        long pathCount = iPathResult.getPathCount();
        if (pathCount > 0) {
            this.mNaviPath.setType(i);
            this.mNaviPath.setStrategy(0);
            this.mNaviPath.setPoint(getPOIForRequest(routeParams));
            ArrayList<PathInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < pathCount; i2++) {
                arrayList.add(((XPVariantPath) iPathResult.getPath(i2)).getVariantPath());
            }
            this.mNaviPath.setVecPaths(arrayList);
        }
    }

    public NaviPath getNaviPath() {
        return this.mNaviPath;
    }

    private POIForRequest getPOIForRequest(@NonNull RouteParams routeParams) {
        if (routeParams.mStartInfo == null || routeParams.mEndInfo == null) {
            return null;
        }
        POIForRequest create = POIForRequest.create();
        create.addPoint(0, routeParams.mStartInfo.toBLPOIInfo(true));
        create.addPoint(2, routeParams.mEndInfo.toBLPOIInfo(false));
        List<XPViaPoint> list = routeParams.mViaInfos;
        if (CollectionUtils.isNotEmpty(list)) {
            for (XPViaPoint xPViaPoint : list) {
                if (!xPViaPoint.getIsPassedVia()) {
                    create.addPoint(1, xPViaPoint.toBLPOIInfo(false));
                }
            }
        }
        return create;
    }
}
