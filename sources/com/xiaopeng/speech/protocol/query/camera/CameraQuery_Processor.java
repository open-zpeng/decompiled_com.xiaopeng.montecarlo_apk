package com.xiaopeng.speech.protocol.query.camera;

import com.xiaopeng.speech.annotation.IQueryProcessor;
import com.xiaopeng.speech.protocol.event.query.QueryCameraEvent;
/* loaded from: classes3.dex */
public class CameraQuery_Processor implements IQueryProcessor {
    private CameraQuery mTarget;

    public CameraQuery_Processor(CameraQuery cameraQuery) {
        this.mTarget = cameraQuery;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.IQueryProcessor
    public Object querySensor(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1268994260:
                if (str.equals(QueryCameraEvent.GET_CAMERA_THREE_D_SUPPORT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -504669293:
                if (str.equals(QueryCameraEvent.GET_SUPPORT_TOP_STATUS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -94871978:
                if (str.equals(QueryCameraEvent.IS_CAMERA_RECORDING)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -9645022:
                if (str.equals(QueryCameraEvent.GET_CAMERA_TRANSPARENT_CHASSIS_SUPPORT)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 180040983:
                if (str.equals(QueryCameraEvent.GET_BUSINESS_CAMERA_STATUS)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1273362324:
                if (str.equals(QueryCameraEvent.GET_SUPPORT_REAR_STATUS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1391541314:
                if (str.equals(QueryCameraEvent.GET_SUPPORT_PANORAMIC_STATUS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return Integer.valueOf(this.mTarget.getSupportTopStatus(str, str2));
            case 1:
                return Integer.valueOf(this.mTarget.getSupportPanoramicStatus(str, str2));
            case 2:
                return Integer.valueOf(this.mTarget.getSupportRearStatus(str, str2));
            case 3:
                return Integer.valueOf(this.mTarget.getBusinessCameraStatus(str, str2));
            case 4:
                return Integer.valueOf(this.mTarget.getCameraThreeDSupport(str, str2));
            case 5:
                return Integer.valueOf(this.mTarget.getCameraTransparentChassisSupport(str, str2));
            case 6:
                return Boolean.valueOf(this.mTarget.isCameraRecording(str, str2));
            default:
                return null;
        }
    }

    @Override // com.xiaopeng.speech.annotation.IQueryProcessor
    public String[] getQueryEvents() {
        return new String[]{QueryCameraEvent.GET_SUPPORT_TOP_STATUS, QueryCameraEvent.GET_SUPPORT_PANORAMIC_STATUS, QueryCameraEvent.GET_SUPPORT_REAR_STATUS, QueryCameraEvent.GET_BUSINESS_CAMERA_STATUS, QueryCameraEvent.GET_CAMERA_THREE_D_SUPPORT, QueryCameraEvent.GET_CAMERA_TRANSPARENT_CHASSIS_SUPPORT, QueryCameraEvent.IS_CAMERA_RECORDING};
    }
}
