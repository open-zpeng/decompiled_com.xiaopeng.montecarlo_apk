package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsAudiHcp3EventSearchRequestParam extends BLRequestBase implements Serializable {
    public String adiu = "";
    public String navi_id = "";
    public String path_id = "";
    public EventRect event_rect = new EventRect();
    public ArrayList<Integer> white_list = new ArrayList<>();
    public ArrayList<Integer> black_list = new ArrayList<>();
    public ArrayList<String> poi_ids1 = new ArrayList<>();
}
