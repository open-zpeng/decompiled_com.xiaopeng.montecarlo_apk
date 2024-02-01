package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMMsgFilter implements Serializable {
    private static final long serialVersionUID = -1762784347741292453L;
    public ArrayList<AIMMsgContentFilter> content;
    public boolean filterRecall;
    public boolean orderInAsc;

    public AIMMsgFilter(ArrayList<AIMMsgContentFilter> arrayList, boolean z, boolean z2) {
        this.filterRecall = false;
        this.orderInAsc = false;
        this.content = arrayList;
        this.filterRecall = z;
        this.orderInAsc = z2;
    }

    public AIMMsgFilter() {
        this.filterRecall = false;
        this.orderInAsc = false;
    }

    public ArrayList<AIMMsgContentFilter> getContent() {
        return this.content;
    }

    public boolean getFilterRecall() {
        return this.filterRecall;
    }

    public boolean getOrderInAsc() {
        return this.orderInAsc;
    }

    public String toString() {
        return "AIMMsgFilter{content=" + this.content + ",filterRecall=" + this.filterRecall + ",orderInAsc=" + this.orderInAsc + "}";
    }
}
