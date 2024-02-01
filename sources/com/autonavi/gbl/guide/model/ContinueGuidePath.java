package com.autonavi.gbl.guide.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.guide.model.impl.ContinueGuidePathImpl;
import java.util.ArrayList;
@IntfAuto(target = ContinueGuidePathImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class ContinueGuidePath {
    private static String PACKAGE = ReflexTool.PN(ContinueGuidePath.class);
    private ContinueGuidePathImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected ContinueGuidePath(long j, boolean z) {
        this(new ContinueGuidePathImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ContinueGuidePath.class, this, this.mControl);
        }
    }

    public ContinueGuidePath() {
        this(new ContinueGuidePathImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ContinueGuidePath.class, this, this.mControl);
        }
    }

    public ContinueGuidePath(ContinueGuidePathImpl continueGuidePathImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(continueGuidePathImpl);
    }

    private void $constructor(ContinueGuidePathImpl continueGuidePathImpl) {
        if (continueGuidePathImpl != null) {
            this.mControl = continueGuidePathImpl;
            this.mTargetId = String.format("ContinueGuidePath_%s_%d", String.valueOf(ContinueGuidePathImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ContinueGuidePathImpl getControl() {
        return this.mControl;
    }

    public void setMainPathId(long j) {
        ContinueGuidePathImpl continueGuidePathImpl = this.mControl;
        if (continueGuidePathImpl != null) {
            continueGuidePathImpl.setMainPathId(j);
        }
    }

    public long getMainPathId() {
        ContinueGuidePathImpl continueGuidePathImpl = this.mControl;
        if (continueGuidePathImpl != null) {
            return continueGuidePathImpl.getMainPathId();
        }
        return 0L;
    }

    public void setPathInfoList(ArrayList<PathInfo> arrayList) {
        ContinueGuidePathImpl continueGuidePathImpl = this.mControl;
        if (continueGuidePathImpl != null) {
            continueGuidePathImpl.setPathInfoList(arrayList);
        }
    }

    public ArrayList<PathInfo> getPathInfoList() {
        ContinueGuidePathImpl continueGuidePathImpl = this.mControl;
        if (continueGuidePathImpl != null) {
            return continueGuidePathImpl.getPathInfoList();
        }
        return null;
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
