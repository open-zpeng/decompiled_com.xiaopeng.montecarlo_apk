package com.autonavi.gbl.scene.dynamic.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.FatigueInfo;
import com.autonavi.gbl.common.model.GreetingParam;
import com.autonavi.gbl.common.model.RequestRestrictRuleType;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.common.model.STTipsInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.scene.dynamic.DynamicCloudShowInfoModule;
import com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl;
import com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl;
import java.util.ArrayList;
@IntfAuto(target = DynamicCloudShowInfoModule.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDynamicCloudShowInfoModuleImpl extends IBaseSceneModuleImpl {
    private static BindTable BIND_TABLE = new BindTable(IDynamicCloudShowInfoModuleImpl.class);
    private transient long swigCPtr;

    private static native long IDynamicCloudShowInfoModuleImpl_SWIGUpcast(long j);

    private static native boolean abortRestrictAreaRequestNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2);

    private static native boolean addDynamicCloudShowInfoObserverNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean dynamicFatigueNotifyNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, ArrayList<FatigueInfo> arrayList);

    private static native void getCloudInfoNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, PathInfo pathInfo, long j3, STTipsInfo sTTipsInfo);

    private static native int initNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, boolean z);

    private static native boolean removeDynamicCloudShowInfoObserverNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl);

    private static native RestrictRuleResult requestRestrictRuleByPathNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, PathInfo pathInfo, int i);

    private static native RestrictRuleResult requestRestrictRuleNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, int i, ArrayList<Long> arrayList);

    private static native void requestTipsInfoNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, PathInfo pathInfo);

    private static native boolean setGreetingParamNative(long j, IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl, long j2, GreetingParam greetingParam);

    public IDynamicCloudShowInfoModuleImpl(long j, boolean z) {
        super(IDynamicCloudShowInfoModuleImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public boolean equals(Object obj) {
        if (obj instanceof IDynamicCloudShowInfoModuleImpl) {
            return getUID(this) == getUID((IDynamicCloudShowInfoModuleImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl) {
        long cPtr = getCPtr(iDynamicCloudShowInfoModuleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl) {
        if (iDynamicCloudShowInfoModuleImpl == null) {
            return 0L;
        }
        return iDynamicCloudShowInfoModuleImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.impl.IBaseSceneModuleImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public int init(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, z);
    }

    public STTipsInfo getCloudInfo(PathInfo pathInfo) {
        STTipsInfo sTTipsInfo = new STTipsInfo();
        getCloudInfo(pathInfo, sTTipsInfo);
        return sTTipsInfo;
    }

    private void getCloudInfo(PathInfo pathInfo, STTipsInfo sTTipsInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getCloudInfoNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo, 0L, sTTipsInfo);
    }

    public RestrictRuleResult requestRestrictRuleByPath(PathInfo pathInfo, @RequestRestrictRuleType.RequestRestrictRuleType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRestrictRuleByPathNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo, i);
    }

    public RestrictRuleResult requestRestrictRule(@RequestRestrictRuleType.RequestRestrictRuleType1 int i, ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestRestrictRuleNative(j, this, i, arrayList);
    }

    public boolean abortRestrictAreaRequest(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return abortRestrictAreaRequestNative(j2, this, j);
    }

    public boolean addDynamicCloudShowInfoObserver(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addDynamicCloudShowInfoObserverNative(j, this, IDynamicCloudShowInfoObserverImpl.getCPtr(iDynamicCloudShowInfoObserverImpl), iDynamicCloudShowInfoObserverImpl);
    }

    public boolean removeDynamicCloudShowInfoObserver(IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeDynamicCloudShowInfoObserverNative(j, this, IDynamicCloudShowInfoObserverImpl.getCPtr(iDynamicCloudShowInfoObserverImpl), iDynamicCloudShowInfoObserverImpl);
    }

    public boolean dynamicFatigueNotify(ArrayList<FatigueInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dynamicFatigueNotifyNative(j, this, arrayList);
    }

    public void requestTipsInfo(PathInfo pathInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        requestTipsInfoNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo);
    }

    public boolean setGreetingParam(GreetingParam greetingParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setGreetingParamNative(j, this, 0L, greetingParam);
    }
}
