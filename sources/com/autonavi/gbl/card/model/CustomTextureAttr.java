package com.autonavi.gbl.card.model;

import android.util.Log;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.card.observer.IFileContentLoader;
import com.autonavi.gbl.card.observer.impl.IFileContentLoaderImpl;
import com.autonavi.gbl.map.layer.model.LayerIconAnchor;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
/* loaded from: classes.dex */
public class CustomTextureAttr implements Serializable {
    @LayerIconAnchor.LayerIconAnchor1
    private int anchorType;
    private IFileContentLoaderImpl fileProxy;
    private boolean isEnableStrategy;
    private boolean isGenMipmaps;
    private boolean isNightForAsvg;
    private boolean isPreMulAlpha;
    private boolean isRepeat;
    private TypeHelper mTypeHelper;
    private float scaleFactor;
    private long xOffset;
    private float xRatio;
    private long yOffset;
    private float yRatio;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("CustomTextureAttr" + hashCode());
    }

    private void recordByIntfAuto() {
        getFileProxy();
    }

    public void setScaleFactor(float f) {
        this.scaleFactor = f;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public void setIsNightForAsvg(boolean z) {
        this.isNightForAsvg = z;
    }

    public boolean getIsNightForAsvg() {
        return this.isNightForAsvg;
    }

    public void setIsEnableStrategy(boolean z) {
        this.isEnableStrategy = z;
    }

    public boolean getIsEnableStrategy() {
        return this.isEnableStrategy;
    }

    public void setAnchorType(int i) {
        this.anchorType = i;
    }

    public int getAnchorType() {
        return this.anchorType;
    }

    public void setXRatio(float f) {
        this.xRatio = f;
    }

    public float getXRatio() {
        return this.xRatio;
    }

    public void setYRatio(float f) {
        this.yRatio = f;
    }

    public float getYRatio() {
        return this.yRatio;
    }

    public void setXOffset(long j) {
        this.xOffset = j;
    }

    public long getXOffset() {
        return this.xOffset;
    }

    public void setYOffset(long j) {
        this.yOffset = j;
    }

    public long getYOffset() {
        return this.yOffset;
    }

    public void setIsGenMipmaps(boolean z) {
        this.isGenMipmaps = z;
    }

    public boolean getIsGenMipmaps() {
        return this.isGenMipmaps;
    }

    public void setIsRepeat(boolean z) {
        this.isRepeat = z;
    }

    public boolean getIsRepeat() {
        return this.isRepeat;
    }

    public void setIsPreMulAlpha(boolean z) {
        this.isPreMulAlpha = z;
    }

    public boolean getIsPreMulAlpha() {
        return this.isPreMulAlpha;
    }

    public void setFileProxy(IFileContentLoader iFileContentLoader) {
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.CustomTextureAttr.1
        });
        try {
            Method method = getClass().getMethod("setFileProxy", IFileContentLoader.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                Set bindSet = typeHelper.getBindSet(method, 0);
                bindSet.remove(iFileContentLoader);
                this.fileProxy = (IFileContentLoaderImpl) this.mTypeHelper.transfer(method, 0, iFileContentLoader);
                this.mTypeHelper.unbindSet(method, 0, bindSet);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IFileContentLoader getFileProxy() {
        if (this.mTypeHelper != null && this.fileProxy != null) {
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.CustomTextureAttr.2
            });
            try {
                return (IFileContentLoader) this.mTypeHelper.transfer(getClass().getMethod("getFileProxy", new Class[0]), -1, (Object) this.fileProxy, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public CustomTextureAttr() {
        initTypeHelper();
        this.scaleFactor = 1.0f;
        this.isNightForAsvg = false;
        this.isEnableStrategy = false;
        this.anchorType = 0;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.xOffset = 0L;
        this.yOffset = 0L;
        this.isGenMipmaps = false;
        this.isRepeat = false;
        this.isPreMulAlpha = true;
        this.fileProxy = null;
        recordByIntfAuto();
    }

    protected CustomTextureAttr(float f, boolean z, boolean z2, @LayerIconAnchor.LayerIconAnchor1 int i, float f2, float f3, long j, long j2, boolean z3, boolean z4, boolean z5, IFileContentLoaderImpl iFileContentLoaderImpl) {
        initTypeHelper();
        this.scaleFactor = f;
        this.isNightForAsvg = z;
        this.isEnableStrategy = z2;
        this.anchorType = i;
        this.xRatio = f2;
        this.yRatio = f3;
        this.xOffset = j;
        this.yOffset = j2;
        this.isGenMipmaps = z3;
        this.isRepeat = z4;
        this.isPreMulAlpha = z5;
        this.fileProxy = iFileContentLoaderImpl;
        recordByIntfAuto();
    }

    public CustomTextureAttr(float f, boolean z, boolean z2, @LayerIconAnchor.LayerIconAnchor1 int i, float f2, float f3, long j, long j2, boolean z3, boolean z4, boolean z5, IFileContentLoader iFileContentLoader) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.card.model.CustomTextureAttr.3
        });
        this.scaleFactor = f;
        this.isNightForAsvg = z;
        this.isEnableStrategy = z2;
        this.anchorType = i;
        this.xRatio = f2;
        this.yRatio = f3;
        this.xOffset = j;
        this.yOffset = j2;
        this.isGenMipmaps = z3;
        this.isRepeat = z4;
        this.isPreMulAlpha = z5;
        TypeHelper typeHelper = this.mTypeHelper;
        this.fileProxy = typeHelper != null ? (IFileContentLoaderImpl) typeHelper.transfer(EC, 11, iFileContentLoader) : null;
        recordByIntfAuto();
    }
}
