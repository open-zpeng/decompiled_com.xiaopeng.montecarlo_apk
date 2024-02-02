package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class XPVariantPath implements IVariantPath {
    private static final L.Tag TAG = new L.Tag("XPVariantPath");
    private long mPathId;
    private long mPathLength;
    private final IPathResult mPathResult;
    private final PathInfo mVariantPath;

    public XPVariantPath(@NonNull PathInfo pathInfo, @NonNull IPathResult iPathResult) {
        this.mPathId = 0L;
        this.mPathLength = 0L;
        if (pathInfo == null || iPathResult == null) {
            throw new IllegalArgumentException("variantPath or pathResult should not be null");
        }
        this.mVariantPath = pathInfo;
        this.mPathResult = iPathResult;
        XPDrivePathAccessor obtain = XPDrivePathAccessor.obtain(pathInfo, iPathResult);
        if (obtain != null) {
            this.mPathId = obtain.getPathID();
            this.mPathLength = obtain.getPathLength();
            obtain.recycle();
            return;
        }
        L.i(TAG, "  create XPVariantPath error");
    }

    public PathInfo getVariantPath() {
        return this.mVariantPath;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath
    public long getPathId() {
        return this.mPathId;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath
    public long getPathLength() {
        return this.mPathLength;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath
    public boolean isValid() {
        return (this.mVariantPath == null || this.mPathResult == null) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath
    public XPDrivePathAccessor getDrivePathAccessor() {
        return XPDrivePathAccessor.obtain(this.mVariantPath, this.mPathResult);
    }
}
