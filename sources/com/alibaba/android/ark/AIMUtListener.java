package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface AIMUtListener {
    void OnCountReport(String str, String str2, double d, HashMap<String, String> hashMap);

    void OnFailReport(String str, String str2, int i, String str3, HashMap<String, String> hashMap);

    void OnStatRegister(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2);

    void OnStatReport(String str, String str2, HashMap<String, String> hashMap, HashMap<String, Double> hashMap2);

    void OnSuccessReport(String str, String str2, HashMap<String, String> hashMap);
}
