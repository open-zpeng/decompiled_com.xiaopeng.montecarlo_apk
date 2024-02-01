package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class BaseBridge implements Parcelable {
    public static final int START_MODE_KILL_TOP_SCENE = 16;
    public static final int START_MODE_NEW = 0;
    public static final int START_MODE_OVER = 2;
    public static final int START_MODE_OVER_NOT_HIDE = 8;
    public static final int START_MODE_SINGLE = 1;
    public static final int START_MODE_SINGLE_NOT_DESTROY = 4;
    private String mChildClassName;
    private StatusConst.Mode mMode;
    SceneState mSceneState;
    public static final Parcelable.Creator<BaseBridge> CREATOR = new Parcelable.Creator<BaseBridge>() { // from class: com.xiaopeng.montecarlo.base.BaseBridge.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseBridge createFromParcel(Parcel parcel) {
            BaseBridge baseBridge = new BaseBridge(StatusConst.Mode.valueOf(parcel.readString()));
            baseBridge.mChildClassName = parcel.readString();
            baseBridge.mBundle = parcel.readBundle();
            baseBridge.mRequestCode = parcel.readInt();
            baseBridge.mBackSceneId = parcel.readInt();
            baseBridge.mStartMode = parcel.readInt();
            return baseBridge;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseBridge[] newArray(int i) {
            return new BaseBridge[i];
        }
    };
    private static final L.Tag TAG = new L.Tag("BaseBridge");
    private int mBackSceneId = 0;
    private Bundle mBundle = null;
    private Object mObject = null;
    private int mRequestCode = 0;
    private int mStartMode = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseBridge(StatusConst.Mode mode) {
        this.mMode = null;
        this.mChildClassName = null;
        this.mMode = mode;
        this.mChildClassName = getClass().getName();
    }

    public final BaseBridge setStartMode(int i) {
        this.mStartMode = i | this.mStartMode;
        return this;
    }

    public final BaseBridge enableSingleMode() {
        return setStartMode(1);
    }

    public final BaseBridge enableSingleNotDestroyMode() {
        return setStartMode(5);
    }

    public final BaseBridge enableOverMode() {
        return setStartMode(2);
    }

    public final BaseBridge enableOverAndNotHideMode() {
        return setStartMode(10);
    }

    public final BaseBridge enableKillTopSceneMode() {
        return setStartMode(16);
    }

    public final boolean isSingleMode() {
        return (this.mStartMode & 1) != 0;
    }

    public final boolean isOverMode() {
        return (this.mStartMode & 2) != 0;
    }

    public final boolean isSingleNotDestroyMode() {
        return isSingleMode() && (this.mStartMode & 4) != 0;
    }

    public final boolean isOverNotHideMode() {
        return isOverMode() && (this.mStartMode & 8) != 0;
    }

    public final boolean isKillTopSceneMode() {
        return (this.mStartMode & 16) != 0;
    }

    public BaseBridge update(BaseBridge baseBridge) {
        this.mMode = baseBridge.mMode;
        this.mChildClassName = baseBridge.mChildClassName;
        this.mBundle = baseBridge.mBundle;
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        this.mRequestCode = baseBridge.mRequestCode;
        this.mBackSceneId = baseBridge.mBackSceneId;
        this.mStartMode = baseBridge.mStartMode;
        return this;
    }

    private void startScene(ScenesManager scenesManager) {
        if (this.mMode == null) {
            L.e(TAG, "Unknown Scene Mode");
            throw new IllegalArgumentException();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "create: " + this.mMode.name() + " scene");
        }
        scenesManager.createScene(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startSceneForResult(ScenesManager scenesManager, int i, int i2) {
        this.mBackSceneId = i2;
        this.mRequestCode = i;
        startScene(scenesManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSceneResult(Bundle bundle, ScenesManager scenesManager) {
        int i = this.mBackSceneId;
        if (i > 0) {
            scenesManager.backResult(i, this.mRequestCode, bundle);
        }
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public BaseBridge setBundle(Bundle bundle) {
        this.mBundle = bundle;
        Bundle bundle2 = this.mBundle;
        if (bundle2 != null) {
            bundle2.setClassLoader(getClass().getClassLoader());
        }
        return this;
    }

    public Object getObject() {
        return this.mObject;
    }

    public BaseBridge setObject(Object obj) {
        this.mObject = obj;
        return this;
    }

    public StatusConst.Mode getMode() {
        return this.mMode;
    }

    public String getChildClassName() {
        return this.mChildClassName;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public int getBackSceneId() {
        return this.mBackSceneId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMode.name());
        parcel.writeString(this.mChildClassName);
        parcel.writeBundle(this.mBundle);
        parcel.writeInt(this.mRequestCode);
        parcel.writeInt(this.mBackSceneId);
        parcel.writeInt(this.mStartMode);
    }
}
