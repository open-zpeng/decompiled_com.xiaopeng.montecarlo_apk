package com.xiaopeng.montecarlo.base;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.scene.IScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.speech.command.ISpeechEvent;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class SceneInfoStack implements Iterable<SceneInfo> {
    private ArrayList<SceneInfo> mList = new ArrayList<>();

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<SceneInfo> iterator() {
        return this.mList.iterator();
    }

    public int size() {
        return this.mList.size();
    }

    public SceneInfo get(int i) {
        return this.mList.get(i);
    }

    public void clear() {
        this.mList.clear();
    }

    public void add(SceneInfo sceneInfo) {
        this.mList.add(sceneInfo);
    }

    public SceneInfo remove(int i) {
        return this.mList.remove(i);
    }

    public boolean remove(SceneInfo sceneInfo) {
        return sceneInfo != null && this.mList.remove(sceneInfo);
    }

    public boolean removeAll(ArrayList<SceneInfo> arrayList) {
        return arrayList != null && this.mList.removeAll(arrayList);
    }

    public SceneInfo findBySceneId(int i, boolean z) {
        SceneInfo findChildSceneById;
        Iterator<SceneInfo> it = this.mList.iterator();
        while (it.hasNext()) {
            SceneInfo next = it.next();
            if (next.mScene.getSceneId() == i) {
                return next;
            }
            if (z && (findChildSceneById = next.mScene.findChildSceneById(i)) != null) {
                return findChildSceneById;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneInfo pop() {
        int size = this.mList.size();
        if (size > 0) {
            return this.mList.remove(size - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void push(SceneInfo sceneInfo) {
        if (sceneInfo == null) {
            return;
        }
        this.mList.add(sceneInfo);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mList.size());
        sb.append(":[");
        Iterator<SceneInfo> it = this.mList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append("]");
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class SceneInfo {
        StatusConst.Mode mMode;
        public IScene mScene;
        ISpeechEvent mSpeech;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SceneInfo(@NonNull IScene iScene) {
            this.mScene = iScene;
            this.mMode = iScene.getMode();
            this.mSpeech = iScene.getSpeechEvent();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mMode);
            IScene iScene = this.mScene;
            if (iScene != null && iScene.getChildSceneInfoStack() != null) {
                Iterator it = this.mScene.getChildSceneInfoStack().mList.iterator();
                while (it.hasNext()) {
                    sb.append("-");
                    sb.append(((SceneInfo) it.next()).mMode.toString().toLowerCase());
                }
            }
            sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
            return sb.toString();
        }
    }
}
