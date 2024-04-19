package com.xiaopeng.montecarlo.navcore.mapdisplay;

import androidx.annotation.NonNull;
import com.autonavi.gbl.map.layer.model.PolylineCapTextureInfo;
import com.autonavi.gbl.map.layer.model.PolylineTextureInfo;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class NaviRouteOverlayParam {
    private static final L.Tag TAG = new L.Tag("NaviRouteOverlayParam");
    private static final int TEXTURE_AMBLE_SELECT_BORDER_COLOR = -6788864;
    private static final int TEXTURE_AMBLE_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_AMBLE_SELECT_FILL_COLOR = -2581248;
    private static final int TEXTURE_AMBLE_SELECT_FILL_COLOR_NIGHT = -2712576;
    private static final int TEXTURE_AMBLE_UNSELECT_BORDER_COLOR = -1916036;
    private static final int TEXTURE_AMBLE_UNSELECT_BORDER_COLOR_NIGHT = -8755408;
    private static final int TEXTURE_AMBLE_UNSELECT_FILL_COLOR = -596552;
    private static final int TEXTURE_AMBLE_UNSELECT_FILL_COLOR_NIGHT = -10202073;
    private static final int TEXTURE_CONGESTED_SELECT_BORDER_COLOR = -11534336;
    private static final int TEXTURE_CONGESTED_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_CONGESTED_SELECT_FILL_COLOR = -7864317;
    private static final int TEXTURE_CONGESTED_SELECT_FILL_COLOR_NIGHT = -10420222;
    private static final int TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR = -4689037;
    private static final int TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR_NIGHT = -9491411;
    private static final int TEXTURE_CONGESTED_UNSELECT_FILL_COLOR = -3172973;
    private static final int TEXTURE_CONGESTED_UNSELECT_FILL_COLOR_NIGHT = -12054251;
    private static final int TEXTURE_DEFAULT_SELECT_BORDER_COLOR = -16753226;
    private static final int TEXTURE_DEFAULT_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_DEFAULT_SELECT_FILL_COLOR = -16751910;
    private static final int TEXTURE_DEFAULT_SELECT_FILL_COLOR_NIGHT = -16752684;
    private static final int TEXTURE_DEFAULT_UNSELECT_BORDER_COLOR = -9460272;
    private static final int TEXTURE_DEFAULT_UNSELECT_BORDER_COLOR_NIGHT = -14658934;
    private static final int TEXTURE_DEFAULT_UNSELECT_FILL_COLOR = -6697473;
    private static final int TEXTURE_DEFAULT_UNSELECT_FILL_COLOR_NIGHT = -15450524;
    private static final int TEXTURE_JAM_SELECT_BORDER_COLOR = -7274496;
    private static final int TEXTURE_JAM_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_JAM_SELECT_FILL_COLOR = -2349530;
    private static final int TEXTURE_JAM_SELECT_FILL_COLOR_NIGHT = -4128768;
    private static final int TEXTURE_JAM_UNSELECT_BORDER_COLOR = -3308922;
    private static final int TEXTURE_JAM_UNSELECT_BORDER_COLOR_NIGHT = -8046274;
    private static final int TEXTURE_JAM_UNSELECT_FILL_COLOR = -21859;
    private static final int TEXTURE_JAM_UNSELECT_FILL_COLOR_NIGHT = -10343635;
    private static final int TEXTURE_OPEN_SELECT_BORDER_COLOR = -16747008;
    private static final int TEXTURE_OPEN_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_OPEN_SELECT_FILL_COLOR = -16729569;
    private static final int TEXTURE_OPEN_SELECT_FILL_COLOR_NIGHT = -16737766;
    private static final int TEXTURE_OPEN_UNSELECT_BORDER_COLOR = -8474485;
    private static final int TEXTURE_OPEN_UNSELECT_BORDER_COLOR_NIGHT = -11695282;
    private static final int TEXTURE_OPEN_UNSELECT_FILL_COLOR = -6630486;
    private static final int TEXTURE_OPEN_UNSELECT_FILL_COLOR_NIGHT = -12882621;
    private static final int TEXTURE_RAPIDER_SELECT_BORDER_COLOR = -16751285;
    private static final int TEXTURE_RAPIDER_SELECT_BORDER_COLOR_NIGHT = -1;
    private static final int TEXTURE_RAPIDER_SELECT_FILL_COLOR = -16745123;
    private static final int TEXTURE_RAPIDER_SELECT_FILL_COLOR_NIGHT = -16749294;
    private static final int TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR = -10645373;
    private static final int TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR_NIGHT = -12357030;
    private static final int TEXTURE_RAPIDER_UNSELECT_FILL_COLOR = -9983591;
    private static final int TEXTURE_RAPIDER_UNSELECT_FILL_COLOR_NIGHT = -14398916;
    private static final int WIDTH_DEFAULT = 38;
    private static final int WIDTH_HAWK_EYE = 20;
    public boolean mNightMode;

    private int getRealTextureType(int i) {
        if (i >= 32) {
            return i - 24;
        }
        if (16 == i) {
            return 3;
        }
        return i;
    }

    public boolean getLineNeedShowArrow(int i, boolean z) {
        if (i == 2 || i == 3) {
            return z;
        }
        if (i != 4) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0071 A[SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.autonavi.gbl.map.layer.model.RouteLayerParam> getProperties(@androidx.annotation.NonNull com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r17, int r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.mapdisplay.NaviRouteOverlayParam.getProperties(com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper, int, boolean, boolean):java.util.List");
    }

    @NonNull
    public PolylineTextureInfo getRouteTextureInfo(int i) {
        float f;
        float f2 = 16.0f;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        switch (i) {
            case 1:
                f5 = 0.05f;
                f = 0.95f;
                f4 = f3;
                PolylineTextureInfo polylineTextureInfo = new PolylineTextureInfo();
                polylineTextureInfo.x1 = f5;
                polylineTextureInfo.y1 = f4;
                polylineTextureInfo.x2 = f;
                polylineTextureInfo.y2 = f3;
                polylineTextureInfo.textureLen = f2;
                return polylineTextureInfo;
            case 2:
                f = 1.0f;
                f4 = f3;
                PolylineTextureInfo polylineTextureInfo2 = new PolylineTextureInfo();
                polylineTextureInfo2.x1 = f5;
                polylineTextureInfo2.y1 = f4;
                polylineTextureInfo2.x2 = f;
                polylineTextureInfo2.y2 = f3;
                polylineTextureInfo2.textureLen = f2;
                return polylineTextureInfo2;
            case 3:
                f2 = 48.0f;
                f = 1.0f;
                f3 = 0.0f;
                PolylineTextureInfo polylineTextureInfo22 = new PolylineTextureInfo();
                polylineTextureInfo22.x1 = f5;
                polylineTextureInfo22.y1 = f4;
                polylineTextureInfo22.x2 = f;
                polylineTextureInfo22.y2 = f3;
                polylineTextureInfo22.textureLen = f2;
                return polylineTextureInfo22;
            case 4:
                f2 = 30.0f;
                f = 1.0f;
                f3 = 0.0f;
                PolylineTextureInfo polylineTextureInfo222 = new PolylineTextureInfo();
                polylineTextureInfo222.x1 = f5;
                polylineTextureInfo222.y1 = f4;
                polylineTextureInfo222.x2 = f;
                polylineTextureInfo222.y2 = f3;
                polylineTextureInfo222.textureLen = f2;
                return polylineTextureInfo222;
            case 5:
            case 7:
                f = 1.0f;
                f3 = 0.0f;
                PolylineTextureInfo polylineTextureInfo2222 = new PolylineTextureInfo();
                polylineTextureInfo2222.x1 = f5;
                polylineTextureInfo2222.y1 = f4;
                polylineTextureInfo2222.x2 = f;
                polylineTextureInfo2222.y2 = f3;
                polylineTextureInfo2222.textureLen = f2;
                return polylineTextureInfo2222;
            case 6:
                f2 = 32.0f;
                f = 0.5f;
                f3 = 0.0f;
                PolylineTextureInfo polylineTextureInfo22222 = new PolylineTextureInfo();
                polylineTextureInfo22222.x1 = f5;
                polylineTextureInfo22222.y1 = f4;
                polylineTextureInfo22222.x2 = f;
                polylineTextureInfo22222.y2 = f3;
                polylineTextureInfo22222.textureLen = f2;
                return polylineTextureInfo22222;
            default:
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = f3;
                PolylineTextureInfo polylineTextureInfo222222 = new PolylineTextureInfo();
                polylineTextureInfo222222.x1 = f5;
                polylineTextureInfo222222.y1 = f4;
                polylineTextureInfo222222.x2 = f;
                polylineTextureInfo222222.y2 = f3;
                polylineTextureInfo222222.textureLen = f2;
                return polylineTextureInfo222222;
        }
    }

    @NonNull
    public PolylineTextureInfo getSimple3DTextureInfo(int i) {
        PolylineTextureInfo polylineTextureInfo = new PolylineTextureInfo();
        polylineTextureInfo.x1 = 0.0f;
        polylineTextureInfo.y1 = 0.0f;
        polylineTextureInfo.x2 = 0.0f;
        polylineTextureInfo.y2 = 0.0f;
        polylineTextureInfo.textureLen = 0.0f;
        return polylineTextureInfo;
    }

    @NonNull
    public PolylineCapTextureInfo getRouteCapTextureInfo(int i) {
        float f = 0.6f;
        float f2 = 0.25f;
        float f3 = 1.0f;
        float f4 = 0.5f;
        switch (i) {
            case 1:
                f3 = 0.95f;
                f = 0.75f;
                f2 = 0.5f;
                f4 = 0.05f;
                break;
            case 2:
                f = 0.75f;
                f2 = 0.5f;
                f4 = 0.0f;
                break;
            case 3:
            case 6:
            case 7:
                break;
            case 4:
            case 5:
            default:
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
                break;
        }
        PolylineCapTextureInfo polylineCapTextureInfo = new PolylineCapTextureInfo();
        polylineCapTextureInfo.x1 = f4;
        polylineCapTextureInfo.y1 = f2;
        polylineCapTextureInfo.x2 = f3;
        polylineCapTextureInfo.y2 = f;
        return polylineCapTextureInfo;
    }

    @NonNull
    public RoadParam getRoadParam(int i, boolean z, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if (L.ENABLE) {
            L.d(TAG, "getRoadParam : [ TextureType : " + i + ", mNightMode : " + this.mNightMode + ", isAlternative : " + z2 + ", isHighLight : " + z3 + "]");
        }
        int i13 = TEXTURE_AMBLE_UNSELECT_FILL_COLOR_NIGHT;
        int i14 = TEXTURE_AMBLE_UNSELECT_BORDER_COLOR;
        int i15 = TEXTURE_AMBLE_UNSELECT_FILL_COLOR;
        int i16 = TEXTURE_OPEN_UNSELECT_BORDER_COLOR_NIGHT;
        if (i == 16) {
            i2 = R.drawable.map_lr_road_white_front;
            i3 = R.drawable.map_lr_road_white_back;
            if (this.mNightMode) {
                if (z2 || !z3) {
                    i13 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR_NIGHT;
                    i4 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR_NIGHT;
                    i5 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR_NIGHT;
                    i14 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR_NIGHT;
                    i15 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR_NIGHT;
                    i16 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR_NIGHT;
                } else {
                    i13 = TEXTURE_RAPIDER_SELECT_FILL_COLOR_NIGHT;
                    i6 = TEXTURE_RAPIDER_SELECT_FILL_COLOR_NIGHT;
                    i7 = TEXTURE_RAPIDER_SELECT_FILL_COLOR_NIGHT;
                    i15 = i7;
                }
            } else if (z2 || !z3) {
                i13 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR;
                i4 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR;
                i5 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR;
                i14 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR;
                i15 = TEXTURE_RAPIDER_UNSELECT_FILL_COLOR;
                i16 = TEXTURE_RAPIDER_UNSELECT_BORDER_COLOR;
            } else {
                i13 = TEXTURE_RAPIDER_SELECT_FILL_COLOR;
                i4 = TEXTURE_RAPIDER_SELECT_BORDER_COLOR;
                i5 = TEXTURE_RAPIDER_SELECT_FILL_COLOR;
                i14 = TEXTURE_RAPIDER_SELECT_BORDER_COLOR;
                i15 = TEXTURE_RAPIDER_SELECT_FILL_COLOR;
                i16 = TEXTURE_RAPIDER_SELECT_BORDER_COLOR;
            }
            RoadParam roadParam = new RoadParam();
            int realTextureType = getRealTextureType(i);
            roadParam.mfillLineMarkId = 421 - realTextureType;
            roadParam.mborderLineMarkId = 437 - realTextureType;
            roadParam.fillLineResId = i2;
            roadParam.borderLineResId = i3;
            roadParam.fillLineColor = i13;
            roadParam.borderColor = i4;
            roadParam.selectFillColor = i5;
            roadParam.selectBorderColor = i14;
            roadParam.unSelectFillColor = i15;
            roadParam.unSelectBorderColor = i16;
            return roadParam;
        }
        if (i == 34) {
            if (this.mNightMode) {
                if (z2 || !z3) {
                    i8 = R.drawable.map_traffic_platenum_restrict_light;
                } else {
                    i8 = R.drawable.map_traffic_platenum_restrict_hl;
                }
            } else if (z2 || !z3) {
                i8 = R.drawable.map_traffic_platenum_restrict_light;
            } else {
                i8 = R.drawable.map_traffic_platenum_restrict_hl;
            }
            i2 = i8;
            i4 = -1;
            i5 = -1;
            i3 = -1;
        } else {
            if (i != 38) {
                switch (i) {
                    case 0:
                        i11 = R.drawable.map_lr_dott_car_light;
                        i12 = R.drawable.map_lr_dott_car_light;
                        i2 = i11;
                        i3 = i12;
                        i4 = -1;
                        i5 = -1;
                        i13 = -1;
                        i14 = i13;
                        i15 = i14;
                        i16 = i15;
                        break;
                    case 1:
                        i9 = R.drawable.map_lr_dott_car_light;
                        i10 = R.drawable.map_lr_dott_car_light;
                        break;
                    case 2:
                        i2 = R.drawable.map_lr_road_white_front;
                        i3 = R.drawable.map_lr_road_white_back;
                        if (!this.mNightMode) {
                            if (!z2 && z3) {
                                i13 = TEXTURE_DEFAULT_SELECT_FILL_COLOR;
                                i4 = TEXTURE_DEFAULT_SELECT_BORDER_COLOR;
                                i5 = TEXTURE_DEFAULT_SELECT_FILL_COLOR;
                                i14 = TEXTURE_DEFAULT_SELECT_BORDER_COLOR;
                                i15 = TEXTURE_DEFAULT_SELECT_FILL_COLOR;
                                i16 = TEXTURE_DEFAULT_SELECT_BORDER_COLOR;
                                break;
                            } else {
                                i4 = TEXTURE_DEFAULT_UNSELECT_BORDER_COLOR;
                                i14 = i4;
                                i16 = i14;
                                i5 = TEXTURE_DEFAULT_UNSELECT_FILL_COLOR;
                            }
                        } else if (!z2 && z3) {
                            i13 = TEXTURE_DEFAULT_SELECT_FILL_COLOR_NIGHT;
                            i6 = TEXTURE_DEFAULT_SELECT_FILL_COLOR_NIGHT;
                            i7 = TEXTURE_DEFAULT_SELECT_FILL_COLOR_NIGHT;
                            i15 = i7;
                            break;
                        } else {
                            i4 = TEXTURE_DEFAULT_UNSELECT_BORDER_COLOR_NIGHT;
                            i14 = i4;
                            i16 = i14;
                            i5 = TEXTURE_DEFAULT_UNSELECT_FILL_COLOR_NIGHT;
                        }
                        i13 = i5;
                        i15 = i13;
                        break;
                    case 3:
                        i2 = R.drawable.map_lr_road_white_front;
                        i3 = R.drawable.map_lr_road_white_back;
                        if (!this.mNightMode) {
                            if (!z2 && z3) {
                                i13 = TEXTURE_OPEN_SELECT_FILL_COLOR;
                                i4 = TEXTURE_OPEN_SELECT_BORDER_COLOR;
                                i5 = TEXTURE_OPEN_SELECT_FILL_COLOR;
                                i14 = TEXTURE_OPEN_SELECT_BORDER_COLOR;
                                i15 = TEXTURE_OPEN_SELECT_FILL_COLOR;
                                i16 = TEXTURE_OPEN_SELECT_BORDER_COLOR;
                                break;
                            } else {
                                i4 = TEXTURE_OPEN_UNSELECT_BORDER_COLOR;
                                i14 = i4;
                                i16 = i14;
                                i5 = TEXTURE_OPEN_UNSELECT_FILL_COLOR;
                            }
                        } else if (!z2 && z3) {
                            i13 = TEXTURE_OPEN_SELECT_FILL_COLOR_NIGHT;
                            i6 = TEXTURE_OPEN_SELECT_FILL_COLOR_NIGHT;
                            i7 = TEXTURE_OPEN_SELECT_FILL_COLOR_NIGHT;
                            i15 = i7;
                            break;
                        } else {
                            i4 = TEXTURE_OPEN_UNSELECT_BORDER_COLOR_NIGHT;
                            i14 = i4;
                            i5 = TEXTURE_OPEN_UNSELECT_FILL_COLOR_NIGHT;
                        }
                        i13 = i5;
                        i15 = i13;
                        break;
                    case 4:
                        i2 = R.drawable.map_lr_road_white_front;
                        int i17 = R.drawable.map_lr_road_white_back;
                        if (!this.mNightMode) {
                            if (!z2 && z3) {
                                i13 = TEXTURE_AMBLE_SELECT_FILL_COLOR;
                                i5 = TEXTURE_AMBLE_SELECT_FILL_COLOR;
                                i4 = TEXTURE_AMBLE_SELECT_BORDER_COLOR;
                                i3 = i17;
                                i16 = TEXTURE_AMBLE_SELECT_BORDER_COLOR;
                                i15 = TEXTURE_AMBLE_SELECT_FILL_COLOR;
                                i14 = TEXTURE_AMBLE_SELECT_BORDER_COLOR;
                                break;
                            } else {
                                i4 = TEXTURE_AMBLE_UNSELECT_BORDER_COLOR;
                                i5 = TEXTURE_AMBLE_UNSELECT_FILL_COLOR;
                                i13 = i5;
                                i3 = i17;
                                i16 = i4;
                                break;
                            }
                        } else if (!z2 && z3) {
                            i13 = TEXTURE_AMBLE_SELECT_FILL_COLOR_NIGHT;
                            i6 = TEXTURE_AMBLE_SELECT_FILL_COLOR_NIGHT;
                            i15 = TEXTURE_AMBLE_SELECT_FILL_COLOR_NIGHT;
                            i3 = i17;
                            break;
                        } else {
                            i4 = TEXTURE_AMBLE_UNSELECT_BORDER_COLOR_NIGHT;
                            i14 = i4;
                            i5 = TEXTURE_AMBLE_UNSELECT_FILL_COLOR_NIGHT;
                            i15 = i5;
                            i3 = i17;
                            i16 = i14;
                            break;
                        }
                    case 5:
                        i2 = R.drawable.map_lr_road_white_front;
                        i3 = R.drawable.map_lr_road_white_back;
                        if (!this.mNightMode) {
                            if (!z2 && z3) {
                                i13 = TEXTURE_JAM_SELECT_FILL_COLOR;
                                i4 = TEXTURE_JAM_SELECT_BORDER_COLOR;
                                i5 = TEXTURE_JAM_SELECT_FILL_COLOR;
                                i14 = TEXTURE_JAM_SELECT_BORDER_COLOR;
                                i15 = TEXTURE_JAM_SELECT_FILL_COLOR;
                                i16 = TEXTURE_JAM_SELECT_BORDER_COLOR;
                                break;
                            } else {
                                i13 = TEXTURE_JAM_UNSELECT_FILL_COLOR;
                                i4 = TEXTURE_JAM_UNSELECT_BORDER_COLOR;
                                i5 = TEXTURE_JAM_UNSELECT_FILL_COLOR;
                                i14 = TEXTURE_JAM_UNSELECT_BORDER_COLOR;
                                i15 = TEXTURE_JAM_UNSELECT_FILL_COLOR;
                                i16 = TEXTURE_JAM_UNSELECT_BORDER_COLOR;
                                break;
                            }
                        } else if (!z2 && z3) {
                            i13 = TEXTURE_JAM_SELECT_FILL_COLOR_NIGHT;
                            i6 = TEXTURE_JAM_SELECT_FILL_COLOR_NIGHT;
                            i7 = TEXTURE_JAM_SELECT_FILL_COLOR_NIGHT;
                            i15 = i7;
                            break;
                        } else {
                            i13 = TEXTURE_JAM_UNSELECT_FILL_COLOR_NIGHT;
                            i4 = TEXTURE_JAM_UNSELECT_BORDER_COLOR_NIGHT;
                            i5 = TEXTURE_JAM_UNSELECT_FILL_COLOR_NIGHT;
                            i14 = TEXTURE_JAM_UNSELECT_BORDER_COLOR_NIGHT;
                            i15 = TEXTURE_JAM_UNSELECT_FILL_COLOR_NIGHT;
                            i16 = TEXTURE_JAM_UNSELECT_BORDER_COLOR_NIGHT;
                            break;
                        }
                    case 6:
                        i2 = R.drawable.map_lr_road_white_front;
                        i3 = R.drawable.map_lr_road_white_back;
                        if (!this.mNightMode) {
                            if (!z2 && z3) {
                                i13 = TEXTURE_CONGESTED_SELECT_FILL_COLOR;
                                i4 = TEXTURE_CONGESTED_SELECT_BORDER_COLOR;
                                i5 = TEXTURE_CONGESTED_SELECT_FILL_COLOR;
                                i14 = TEXTURE_CONGESTED_SELECT_BORDER_COLOR;
                                i15 = TEXTURE_CONGESTED_SELECT_FILL_COLOR;
                                i16 = TEXTURE_CONGESTED_SELECT_BORDER_COLOR;
                                break;
                            } else {
                                i13 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR;
                                i4 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR;
                                i5 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR;
                                i14 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR;
                                i15 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR;
                                i16 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR;
                                break;
                            }
                        } else if (!z2 && z3) {
                            i13 = TEXTURE_CONGESTED_SELECT_FILL_COLOR_NIGHT;
                            i6 = TEXTURE_CONGESTED_SELECT_FILL_COLOR_NIGHT;
                            i7 = TEXTURE_CONGESTED_SELECT_FILL_COLOR_NIGHT;
                            i15 = i7;
                            break;
                        } else {
                            i13 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR_NIGHT;
                            i4 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR_NIGHT;
                            i5 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR_NIGHT;
                            i14 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR_NIGHT;
                            i15 = TEXTURE_CONGESTED_UNSELECT_FILL_COLOR_NIGHT;
                            i16 = TEXTURE_CONGESTED_UNSELECT_BORDER_COLOR_NIGHT;
                            break;
                        }
                    case 7:
                        i11 = R.drawable.map_aolr;
                        i12 = R.drawable.map_aolr;
                        i2 = i11;
                        i3 = i12;
                        i4 = -1;
                        i5 = -1;
                        i13 = -1;
                        i14 = i13;
                        i15 = i14;
                        i16 = i15;
                        break;
                    default:
                        i4 = -1;
                        i5 = -1;
                        i2 = -1;
                        i3 = -1;
                        break;
                }
                RoadParam roadParam2 = new RoadParam();
                int realTextureType2 = getRealTextureType(i);
                roadParam2.mfillLineMarkId = 421 - realTextureType2;
                roadParam2.mborderLineMarkId = 437 - realTextureType2;
                roadParam2.fillLineResId = i2;
                roadParam2.borderLineResId = i3;
                roadParam2.fillLineColor = i13;
                roadParam2.borderColor = i4;
                roadParam2.selectFillColor = i5;
                roadParam2.selectBorderColor = i14;
                roadParam2.unSelectFillColor = i15;
                roadParam2.unSelectBorderColor = i16;
                return roadParam2;
            }
            i9 = R.drawable.map_ferry;
            i10 = R.drawable.map_ferry;
            i3 = i10;
            i15 = -10053889;
            i16 = -10053889;
            i4 = -16738561;
            i5 = -16738561;
            i13 = -16738561;
            i14 = -16738561;
            i2 = i9;
            RoadParam roadParam22 = new RoadParam();
            int realTextureType22 = getRealTextureType(i);
            roadParam22.mfillLineMarkId = 421 - realTextureType22;
            roadParam22.mborderLineMarkId = 437 - realTextureType22;
            roadParam22.fillLineResId = i2;
            roadParam22.borderLineResId = i3;
            roadParam22.fillLineColor = i13;
            roadParam22.borderColor = i4;
            roadParam22.selectFillColor = i5;
            roadParam22.selectBorderColor = i14;
            roadParam22.unSelectFillColor = i15;
            roadParam22.unSelectBorderColor = i16;
            return roadParam22;
        }
        i13 = i3;
        i14 = i13;
        i15 = i14;
        i16 = i15;
        RoadParam roadParam222 = new RoadParam();
        int realTextureType222 = getRealTextureType(i);
        roadParam222.mfillLineMarkId = 421 - realTextureType222;
        roadParam222.mborderLineMarkId = 437 - realTextureType222;
        roadParam222.fillLineResId = i2;
        roadParam222.borderLineResId = i3;
        roadParam222.fillLineColor = i13;
        roadParam222.borderColor = i4;
        roadParam222.selectFillColor = i5;
        roadParam222.selectBorderColor = i14;
        roadParam222.unSelectFillColor = i15;
        roadParam222.unSelectBorderColor = i16;
        return roadParam222;
        i14 = -1;
        i16 = -1;
        i5 = i6;
        i4 = -1;
        RoadParam roadParam2222 = new RoadParam();
        int realTextureType2222 = getRealTextureType(i);
        roadParam2222.mfillLineMarkId = 421 - realTextureType2222;
        roadParam2222.mborderLineMarkId = 437 - realTextureType2222;
        roadParam2222.fillLineResId = i2;
        roadParam2222.borderLineResId = i3;
        roadParam2222.fillLineColor = i13;
        roadParam2222.borderColor = i4;
        roadParam2222.selectFillColor = i5;
        roadParam2222.selectBorderColor = i14;
        roadParam2222.unSelectFillColor = i15;
        roadParam2222.unSelectBorderColor = i16;
        return roadParam2222;
    }

    @NonNull
    private OverlayParamBoolean getOverlayParmBoolean(int i) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        switch (i) {
            case 1:
            case 2:
                z = true;
                z2 = true;
                break;
            case 3:
                z = false;
                z2 = true;
                z3 = false;
                break;
            case 4:
            case 5:
            case 7:
                z = true;
                z2 = true;
                z3 = false;
                break;
            case 6:
                z = false;
                z2 = true;
                break;
            default:
                z2 = false;
                z = true;
                z3 = false;
                break;
        }
        OverlayParamBoolean overlayParamBoolean = new OverlayParamBoolean();
        overlayParamBoolean.isUseCap = z3;
        overlayParamBoolean.isUseColor = z;
        overlayParamBoolean.isLineExtract = false;
        overlayParamBoolean.isCanBeCovered = z2;
        return overlayParamBoolean;
    }

    /* loaded from: classes3.dex */
    public enum Texture {
        LIMIT(34, 6),
        FERRY(38, 7),
        ARROW(7, 3),
        NAVIABLE(1, 4),
        NONAVI(0, 4),
        DEFAULT(2, 2),
        OPEN(3, 2),
        AMBLE(4, 2),
        JAM(5, 2),
        CONGESTED(6, 2),
        RAPIDER(16, 2);
        
        public int lineType;
        public int textureType;

        Texture(int i, int i2) {
            this.textureType = i;
            this.lineType = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class OverlayParamBoolean {
        public boolean isCanBeCovered;
        public boolean isLineExtract;
        public boolean isUseCap;
        public boolean isUseColor;

        OverlayParamBoolean() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class RoadParam {
        public int borderColor;
        public int borderLineResId;
        public int fillLineColor;
        public int fillLineResId;
        public int mborderLineMarkId;
        public int mfillLineMarkId;
        public int selectBorderColor;
        public int selectFillColor;
        public int unSelectBorderColor;
        public int unSelectFillColor;

        RoadParam() {
        }
    }
}
