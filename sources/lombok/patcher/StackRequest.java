package lombok.patcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/patcher/StackRequest.SCL.lombok */
public enum StackRequest {
    RETURN_VALUE(-1),
    THIS(-1),
    PARAM1(0),
    PARAM2(1),
    PARAM3(2),
    PARAM4(3),
    PARAM5(4),
    PARAM6(5);
    
    private final int paramPos;
    public static final List<StackRequest> PARAMS_IN_ORDER = Collections.unmodifiableList(Arrays.asList(PARAM1, PARAM2, PARAM3, PARAM4, PARAM5, PARAM6));

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static StackRequest[] valuesCustom() {
        StackRequest[] valuesCustom = values();
        int length = valuesCustom.length;
        StackRequest[] stackRequestArr = new StackRequest[length];
        System.arraycopy(valuesCustom, 0, stackRequestArr, 0, length);
        return stackRequestArr;
    }

    StackRequest(int paramPos) {
        this.paramPos = paramPos;
    }

    public int getParamPos() {
        return this.paramPos;
    }
}
