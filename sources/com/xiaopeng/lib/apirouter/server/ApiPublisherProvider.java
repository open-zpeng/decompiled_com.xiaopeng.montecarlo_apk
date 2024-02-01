package com.xiaopeng.lib.apirouter.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.lib.apirouter.BuildConfig;
/* loaded from: classes.dex */
public class ApiPublisherProvider extends ContentProvider {
    public static Context CONTEXT = null;
    private static final String TAG = "com.xiaopeng.lib.apirouter.server.ApiPublisherProvider";
    private AutoCodeMatcher mMatcher;

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        CONTEXT = getContext();
        this.mMatcher = new AutoCodeMatcher();
        Log.i(TAG, String.format("onCreate version:[%s], pkgName:[%s]", BuildConfig.BUILD_VERSION, CONTEXT.getPackageName()));
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        Pair<IBinder, String> match = this.mMatcher.match(str);
        Bundle bundle2 = new Bundle();
        if (match != null) {
            bundle2.putBinder("binder", (IBinder) match.first);
            bundle2.putString("manifest", (String) match.second);
        }
        return bundle2;
    }

    public static void setContext(Context context) {
        CONTEXT = context;
    }

    public static void addManifestHandler(IManifestHandler iManifestHandler) {
        String str = TAG;
        Log.i(str, "addManifestHandler " + iManifestHandler);
        AutoCodeMatcher.addManifestHandler(iManifestHandler);
    }
}
