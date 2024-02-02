package com.autonavi.gbl.card.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.card.TextureManager;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.card.model.CustomUpdateParam;
import com.autonavi.gbl.card.model.ResourceType;
import com.autonavi.gbl.card.model.StaticTextureParam;
import com.autonavi.gbl.card.model.TextureCntInfo;
@IntfAuto(target = TextureManager.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ITextureManagerImpl {
    private static BindTable BIND_TABLE = new BindTable(ITextureManagerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addCustomTextureNative(long j, ITextureManagerImpl iTextureManagerImpl, long j2, CustomTextureParam customTextureParam);

    private static native int addStaticTextureNative(long j, ITextureManagerImpl iTextureManagerImpl, long j2, StaticTextureParam staticTextureParam);

    private static native void destroyCustomTextureNative(long j, ITextureManagerImpl iTextureManagerImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native int getResourceTypeNative(long j, ITextureManagerImpl iTextureManagerImpl, String str);

    private static native boolean getUsedTextureCntNative(long j, ITextureManagerImpl iTextureManagerImpl, long j2, TextureCntInfo textureCntInfo);

    private static native boolean setMarkerIdRangeNative(long j, ITextureManagerImpl iTextureManagerImpl, int i, int i2);

    private static native int updateCustomTextureNative(long j, ITextureManagerImpl iTextureManagerImpl, int i, long j2, CustomUpdateParam customUpdateParam);

    public ITextureManagerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ITextureManagerImpl) && getUID(this) == getUID((ITextureManagerImpl) obj);
    }

    private static long getUID(ITextureManagerImpl iTextureManagerImpl) {
        long cPtr = getCPtr(iTextureManagerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ITextureManagerImpl iTextureManagerImpl) {
        if (iTextureManagerImpl == null) {
            return 0L;
        }
        return iTextureManagerImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public TextureCntInfo getUsedTextureCnt() {
        TextureCntInfo textureCntInfo = new TextureCntInfo();
        if (getUsedTextureCnt(textureCntInfo)) {
            return textureCntInfo;
        }
        return null;
    }

    public boolean setMarkerIdRange(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setMarkerIdRangeNative(j, this, i, i2);
    }

    private boolean getUsedTextureCnt(TextureCntInfo textureCntInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUsedTextureCntNative(j, this, 0L, textureCntInfo);
    }

    public int addStaticTexture(StaticTextureParam staticTextureParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addStaticTextureNative(j, this, 0L, staticTextureParam);
    }

    public int addCustomTexture(CustomTextureParam customTextureParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addCustomTextureNative(j, this, 0L, customTextureParam);
    }

    public int updateCustomTexture(int i, CustomUpdateParam customUpdateParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateCustomTextureNative(j, this, i, 0L, customUpdateParam);
    }

    public void destroyCustomTexture(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroyCustomTextureNative(j, this, i);
    }

    @ResourceType.ResourceType1
    public int getResourceType(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getResourceTypeNative(j, this, str);
    }
}
