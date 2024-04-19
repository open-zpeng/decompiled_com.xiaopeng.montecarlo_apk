package com.xiaopeng.montecarlo.navcore.bean.sync;
/* loaded from: classes2.dex */
public class AccountDeleteUserDataRequest {
    int mLocalVer;
    int mScrapDelFavVer;
    int mScrapHistoryVer;

    public void setScrapHistoryVer(int i) {
        this.mScrapHistoryVer = i;
    }

    public int getScrapHistoryVer() {
        return this.mScrapHistoryVer;
    }

    public void setScrapDelFavVer(int i) {
        this.mScrapDelFavVer = i;
    }

    public int getScrapDelFavVer() {
        return this.mScrapDelFavVer;
    }

    public void setLocalVer(int i) {
        this.mLocalVer = i;
    }

    public int getLocalVer() {
        return this.mLocalVer;
    }

    public boolean isValid() {
        return (this.mScrapHistoryVer > 0 || this.mScrapDelFavVer > 0) && this.mLocalVer > 0;
    }

    public boolean isDelAll() {
        int i;
        int i2 = this.mScrapDelFavVer;
        return i2 > 0 && (i = this.mScrapHistoryVer) > 0 && i == i2;
    }

    public int getDelVer() {
        return this.mScrapDelFavVer;
    }

    public boolean isDelFav() {
        return this.mScrapDelFavVer > 0;
    }

    public boolean isDelHis() {
        return this.mScrapHistoryVer > 0;
    }

    public String toString() {
        return "AccountDeleteUserDataRequest{mScrapHistoryVer=" + this.mScrapHistoryVer + ", mScrapDelFavVer=" + this.mScrapDelFavVer + ", mLocalVer=" + this.mLocalVer + '}';
    }
}
