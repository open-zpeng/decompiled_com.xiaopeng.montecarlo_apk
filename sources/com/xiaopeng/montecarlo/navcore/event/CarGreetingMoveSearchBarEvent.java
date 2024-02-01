package com.xiaopeng.montecarlo.navcore.event;
/* loaded from: classes3.dex */
public class CarGreetingMoveSearchBarEvent {
    private boolean mIsDownMove;

    public boolean isDownMove() {
        return this.mIsDownMove;
    }

    public void setDownMove(boolean z) {
        this.mIsDownMove = z;
    }

    public CarGreetingMoveSearchBarEvent(boolean z) {
        this.mIsDownMove = z;
    }
}
