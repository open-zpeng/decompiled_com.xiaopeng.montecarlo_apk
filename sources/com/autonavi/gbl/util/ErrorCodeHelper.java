package com.autonavi.gbl.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.ErrorCodeHelperImpl;
import com.autonavi.gbl.util.model.ErrorDetail;
@IntfAuto(target = ErrorCodeHelperImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class ErrorCodeHelper {
    private static String PACKAGE = ReflexTool.PN(ErrorCodeHelper.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private ErrorCodeHelperImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected ErrorCodeHelper(long j, boolean z) {
        this(new ErrorCodeHelperImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ErrorCodeHelper.class, this, this.mControl);
        }
    }

    public ErrorCodeHelper() {
        this(new ErrorCodeHelperImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(ErrorCodeHelper.class, this, this.mControl);
        }
    }

    public ErrorCodeHelper(ErrorCodeHelperImpl errorCodeHelperImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(errorCodeHelperImpl);
    }

    private void $constructor(ErrorCodeHelperImpl errorCodeHelperImpl) {
        if (errorCodeHelperImpl != null) {
            this.mControl = errorCodeHelperImpl;
            this.mTargetId = String.format("ErrorCodeHelper_%s_%d", String.valueOf(ErrorCodeHelperImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ErrorCodeHelperImpl getControl() {
        return this.mControl;
    }

    public static ErrorDetail getErrorDetail(int i) {
        return ErrorCodeHelperImpl.getErrorDetail(i);
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
