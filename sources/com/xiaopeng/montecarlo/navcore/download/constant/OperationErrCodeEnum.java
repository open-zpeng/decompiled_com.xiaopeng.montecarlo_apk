package com.xiaopeng.montecarlo.navcore.download.constant;
/* loaded from: classes3.dex */
public enum OperationErrCodeEnum {
    OPERATION_ERR_CODE_CORRECT(0, "CORRECT"),
    OPERATION_ERR_CODE_NET_NONE(1, "NET_NONE"),
    OPERATION_ERR_CODE_NET_DNS_TIMEOUT(2, "NET_DNS_TIMEOUT"),
    OPERATION_ERR_CODE_NET_CONNECT_TIMEOUT(3, "NET_CONNECT_TIMEOUT"),
    OPERATION_ERR_CODE_NET_SEND_FAILED(4, "NET_SEND_FAILED"),
    OPERATION_ERR_CODE_NET_RECV_FAILED(5, "NET_RECV_FAILED"),
    OPERATION_ERROR_CODE_NET_DATA_INVALID(6, "NET_DATA_INVALID"),
    OPERATION_ERR_CODE_CHECK_INVALID(7, "CHECK_INVALID"),
    OPERATION_ERR_CODE_UNZIP_INVALID(8, "UNZIP_INVALID"),
    OPERATION_ERR_CODE_MERGER_INVALID(9, "MERGER_INVALID"),
    OPERATION_ERR_CODE_SPACE_UNENOUTH(10, "SPACE_UNENOUTH"),
    OPERATION_ERR_CODE_FILE_OPEN_INVALID(11, "FILE_OPEN_INVALID"),
    OPERATION_ERR_CODE_FILE_RENAME_INVALID(12, "FILE_RENAME_INVALID"),
    OPERATION_ERR_CODE_FILE_READ_INVALID(13, "FILE_READ_INVALID"),
    OPERATION_ERR_CODE_FILE_WRITE_INVALID(14, "FILE_WRITE_INVALID"),
    OPERATION_ERR_CODE_FILE_MOVE_INVALID(15, "FILE_MOVE_INVALID"),
    OPERATION_CODE_UNKONW_INVALID(16, "UNKONW_INVALID"),
    OPERATION_CODE_MAX(17, "MAX");
    
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    OperationErrCodeEnum(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static OperationErrCodeEnum parse(int i) {
        OperationErrCodeEnum[] values;
        for (OperationErrCodeEnum operationErrCodeEnum : values()) {
            if (operationErrCodeEnum.getId() == i) {
                return operationErrCodeEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }
}
