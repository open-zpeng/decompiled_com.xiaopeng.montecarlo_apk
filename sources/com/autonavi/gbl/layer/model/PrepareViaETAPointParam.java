package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PrepareViaETAPointParam extends PrepareLayerMarkerParam implements Serializable {
    public boolean showETA = true;
    public boolean isTime12Format = false;
    public boolean isETASimpleFormat = false;
    public int energyLeftPercent = -1;
}
