package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.layer.impl.IBizRoadCrossControlImpl;
import com.autonavi.gbl.layer.model.BizRoadCrossType;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.RealCity3DFilter;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
@IntfAuto(target = IBizRoadCrossControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizRoadCrossControl {
    private static String PACKAGE = ReflexTool.PN(BizRoadCrossControl.class);
    private IBizRoadCrossControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizRoadCrossControl(long j, boolean z) {
        this(new IBizRoadCrossControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizRoadCrossControl.class, this, this.mControl);
        }
    }

    public BizRoadCrossControl(IBizRoadCrossControlImpl iBizRoadCrossControlImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizRoadCrossControlImpl);
    }

    private void $constructor(IBizRoadCrossControlImpl iBizRoadCrossControlImpl) {
        if (iBizRoadCrossControlImpl != null) {
            this.mControl = iBizRoadCrossControlImpl;
            this.mTargetId = String.format("BizRoadCrossControl_%s_%d", String.valueOf(IBizRoadCrossControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IBizRoadCrossControlImpl getControl() {
        return this.mControl;
    }

    public boolean matchBizControl(long j) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.matchBizControl(j);
        }
        return false;
    }

    public void setStyle(IPrepareLayerStyle iPrepareLayerStyle) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = BizRoadCrossControl.class.getMethod("setStyle", IPrepareLayerStyle.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iPrepareLayerStyle);
            IPrepareLayerStyleImpl iPrepareLayerStyleImpl = null;
            if (iPrepareLayerStyle != null && (typeHelper = this.mTypeHelper) != null) {
                iPrepareLayerStyleImpl = (IPrepareLayerStyleImpl) typeHelper.transfer(method, 0, iPrepareLayerStyle);
            }
            IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
            if (iBizRoadCrossControlImpl != null) {
                iBizRoadCrossControlImpl.setStyle(iPrepareLayerStyleImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public IPrepareLayerStyle getStyle() {
        IPrepareLayerStyleImpl style;
        TypeHelper typeHelper;
        try {
            Method method = BizRoadCrossControl.class.getMethod("getStyle", new Class[0]);
            IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
            if (iBizRoadCrossControlImpl == null || (style = iBizRoadCrossControlImpl.getStyle()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (IPrepareLayerStyle) typeHelper.transfer(method, -1, (Object) style, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void updateStyle(@CrossType.CrossType1 int i) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.updateStyle(i);
        }
    }

    public void setRasterImageArrowColor(boolean z, int i) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setRasterImageArrowColor(z, i);
        }
    }

    public boolean setRasterImageData(LayerTexture layerTexture, LayerTexture layerTexture2) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.setRasterImageData(layerTexture, layerTexture2);
        }
        return false;
    }

    public boolean updateCross(byte[] bArr, @CrossType.CrossType1 int i) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.updateCross(bArr, i);
        }
        return false;
    }

    public void setRoadCrossRect(@CrossType.CrossType1 int i, RectInt rectInt) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setRoadCrossRect(i, rectInt);
        }
    }

    public void hideCross(@CrossType.CrossType1 int i) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.hideCross(i);
        }
    }

    public void set3DCrossCarMode(boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.set3DCrossCarMode(z);
        }
    }

    public void setRctHeadAngleSync(boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setRctHeadAngleSync(z);
        }
    }

    public boolean setFlyTmc(byte[] bArr, ArrayList<RealCityTmcParam> arrayList) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.setFlyTmc(bArr, arrayList);
        }
        return false;
    }

    public void updateNaviInfo(NaviInfo naviInfo) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.updateNaviInfo(naviInfo);
        }
    }

    public void setCrossImageInfo(CrossImageInfo crossImageInfo) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setCrossImageInfo(crossImageInfo);
        }
    }

    public void setVisible(boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setVisible(z);
        }
    }

    public boolean getVisible() {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.getVisible();
        }
        return false;
    }

    public void setVisible(@CrossType.CrossType1 int i, boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setVisible(i, z);
        }
    }

    public boolean getVisible(@BizRoadCrossType.BizRoadCrossType1 int i) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.getVisible(i);
        }
        return false;
    }

    public void saveVisible() {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.saveVisible();
        }
    }

    public void restoreVisible() {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.restoreVisible();
        }
    }

    public void setViewPostureEvent(@CrossType.CrossType1 int i, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i2) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setViewPostureEvent(i, i2);
        }
    }

    public boolean setRct3DFilter(RealCity3DFilter realCity3DFilter) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            return iBizRoadCrossControlImpl.setRct3DFilter(realCity3DFilter);
        }
        return false;
    }

    public void showRtcSkeleton(boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.showRtcSkeleton(z);
        }
    }

    public void showRtcArrow3D(boolean z) {
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.showRtcArrow3D(z);
        }
    }

    public void setRtcBinaryData(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IBizRoadCrossControlImpl iBizRoadCrossControlImpl = this.mControl;
        if (iBizRoadCrossControlImpl != null) {
            iBizRoadCrossControlImpl.setRtcBinaryData(bArr);
        }
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
