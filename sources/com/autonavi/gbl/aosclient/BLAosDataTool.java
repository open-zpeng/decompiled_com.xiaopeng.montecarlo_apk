package com.autonavi.gbl.aosclient;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.impl.BLAosDataToolImpl;
@IntfAuto(target = BLAosDataToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BLAosDataTool {
    private static String PACKAGE = ReflexTool.PN(BLAosDataTool.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BLAosDataToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BLAosDataTool(long j, boolean z) {
        this(new BLAosDataToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosDataTool.class, this, this.mControl);
        }
    }

    public BLAosDataTool() {
        this(new BLAosDataToolImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosDataTool.class, this, this.mControl);
        }
    }

    public BLAosDataTool(BLAosDataTool bLAosDataTool) {
        this(new BLAosDataToolImpl((BLAosDataToolImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.aosclient.BLAosDataTool", bLAosDataTool)));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosDataTool.class, this, this.mControl);
        }
    }

    public BLAosDataTool(BLAosDataToolImpl bLAosDataToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bLAosDataToolImpl);
    }

    private void $constructor(BLAosDataToolImpl bLAosDataToolImpl) {
        if (bLAosDataToolImpl != null) {
            this.mControl = bLAosDataToolImpl;
            this.mTargetId = String.format("BLAosDataTool_%s_%d", String.valueOf(BLAosDataToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BLAosDataToolImpl getControl() {
        return this.mControl;
    }

    public static String getSessionid(String str) {
        return BLAosDataToolImpl.getSessionid(str);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosDataTool.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosDataTool.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.BLAosDataTool.3
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
