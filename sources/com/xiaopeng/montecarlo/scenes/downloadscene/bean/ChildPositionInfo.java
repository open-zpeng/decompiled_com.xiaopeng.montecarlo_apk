package com.xiaopeng.montecarlo.scenes.downloadscene.bean;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class ChildPositionInfo {
    private int mAdcode;
    private int mChildPosition;
    private int mGroupPosition;

    public int getGroupPosition() {
        return this.mGroupPosition;
    }

    public int getChildPosition() {
        return this.mChildPosition;
    }

    public int getAdcode() {
        return this.mAdcode;
    }

    public ChildPositionInfo(int i, int i2, int i3) {
        this.mGroupPosition = i;
        this.mChildPosition = i2;
        this.mAdcode = i3;
    }

    @NonNull
    public String toString() {
        return this.mAdcode + ": (" + this.mGroupPosition + "," + this.mChildPosition + ")";
    }
}
