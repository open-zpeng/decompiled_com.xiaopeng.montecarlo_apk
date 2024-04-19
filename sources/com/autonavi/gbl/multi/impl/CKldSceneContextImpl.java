package com.autonavi.gbl.multi.impl;

import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.impl.IKldSceneBaseImpl;
/* loaded from: classes2.dex */
public class CKldSceneContextImpl {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int getDiplsyName1Native(long j, CKldSceneContextImpl cKldSceneContextImpl, String[] strArr);

    private static native String getDiplsyNameNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native int getDispayIdNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native long getDisplayNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native int getDisplayTypeNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native String getTopSceneNameNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native long getTopSceneNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native boolean isRemoteDisplayNative(long j, CKldSceneContextImpl cKldSceneContextImpl);

    private static native int registerSceneMapNative(long j, CKldSceneContextImpl cKldSceneContextImpl, String str, String str2);

    private static native int registerSceneNaviNative(long j, CKldSceneContextImpl cKldSceneContextImpl, String str, String str2);

    private static native int registerSceneOpeningNative(long j, CKldSceneContextImpl cKldSceneContextImpl, String str, String str2);

    private static native int registerScenePreviewNative(long j, CKldSceneContextImpl cKldSceneContextImpl, String str, String str2);

    private static native int registerSceneRouteResultNative(long j, CKldSceneContextImpl cKldSceneContextImpl, String str, String str2);

    public CKldSceneContextImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CKldSceneContextImpl cKldSceneContextImpl) {
        if (cKldSceneContextImpl == null) {
            return 0L;
        }
        return cKldSceneContextImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public int registerSceneMap(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerSceneMapNative(j, this, str, str2);
    }

    public int registerSceneNavi(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerSceneNaviNative(j, this, str, str2);
    }

    public int registerSceneOpening(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerSceneOpeningNative(j, this, str, str2);
    }

    public int registerScenePreview(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerScenePreviewNative(j, this, str, str2);
    }

    public int registerSceneRouteResult(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerSceneRouteResultNative(j, this, str, str2);
    }

    public IKldSceneBaseImpl getTopScene() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long topSceneNative = getTopSceneNative(j, this);
        if (topSceneNative == 0) {
            return null;
        }
        return new IKldSceneBaseImpl(topSceneNative, false);
    }

    public String getTopSceneName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTopSceneNameNative(j, this);
    }

    public String getDiplsyName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDiplsyNameNative(j, this);
    }

    public boolean isRemoteDisplay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRemoteDisplayNative(j, this);
    }

    public int getDispayId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDispayIdNative(j, this);
    }

    @DisplayType.DisplayType1
    public int getDisplayType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDisplayTypeNative(j, this);
    }

    public IKldDisplayImpl getDisplay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long displayNative = getDisplayNative(j, this);
        if (displayNative == 0) {
            return null;
        }
        return new IKldDisplayImpl(displayNative, false);
    }

    public int getDiplsyName(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDiplsyName1Native(j, this, strArr);
    }
}
