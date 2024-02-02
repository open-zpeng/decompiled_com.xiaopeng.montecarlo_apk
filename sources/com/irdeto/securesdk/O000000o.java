package com.irdeto.securesdk;

import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
/* compiled from: ISFErrorType.java */
/* loaded from: classes2.dex */
public enum O000000o {
    ISF_MGR_NONE(0, "no error"),
    ISF_MGR_UNKNOWN(1, "Unknown Error"),
    ISF_MGR_INVALID_PARAMETER(2, "Parameter is invalid"),
    ISF_MGR_ERROR_INT(3, "Initialization failed"),
    ISF_MGR_ALREADY_INITIALIZED(4, "Already initialized"),
    ISF_MGR_NOT_PROVISIONED(5, "Not provisioned"),
    ISF_MGR_INVALID_PROVISION_RESPONSE(6, "Invalid provision response"),
    ISF_MGR_NOT_SUPPORTED(7, "NOT supported"),
    ISF_MGR_NO_PERMISSION(8, "NO permission"),
    ISF_MGR_TOKEN_SAVE_FAILED(9, "Token Save Failed"),
    ISF_MGR_ROOTDETECTED(10, "Root Detected"),
    ISF_MGR_TOKEN_OPERATE_FAILED(11, "Token Operate Failed"),
    ISF_MGR_GENERATE_OPAQUE_DATA_FAILED(12, "Generate Opaque Data Failed"),
    ISF_MGR_SECURE_SDK_INITIALIZE_FAILED(13, "Secure sdk initialize failed"),
    ISF_MGR_SHARED_SECURE_STORE_INVALID(14, "Invalid shared secure store"),
    ISF_MGR_GE_APP_ENV_ERROR(15, "Application flag error"),
    ISF_MGR_LOCAL_SECURE_STORE_INVALID(16, "Invalid local secure store"),
    ISF_CRD_NONE(256, "no error"),
    ISF_IS_NONE(512, "no error"),
    ISF_IS_HELP(513, "Invalid individual helper"),
    ISF_IS_UUID(514, "Invalid UUID of SS2"),
    ISF_IS_CTXP(515, "Invalid preconfig context"),
    ISF_IS_CTX1(516, "Invalid store context of ss1"),
    ISF_IS_CTX2(517, "Invalid store context of ss2"),
    ISF_IS_PTXT(518, "Invalid plain provision request"),
    ISF_IS_CNFP(BLParams.GuideOverlayTypePathBoard, "Invalid preconfig pub key"),
    ISF_IS_JWEC(520, "Invalid JWE compact data of response"),
    ISF_IS_JWSC(521, "Invalid JWS compact data of response"),
    ISF_IS_ESTR(BLParams.GuideOverlayTypeTurnArrow, "Failed to decode response"),
    ISF_IS_HTTP(BLParams.GuideOverlayTypeTips, "Failed to send http request"),
    ISF_IS_RESP(524, "Failed to get response from IS server"),
    ISF_IS_JFMT(BLParams.GuideOverlayTypeParking, "Invalid JSON format of response"),
    ISF_IS_JDAT(526, "Invalid JSON sdata object"),
    ISF_IS_JVAL(527, "Invalid JSON sdata value"),
    ISF_IS_JWSS(BLParams.GuideOverlayTypeIntervalCamera, "Invalid JWS signature"),
    ISF_IS_ECCD(BLParams.GuideOverlayTypeVectorCross, "Failed to decoding ECC KW body"),
    ISF_IS_SAV1(BLParams.GuideOverlayType3DCross, "Invalid parameters (data or path) of saving ss2"),
    ISF_IS_SAV2(BLParams.GuideOverlayTypeBuilding, "Invalid data length of saving ss2"),
    ISF_IS_SAV3(BLParams.GuideOverlayTypeMixForkInfo, "Failed to open saving file"),
    ISF_IS_SAV4(BLParams.GuideOverlayTypeAllBoard, "Failed to writing data into file"),
    ISF_CS_NONE(768, "no error"),
    ISF_CS_DECRYPT_FAILED(769, "decrypt failed"),
    ISF_CS_ENCRYPT_FAILED(BLParams.RouteOverlayCruise, "encrypt failed"),
    ISF_SIPC_NOT_INIT(1281, "Secure IPC is uninitialized"),
    ISF_SIPC_INIT_FAIL(1282, "Secure IPC initialization failed"),
    ISF_SIPC_OBJ_SRL_FAIL(SyncRet.SyncRetOffline, "Secure IPC object serialization failed"),
    ISF_SIPC_OBJ_PRT_FAIL(SyncRet.SyncRetBusy, "Secure IPC object protection failed"),
    ISF_SIPC_OBJ_DSRL_FAIL(SyncRet.SyncRetInvalidCall, "Secure IPC object deserialization failed"),
    ISF_SIPC_OBJ_DECRYPT_FAIL(SyncRet.SyncRetPostponed, "Secure IPC object decryption failed"),
    ISF_SS_CREATE_FAILED(1537, "Create secure store failed"),
    ISF_SS_WRITE_FAILED(1538, "Save data to secure store failed"),
    ISF_SS_READ_FAILED(1539, "Get data from secure store failed"),
    ISF_SS_LOAD_SS_FAILED(1540, "Load secure store failed"),
    ISF_SS_INVALID_SS_PATH(1541, "Invalid secure store path");
    
    private int O000OooO;
    private String O000Oooo;

    O000000o(int i, String str) {
        this.O000OooO = i;
        this.O000Oooo = str;
    }

    public static O000000o O000000o(int i) {
        O000000o[] values;
        for (O000000o o000000o : values()) {
            if (o000000o.O000000o() == i) {
                return o000000o;
            }
        }
        throw new IllegalArgumentException("Invalid MediaEventType:" + i);
    }

    public static O000000o O00000Oo(int i) {
        return O000000o(Math.abs(i) | ISF_IS_NONE.O000000o());
    }

    public int O000000o() {
        return this.O000OooO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.O000Oooo;
    }
}
