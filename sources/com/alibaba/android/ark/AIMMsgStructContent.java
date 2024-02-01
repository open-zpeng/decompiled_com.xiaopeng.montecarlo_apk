package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMMsgStructContent implements Serializable {
    private static final long serialVersionUID = -1843939469045446360L;
    public ArrayList<AIMMsgStructElement> elements;

    public AIMMsgStructContent(ArrayList<AIMMsgStructElement> arrayList) {
        this.elements = arrayList;
    }

    public AIMMsgStructContent() {
    }

    public ArrayList<AIMMsgStructElement> getElements() {
        return this.elements;
    }

    public String toString() {
        return "AIMMsgStructContent{elements=" + this.elements + "}";
    }
}
