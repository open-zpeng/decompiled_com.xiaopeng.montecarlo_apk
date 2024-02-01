package com.autonavi.gbl.guide.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.guide.model.PlayRingType;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.observer.ISoundPlayObserver;
import com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl;
@IntfAuto(target = ISoundPlayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class SoundPlayObserverRouter extends ISoundPlayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(SoundPlayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(SoundPlayObserverRouter.class);
    private TypeHelper mHelper;
    private ISoundPlayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, ISoundPlayObserver iSoundPlayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ISoundPlayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iSoundPlayObserver;
    }

    protected SoundPlayObserverRouter(String str, ISoundPlayObserver iSoundPlayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSoundPlayObserver);
    }

    protected SoundPlayObserverRouter(String str, ISoundPlayObserver iSoundPlayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iSoundPlayObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl
    public void onPlayTTS(SoundInfo soundInfo) {
        ISoundPlayObserver iSoundPlayObserver = this.mObserver;
        if (iSoundPlayObserver != null) {
            iSoundPlayObserver.onPlayTTS(soundInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl
    public void onPlayRing(@PlayRingType.PlayRingType1 int i) {
        ISoundPlayObserver iSoundPlayObserver = this.mObserver;
        if (iSoundPlayObserver != null) {
            iSoundPlayObserver.onPlayRing(i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl
    public boolean isPlaying() {
        ISoundPlayObserver iSoundPlayObserver = this.mObserver;
        if (iSoundPlayObserver != null) {
            return iSoundPlayObserver.isPlaying();
        }
        return false;
    }
}
