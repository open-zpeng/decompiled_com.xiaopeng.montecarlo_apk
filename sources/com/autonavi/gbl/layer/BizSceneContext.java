package com.autonavi.gbl.layer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.BizSceneContextImpl;
import com.autonavi.gbl.layer.model.SceneOperateType;
import com.autonavi.gbl.map.model.MapEngineID;
@IntfAuto(target = BizSceneContextImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizSceneContext {
    private static String PACKAGE = ReflexTool.PN(BizSceneContext.class);
    private BizSceneContextImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizSceneContext(long j, boolean z) {
        this(new BizSceneContextImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizSceneContext.class, this, this.mControl);
        }
    }

    public BizSceneContext(String str, @SceneOperateType.SceneOperateType1 int i) {
        this(new BizSceneContextImpl(str, i));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizSceneContext.class, this, this.mControl);
        }
    }

    public BizSceneContext(BizSceneContextImpl bizSceneContextImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bizSceneContextImpl);
    }

    private void $constructor(BizSceneContextImpl bizSceneContextImpl) {
        if (bizSceneContextImpl != null) {
            this.mControl = bizSceneContextImpl;
            this.mTargetId = String.format("BizSceneContext_%s_%d", String.valueOf(BizSceneContextImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BizSceneContextImpl getControl() {
        return this.mControl;
    }

    public String getSceneName() {
        BizSceneContextImpl bizSceneContextImpl = this.mControl;
        if (bizSceneContextImpl != null) {
            return bizSceneContextImpl.getSceneName();
        }
        return null;
    }

    @SceneOperateType.SceneOperateType1
    public int getOperateType() {
        BizSceneContextImpl bizSceneContextImpl = this.mControl;
        if (bizSceneContextImpl != null) {
            return bizSceneContextImpl.getOperateType();
        }
        return Integer.MIN_VALUE;
    }

    public void setMapEngineId(@MapEngineID.MapEngineID1 int i) {
        BizSceneContextImpl bizSceneContextImpl = this.mControl;
        if (bizSceneContextImpl != null) {
            bizSceneContextImpl.setMapEngineId(i);
        }
    }

    @MapEngineID.MapEngineID1
    public int getMapEngineId() {
        BizSceneContextImpl bizSceneContextImpl = this.mControl;
        if (bizSceneContextImpl != null) {
            return bizSceneContextImpl.getMapEngineId();
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
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

    public synchronized void delete() {
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
