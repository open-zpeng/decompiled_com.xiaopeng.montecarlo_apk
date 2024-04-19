package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.guide.model.TMCIncidentType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TMCIncidentReport implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    @TMCIncidentType.TMCIncidentType1
    public int type;

    public TMCIncidentReport() {
        this.type = 1;
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
    }

    public TMCIncidentReport(@TMCIncidentType.TMCIncidentType1 int i, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble) {
        this.type = i;
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
    }
}
