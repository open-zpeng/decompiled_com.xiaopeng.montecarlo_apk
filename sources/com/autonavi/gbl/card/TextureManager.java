package com.autonavi.gbl.card;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.impl.ITextureManagerImpl;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.card.model.CustomUpdateParam;
import com.autonavi.gbl.card.model.ResourceType;
import com.autonavi.gbl.card.model.StaticTextureParam;
import com.autonavi.gbl.card.model.TextureCntInfo;
@IntfAuto(target = ITextureManagerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class TextureManager {
    private static String PACKAGE = ReflexTool.PN(TextureManager.class);
    private ITextureManagerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected TextureManager(long j, boolean z) {
        this(new ITextureManagerImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(TextureManager.class, this, this.mControl);
        }
    }

    public TextureManager(ITextureManagerImpl iTextureManagerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iTextureManagerImpl);
    }

    private void $constructor(ITextureManagerImpl iTextureManagerImpl) {
        if (iTextureManagerImpl != null) {
            this.mControl = iTextureManagerImpl;
            this.mTargetId = String.format("TextureManager_%s_%d", String.valueOf(ITextureManagerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ITextureManagerImpl getControl() {
        return this.mControl;
    }

    public TextureCntInfo getUsedTextureCnt() {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.getUsedTextureCnt();
        }
        return null;
    }

    public boolean setMarkerIdRange(int i, int i2) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.setMarkerIdRange(i, i2);
        }
        return false;
    }

    public int addStaticTexture(StaticTextureParam staticTextureParam) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.addStaticTexture(staticTextureParam);
        }
        return 0;
    }

    public int addCustomTexture(CustomTextureParam customTextureParam) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.addCustomTexture(customTextureParam);
        }
        return 0;
    }

    public int updateCustomTexture(int i, CustomUpdateParam customUpdateParam) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.updateCustomTexture(i, customUpdateParam);
        }
        return 0;
    }

    public void destroyCustomTexture(int i) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            iTextureManagerImpl.destroyCustomTexture(i);
        }
    }

    @ResourceType.ResourceType1
    public int getResourceType(String str) {
        ITextureManagerImpl iTextureManagerImpl = this.mControl;
        if (iTextureManagerImpl != null) {
            return iTextureManagerImpl.getResourceType(str);
        }
        return Integer.MIN_VALUE;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.card.TextureManager.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.card.TextureManager.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.card.TextureManager.3
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
