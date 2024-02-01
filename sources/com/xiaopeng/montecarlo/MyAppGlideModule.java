package com.xiaopeng.montecarlo;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.xiaopeng.montecarlo.xpglide.XpGlideCacheHelper;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class MyAppGlideModule extends AppGlideModule {
    private static final int CONNECT_TIME_OUT = 20;
    private static final int READ_TIME_OUT = 20;
    private static final int WRITE_TIME_OUT = 20;
    private OkHttpClient mOkHttpClient = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build();

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        XpGlideCacheHelper.getInstance().wrapWeakRefCache(glide);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(this.mOkHttpClient));
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        super.applyOptions(context, glideBuilder);
        XpGlideCacheHelper xpGlideCacheHelper = XpGlideCacheHelper.getInstance();
        xpGlideCacheHelper.init(context);
        glideBuilder.setMemoryCache(xpGlideCacheHelper.getLruResourceCache());
        glideBuilder.setDiskCache(xpGlideCacheHelper.getDiskCacheFactory());
    }
}
