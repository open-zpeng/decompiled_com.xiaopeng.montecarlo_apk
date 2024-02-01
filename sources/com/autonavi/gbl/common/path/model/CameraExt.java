package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CameraExt implements Serializable {
    public BigInteger cameraId;
    public int distToEnd;
    public long entityId;
    public CameraExtFeaturesFlag features;
    public Coord2DDouble pos;
    public ArrayList<SubCameraExt> subCameras;

    public CameraExt() {
        this.cameraId = new BigInteger("0");
        this.distToEnd = 0;
        this.entityId = 0L;
        this.pos = new Coord2DDouble();
        this.features = new CameraExtFeaturesFlag();
        this.subCameras = new ArrayList<>();
    }

    public CameraExt(BigInteger bigInteger, int i, long j, Coord2DDouble coord2DDouble, CameraExtFeaturesFlag cameraExtFeaturesFlag, ArrayList<SubCameraExt> arrayList) {
        this.cameraId = bigInteger;
        this.distToEnd = i;
        this.entityId = j;
        this.pos = coord2DDouble;
        this.features = cameraExtFeaturesFlag;
        this.subCameras = arrayList;
    }
}
