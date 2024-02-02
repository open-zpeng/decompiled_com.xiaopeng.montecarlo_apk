package com.autonavi.gbl.map.model;

import com.autonavi.gbl.util.model.LanguageType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MapFontLoaderParam implements Serializable {
    public boolean customFont;
    @LanguageType.LanguageType1
    public int language;

    public MapFontLoaderParam() {
        this.language = 0;
        this.customFont = false;
    }

    public MapFontLoaderParam(@LanguageType.LanguageType1 int i, boolean z) {
        this.language = i;
        this.customFont = z;
    }
}
