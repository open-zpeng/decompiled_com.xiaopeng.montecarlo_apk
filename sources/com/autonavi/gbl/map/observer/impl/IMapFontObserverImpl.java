package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.observer.MapFontObserver;
@IntfAuto(target = MapFontObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapFontObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapFontObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapFontObserverImpl_change_ownership(IMapFontObserverImpl iMapFontObserverImpl, long j, boolean z);

    private static native void IMapFontObserverImpl_director_connect(IMapFontObserverImpl iMapFontObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getFontMetricsNative(long j, IMapFontObserverImpl iMapFontObserverImpl, long j2, FontMetricsRequestParam fontMetricsRequestParam, long j3, FontMetrics fontMetrics);

    private static native boolean getGlyphMetricsNative(long j, IMapFontObserverImpl iMapFontObserverImpl, long j2, GlyphRequestParam glyphRequestParam, long j3, GlyphMetrics glyphMetrics);

    private static native boolean getGlyphRasterNative(long j, IMapFontObserverImpl iMapFontObserverImpl, long j2, GlyphRequestParam glyphRequestParam, long j3, GlyphRaster glyphRaster);

    public IMapFontObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapFontObserverImpl) && getUID(this) == getUID((IMapFontObserverImpl) obj);
    }

    private static long getUID(IMapFontObserverImpl iMapFontObserverImpl) {
        long cPtr = getCPtr(iMapFontObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapFontObserverImpl iMapFontObserverImpl) {
        if (iMapFontObserverImpl == null) {
            return 0L;
        }
        return iMapFontObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IMapFontObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapFontObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean getGlyphMetrics(GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        return $explicit_getGlyphMetrics(glyphRequestParam, glyphMetrics);
    }

    public boolean $explicit_getGlyphMetrics(GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGlyphMetricsNative(j, this, 0L, glyphRequestParam, 0L, glyphMetrics);
    }

    public boolean getGlyphRaster(GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        return $explicit_getGlyphRaster(glyphRequestParam, glyphRaster);
    }

    public boolean $explicit_getGlyphRaster(GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGlyphRasterNative(j, this, 0L, glyphRequestParam, 0L, glyphRaster);
    }

    public boolean getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        return $explicit_getFontMetrics(fontMetricsRequestParam, fontMetrics);
    }

    public boolean $explicit_getFontMetrics(FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFontMetricsNative(j, this, 0L, fontMetricsRequestParam, 0L, fontMetrics);
    }

    public IMapFontObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapFontObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
