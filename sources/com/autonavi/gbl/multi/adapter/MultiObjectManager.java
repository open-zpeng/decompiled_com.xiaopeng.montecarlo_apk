package com.autonavi.gbl.multi.adapter;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class MultiObjectManager {
    private static MultiObjectManager singletonHungary = new MultiObjectManager();
    private HashMap<String, Object> hashMapConfigObject = new HashMap<>();
    private HashMap<String, Object> hashMapSceneObject = new HashMap<>();

    private MultiObjectManager() {
    }

    public static MultiObjectManager getInstance() {
        return singletonHungary;
    }

    public void putConfigObject(String str, Object obj) {
        this.hashMapConfigObject.put(str, obj);
    }

    public Object getConfigObject(String str) {
        return this.hashMapConfigObject.get(str);
    }

    public void removeConfigObject(String str) {
        this.hashMapConfigObject.remove(str);
    }

    public void putSceneObject(String str, Object obj) {
        this.hashMapSceneObject.put(str, obj);
    }

    public Object getSceneObject(String str) {
        return this.hashMapSceneObject.get(str);
    }

    public void removeSceneObject(String str) {
        this.hashMapSceneObject.remove(str);
    }
}
