package com.google.zxing.datamatrix.encoder;

import com.autonavi.gbl.common.model.RouteErrorcode;
import com.autonavi.gbl.pos.model.LocTrafficSignType;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import org.objectweb.asm.Opcodes;
/* loaded from: classes2.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{LocTrafficSignType.LOC_TRAFFIC_SIGN_AXLE_WEIGTH_LIMIT, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, RouteChargeDecorator.TYPE_SELECTED_KEEPER, 92, RouteErrorcode.RouteErrorcodeDataIsNull}, new int[]{28, 24, Opcodes.INVOKEINTERFACE, Opcodes.IF_ACMPNE, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 248, 116, 255, 110, 61}, new int[]{Opcodes.DRETURN, 138, 205, 12, Opcodes.MONITORENTER, Opcodes.JSR, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, Opcodes.GETSTATIC, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, Opcodes.INVOKEDYNAMIC, 83, Opcodes.INVOKEINTERFACE}, new int[]{83, Opcodes.MONITOREXIT, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, 241, 213, 109, 129, 94, RouteErrorcode.RouteErrorcodeDataIsNull, LocTrafficSignType.LOC_TRAFFIC_SIGN_MAXIMUN_WIDTH, 48, 90, Opcodes.NEWARRAY}, new int[]{15, Opcodes.MONITOREXIT, 244, 9, 233, 71, Opcodes.JSR, 2, Opcodes.NEWARRAY, 160, 153, 145, 253, 79, 108, 82, 27, Opcodes.FRETURN, Opcodes.INVOKEDYNAMIC, Opcodes.IRETURN}, new int[]{52, Opcodes.ARRAYLENGTH, 88, 205, 109, 39, Opcodes.ARETURN, 21, 155, Opcodes.MULTIANEWARRAY, 251, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 155, 21, 5, Opcodes.IRETURN, RouteErrorcode.RouteErrorcodeDataIsNull, 124, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, Opcodes.INSTANCEOF}, new int[]{211, LocTrafficSignType.LOC_TRAFFIC_SIGN_CUSTOMS, 43, 97, 71, 96, 103, Opcodes.FRETURN, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, Opcodes.JSR, 93, 255}, new int[]{245, 127, 242, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_STRAIGHT_THRU_RIGHT_TURN, 130, 250, 162, Opcodes.PUTFIELD, 102, 120, 84, Opcodes.PUTSTATIC, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_OVERTAKING, 251, 80, Opcodes.INVOKEVIRTUAL, LocTrafficSignType.LOC_TRAFFIC_SIGN_STOP_AND_CHECK, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, Opcodes.DRETURN, Opcodes.INVOKESTATIC, 59, 25, LocTrafficSignType.LOC_TRAFFIC_SIGN_MAXIMUN_WIDTH, 98, 81, 112}, new int[]{77, Opcodes.INSTANCEOF, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, Opcodes.DRETURN, 95, 100, 9, Opcodes.GOTO, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, Opcodes.RETURN, LocTrafficSignType.LOC_TRAFFIC_SIGN_MAXIMUM_CLEARANCE, 5, 9, 5}, new int[]{245, 132, Opcodes.IRETURN, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 96, 32, 117, 22, 238, 133, 238, LocTrafficSignType.LOC_TRAFFIC_SIGN_CUSTOMS, 205, Opcodes.NEWARRAY, LocTrafficSignType.LOC_TRAFFIC_SIGN_MIN_SPEED_LIMIT, 87, Opcodes.ATHROW, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, Opcodes.INVOKEDYNAMIC, RouteChargeDecorator.TYPE_SELECTED_KEEPER, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, 147, 160, Opcodes.DRETURN, 69, 213, 92, 253, LocTrafficSignType.LOC_TRAFFIC_SIGN_MAXIMUN_WIDTH, 19}, new int[]{Opcodes.DRETURN, 9, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 238, 12, 17, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_OVERTAKING, 208, 100, 29, Opcodes.DRETURN, 170, LocTrafficSignType.LOC_TRAFFIC_SIGN_CARRYING_HAZARDOUS_MATERIAL_PROHIBITED, 192, 215, LocTrafficSignType.LOC_TRAFFIC_SIGN_END_OF_NO_STOPPING_ZONE, 150, 159, 36, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 38, 200, 132, 54, LocTrafficSignType.LOC_TRAFFIC_SIGN_AXLE_WEIGTH_LIMIT, 146, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_STRAIGHT_THRU_RIGHT_TURN, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_STOPPING_AREA, 117, 203, 29, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING_AREA, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, Opcodes.RET, 50, 144, 210, 39, 118, 202, Opcodes.NEWARRAY, 201, Opcodes.ANEWARRAY, 143, 108, 196, 37, Opcodes.INVOKEINTERFACE, 112, 134, LocTrafficSignType.LOC_TRAFFIC_SIGN_CARRYING_HAZARDOUS_MATERIAL_PROHIBITED, 245, 63, Opcodes.MULTIANEWARRAY, Opcodes.ARRAYLENGTH, 250, 106, Opcodes.INVOKEINTERFACE, LocTrafficSignType.LOC_TRAFFIC_SIGN_END_OF_NO_OVERTAKING, Opcodes.DRETURN, 64, 114, 71, 161, 44, 147, 6, 27, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_STRAIGHT_THRU_RIGHT_TURN, 51, 63, 87, 10, 40, 130, Opcodes.NEWARRAY, 17, 163, 31, Opcodes.ARETURN, 170, 4, 107, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING_AREA, 7, 94, Opcodes.IF_ACMPNE, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_HONKING, 124, 86, 47, 11, 204}, new int[]{LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_OVERTAKING, LocTrafficSignType.LOC_TRAFFIC_SIGN_AXLE_WEIGTH_LIMIT, Opcodes.LRETURN, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, Opcodes.GETFIELD, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_STOPPING_AREA, Opcodes.MULTIANEWARRAY, 158, Opcodes.RETURN, 68, 122, 93, 213, 15, 160, LocTrafficSignType.LOC_TRAFFIC_SIGN_WEIGTH_LIMIT, LocTrafficSignType.LOC_TRAFFIC_SIGN_MAX_SPEED_LIMIT, 66, 139, 153, Opcodes.INVOKEINTERFACE, 202, Opcodes.GOTO, Opcodes.PUTSTATIC, 25, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_OVERTAKING, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING_AREA, 96, 210, LocTrafficSignType.LOC_TRAFFIC_SIGN_CUSTOMS, 136, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING, 239, Opcodes.PUTFIELD, 241, 59, 52, Opcodes.IRETURN, 25, 49, LocTrafficSignType.LOC_TRAFFIC_SIGN_NO_PARKING_AREA, 211, Opcodes.ANEWARRAY, 64, 54, 108, 153, 132, 63, 96, 103, 82, Opcodes.INVOKEDYNAMIC}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
        }
        int[] iArr2 = FACTORS[i4];
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int i7 = i3 - 1;
            int charAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (charAt != 0 && iArr2[i7] != 0) {
                    char c = cArr[i7 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                } else {
                    cArr[i7] = cArr[i7 - 1];
                }
                i7--;
            }
            if (charAt != 0 && iArr2[0] != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i3];
        for (int i8 = 0; i8 < i3; i8++) {
            cArr2[i8] = cArr[(i3 - i8) - 1];
        }
        return String.valueOf(cArr2);
    }
}
