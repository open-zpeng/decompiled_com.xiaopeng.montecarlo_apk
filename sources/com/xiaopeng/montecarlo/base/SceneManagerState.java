package com.xiaopeng.montecarlo.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.base.SceneInfoStack;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SceneManagerState implements Parcelable {
    public static final Parcelable.Creator<SceneManagerState> CREATOR = new Parcelable.Creator<SceneManagerState>() { // from class: com.xiaopeng.montecarlo.base.SceneManagerState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneManagerState createFromParcel(Parcel parcel) {
            return new SceneManagerState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SceneManagerState[] newArray(int i) {
            return new SceneManagerState[i];
        }
    };
    final SceneState[] mActive;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SceneManagerState(ScenesManager scenesManager) {
        SceneInfoStack.SceneInfo currentSceneInfo = scenesManager.getCurrentSceneInfo();
        if (currentSceneInfo != null) {
            SceneInfoStack sceneInfoStack = scenesManager.getSceneInfoStack();
            int size = sceneInfoStack.size();
            this.mActive = new SceneState[size + 1];
            SceneState[] sceneStateArr = this.mActive;
            SceneState sceneState = new SceneState(currentSceneInfo.mScene);
            int i = 0;
            sceneStateArr[0] = sceneState;
            while (i < size) {
                int i2 = i + 1;
                this.mActive[i2] = new SceneState(sceneInfoStack.get((size - 1) - i).mScene);
                i = i2;
            }
            return;
        }
        this.mActive = null;
    }

    public SceneManagerState(Parcel parcel) {
        this.mActive = (SceneState[]) parcel.createTypedArray(SceneState.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mActive, i);
    }
}
