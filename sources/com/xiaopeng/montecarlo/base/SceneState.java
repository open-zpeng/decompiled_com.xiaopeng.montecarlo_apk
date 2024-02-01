package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
/* loaded from: classes.dex */
public final class SceneState implements Parcelable {
    public static final Parcelable.Creator<SceneState> CREATOR = new Parcelable.Creator<SceneState>() { // from class: com.xiaopeng.montecarlo.base.SceneState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneState createFromParcel(Parcel parcel) {
            return new SceneState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneState[] newArray(int i) {
            return new SceneState[i];
        }
    };
    final BaseBridge mBridge;
    final SceneState[] mChild;
    final boolean mIsCreated;
    final MapStatus mMapStatus;
    final MapStatus mRestoreMapStatus;
    final Bundle mResultBundle;
    final MapUIStatus mSavedMapUi;
    final Bundle mSavedSceneState;
    final int mSceneId;
    final MapUIStatus mUsedMapUi;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SceneState(IScene iScene) {
        this.mBridge = iScene.getBridge();
        this.mSceneId = iScene.getSceneId();
        this.mResultBundle = iScene.getResultBundle();
        this.mSavedMapUi = iScene.getSavedMapUi();
        this.mUsedMapUi = iScene.getUsedMapUi();
        this.mMapStatus = iScene.getMapStatus();
        this.mRestoreMapStatus = iScene.getRestoreMapStatus();
        this.mSavedSceneState = iScene.getSavedSceneState();
        this.mIsCreated = iScene.isCreated();
        int childStackSize = iScene.getChildStackSize();
        if (childStackSize > 0) {
            this.mChild = new SceneState[childStackSize];
            for (int i = 0; i < childStackSize; i++) {
                this.mChild[i] = new SceneState(iScene.getChildSceneInfoStack().get((childStackSize - 1) - i).mScene);
            }
        } else {
            this.mChild = null;
        }
        this.mSavedSceneState.putBoolean("scene:isDetached", iScene.isDetached());
        this.mSavedSceneState.putBoolean("scene:isAdded", iScene.isAdded());
        iScene.onSaveState(this.mSavedSceneState);
    }

    public SceneState(Parcel parcel) {
        this.mBridge = (BaseBridge) parcel.readParcelable(BaseBridge.class.getClassLoader());
        this.mSceneId = parcel.readInt();
        this.mResultBundle = parcel.readBundle(getClass().getClassLoader());
        this.mSavedSceneState = parcel.readBundle(getClass().getClassLoader());
        this.mSavedMapUi = (MapUIStatus) parcel.readParcelable(MapUIStatus.class.getClassLoader());
        this.mUsedMapUi = (MapUIStatus) parcel.readParcelable(MapUIStatus.class.getClassLoader());
        this.mMapStatus = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.mRestoreMapStatus = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.mChild = (SceneState[]) parcel.createTypedArray(CREATOR);
        this.mIsCreated = parcel.readByte() == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mBridge, i);
        parcel.writeInt(this.mSceneId);
        parcel.writeBundle(this.mResultBundle);
        parcel.writeBundle(this.mSavedSceneState);
        parcel.writeParcelable(this.mSavedMapUi, i);
        parcel.writeParcelable(this.mUsedMapUi, i);
        parcel.writeParcelable(this.mMapStatus, i);
        parcel.writeParcelable(this.mRestoreMapStatus, i);
        parcel.writeTypedArray(this.mChild, i);
        parcel.writeByte(this.mIsCreated ? (byte) 1 : (byte) 0);
    }
}
