package com.autonavi.gbl.aosclient.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.EGHTTPCLIENTSTATUS;
import com.autonavi.gbl.aosclient.model.ENETWORKSTATUS;
import com.autonavi.gbl.aosclient.model.impl.GHttpImpl;
@IntfAuto(target = GHttpImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class GHttp {
    private static String PACKAGE = ReflexTool.PN(GHttp.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private GHttpImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GHttp(long j, boolean z) {
        this(new GHttpImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GHttp.class, this, this.mControl);
        }
    }

    public GHttp() {
        this(new GHttpImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GHttp.class, this, this.mControl);
        }
    }

    public GHttp(GHttpImpl gHttpImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(gHttpImpl);
    }

    private void $constructor(GHttpImpl gHttpImpl) {
        if (gHttpImpl != null) {
            this.mControl = gHttpImpl;
            this.mTargetId = String.format("GHttp_%s_%d", String.valueOf(GHttpImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected GHttpImpl getControl() {
        return this.mControl;
    }

    public static short[] getString(@EGHTTPCLIENTSTATUS.EGHTTPCLIENTSTATUS1 int i) {
        return GHttpImpl.getString(i);
    }

    public static String getStringUtf8(@ENETWORKSTATUS.ENETWORKSTATUS1 int i) {
        return GHttpImpl.getStringUtf8(i);
    }

    public static boolean checkCanDelete(@EGHTTPCLIENTSTATUS.EGHTTPCLIENTSTATUS1 int i) {
        return GHttpImpl.checkCanDelete(i);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.GHttp.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.GHttp.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.GHttp.3
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
