package com.autonavi.gbl.scene.dynamic;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.FatigueInfo;
import com.autonavi.gbl.common.model.GreetingParam;
import com.autonavi.gbl.common.model.RequestRestrictRuleType;
import com.autonavi.gbl.common.model.RestrictRuleResult;
import com.autonavi.gbl.common.model.STTipsInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.scene.BaseSceneModule;
import com.autonavi.gbl.scene.dynamic.impl.IDynamicCloudShowInfoModuleImpl;
import com.autonavi.gbl.scene.observer.IDynamicCloudShowInfoObserver;
import com.autonavi.gbl.scene.observer.impl.IDynamicCloudShowInfoObserverImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IDynamicCloudShowInfoModuleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class DynamicCloudShowInfoModule extends BaseSceneModule {
    private static String PACKAGE = ReflexTool.PN(DynamicCloudShowInfoModule.class);
    private IDynamicCloudShowInfoModuleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected DynamicCloudShowInfoModule(long j, boolean z) {
        this(new IDynamicCloudShowInfoModuleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DynamicCloudShowInfoModule.class, this, this.mControl);
        }
    }

    public DynamicCloudShowInfoModule(IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl) {
        super(iDynamicCloudShowInfoModuleImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDynamicCloudShowInfoModuleImpl);
    }

    private void $constructor(IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl) {
        if (iDynamicCloudShowInfoModuleImpl != null) {
            this.mControl = iDynamicCloudShowInfoModuleImpl;
            this.mTargetId = String.format("DynamicCloudShowInfoModule_%s_%d", String.valueOf(IDynamicCloudShowInfoModuleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public IDynamicCloudShowInfoModuleImpl getControl() {
        return this.mControl;
    }

    public int init(boolean z) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.init(z);
        }
        return Integer.MIN_VALUE;
    }

    public STTipsInfo getCloudInfo(PathInfo pathInfo) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.getCloudInfo(pathInfo);
        }
        return null;
    }

    public RestrictRuleResult requestRestrictRuleByPath(PathInfo pathInfo, @RequestRestrictRuleType.RequestRestrictRuleType1 int i) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.requestRestrictRuleByPath(pathInfo, i);
        }
        return null;
    }

    public RestrictRuleResult requestRestrictRule(@RequestRestrictRuleType.RequestRestrictRuleType1 int i, ArrayList<Long> arrayList) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.requestRestrictRule(i, arrayList);
        }
        return null;
    }

    public boolean abortRestrictAreaRequest(long j) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.abortRestrictAreaRequest(j);
        }
        return false;
    }

    public boolean addDynamicCloudShowInfoObserver(IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicCloudShowInfoModule.class.getMethod("addDynamicCloudShowInfoObserver", IDynamicCloudShowInfoObserver.class);
            IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl = null;
            if (iDynamicCloudShowInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDynamicCloudShowInfoObserverImpl = (IDynamicCloudShowInfoObserverImpl) typeHelper.transfer(method, 0, iDynamicCloudShowInfoObserver);
            }
            IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
            if (iDynamicCloudShowInfoModuleImpl != null) {
                return iDynamicCloudShowInfoModuleImpl.addDynamicCloudShowInfoObserver(iDynamicCloudShowInfoObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeDynamicCloudShowInfoObserver(IDynamicCloudShowInfoObserver iDynamicCloudShowInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = DynamicCloudShowInfoModule.class.getMethod("removeDynamicCloudShowInfoObserver", IDynamicCloudShowInfoObserver.class);
            IDynamicCloudShowInfoObserverImpl iDynamicCloudShowInfoObserverImpl = null;
            if (iDynamicCloudShowInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iDynamicCloudShowInfoObserverImpl = (IDynamicCloudShowInfoObserverImpl) typeHelper.transfer(method, 0, iDynamicCloudShowInfoObserver);
            }
            IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
            if (iDynamicCloudShowInfoModuleImpl != null) {
                boolean removeDynamicCloudShowInfoObserver = iDynamicCloudShowInfoModuleImpl.removeDynamicCloudShowInfoObserver(iDynamicCloudShowInfoObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDynamicCloudShowInfoObserver);
                }
                return removeDynamicCloudShowInfoObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean dynamicFatigueNotify(ArrayList<FatigueInfo> arrayList) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.dynamicFatigueNotify(arrayList);
        }
        return false;
    }

    public void requestTipsInfo(PathInfo pathInfo) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            iDynamicCloudShowInfoModuleImpl.requestTipsInfo(pathInfo);
        }
    }

    public boolean setGreetingParam(GreetingParam greetingParam) {
        IDynamicCloudShowInfoModuleImpl iDynamicCloudShowInfoModuleImpl = this.mControl;
        if (iDynamicCloudShowInfoModuleImpl != null) {
            return iDynamicCloudShowInfoModuleImpl.setGreetingParam(greetingParam);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.scene.BaseSceneModule
    public void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.scene.observer.IDynamicCloudShowInfoObserver")).iterator();
            while (it.hasNext()) {
                removeDynamicCloudShowInfoObserver((IDynamicCloudShowInfoObserver) it.next());
            }
        }
        super.clean();
    }

    @Override // com.autonavi.gbl.scene.BaseSceneModule
    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
