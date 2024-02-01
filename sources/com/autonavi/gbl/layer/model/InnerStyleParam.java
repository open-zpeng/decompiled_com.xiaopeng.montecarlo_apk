package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.card.model.CardFontInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class InnerStyleParam implements Serializable {
    public ArrayList<String> cardCmbPaths;
    public ArrayList<CardFontInfo> cardFonts;
    public boolean cardUpdateMode;
    public boolean debugMode;
    public String layerAssetPath;
    public HashMap<Integer, String> mapStyleFilePath;
    public String priorityLayerAssetPath;

    public InnerStyleParam() {
        this.debugMode = false;
        this.cardUpdateMode = true;
        this.layerAssetPath = "";
        this.priorityLayerAssetPath = "";
        this.cardCmbPaths = new ArrayList<>();
        this.cardFonts = new ArrayList<>();
        this.mapStyleFilePath = new HashMap<>();
    }

    public InnerStyleParam(boolean z, boolean z2, String str, String str2, ArrayList<String> arrayList, ArrayList<CardFontInfo> arrayList2, HashMap<Integer, String> hashMap) {
        this.debugMode = z;
        this.cardUpdateMode = z2;
        this.layerAssetPath = str;
        this.priorityLayerAssetPath = str2;
        this.cardCmbPaths = arrayList;
        this.cardFonts = arrayList2;
        this.mapStyleFilePath = hashMap;
    }
}
