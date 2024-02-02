package com.google.zxing.oned;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.autonavi.gbl.data.model.RegionCode;
import com.autonavi.gbl.map.layer.model.LayerPriorityType;
import com.autonavi.gbl.pos.model.LocTrafficSignType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes2.dex */
public final class Code93Reader extends OneDReader {
    private static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {276, LocTrafficSignType.LOC_TRAFFIC_SIGN_BUS_LANE, LocTrafficSignType.LOC_TRAFFIC_SIGN_STRAIGHT_LEFT_TURN_LANE, LocTrafficSignType.LOC_TRAFFIC_SIGN_STRAIGHT_LANE, MarkUtils.MARKER_ID_TIE_1, MarkUtils.MARKER_ID_RECOMMEND_PARK_FOCUS_3, MarkUtils.MARKER_ID_RECOMMEND_PARK_FOCUS_1, LocTrafficSignType.LOC_TRAFFIC_SIGN_CARRIAGEWAY, 274, 266, TypedValues.Cycle.TYPE_WAVE_OFFSET, 420, 418, 404, 402, 394, MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE, 356, 354, 308, 282, RegionCode.REGION_CODE_HKG, LocTrafficSignType.LOC_TRAFFIC_SIGN_NON_MOTOR_VEHICLES_LANE, LocTrafficSignType.LOC_TRAFFIC_SIGN_U_LEFT_TURN_LANE, 300, 278, 436, 434, 428, TypedValues.Cycle.TYPE_CUSTOM_WAVE_SHAPE, 406, SpeechNaviEvent.SPEECH_SWITCH_MAP_MODE, 364, MarkUtils.MARKER_ID_BUBBLE_PASSED_VIA_CHARGE, 310, 314, 302, 468, 466, 458, MarkUtils.MARKER_ID_FAVOURITE, 374, 430, MarkUtils.MARKER_ID_CAR_NAVIGATION_3D, MarkUtils.MARKER_ID_ETA_EVENT, 470, 306, LayerPriorityType.LayerPriorityCruiseEvent};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] findAsteriskPattern;
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char patternToChar = patternToChar(pattern);
            sb.append(patternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int nextSet2 = bitArray.getNextSet(i2);
            if (patternToChar == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                checkChecksums(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new Result(decodeExtended(sb), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f), new ResultPoint(nextSet + (i4 / 2.0f), f)}, BarcodeFormat.CODE_93);
            }
            nextSet = nextSet2;
        }
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else if (toPattern(iArr) == ASTERISK_ENCODING) {
                    return new int[]{i2, nextSet};
                } else {
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toPattern(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((iArr[i4] * 9.0f) / i);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static char patternToChar(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return ALPHABET[i2];
                }
                i2++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i2 >= length - 1) {
                throw FormatException.getFormatInstance();
            } else {
                i2++;
                char charAt2 = charSequence.charAt(i2);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i = charAt2 - '@';
                            c = (char) i;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c = 127;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        c = (char) i;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i = charAt2 - ' ';
                            c = (char) i;
                            break;
                        } else if (charAt2 == 'Z') {
                            c = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i = charAt2 + ' ';
                            c = (char) i;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c = 0;
                        break;
                }
                sb.append(c);
            }
            i2++;
        }
        return sb.toString();
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += ALPHABET_STRING.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != ALPHABET[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
