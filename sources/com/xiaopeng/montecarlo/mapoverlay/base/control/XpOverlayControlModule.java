package com.xiaopeng.montecarlo.mapoverlay.base.control;

import com.xiaopeng.montecarlo.base.MainContext;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class XpOverlayControlModule {
    private static MainContext sMainContext;
    private static final ConcurrentHashMap<Integer, IDecoratorOverlayItemOperation> sModuleMap = new ConcurrentHashMap<>();

    public static void init(MainContext mainContext) {
        sMainContext = mainContext;
    }

    public static void register(Integer num, IDecoratorOverlayItemOperation iDecoratorOverlayItemOperation) {
        if (num == null || iDecoratorOverlayItemOperation == null || sModuleMap.containsKey(num)) {
            return;
        }
        sModuleMap.put(num, iDecoratorOverlayItemOperation);
    }

    public static IDecoratorOverlayItemOperation get(Integer num) {
        IDecoratorOverlayItemOperation iDecoratorOverlayItemOperation = sModuleMap.get(num);
        if (iDecoratorOverlayItemOperation == null) {
            IDecoratorOverlayItemOperation create = create(num);
            register(num, create);
            return create;
        }
        return iDecoratorOverlayItemOperation;
    }

    private static IDecoratorOverlayItemOperation create(Integer num) {
        int intValue = num.intValue();
        if (intValue != 8004) {
            if (intValue == 8005) {
                return new XpChargeControl(sMainContext);
            }
            switch (intValue) {
                case 6001:
                    return new XpStartPointControl(sMainContext);
                case 6002:
                    return new XpEndPointControl(sMainContext);
                case 6003:
                    return new XpWayPointControl(sMainContext);
                default:
                    switch (intValue) {
                        case 20001:
                            return new XpSearchControl(sMainContext);
                        case 20002:
                            return new XpRouteChargeControl(sMainContext);
                        case 20003:
                            return new XpPoiDetailControl(sMainContext);
                        case 20004:
                            return new XpRGCControl(sMainContext);
                        case 20005:
                            return new XpMarkControl(sMainContext);
                        case 20006:
                            return new XpVPAControl(sMainContext);
                        default:
                            return null;
                    }
            }
        }
        return new XpFavoriteControl(sMainContext);
    }
}
