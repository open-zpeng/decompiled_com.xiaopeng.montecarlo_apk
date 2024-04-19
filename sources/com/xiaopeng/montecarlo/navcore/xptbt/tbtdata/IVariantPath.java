package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;
/* loaded from: classes3.dex */
public interface IVariantPath {
    XPDrivePathAccessor getDrivePathAccessor();

    long getPathId();

    long getPathLength();

    boolean isValid();
}
