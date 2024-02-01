package com.autonavi.gbl.util;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.impl.LanguageToolImpl;
@IntfAuto(target = LanguageToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class LanguageTool {
    private static String PACKAGE = ReflexTool.PN(LanguageTool.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private LanguageToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected LanguageTool(long j, boolean z) {
        this(new LanguageToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LanguageTool.class, this, this.mControl);
        }
    }

    public LanguageTool() {
        this(new LanguageToolImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LanguageTool.class, this, this.mControl);
        }
    }

    public LanguageTool(LanguageToolImpl languageToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(languageToolImpl);
    }

    private void $constructor(LanguageToolImpl languageToolImpl) {
        if (languageToolImpl != null) {
            this.mControl = languageToolImpl;
            this.mTargetId = String.format("LanguageTool_%s_%d", String.valueOf(LanguageToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected LanguageToolImpl getControl() {
        return this.mControl;
    }

    public static String convertS2T(String str) {
        return LanguageToolImpl.convertS2T(str);
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
