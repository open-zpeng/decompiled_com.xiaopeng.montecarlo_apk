package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsVaCarLogoResponseData implements Serializable {
    public ArrayList<RecommendLogoListItem> recommend_logo_list;
    public ArrayList<RecommendLogoListItem> user_logo_list;

    public WsVaCarLogoResponseData() {
        this.recommend_logo_list = new ArrayList<>();
        this.user_logo_list = new ArrayList<>();
    }

    public WsVaCarLogoResponseData(ArrayList<RecommendLogoListItem> arrayList, ArrayList<RecommendLogoListItem> arrayList2) {
        this.recommend_logo_list = arrayList;
        this.user_logo_list = arrayList2;
    }
}
