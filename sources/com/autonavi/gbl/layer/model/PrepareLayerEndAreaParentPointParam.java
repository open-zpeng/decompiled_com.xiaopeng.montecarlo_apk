package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PrepareLayerEndAreaParentPointParam extends PrepareLayerMarkerParam implements Serializable {
    public boolean isPlanScene = false;
    public boolean onlyShowName = false;
    public boolean showETA = true;
    public boolean showEnergy = true;
    public boolean showOdd = true;
    public boolean isTime12Format = false;
    public boolean isETASimpleFormat = false;
    public int energyLeftPercent = -1;
    public int weatherId = 0;
}
