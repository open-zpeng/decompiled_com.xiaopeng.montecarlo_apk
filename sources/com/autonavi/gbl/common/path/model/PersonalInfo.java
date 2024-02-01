package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PersonalInfo implements Serializable {
    public FavoriteSourceInfo m_favoriteSourceInfo;

    public PersonalInfo() {
        this.m_favoriteSourceInfo = new FavoriteSourceInfo();
    }

    public PersonalInfo(FavoriteSourceInfo favoriteSourceInfo) {
        this.m_favoriteSourceInfo = favoriteSourceInfo;
    }
}
