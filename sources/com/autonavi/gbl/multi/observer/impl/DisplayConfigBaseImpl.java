package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.observer.DisplayConfigBase;
import java.util.ArrayList;
@IntfAuto(target = DisplayConfigBase.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class DisplayConfigBaseImpl extends IKldConfigItemBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(DisplayConfigBaseImpl.class);
    private transient long swigCPtr;

    private static native long DisplayConfigBaseImpl_SWIGUpcast(long j);

    private static native void DisplayConfigBaseImpl_change_ownership(DisplayConfigBaseImpl displayConfigBaseImpl, long j, boolean z);

    private static native void DisplayConfigBaseImpl_director_connect(DisplayConfigBaseImpl displayConfigBaseImpl, long j, boolean z, boolean z2);

    private static native int applyConfigNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native int applyConfigSwigExplicitDisplayConfigBaseImplNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, long j2, IKldDisplayImpl iKldDisplayImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String displayNameGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void displayNameSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native boolean fboEnableGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void fboEnableSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, boolean z);

    private static native long getViewModeNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    private static native long getWorkedViewModeNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native boolean innerResumeGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void innerResumeSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, boolean z);

    private static native String laneProfileGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void laneProfileSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native String mapProfileGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void mapProfileSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native long[] modesGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void modesSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, long[] jArr);

    private static native int needAntiAliasGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void needAntiAliasSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    private static native int parseConfigStringNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native int parseConfigStringSwigExplicitDisplayConfigBaseImplNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native int renderPolicyGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void renderPolicySetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    private static native int samplesGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void samplesSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    private static native void setWorkedIndexNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    private static native String surfaceConfigNameGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void surfaceConfigNameSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, String str);

    private static native int workedModeIndexGetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl);

    private static native void workedModeIndexSetNative(long j, DisplayConfigBaseImpl displayConfigBaseImpl, int i);

    public DisplayConfigBaseImpl(long j, boolean z) {
        super(DisplayConfigBaseImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof DisplayConfigBaseImpl) {
            return getUID(this) == getUID((DisplayConfigBaseImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(DisplayConfigBaseImpl displayConfigBaseImpl) {
        long cPtr = getCPtr(displayConfigBaseImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DisplayConfigBaseImpl displayConfigBaseImpl) {
        if (displayConfigBaseImpl == null) {
            return 0L;
        }
        return displayConfigBaseImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        DisplayConfigBaseImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        DisplayConfigBaseImpl_change_ownership(this, this.swigCPtr, true);
    }

    public DisplayConfigBaseImpl() {
        this(createNativeObj(), true);
        MultiObserverJNI.swig_jni_init();
        DisplayConfigBaseImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public DisplayViewMode getViewMode(int i) {
        return $explicit_getViewMode(i);
    }

    public DisplayViewMode $explicit_getViewMode(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long viewModeNative = getViewModeNative(j, this, i);
        if (viewModeNative == 0) {
            return null;
        }
        return new DisplayViewMode(viewModeNative, false);
    }

    public DisplayViewMode getWorkedViewMode() {
        return $explicit_getWorkedViewMode();
    }

    public DisplayViewMode $explicit_getWorkedViewMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long workedViewModeNative = getWorkedViewModeNative(j, this);
        if (workedViewModeNative == 0) {
            return null;
        }
        return new DisplayViewMode(workedViewModeNative, false);
    }

    public void setWorkedIndex(int i) {
        $explicit_setWorkedIndex(i);
    }

    public void $explicit_setWorkedIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setWorkedIndexNative(j, this, i);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int parseConfigString(String str) {
        return $explicit_parseConfigString(str);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_parseConfigString(String str) {
        if (this.swigCPtr != 0) {
            return getClass() == DisplayConfigBaseImpl.class ? parseConfigStringNative(this.swigCPtr, this, str) : parseConfigStringSwigExplicitDisplayConfigBaseImplNative(this.swigCPtr, this, str);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        return $explicit_applyConfig(iKldDisplayImpl);
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldConfigItemBaseImpl
    public int $explicit_applyConfig(IKldDisplayImpl iKldDisplayImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == DisplayConfigBaseImpl.class ? applyConfigNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl) : applyConfigSwigExplicitDisplayConfigBaseImplNative(this.swigCPtr, this, IKldDisplayImpl.getCPtr(iKldDisplayImpl), iKldDisplayImpl);
        }
        throw new NullPointerException();
    }

    public void setDisplayName(String str) {
        $explicit_setDisplayName(str);
    }

    public void $explicit_setDisplayName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        displayNameSetNative(j, this, str);
    }

    public String getDisplayName() {
        return $explicit_getDisplayName();
    }

    public String $explicit_getDisplayName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return displayNameGetNative(j, this);
    }

    public void setSurfaceConfigName(String str) {
        $explicit_setSurfaceConfigName(str);
    }

    public void $explicit_setSurfaceConfigName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        surfaceConfigNameSetNative(j, this, str);
    }

    public String getSurfaceConfigName() {
        return $explicit_getSurfaceConfigName();
    }

    public String $explicit_getSurfaceConfigName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return surfaceConfigNameGetNative(j, this);
    }

    public void setModes(ArrayList<DisplayViewMode> arrayList) {
        $explicit_setModes(arrayList);
    }

    public void $explicit_setModes(ArrayList<DisplayViewMode> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = DisplayViewMode.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        modesSetNative(this.swigCPtr, this, jArr);
    }

    public ArrayList<DisplayViewMode> getModes() {
        return $explicit_getModes();
    }

    public ArrayList<DisplayViewMode> $explicit_getModes() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        ArrayList<DisplayViewMode> arrayList = null;
        long[] modesGetNative = modesGetNative(j, this);
        if (modesGetNative != null) {
            arrayList = new ArrayList<>();
            for (long j2 : modesGetNative) {
                arrayList.add(new DisplayViewMode(j2, false));
            }
        }
        return arrayList;
    }

    public void setMapProfile(String str) {
        $explicit_setMapProfile(str);
    }

    public void $explicit_setMapProfile(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mapProfileSetNative(j, this, str);
    }

    public String getMapProfile() {
        return $explicit_getMapProfile();
    }

    public String $explicit_getMapProfile() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mapProfileGetNative(j, this);
    }

    public void setLaneProfile(String str) {
        $explicit_setLaneProfile(str);
    }

    public void $explicit_setLaneProfile(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        laneProfileSetNative(j, this, str);
    }

    public String getLaneProfile() {
        return $explicit_getLaneProfile();
    }

    public String $explicit_getLaneProfile() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return laneProfileGetNative(j, this);
    }

    public void setRenderPolicy(int i) {
        $explicit_setRenderPolicy(i);
    }

    public void $explicit_setRenderPolicy(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        renderPolicySetNative(j, this, i);
    }

    public int getRenderPolicy() {
        return $explicit_getRenderPolicy();
    }

    public int $explicit_getRenderPolicy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return renderPolicyGetNative(j, this);
    }

    public void setInnerResume(boolean z) {
        $explicit_setInnerResume(z);
    }

    public void $explicit_setInnerResume(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        innerResumeSetNative(j, this, z);
    }

    public boolean getInnerResume() {
        return $explicit_getInnerResume();
    }

    public boolean $explicit_getInnerResume() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return innerResumeGetNative(j, this);
    }

    public void setFboEnable(boolean z) {
        $explicit_setFboEnable(z);
    }

    public void $explicit_setFboEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        fboEnableSetNative(j, this, z);
    }

    public boolean getFboEnable() {
        return $explicit_getFboEnable();
    }

    public boolean $explicit_getFboEnable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return fboEnableGetNative(j, this);
    }

    public void setNeedAntiAlias(int i) {
        $explicit_setNeedAntiAlias(i);
    }

    public void $explicit_setNeedAntiAlias(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        needAntiAliasSetNative(j, this, i);
    }

    public int getNeedAntiAlias() {
        return $explicit_getNeedAntiAlias();
    }

    public int $explicit_getNeedAntiAlias() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return needAntiAliasGetNative(j, this);
    }

    public void setSamples(int i) {
        $explicit_setSamples(i);
    }

    public void $explicit_setSamples(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        samplesSetNative(j, this, i);
    }

    public int getSamples() {
        return $explicit_getSamples();
    }

    public int $explicit_getSamples() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return samplesGetNative(j, this);
    }

    public void setWorkedModeIndex(int i) {
        $explicit_setWorkedModeIndex(i);
    }

    public void $explicit_setWorkedModeIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        workedModeIndexSetNative(j, this, i);
    }

    public int getWorkedModeIndex() {
        return $explicit_getWorkedModeIndex();
    }

    public int $explicit_getWorkedModeIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return workedModeIndexGetNative(j, this);
    }
}
