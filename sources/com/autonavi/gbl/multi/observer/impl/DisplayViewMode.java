package com.autonavi.gbl.multi.observer.impl;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DisplayViewMode {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long[] getConfigListNative(long j, DisplayViewMode displayViewMode);

    private static native long getSceneConfNative(long j, DisplayViewMode displayViewMode, String str);

    private static native long getSizeNative(long j, DisplayViewMode displayViewMode);

    private static native long obtainNative();

    private static native int parseConfigStringNative(long j, DisplayViewMode displayViewMode, String str);

    public DisplayViewMode(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DisplayViewMode displayViewMode) {
        if (displayViewMode == null) {
            return 0L;
        }
        return displayViewMode.swigCPtr;
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

    public int parseConfigString(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseConfigStringNative(j, this, str);
    }

    public DisplaySceneConfigBaseImpl getSceneConf(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long sceneConfNative = getSceneConfNative(j, this, str);
        if (sceneConfNative == 0) {
            return null;
        }
        return new DisplaySceneConfigBaseImpl(sceneConfNative, false);
    }

    public ArrayList<DisplaySceneConfigBaseImpl> getConfigList() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<DisplaySceneConfigBaseImpl> arrayList = null;
        long[] configListNative = getConfigListNative(j, this);
        if (configListNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : configListNative) {
                arrayList.add(new DisplaySceneConfigBaseImpl(j2, false));
            }
        }
        return arrayList;
    }

    public long getSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSizeNative(j, this);
    }

    public static DisplayViewMode obtain() {
        long obtainNative = obtainNative();
        if (obtainNative == 0) {
            return null;
        }
        return new DisplayViewMode(obtainNative, false);
    }
}
