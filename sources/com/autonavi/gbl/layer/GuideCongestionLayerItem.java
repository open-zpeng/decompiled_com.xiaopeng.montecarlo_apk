package com.autonavi.gbl.layer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.guide.model.NaviCongestionDetailInfo;
import com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem;
import com.autonavi.gbl.layer.router.GuideCongestionLayerItemRouter;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(target = GuideCongestionLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes.dex */
public class GuideCongestionLayerItem extends QuadrantLayerItem implements IGuideCongestionLayerItem {
    private static String PACKAGE = ReflexTool.PN(GuideCongestionLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private GuideCongestionLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideCongestionLayerItem(long j, boolean z) {
        this(new GuideCongestionLayerItemRouter("GuideCongestionLayerItem", (IGuideCongestionLayerItem) null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideCongestionLayerItem.class}, new Object[]{this});
    }

    public GuideCongestionLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(new GuideCongestionLayerItemRouter("GuideCongestionLayerItem", (IGuideCongestionLayerItem) null, i, j));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{IGuideCongestionLayerItem.class}, new Object[]{this});
    }

    public GuideCongestionLayerItem(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        super(guideCongestionLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(guideCongestionLayerItemImpl);
    }

    private void $constructor(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        if (guideCongestionLayerItemImpl != null) {
            this.mService = guideCongestionLayerItemImpl;
            this.mTargetId = String.format("GuideCongestionLayerItem_%s_%d", String.valueOf(GuideCongestionLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.QuadrantLayerItem, com.autonavi.gbl.map.layer.PointLayerItem, com.autonavi.gbl.map.layer.LayerItem
    public GuideCongestionLayerItemImpl getService() {
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
        return GuideCongestionLayerItemImpl.getClassTypeName();
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMDirectionStyle(i);
        }
    }

    public void setMCongestionStatus(@TrafficStatus.TrafficStatus1 int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMCongestionStatus(i);
        }
    }

    public void setMTimeInfo(String str) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMTimeInfo(str);
        }
    }

    public void setMCongestExtend(CongestExtend congestExtend) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMCongestExtend(congestExtend);
        }
    }

    public void setMLayerTag(int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMLayerTag(i);
        }
    }

    public void setMRemainDist(long j) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMRemainDist(j);
        }
    }

    public void setMTotalTimeOfSeconds(long j) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMTotalTimeOfSeconds(j);
        }
    }

    public void setMTotalRemainDist(long j) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMTotalRemainDist(j);
        }
    }

    public void setMCongestionDetailInfo(NaviCongestionDetailInfo naviCongestionDetailInfo) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMCongestionDetailInfo(naviCongestionDetailInfo);
        }
    }

    public void setShowChatRoomStyle(boolean z) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setShowChatRoomStyle(z);
        }
    }

    public void setMSegId(int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMSegId(i);
        }
    }

    public void setMLinkId(int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMLinkId(i);
        }
    }

    public void setMPointId(int i) {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            guideCongestionLayerItemImpl.$explicit_setMPointId(i);
        }
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMDirectionStyle();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    @TrafficStatus.TrafficStatus1
    public int getMCongestionStatus() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMCongestionStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public String getMTimeInfo() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMTimeInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public CongestExtend getMCongestExtend() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMCongestExtend();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public int getMLayerTag() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMLayerTag();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public long getMRemainDist() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public long getMTotalTimeOfSeconds() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMTotalTimeOfSeconds();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public long getMTotalRemainDist() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMTotalRemainDist();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public NaviCongestionDetailInfo getMCongestionDetailInfo() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMCongestionDetailInfo();
        }
        return null;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public boolean getShowChatRoomStyle() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getShowChatRoomStyle();
        }
        return false;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public int getMSegId() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMSegId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public int getMLinkId() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMLinkId();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.layer.observer.IGuideCongestionLayerItem
    public int getMPointId() {
        GuideCongestionLayerItemImpl guideCongestionLayerItemImpl = this.mService;
        if (guideCongestionLayerItemImpl != null) {
            return guideCongestionLayerItemImpl.$explicit_getMPointId();
        }
        return 0;
    }
}
