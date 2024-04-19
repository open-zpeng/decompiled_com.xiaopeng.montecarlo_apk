package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FavoriteSourceInfo implements Serializable {
    public boolean m_bFavorite;
    public int m_gateIndex;
    public LinkRange m_innerRoadRange;

    public FavoriteSourceInfo() {
        this.m_bFavorite = false;
        this.m_gateIndex = -1;
        this.m_innerRoadRange = new LinkRange();
    }

    public FavoriteSourceInfo(boolean z, int i, LinkRange linkRange) {
        this.m_bFavorite = z;
        this.m_gateIndex = i;
        this.m_innerRoadRange = linkRange;
    }
}
