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
public class StaticTextureParam implements Serializable {
    @LayerIconAnchor.LayerIconAnchor1
    private int anchorType;
    private IFileContentLoaderImpl fileProxy;
    private boolean isGenMipmaps;
    private boolean isPreMulAlpha;
    private boolean isRepeat;
    private TypeHelper mTypeHelper;
    private MarkerKeyParam markerKey;
    private float xRatio;
    private float yRatio;

    public void delete() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    private void initTypeHelper() {
        this.mTypeHelper = new TypeHelper("StaticTextureParam" + hashCode());
    }

    private void recordByIntfAuto() {
        getFileProxy();
    }

    public void setMarkerKey(MarkerKeyParam markerKeyParam) {
        this.markerKey = markerKeyParam;
    }

    public MarkerKeyParam getMarkerKey() {
        return this.markerKey;
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
        ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.StaticTextureParam.1
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
            ReflexTool.EM(new Object() { // from class: com.autonavi.gbl.card.model.StaticTextureParam.2
            });
            try {
                return (IFileContentLoader) this.mTypeHelper.transfer(getClass().getMethod("getFileProxy", new Class[0]), -1, (Object) this.fileProxy, true);
            } catch (Exception e) {
                Log.w("INTFAUTO", Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public StaticTextureParam() {
        initTypeHelper();
        this.markerKey = new MarkerKeyParam();
        this.anchorType = 0;
        this.xRatio = 0.0f;
        this.yRatio = 0.0f;
        this.isGenMipmaps = false;
        this.isRepeat = false;
        this.isPreMulAlpha = true;
        this.fileProxy = null;
        recordByIntfAuto();
    }

    protected StaticTextureParam(MarkerKeyParam markerKeyParam, @LayerIconAnchor.LayerIconAnchor1 int i, float f, float f2, boolean z, boolean z2, boolean z3, IFileContentLoaderImpl iFileContentLoaderImpl) {
        initTypeHelper();
        this.markerKey = markerKeyParam;
        this.anchorType = i;
        this.xRatio = f;
        this.yRatio = f2;
        this.isGenMipmaps = z;
        this.isRepeat = z2;
        this.isPreMulAlpha = z3;
        this.fileProxy = iFileContentLoaderImpl;
        recordByIntfAuto();
    }

    public StaticTextureParam(MarkerKeyParam markerKeyParam, @LayerIconAnchor.LayerIconAnchor1 int i, float f, float f2, boolean z, boolean z2, boolean z3, IFileContentLoader iFileContentLoader) {
        initTypeHelper();
        Constructor EC = ReflexTool.EC(new Object() { // from class: com.autonavi.gbl.card.model.StaticTextureParam.3
        });
        this.markerKey = markerKeyParam;
        this.anchorType = i;
        this.xRatio = f;
        this.yRatio = f2;
        this.isGenMipmaps = z;
        this.isRepeat = z2;
        this.isPreMulAlpha = z3;
        TypeHelper typeHelper = this.mTypeHelper;
        this.fileProxy = typeHelper != null ? (IFileContentLoaderImpl) typeHelper.transfer(EC, 7, iFileContentLoader) : null;
        recordByIntfAuto();
    }
}
