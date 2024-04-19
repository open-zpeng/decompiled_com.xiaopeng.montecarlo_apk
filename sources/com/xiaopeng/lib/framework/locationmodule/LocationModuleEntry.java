package com.xiaopeng.lib.framework.locationmodule;

import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider;
/* loaded from: classes2.dex */
public class LocationModuleEntry implements IModuleEntry {
    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls != ILocationProvider.class) {
            if (cls == ILocationConsumer.class) {
                return LocationConsumerHolder.INSTANCE;
            }
            return null;
        }
        return LocationProviderHolder.INSTANCE;
    }

    /* loaded from: classes2.dex */
    private static final class LocationConsumerHolder {
        private static final ILocationConsumer INSTANCE = new LocationConsumerImpl();

        private LocationConsumerHolder() {
        }
    }

    /* loaded from: classes2.dex */
    private static final class LocationProviderHolder {
        private static final ILocationProvider INSTANCE = new LocationProviderImpl();

        private LocationProviderHolder() {
        }
    }
}
