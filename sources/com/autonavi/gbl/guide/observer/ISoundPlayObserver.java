package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.PlayRingType;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.router.SoundPlayObserverRouter;
@IntfAuto(target = SoundPlayObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISoundPlayObserver {
    boolean isPlaying();

    void onPlayRing(@PlayRingType.PlayRingType1 int i);

    void onPlayTTS(SoundInfo soundInfo);
}
