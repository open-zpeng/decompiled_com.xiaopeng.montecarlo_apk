package com.xiaopeng.montecarlo;
/* loaded from: classes.dex */
final class BenchPlatformInterface extends AbstractPlatformInterface {
    @Override // com.xiaopeng.montecarlo.AbstractPlatformInterface, com.autonavi.gbl.util.observer.IPlatformInterface
    public float getDensity(int i) {
        return 1080.0f;
    }

    @Override // com.xiaopeng.montecarlo.AbstractPlatformInterface, com.autonavi.gbl.util.observer.IPlatformInterface
    public int getDensityDpi(int i) {
        return 320;
    }

    BenchPlatformInterface() {
    }
}
