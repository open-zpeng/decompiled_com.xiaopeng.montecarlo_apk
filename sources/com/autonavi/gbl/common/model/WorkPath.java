package com.autonavi.gbl.common.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.impl.WorkPathImpl;
@IntfAuto(target = WorkPathImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class WorkPath {
    private static String PACKAGE = ReflexTool.PN(WorkPath.class);
    private WorkPathImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected WorkPath(long j, boolean z) {
        this(new WorkPathImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(WorkPath.class, this, this.mControl);
        }
    }

    public WorkPath() {
        this(new WorkPathImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(WorkPath.class, this, this.mControl);
        }
    }

    public WorkPath(WorkPathImpl workPathImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(workPathImpl);
    }

    private void $constructor(WorkPathImpl workPathImpl) {
        if (workPathImpl != null) {
            this.mControl = workPathImpl;
            this.mTargetId = String.format("WorkPath_%s_%d", String.valueOf(WorkPathImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected WorkPathImpl getControl() {
        return this.mControl;
    }

    public void setNavi(String str) {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            workPathImpl.setNavi(str);
        }
    }

    public String getNavi() {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            return workPathImpl.getNavi();
        }
        return null;
    }

    public void setRes(String str) {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            workPathImpl.setRes(str);
        }
    }

    public String getRes() {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            return workPathImpl.getRes();
        }
        return null;
    }

    public void setCache(String str) {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            workPathImpl.setCache(str);
        }
    }

    public String getCache() {
        WorkPathImpl workPathImpl = this.mControl;
        if (workPathImpl != null) {
            return workPathImpl.getCache();
        }
        return null;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.WorkPath.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.WorkPath.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.model.WorkPath.3
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
