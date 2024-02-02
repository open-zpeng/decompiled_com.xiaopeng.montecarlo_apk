package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.autonavi.gbl.common.path.model.LightBarItem;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.BLDataModelUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class XPLightBarInfo implements ILightBarInfo {
    private static final L.Tag TAG = new L.Tag("XPLightBarInfo");
    private LightBarInfo mLightBarInfo;

    public XPLightBarInfo(LightBarInfo lightBarInfo) {
        this.mLightBarInfo = lightBarInfo;
    }

    public XPLightBarInfo(List<XPLightBarItem> list, long j) {
        this.mLightBarInfo = BLDataModelUtil.toBLLightBarInfo(list, j);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public long getPathId() {
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo != null) {
            return lightBarInfo.pathID;
        }
        return -1L;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public int getLightBarItemSize() {
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo == null || lightBarInfo.itemList == null) {
            return 0;
        }
        return this.mLightBarInfo.itemList.size();
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public int getStatusFlag(int i) {
        LightBarItem lightBarItem;
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo == null || lightBarInfo.itemList == null || i >= this.mLightBarInfo.itemList.size() || i < 0 || (lightBarItem = this.mLightBarInfo.itemList.get(i)) == null) {
            return 0;
        }
        return lightBarItem.statusFlag;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public int getLightBarItemLength(int i) {
        LightBarItem lightBarItem;
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo == null || lightBarInfo.itemList == null || i >= this.mLightBarInfo.itemList.size() || i < 0 || (lightBarItem = this.mLightBarInfo.itemList.get(i)) == null) {
            return 0;
        }
        return lightBarItem.length;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public int getLightBarItemStatus(int i) {
        LightBarItem lightBarItem;
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo == null || lightBarInfo.itemList == null || i >= this.mLightBarInfo.itemList.size() || i < 0 || (lightBarItem = this.mLightBarInfo.itemList.get(i)) == null) {
            return 0;
        }
        return lightBarItem.status;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo
    public int getLightBarItemFineStatus(int i) {
        LightBarItem lightBarItem;
        LightBarInfo lightBarInfo = this.mLightBarInfo;
        if (lightBarInfo == null || lightBarInfo.itemList == null || i >= this.mLightBarInfo.itemList.size() || i < 0 || (lightBarItem = this.mLightBarInfo.itemList.get(i)) == null) {
            return 0;
        }
        return lightBarItem.fineStatus;
    }

    public LightBarInfo getLightBarInfo() {
        return this.mLightBarInfo;
    }
}
