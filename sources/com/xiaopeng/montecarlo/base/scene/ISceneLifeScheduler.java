package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.base.scene.IScene;
/* loaded from: classes2.dex */
public interface ISceneLifeScheduler<T extends IScene> {
    void add(int i, T t);

    void attach(T t);

    void detach(T t);

    T findSceneById(int i);

    void remove(T t);

    void show(T t);
}
