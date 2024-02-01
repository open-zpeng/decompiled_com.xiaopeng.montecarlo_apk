package com.xiaopeng.montecarlo.navcore.event;
/* loaded from: classes3.dex */
public class FavoriteSyncEvent {
    private int mUserType = 0;
    private boolean mShowDialog = false;

    public int getUserType() {
        return this.mUserType;
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    public boolean isShowDialog() {
        return this.mShowDialog;
    }

    public void setShowDialog(boolean z) {
        this.mShowDialog = z;
    }
}
