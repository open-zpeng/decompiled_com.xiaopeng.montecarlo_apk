package com.xiaopeng.montecarlo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class XpThemeSwitchReceiver extends BroadcastReceiver {
    private static final L.Tag TAG = new L.Tag("XpThemeSwitchReceiver");
    public ArrayList<ThemeSwitchListener> mListenerList = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface ThemeSwitchListener {
        void onThemeSwitch(int i);
    }

    public ArrayList<ThemeSwitchListener> getListenerList() {
        return this.mListenerList;
    }

    public synchronized void addThemeSwitchListener(ThemeSwitchListener themeSwitchListener) {
        CollectionUtils.listAdd(this.mListenerList, themeSwitchListener);
    }

    public synchronized void removeThemeSwtichListener(ThemeSwitchListener themeSwitchListener) {
        if (themeSwitchListener != null) {
            this.mListenerList.remove(themeSwitchListener);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList arrayList;
        if (IntentActions.ACTION_XP_THEME_SWITCH.equals(intent.getAction())) {
            final int i = intent.getExtras().getInt("theme");
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                arrayList = new ArrayList(this.mListenerList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                final ThemeSwitchListener themeSwitchListener = (ThemeSwitchListener) it.next();
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.XpThemeSwitchReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis2 = L.ENABLE ? System.currentTimeMillis() : 0L;
                        themeSwitchListener.onThemeSwitch(i);
                        if (L.ENABLE) {
                            L.Tag tag = XpThemeSwitchReceiver.TAG;
                            L.d(tag, L.formatDayNightSwitchLog("ThemeWatcher==>:onReceive onThemeSwitch:" + themeSwitchListener + ", time: " + (System.currentTimeMillis() - currentTimeMillis2) + "ms"));
                        }
                    }
                });
            }
            L.Tag tag = TAG;
            L.i(tag, L.formatDayNightSwitchLog("ThemeWatcher==>:onReceive total time:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, listeners:" + arrayList.size()));
        }
    }

    public void removeListeners() {
        if (CollectionUtils.isNotEmpty(this.mListenerList)) {
            this.mListenerList.clear();
            this.mListenerList = null;
        }
    }
}
