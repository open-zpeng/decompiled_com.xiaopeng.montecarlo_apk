package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;
/* loaded from: classes2.dex */
public interface IPathResult {
    boolean addPath(IVariantPath iVariantPath);

    boolean addRef();

    void delRef();

    IVariantPath getPath(int i);

    IVariantPath getPath(long j);

    long getPathCount();

    int getPathIndex(long j);

    boolean recycle();

    boolean removePath(IVariantPath iVariantPath);
}
