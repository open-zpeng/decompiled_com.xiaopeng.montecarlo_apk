package com.autonavi.gbl.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.BlToolPoiIDImpl;
@IntfAuto(target = BlToolPoiIDImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BlToolPoiID {
    private static String PACKAGE = ReflexTool.PN(BlToolPoiID.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BlToolPoiIDImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BlToolPoiID(long j, boolean z) {
        this(new BlToolPoiIDImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BlToolPoiID.class, this, this.mControl);
        }
    }

    public BlToolPoiID() {
        this(new BlToolPoiIDImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BlToolPoiID.class, this, this.mControl);
        }
    }

    public BlToolPoiID(BlToolPoiIDImpl blToolPoiIDImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(blToolPoiIDImpl);
    }

    private void $constructor(BlToolPoiIDImpl blToolPoiIDImpl) {
        if (blToolPoiIDImpl != null) {
            this.mControl = blToolPoiIDImpl;
            this.mTargetId = String.format("BlToolPoiID_%s_%d", String.valueOf(BlToolPoiIDImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BlToolPoiIDImpl getControl() {
        return this.mControl;
    }

    public static String poiIDToEventID(String str, long j) {
        return BlToolPoiIDImpl.poiIDToEventID(str, j);
    }

    public static String poiIDToEventID(String str) {
        return BlToolPoiIDImpl.poiIDToEventID(str);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BlToolPoiID.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BlToolPoiID.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.BlToolPoiID.3
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
