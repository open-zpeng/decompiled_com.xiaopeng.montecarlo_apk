package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.model.PointLightType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MsgDataSetPointLight implements Serializable {
    public ArrayList<PointLightParam> lightParam;
    public String pointLightItemName;
    public boolean positionOnly;
    @PointLightType.PointLightType1
    public int type;
    public Coord3DDouble vLightPos;
    public Coord3DDouble vLightPosSimple3D;

    public MsgDataSetPointLight() {
        this.type = 0;
        this.positionOnly = false;
        this.vLightPos = new Coord3DDouble();
        this.vLightPosSimple3D = new Coord3DDouble();
        this.lightParam = new ArrayList<>();
        this.pointLightItemName = "";
    }

    public MsgDataSetPointLight(@PointLightType.PointLightType1 int i, boolean z, Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, ArrayList<PointLightParam> arrayList, String str) {
        this.type = i;
        this.positionOnly = z;
        this.vLightPos = coord3DDouble;
        this.vLightPosSimple3D = coord3DDouble2;
        this.lightParam = arrayList;
        this.pointLightItemName = str;
    }
}
