package com.xiaopeng.montecarlo.navcore.download.autodownload.profile;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class DownloadUserProfile {
    private static final String INVALID_STRING = "";
    public static final int MAX_STORAGE_NUMBERS = 10;
    public static final int MAX_STORAGE_NUMBERS_LOGIN_OUT = 5;
    private static final int MSG_LOAD_MAP_FROM_DATABASE = 101;
    private static final int MSG_SAVE_MAP_FROM_DATABASE = 102;
    private static final long ONE_DAY_MILLISECONDS = 86400000;
    private static final L.Tag TAG = new L.Tag("DownloadUserProfile");
    private final Map<Integer, VisitCityRecorder> mRecorderMap = new ConcurrentHashMap<Integer, VisitCityRecorder>() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile.1
        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public VisitCityRecorder get(Object obj) {
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (num.intValue() > DownloadUserProfile.this.getToday() - 10) {
                    VisitCityRecorder visitCityRecorder = (VisitCityRecorder) super.get(obj);
                    if (visitCityRecorder == null) {
                        VisitCityRecorder visitCityRecorder2 = new VisitCityRecorder(num.intValue());
                        put(num, visitCityRecorder2);
                        return visitCityRecorder2;
                    }
                    return visitCityRecorder;
                }
            }
            return (VisitCityRecorder) super.get(obj);
        }
    };
    private Handler mHandler = new Handler(WorkThreadUtil.getInstance().getDataProcessThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile.2
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 101) {
                DownloadUserProfile.this.handleLoadMapFromDatabase();
            } else if (i != 102) {
            } else {
                DownloadUserProfile.this.handleSaveMapInDatabase();
            }
        }
    };

    public DownloadUserProfile() {
        loadMapFromDatabase();
    }

    public void onAdCodeChanged(int i) {
        if (i > 0) {
            if (this.mRecorderMap == null) {
                loadMapFromDatabase();
            }
            Map<Integer, VisitCityRecorder> map = this.mRecorderMap;
            if (map != null) {
                map.get(Integer.valueOf(getToday())).recordAdCode(i);
                saveMapInDatabase();
                return;
            }
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "adCode is " + i + ", abandon");
    }

    private void loadMapFromDatabase() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(101));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadMapFromDatabase() {
        String string = DataSetHelper.AccountSet.getString(DataSetHelper.AccountSet.KEY_USR_PROFILE_VISIT_CITIES, "");
        L.Tag tag = TAG;
        L.i(tag, "loadMapFromDatabase=" + string);
        convertJson2VisitAdCodeMap(string, this.mRecorderMap);
        sortOutVisitMap(this.mRecorderMap, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSaveMapInDatabase() {
        Map<Integer, VisitCityRecorder> map = this.mRecorderMap;
        if (map != null && !map.isEmpty()) {
            sortOutVisitMap(this.mRecorderMap, 10);
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_USR_PROFILE_VISIT_CITIES, visitAdCodeMap2Json(this.mRecorderMap));
            return;
        }
        L.i(TAG, "saveMapInDatabase, mRecorderMap is null");
    }

    public void saveMapInDatabase() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(102));
        }
    }

    public int getStorageNumbers() {
        if (CollectionUtils.isEmpty(this.mRecorderMap)) {
            return 0;
        }
        return this.mRecorderMap.size();
    }

    @NonNull
    public List<Integer> calculateRecentVisitedCity(int i) {
        if (CollectionUtils.isEmpty(this.mRecorderMap)) {
            L.i(TAG, "calculateRecentVisitedCity, mRecorderMap is null");
            return new ArrayList();
        } else if (this.mRecorderMap.size() < 5) {
            return new ArrayList();
        } else {
            Map<Integer, VisitCityRecorder> map = this.mRecorderMap;
            HashMap hashMap = new HashMap();
            for (Map.Entry<Integer, VisitCityRecorder> entry : this.mRecorderMap.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            sortOutVisitMap(map, i);
            for (VisitCityRecorder visitCityRecorder : map.values()) {
                for (Integer num : visitCityRecorder.getVisitCityList()) {
                    if (hashMap.containsKey(num)) {
                        hashMap.put(num, Integer.valueOf(((Integer) hashMap.get(num)).intValue() + 1));
                    } else {
                        hashMap.put(num, 1);
                    }
                }
            }
            int i2 = 0;
            for (Integer num2 : hashMap.keySet()) {
                int intValue = ((Integer) hashMap.get(num2)).intValue();
                if (intValue > i2) {
                    i2 = intValue;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry2 : hashMap.entrySet()) {
                if (i2 == ((Integer) entry2.getValue()).intValue()) {
                    arrayList.add(entry2.getKey());
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getToday() {
        return (int) (new Date().getTime() / 86400000);
    }

    private String visitAdCodeMap2Json(@NonNull Map<Integer, VisitCityRecorder> map) {
        return CollectionUtils.isEmpty(map) ? "" : GsonUtil.toJson(new ArrayList(map.values()));
    }

    private void convertJson2VisitAdCodeMap(String str, @NonNull Map<Integer, VisitCityRecorder> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List list = (List) GsonUtil.fromJson(str, new TypeToken<List<VisitCityRecorder>>() { // from class: com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile.3
        }.getType());
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                VisitCityRecorder visitCityRecorder = (VisitCityRecorder) list.get(i);
                if (visitCityRecorder != null && visitCityRecorder.getDay() != null) {
                    map.put(visitCityRecorder.getDay(), visitCityRecorder);
                }
            }
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "json: " + str);
    }

    private void sortOutVisitMap(@NonNull Map<Integer, VisitCityRecorder> map, int i) {
        if (CollectionUtils.isEmpty(map)) {
            L.w(TAG, "sortOutVisitMap, mRecorderMap is null");
            return;
        }
        for (Integer num : map.keySet()) {
            if (num.intValue() < (getToday() - i) + 1) {
                map.remove(num);
            }
        }
    }
}
