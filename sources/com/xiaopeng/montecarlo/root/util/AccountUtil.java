package com.xiaopeng.montecarlo.root.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
/* loaded from: classes2.dex */
public class AccountUtil {
    private static final String DATABASE_JOURNAL_SUFFIX = "-journal";

    public static String getLocalDatabaseNameForUser(int i, String str, String str2) {
        String userHandleToString = userHandleToString(i, str);
        if (TextUtils.isEmpty(userHandleToString)) {
            return str2;
        }
        return str2 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + userHandleToString;
    }

    public static String getLocalDatabaseNameForUserId(int i, String str, String str2) {
        String userIdToString = userIdToString(i, str);
        if (TextUtils.isEmpty(userIdToString)) {
            return str2;
        }
        return str2 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + userIdToString;
    }

    @NonNull
    public static String getFavoriteDatabaseNameForUser(int i, String str, String str2, String str3) {
        String userHandleToString = userHandleToString(i, str);
        if (!TextUtils.isEmpty(userHandleToString)) {
            return str2 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + userHandleToString + str3;
        }
        return str2 + str3;
    }

    public static String getDatabaseJournalSuffixName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + DATABASE_JOURNAL_SUFFIX;
    }

    public static String userHandleToString(int i, String str) {
        if (i == 1) {
            return "owner";
        }
        if (i == 3) {
            return "tenant";
        }
        if (i == 2) {
            if (str == null) {
                return "";
            }
            return "" + str;
        } else if (i != 4 || str == null) {
            return "";
        } else {
            return "" + str;
        }
    }

    @NonNull
    public static String getFavoriteDatabaseNameForUserId(int i, String str, String str2, String str3) {
        String userIdToString = userIdToString(i, str);
        if (!TextUtils.isEmpty(userIdToString)) {
            return str2 + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + userIdToString + str3;
        }
        return str2 + str3;
    }

    public static String userIdToString(int i, String str) {
        if (i == 0) {
            return "";
        }
        return "" + str;
    }
}
