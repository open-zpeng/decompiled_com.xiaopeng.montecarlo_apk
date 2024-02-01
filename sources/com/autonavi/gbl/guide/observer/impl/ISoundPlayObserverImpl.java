package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.PlayRingType;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.observer.ISoundPlayObserver;
@IntfAuto(target = ISoundPlayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ISoundPlayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ISoundPlayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ISoundPlayObserverImpl_change_ownership(ISoundPlayObserverImpl iSoundPlayObserverImpl, long j, boolean z);

    private static native void ISoundPlayObserverImpl_director_connect(ISoundPlayObserverImpl iSoundPlayObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean isPlayingNative(long j, ISoundPlayObserverImpl iSoundPlayObserverImpl);

    private static native void onPlayRingNative(long j, ISoundPlayObserverImpl iSoundPlayObserverImpl, int i);

    private static native void onPlayTTSNative(long j, ISoundPlayObserverImpl iSoundPlayObserverImpl, long j2, SoundInfo soundInfo);

    public ISoundPlayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISoundPlayObserverImpl) && getUID(this) == getUID((ISoundPlayObserverImpl) obj);
    }

    private static long getUID(ISoundPlayObserverImpl iSoundPlayObserverImpl) {
        long cPtr = getCPtr(iSoundPlayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISoundPlayObserverImpl iSoundPlayObserverImpl) {
        if (iSoundPlayObserverImpl == null) {
            return 0L;
        }
        return iSoundPlayObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
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
        ISoundPlayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ISoundPlayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onPlayTTS(SoundInfo soundInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onPlayTTSNative(j, this, 0L, soundInfo);
    }

    public void onPlayRing(@PlayRingType.PlayRingType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onPlayRingNative(j, this, i);
    }

    public boolean isPlaying() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isPlayingNative(j, this);
    }

    public ISoundPlayObserverImpl() {
        this(createNativeObj(), true);
        GuideObserverJNI.swig_jni_init();
        ISoundPlayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
