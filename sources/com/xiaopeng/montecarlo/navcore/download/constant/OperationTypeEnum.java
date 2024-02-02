package com.xiaopeng.montecarlo.navcore.download.constant;
/* loaded from: classes2.dex */
public enum OperationTypeEnum {
    OPERATION_TYPE_START(0, "START"),
    OPERATION_TYPE_PAUSE(1, "PAUSE"),
    OPERATION_TYPE_CANCEL(2, "CANCEL"),
    OPERATION_TYPE_DELETE(3, "DELETE"),
    OPERATION_TYPE_MAX(4, "MAX");
    
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    OperationTypeEnum(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static OperationTypeEnum parse(int i) {
        OperationTypeEnum[] values;
        for (OperationTypeEnum operationTypeEnum : values()) {
            if (operationTypeEnum.getId() == i) {
                return operationTypeEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }
}
