package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class LibraryLoader {
    static final String BASE_LIBRARY_NAME = "pl_droidsonroids_gif";
    static final String SURFACE_LIBRARY_NAME = "pl_droidsonroids_gif_surface";
    @SuppressLint({"StaticFieldLeak"})
    private static Context sAppContext;

    private LibraryLoader() {
    }

    public static void initialize(@NonNull Context context) {
        sAppContext = context.getApplicationContext();
    }

    private static Context getContext() {
        if (sAppContext == null) {
            try {
                sAppContext = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return sAppContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void loadLibrary() {
        try {
            System.loadLibrary(BASE_LIBRARY_NAME);
        } catch (UnsatisfiedLinkError unused) {
            ReLinker.loadLibrary(getContext());
        }
    }
}
