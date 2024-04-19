package com.xiaopeng.montecarlo.navcore.mapdisplay;

import androidx.annotation.MainThread;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class MapDeviceIdUtil {
    private static final L.Tag LOG_TAG = new L.Tag(MapDeviceIdUtil.class.getSimpleName());

    @MainThread
    public static void releaseMainDeviceId(int i) {
        MapDeviceIdStatus mapDeviceIdStatus;
        if (i == 0) {
            mapDeviceIdStatus = MapDeviceIdStatus.MAIN;
        } else if (i == 1) {
            mapDeviceIdStatus = MapDeviceIdStatus.DEVICE_EXTERNAL_1;
        } else if (i == 2) {
            mapDeviceIdStatus = MapDeviceIdStatus.DEVICE_EXTERNAL_2;
        } else {
            mapDeviceIdStatus = i != 3 ? null : MapDeviceIdStatus.DEVICE_EXTERNAL_3;
        }
        if (mapDeviceIdStatus != null) {
            mapDeviceIdStatus.setUsed(false);
        }
    }

    @MainThread
    public static int getAvailableMainDeviceId(boolean z) {
        MapDeviceIdStatus mapDeviceIdStatus;
        MapDeviceIdStatus[] values = MapDeviceIdStatus.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                mapDeviceIdStatus = null;
                break;
            }
            mapDeviceIdStatus = values[i];
            if (!mapDeviceIdStatus.isUsed()) {
                if (z) {
                    if (mapDeviceIdStatus != MapDeviceIdStatus.MAIN) {
                        mapDeviceIdStatus.setUsed(true);
                        break;
                    }
                } else {
                    mapDeviceIdStatus.setUsed(true);
                    break;
                }
            }
            i++;
        }
        if (mapDeviceIdStatus == null) {
            L.w(LOG_TAG, "no available main engine type found !!!");
            return -1;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus[mapDeviceIdStatus.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? -1 : 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    /* renamed from: com.xiaopeng.montecarlo.navcore.mapdisplay.MapDeviceIdUtil$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus = new int[MapDeviceIdStatus.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus[MapDeviceIdStatus.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus[MapDeviceIdStatus.DEVICE_EXTERNAL_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus[MapDeviceIdStatus.DEVICE_EXTERNAL_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$navcore$mapdisplay$MapDeviceIdUtil$MapDeviceIdStatus[MapDeviceIdStatus.DEVICE_EXTERNAL_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum MapDeviceIdStatus {
        MAIN,
        DEVICE_EXTERNAL_1,
        DEVICE_EXTERNAL_2,
        DEVICE_EXTERNAL_3;
        
        private boolean mIsUsed;

        public boolean isUsed() {
            return this.mIsUsed;
        }

        public void setUsed(boolean z) {
            this.mIsUsed = z;
        }
    }
}
