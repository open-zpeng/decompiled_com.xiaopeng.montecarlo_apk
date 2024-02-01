package com.dingtalk.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.dingtalk.bifrost.Bifrost;
import com.dingtalk.bifrost.BifrostEnvUtils;
import com.dingtalk.mobile.common.transport.utils.BifrostLogCatUtil;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public class Alarm extends BroadcastReceiver {
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final String TAG = "bifrost.Alarm";
    private static TreeSet<Object[]> alarm_waiting_set = new TreeSet<>(new ComparatorAlarm());
    private static Alarm bc_alarm;
    private static WakerLock wakerlock;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TSetData {
        ID,
        WAITTIME,
        PENDINGINTENT
    }

    private native void onAlarm(long j);

    /* loaded from: classes2.dex */
    private static class ComparatorAlarm implements Comparator<Object[]> {
        private ComparatorAlarm() {
        }

        @Override // java.util.Comparator
        public int compare(Object[] objArr, Object[] objArr2) {
            return (int) (((Long) objArr[TSetData.ID.ordinal()]).longValue() - ((Long) objArr2[TSetData.ID.ordinal()]).longValue());
        }
    }

    public static void resetAlarm(Context context) {
        synchronized (alarm_waiting_set) {
            if (context == null) {
                context = BifrostEnvUtils.getContext();
            }
            Iterator<Object[]> it = alarm_waiting_set.iterator();
            while (it.hasNext()) {
                cancelAlarmMgr(context, (PendingIntent) it.next()[TSetData.PENDINGINTENT.ordinal()]);
            }
            alarm_waiting_set.clear();
            if (bc_alarm != null) {
                context.unregisterReceiver(bc_alarm);
                bc_alarm = null;
            }
        }
    }

    public static boolean start(long j, int i, Context context) {
        try {
            if (Bifrost.getSwchmng().enableBifrostUseAlarm()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (i < 0) {
                    return false;
                }
                if (context == null) {
                    context = BifrostEnvUtils.getContext();
                }
                if (context == null) {
                    return false;
                }
                synchronized (alarm_waiting_set) {
                    if (wakerlock == null) {
                        wakerlock = new WakerLock(context);
                        BifrostLogCatUtil.info(TAG, "start new wakerlock");
                    }
                    if (bc_alarm == null) {
                        bc_alarm = new Alarm();
                        Alarm alarm = bc_alarm;
                        context.registerReceiver(alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
                    }
                    Iterator<Object[]> it = alarm_waiting_set.iterator();
                    while (it.hasNext()) {
                        if (((Long) it.next()[TSetData.ID.ordinal()]).longValue() == j) {
                            return false;
                        }
                    }
                    if (i >= 0) {
                        elapsedRealtime += i;
                    }
                    PendingIntent alarmMgr = setAlarmMgr(j, elapsedRealtime, context);
                    if (alarmMgr == null) {
                        return false;
                    }
                    alarm_waiting_set.add(new Object[]{Long.valueOf(j), Long.valueOf(elapsedRealtime), alarmMgr});
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            BifrostLogCatUtil.error(TAG, "start error", th);
            return false;
        }
    }

    public static boolean stop(long j, Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "stop error", th);
            }
        }
        if (context == null) {
            BifrostLogCatUtil.error(TAG, "context==null");
            return false;
        }
        synchronized (alarm_waiting_set) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context);
                BifrostLogCatUtil.info(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                context.registerReceiver(bc_alarm, new IntentFilter());
                BifrostLogCatUtil.info(TAG, "stop new Alarm");
            }
            Iterator<Object[]> it = alarm_waiting_set.iterator();
            while (it.hasNext()) {
                Object[] next = it.next();
                if (((Long) next[TSetData.ID.ordinal()]).longValue() == j) {
                    cancelAlarmMgr(context, (PendingIntent) next[TSetData.PENDINGINTENT.ordinal()]);
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    private static PendingIntent setAlarmMgr(long j, long j2, Context context) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "setAlarmMgr error", th);
                return null;
            }
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            BifrostLogCatUtil.error(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
        intent.putExtra("ID", j);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) j, intent, 268435456);
        if (Build.VERSION.SDK_INT < 19) {
            alarmManager.set(2, j2, broadcast);
        } else {
            alarmManager.setExact(2, j2, broadcast);
        }
        return broadcast;
    }

    private static boolean cancelAlarmMgr(Context context, PendingIntent pendingIntent) {
        if (context == null) {
            try {
                context = BifrostEnvUtils.getContext();
            } catch (Throwable th) {
                BifrostLogCatUtil.error(TAG, "cancelAlarmMgr error", th);
                return false;
            }
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            BifrostLogCatUtil.error(TAG, "am == null");
            return false;
        } else if (pendingIntent == null) {
            BifrostLogCatUtil.error(TAG, "pendingIntent == null");
            return false;
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
            return true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            Long valueOf = Long.valueOf(intent.getLongExtra("ID", 0L));
            boolean z = false;
            Integer valueOf2 = Integer.valueOf(intent.getIntExtra(KEXTRA_PID, 0));
            if (0 == valueOf.longValue() || valueOf2.intValue() == 0 || valueOf2.intValue() != Process.myPid()) {
                return;
            }
            synchronized (alarm_waiting_set) {
                Iterator<Object[]> it = alarm_waiting_set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((Long) it.next()[TSetData.ID.ordinal()]).equals(valueOf)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
            }
            if (wakerlock != null) {
                wakerlock.lock(200L);
            }
            if (z) {
                onAlarm(valueOf.longValue());
            }
        } catch (Throwable th) {
            BifrostLogCatUtil.error(TAG, "onReceive error", th);
        }
    }
}
