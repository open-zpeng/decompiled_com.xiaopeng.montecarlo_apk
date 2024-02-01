package com.autonavi.gbl.data;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.data.impl.DataToolHotUpdateImpl;
import com.autonavi.gbl.data.model.HotUpdateFileType;
@IntfAuto(target = DataToolHotUpdateImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class DataToolHotUpdate {
    private static String PACKAGE = ReflexTool.PN(DataToolHotUpdate.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private DataToolHotUpdateImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DataToolHotUpdate(long j, boolean z) {
        this(new DataToolHotUpdateImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DataToolHotUpdate.class, this, this.mControl);
        }
    }

    public DataToolHotUpdate() {
        this(new DataToolHotUpdateImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DataToolHotUpdate.class, this, this.mControl);
        }
    }

    public DataToolHotUpdate(DataToolHotUpdateImpl dataToolHotUpdateImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(dataToolHotUpdateImpl);
    }

    private void $constructor(DataToolHotUpdateImpl dataToolHotUpdateImpl) {
        if (dataToolHotUpdateImpl != null) {
            this.mControl = dataToolHotUpdateImpl;
            this.mTargetId = String.format("DataToolHotUpdate_%s_%d", String.valueOf(DataToolHotUpdateImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected DataToolHotUpdateImpl getControl() {
        return this.mControl;
    }

    public static boolean setLocalVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i, String str2) {
        return DataToolHotUpdateImpl.setLocalVersion(str, i, str2);
    }

    public static String getLocalVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i) {
        return DataToolHotUpdateImpl.getLocalVersion(str, i);
    }

    public static String getRemoteVersion(String str, @HotUpdateFileType.HotUpdateFileType1 int i) {
        return DataToolHotUpdateImpl.getRemoteVersion(str, i);
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
