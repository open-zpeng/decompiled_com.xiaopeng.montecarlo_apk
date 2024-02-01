package com.autonavi.gbl.aosclient.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.EGAOSSERVERTYPE;
import com.autonavi.gbl.aosclient.model.impl.GAosServerTypeImpl;
@IntfAuto(target = GAosServerTypeImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class GAosServerType {
    private static String PACKAGE = ReflexTool.PN(GAosServerType.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private GAosServerTypeImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected GAosServerType(long j, boolean z) {
        this(new GAosServerTypeImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GAosServerType.class, this, this.mControl);
        }
    }

    public GAosServerType() {
        this(new GAosServerTypeImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GAosServerType.class, this, this.mControl);
        }
    }

    public GAosServerType(GAosServerTypeImpl gAosServerTypeImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(gAosServerTypeImpl);
    }

    private void $constructor(GAosServerTypeImpl gAosServerTypeImpl) {
        if (gAosServerTypeImpl != null) {
            this.mControl = gAosServerTypeImpl;
            this.mTargetId = String.format("GAosServerType_%s_%d", String.valueOf(GAosServerTypeImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected GAosServerTypeImpl getControl() {
        return this.mControl;
    }

    public static short[] getString(@EGAOSSERVERTYPE.EGAOSSERVERTYPE1 int i) {
        return GAosServerTypeImpl.getString(i);
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
