package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class KeywordSearchSwitchParam implements Serializable {
    public boolean addrPoiMerge;
    public boolean citySuggestion;
    public boolean directJump;
    public boolean locStrict;
    public boolean needCodePoint;
    public boolean needMagicBox;
    public boolean needParkInfo;
    public boolean needUtd;
    public boolean qii;
    public boolean queryAcs;

    public KeywordSearchSwitchParam() {
        this.locStrict = false;
        this.citySuggestion = true;
        this.directJump = false;
        this.needMagicBox = false;
        this.needParkInfo = true;
        this.needCodePoint = true;
        this.needUtd = true;
        this.qii = true;
        this.queryAcs = false;
        this.addrPoiMerge = true;
    }

    public KeywordSearchSwitchParam(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.locStrict = z;
        this.citySuggestion = z2;
        this.directJump = z3;
        this.needMagicBox = z4;
        this.needParkInfo = z5;
        this.needCodePoint = z6;
        this.needUtd = z7;
        this.qii = z8;
        this.queryAcs = z9;
        this.addrPoiMerge = z10;
    }
}
