package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.card.model.CardFontInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InnerStyleParam implements Serializable {
    public ArrayList<String> cardCmbPaths;
    public ArrayList<CardFontInfo> cardFonts;
    public boolean cardUpdateMode;
    public boolean debugMode;
    public String layerAssetPath;

    public InnerStyleParam() {
        this.debugMode = false;
        this.cardUpdateMode = true;
        this.layerAssetPath = "";
        this.cardCmbPaths = new ArrayList<>();
        this.cardFonts = new ArrayList<>();
    }

    public InnerStyleParam(boolean z, boolean z2, String str, ArrayList<String> arrayList, ArrayList<CardFontInfo> arrayList2) {
        this.debugMode = z;
        this.cardUpdateMode = z2;
        this.layerAssetPath = str;
        this.cardCmbPaths = arrayList;
        this.cardFonts = arrayList2;
    }
}
