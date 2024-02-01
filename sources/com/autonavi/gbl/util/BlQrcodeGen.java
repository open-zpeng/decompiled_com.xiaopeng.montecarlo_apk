package com.autonavi.gbl.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.BlQrcodeGenImpl;
import com.autonavi.gbl.util.model.QrCodeStream;
@IntfAuto(target = BlQrcodeGenImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class BlQrcodeGen {
    private static String PACKAGE = ReflexTool.PN(BlQrcodeGen.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BlQrcodeGenImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BlQrcodeGen(long j, boolean z) {
        this(new BlQrcodeGenImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BlQrcodeGen.class, this, this.mControl);
        }
    }

    public BlQrcodeGen() {
        this(new BlQrcodeGenImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BlQrcodeGen.class, this, this.mControl);
        }
    }

    public BlQrcodeGen(BlQrcodeGenImpl blQrcodeGenImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(blQrcodeGenImpl);
    }

    private void $constructor(BlQrcodeGenImpl blQrcodeGenImpl) {
        if (blQrcodeGenImpl != null) {
            this.mControl = blQrcodeGenImpl;
            this.mTargetId = String.format("BlQrcodeGen_%s_%d", String.valueOf(BlQrcodeGenImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BlQrcodeGenImpl getControl() {
        return this.mControl;
    }

    public static QrCodeStream stringToQrcode(String str) {
        return BlQrcodeGenImpl.stringToQrcode(str);
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
