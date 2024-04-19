package com.xiaopeng.montecarlo.navcore.sr.data;
/* loaded from: classes3.dex */
public enum LaneDownloadTaskErrorCodeEnum {
    OPERATION_ERR_CODE_UNKNOWN(-1),
    OPERATION_ERR_CODE_CORRECT(0),
    OPERATION_ERR_CODE_NET_NONE(1),
    OPERATION_ERR_CODE_NET_DNS_TIMEOUT(2),
    OPERATION_ERR_CODE_NET_CONNECT_TIMEOUT(3),
    OPERATION_ERR_CODE_NET_SEND_FAILED(4),
    OPERATION_ERR_CODE_NET_RECV_FAILED(5),
    OPERATION_ERROR_CODE_NET_DATA_INVALID(6),
    OPERATION_ERR_CODE_CHECK_INVALID(7),
    OPERATION_ERR_CODE_UNZIP_INVALID(8),
    OPERATION_ERR_CODE_MERGER_INVALID(9),
    OPERATION_ERR_CODE_SPACE_UNENOUTH(10),
    OPERATION_ERR_CODE_FILE_OPEN_INVALID(11),
    OPERATION_ERR_CODE_FILE_RENAME_INVALID(12),
    OPERATION_ERR_CODE_FILE_READ_INVALID(13),
    OPERATION_ERR_CODE_FILE_WRITE_INVALID(14),
    OPERATION_ERR_CODE_FILE_MOVE_INVALID(15),
    OPERATION_CODE_UNKNOWN_INVALID(16),
    OPERATION_ERROR_GET_URL(17),
    OPERATION_CODE_MAX(18);
    
    private final int mErrorCode;

    LaneDownloadTaskErrorCodeEnum(int i) {
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public static LaneDownloadTaskErrorCodeEnum parse(int i) {
        LaneDownloadTaskErrorCodeEnum[] values;
        for (LaneDownloadTaskErrorCodeEnum laneDownloadTaskErrorCodeEnum : values()) {
            if (laneDownloadTaskErrorCodeEnum.getErrorCode() == i) {
                return laneDownloadTaskErrorCodeEnum;
            }
        }
        return null;
    }
}
