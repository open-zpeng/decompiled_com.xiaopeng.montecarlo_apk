package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.BizGuideRouteControl;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
/* loaded from: classes3.dex */
public class CalculatePreviewUtil {
    @NonNull
    public static RectDouble getPathBound(IVariantPath iVariantPath) {
        XPVariantPath xPVariantPath = (XPVariantPath) iVariantPath;
        return xPVariantPath != null ? BizGuideRouteControl.getOnePathBound(xPVariantPath.getVariantPath()) : new RectDouble();
    }

    public static RectDouble getNaviPathBound(IVariantPath iVariantPath, XPNaviInfo xPNaviInfo) {
        XPDrivePathAccessor drivePathAccessor;
        if (iVariantPath == null || xPNaviInfo == null || ((xPNaviInfo.mCurSegIdx == 0 && xPNaviInfo.mCurLinkIdx == 0 && xPNaviInfo.mCurPointIdx == 0) || (drivePathAccessor = iVariantPath.getDrivePathAccessor()) == null)) {
            return null;
        }
        RectDouble bound = drivePathAccessor.getBound(xPNaviInfo.mCurSegIdx, xPNaviInfo.mCurLinkIdx, xPNaviInfo.mCurPointIdx);
        drivePathAccessor.recycle();
        return bound;
    }

    @NonNull
    public static RectDouble getPathBound(IVariantPath iVariantPath, RectDouble rectDouble) {
        RectDouble rectDouble2 = new RectDouble();
        XPVariantPath xPVariantPath = (XPVariantPath) iVariantPath;
        if (xPVariantPath != null) {
            rectDouble2 = BizGuideRouteControl.getOnePathBound(xPVariantPath.getVariantPath());
        }
        if (rectDouble != null && (rectDouble.bottom != 0.0d || rectDouble.right != 0.0d || rectDouble.top != 0.0d || rectDouble.left != 0.0d)) {
            rectUnion(rectDouble2, rectDouble);
        }
        return rectDouble2;
    }

    @NonNull
    public static RectDouble getPathBound(IPathResult iPathResult) {
        XPPathResult xPPathResult = (XPPathResult) iPathResult;
        return xPPathResult != null ? BizGuideRouteControl.getPathResultBound(xPPathResult.getPathResult()) : new RectDouble();
    }

    public static RectDouble rectUnion(RectDouble rectDouble, RectDouble rectDouble2) {
        if (rectDouble == null || rectDouble2 == null) {
            return rectDouble == null ? rectDouble2 : rectDouble;
        }
        rectDouble.left = Math.min(rectDouble.left, rectDouble2.left);
        rectDouble.right = Math.max(rectDouble.right, rectDouble2.right);
        rectDouble.top = Math.max(rectDouble.top, rectDouble2.top);
        rectDouble.bottom = Math.min(rectDouble.bottom, rectDouble2.bottom);
        return rectDouble;
    }

    public static RectDouble rectUnion(RectDouble rectDouble, double d, double d2) {
        if (rectDouble == null) {
            return null;
        }
        rectDouble.left = Math.min(rectDouble.left, d);
        rectDouble.right = Math.max(rectDouble.right, d);
        rectDouble.top = Math.max(rectDouble.top, d2);
        rectDouble.bottom = Math.min(rectDouble.bottom, d2);
        return rectDouble;
    }
}
