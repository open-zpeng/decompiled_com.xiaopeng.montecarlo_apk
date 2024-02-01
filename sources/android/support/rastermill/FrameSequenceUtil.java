package android.support.rastermill;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.rastermill.cache.DiskCache;
import android.support.rastermill.cache.InternalCacheDiskCacheFactory;
import android.widget.ImageView;
import androidx.annotation.MainThread;
/* loaded from: classes.dex */
public class FrameSequenceUtil {
    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, FrameSequenceParams frameSequenceParams) {
        DiskCache.Factory diskCacheFactory = frameSequenceParams != null ? frameSequenceParams.getDiskCacheFactory() : null;
        if (diskCacheFactory == null) {
            diskCacheFactory = new InternalCacheDiskCacheFactory(context);
        }
        CacheEngine.init(context, diskCacheFactory);
    }

    @MainThread
    public static FrameSequenceController with(ImageView imageView) {
        if (imageView == null) {
            throw new NullPointerException("imageView is null");
        }
        return new FrameSequenceController(imageView);
    }

    @MainThread
    public static void destroy(ImageView imageView) {
        destroy(imageView, true);
    }

    @MainThread
    public static void destroy(ImageView imageView, boolean z) {
        FrameSequenceController.cancelTask(imageView);
        if (imageView.getDrawable() instanceof FrameSequenceDrawable) {
            FrameSequenceDrawable frameSequenceDrawable = (FrameSequenceDrawable) imageView.getDrawable();
            String key = FrameSequenceController.getKey(imageView);
            frameSequenceDrawable.setOnFinishedListener(null);
            if (!frameSequenceDrawable.isDestroyed()) {
                frameSequenceDrawable.stop();
                destroy(frameSequenceDrawable, key);
            }
        }
        FrameSequenceController.setImageView(imageView, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void destroy(FrameSequenceDrawable frameSequenceDrawable, String str) {
        if (frameSequenceDrawable == null || frameSequenceDrawable.isDestroyed()) {
            return;
        }
        frameSequenceDrawable.destroy();
        destroy(frameSequenceDrawable.getFrameSequence());
    }

    @MainThread
    protected static void destroy(FrameSequence frameSequence) {
        if (frameSequence == null || frameSequence.isDestroyed()) {
            return;
        }
        frameSequence.destroy();
    }

    @MainThread
    public static void stop(ImageView imageView) {
        FrameSequenceController.cancelTask(imageView);
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof FrameSequenceDrawable) {
            stop((FrameSequenceDrawable) drawable);
        }
    }

    @MainThread
    public static void stop(FrameSequenceDrawable frameSequenceDrawable) {
        if (frameSequenceDrawable == null || frameSequenceDrawable.isDestroyed() || !frameSequenceDrawable.isRunning()) {
            return;
        }
        frameSequenceDrawable.stop();
    }

    @MainThread
    public static void start(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof FrameSequenceDrawable) {
            start((FrameSequenceDrawable) drawable);
        }
    }

    @MainThread
    public static void start(FrameSequenceDrawable frameSequenceDrawable) {
        if (frameSequenceDrawable == null || frameSequenceDrawable.isDestroyed() || frameSequenceDrawable.isRunning()) {
            return;
        }
        frameSequenceDrawable.start();
    }

    @MainThread
    public static void pause(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof FrameSequenceDrawable) {
            pause((FrameSequenceDrawable) drawable);
        }
    }

    @MainThread
    public static void pause(FrameSequenceDrawable frameSequenceDrawable) {
        if (frameSequenceDrawable == null || frameSequenceDrawable.isDestroyed() || !frameSequenceDrawable.isRunning()) {
            return;
        }
        frameSequenceDrawable.pause();
    }

    @MainThread
    public static void resume(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof FrameSequenceDrawable) {
            resume((FrameSequenceDrawable) drawable);
        }
    }

    @MainThread
    public static void resume(FrameSequenceDrawable frameSequenceDrawable) {
        if (frameSequenceDrawable == null || frameSequenceDrawable.isDestroyed() || frameSequenceDrawable.isRunning()) {
            return;
        }
        frameSequenceDrawable.resume();
    }
}
