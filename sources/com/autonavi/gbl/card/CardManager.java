package com.autonavi.gbl.card;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.impl.ICardManagerImpl;
@IntfAuto(target = ICardManagerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class CardManager {
    private static String PACKAGE = ReflexTool.PN(CardManager.class);
    private ICardManagerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected CardManager(long j, boolean z) {
        this(new ICardManagerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(CardManager.class, this, this.mControl);
        }
    }

    public CardManager() {
        this(new ICardManagerImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(CardManager.class, this, this.mControl);
        }
    }

    public CardManager(ICardManagerImpl iCardManagerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iCardManagerImpl);
    }

    private void $constructor(ICardManagerImpl iCardManagerImpl) {
        if (iCardManagerImpl != null) {
            this.mControl = iCardManagerImpl;
            this.mTargetId = String.format("CardManager_%s_%d", String.valueOf(ICardManagerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ICardManagerImpl getControl() {
        return this.mControl;
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

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
