package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.router.GuideTrafficEventLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideTrafficEventLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideTrafficEventLayerItem extends QuadrantLayerItem implements IGuideTrafficEventLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideTrafficEventLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideTrafficEventLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideTrafficEventLayerItem(long j, boolean z) {
        this(new GuideTrafficEventLayerItemRouter("GuideTrafficEventLayerItem", (IGuideTrafficEventLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficEventLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficEventLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new GuideTrafficEventLayerItemRouter("GuideTrafficEventLayerItem", (IGuideTrafficEventLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideTrafficEventLayerItem.class}, new Object[]{this});
    }

    public GuideTrafficEventLayerItem(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        super(guideTrafficEventLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideTrafficEventLayerItemImpl);
    }

    private void $constructor(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        if (guideTrafficEventLayerItemImpl != null) {
            this.mService = guideTrafficEventLayerItemImpl;
            this.mTargetId = String.format("GuideTrafficEventLayerItem_%s_%d", String.valueOf(GuideTrafficEventLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideTrafficEventLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return GuideTrafficEventLayerItemImpl.getClassTypeName();
    }

    public void setMIndex(int i) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMIndex(i);
        }
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMIsPreview(boolean z) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMIsPreview(z);
        }
    }

    public void setMLayerTag(int i) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMLayerTag(i);
        }
    }

    public void setMLane(String str) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMLane(str);
        }
    }

    public void setMLayer(int i) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMLayer(i);
        }
    }

    public void setPathId(long j) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setPathId(j);
        }
    }

    public void setMId(int i) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMId(i);
        }
    }

    public void setMLabelDesc(String str) {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            guideTrafficEventLayerItemImpl.$explicit_setMLabelDesc(str);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public int getMIndex() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMIndex();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public boolean getMIsPreview() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMIsPreview();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public int getMLayerTag() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public String getMLane() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMLane();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public int getMLayer() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMLayer();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public long getPathId() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getPathId();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public int getMId() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideTrafficEventLayerItem
    public String getMLabelDesc() {
        GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl = this.mService;
        if (guideTrafficEventLayerItemImpl != null) {
            return guideTrafficEventLayerItemImpl.$explicit_getMLabelDesc();
        }
        return null;
    }
}
