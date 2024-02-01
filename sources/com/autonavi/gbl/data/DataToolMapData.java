package com.autonavi.gbl.data;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.DataToolMapDataImpl;
@IntfAuto(target = DataToolMapDataImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class DataToolMapData {
    private static String PACKAGE = ReflexTool.PN(DataToolMapData.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private DataToolMapDataImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DataToolMapData(long j, boolean z) {
        this(new DataToolMapDataImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DataToolMapData.class, this, this.mControl);
        }
    }

    public DataToolMapData() {
        this(new DataToolMapDataImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DataToolMapData.class, this, this.mControl);
        }
    }

    public DataToolMapData(DataToolMapDataImpl dataToolMapDataImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(dataToolMapDataImpl);
    }

    private void $constructor(DataToolMapDataImpl dataToolMapDataImpl) {
        if (dataToolMapDataImpl != null) {
            this.mControl = dataToolMapDataImpl;
            this.mTargetId = String.format("DataToolMapData_%s_%d", String.valueOf(DataToolMapDataImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected DataToolMapDataImpl getControl() {
        return this.mControl;
    }

    public static void cityDataShift(String str, String str2) {
        DataToolMapDataImpl.cityDataShift(str, str2);
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
