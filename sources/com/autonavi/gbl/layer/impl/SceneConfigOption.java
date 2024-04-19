package com.autonavi.gbl.layer.impl;
/* loaded from: classes.dex */
public class SceneConfigOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native String confNameGetNative(long j, SceneConfigOption sceneConfigOption);

    private static native void confNameSetNative(long j, SceneConfigOption sceneConfigOption, String str);

    private static native long createNativeObj();

    private static native String ctrlNameGetNative(long j, SceneConfigOption sceneConfigOption);

    private static native void ctrlNameSetNative(long j, SceneConfigOption sceneConfigOption, String str);

    private static native void destroyNativeObj(long j);

    private static native String jsonGetNative(long j, SceneConfigOption sceneConfigOption);

    private static native void jsonSetNative(long j, SceneConfigOption sceneConfigOption, String str);

    private static native String sceneNameGetNative(long j, SceneConfigOption sceneConfigOption);

    private static native void sceneNameSetNative(long j, SceneConfigOption sceneConfigOption, String str);

    public SceneConfigOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SceneConfigOption sceneConfigOption) {
        if (sceneConfigOption == null) {
            return 0L;
        }
        return sceneConfigOption.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setCtrlName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ctrlNameSetNative(j, this, str);
    }

    public String getCtrlName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return ctrlNameGetNative(j, this);
    }

    public void setSceneName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        sceneNameSetNative(j, this, str);
    }

    public String getSceneName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sceneNameGetNative(j, this);
    }

    public void setConfName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        confNameSetNative(j, this, str);
    }

    public String getConfName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return confNameGetNative(j, this);
    }

    public void setJson(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        jsonSetNative(j, this, str);
    }

    public String getJson() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return jsonGetNative(j, this);
    }

    public SceneConfigOption() {
        this(createNativeObj(), true);
    }
}
