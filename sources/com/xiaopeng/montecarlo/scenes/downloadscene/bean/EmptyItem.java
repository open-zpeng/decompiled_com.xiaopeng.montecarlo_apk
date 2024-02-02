package com.xiaopeng.montecarlo.scenes.downloadscene.bean;
/* loaded from: classes2.dex */
public class EmptyItem extends BaseItem {
    private int mGroupPosition;

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getChildPosition() {
        return -1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isGrayColor() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public boolean isParent() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem
    public int getGroupPosition() {
        return this.mGroupPosition;
    }

    public void setGroupPosition(int i) {
        this.mGroupPosition = i;
    }
}
