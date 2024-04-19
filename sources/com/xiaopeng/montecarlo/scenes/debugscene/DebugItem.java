package com.xiaopeng.montecarlo.scenes.debugscene;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class DebugItem {
    public Method mInitMethod;
    public Method mMethod;
    public String mName;

    public DebugItem(String str, Method method, Method method2) {
        this.mName = str;
        this.mMethod = method;
        this.mInitMethod = method2;
    }

    public static ArrayList<DebugItem> createListFromObj(Context context, Object obj) {
        ArrayList<DebugItem> arrayList = new ArrayList<>();
        Method[] methods = obj.getClass().getMethods();
        Arrays.sort(methods, new Comparator<Method>() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.DebugItem.1
            @Override // java.util.Comparator
            public int compare(Method method, Method method2) {
                return method.getName().compareTo(method2.getName());
            }
        });
        for (Method method : methods) {
            DebugItemTag debugItemTag = (DebugItemTag) method.getAnnotation(DebugItemTag.class);
            if (debugItemTag != null && (!RootUtil.isUserVersion() || debugItemTag.enableInUserVersion())) {
                String stringValue = debugItemTag.stringValue();
                if (TextUtils.isEmpty(stringValue)) {
                    stringValue = context.getResources().getString(debugItemTag.value());
                }
                Method method2 = null;
                String initMethod = debugItemTag.initMethod();
                if (!TextUtils.isEmpty(initMethod)) {
                    try {
                        method2 = obj.getClass().getMethod(initMethod, View.class, Integer.TYPE);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
                arrayList.add(new DebugItem(stringValue, method, method2));
            }
        }
        return arrayList;
    }
}
