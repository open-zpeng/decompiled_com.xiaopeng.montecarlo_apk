package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsOssMaplayerListResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<LayerListItem> layer_list = new ArrayList<>();
    public String md5 = "";
    public ArrayList<SkinListItem> skin_list = new ArrayList<>();
    public String skin_md5 = "";
}
