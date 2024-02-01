package android.support.rastermill;

import android.support.rastermill.loader.ILoader;
import android.support.rastermill.util.ThreadUtils;
import android.util.Pair;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoaderAsyncTask {
    private Runnable mBackground;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private FrameSequenceController mFrameSequenceController;
    private boolean mRelease;

    public LoaderAsyncTask(FrameSequenceController frameSequenceController) {
        this.mFrameSequenceController = frameSequenceController;
    }

    public final void execute() {
        final ILoader loader = this.mFrameSequenceController.getLoader();
        this.mBackground = new Runnable() { // from class: android.support.rastermill.LoaderAsyncTask.1
            @Override // java.lang.Runnable
            public void run() {
                FrameSequenceDrawable frameSequenceDrawable;
                try {
                    frameSequenceDrawable = LoaderAsyncTask.this.mFrameSequenceController.getFrameSequenceDrawable(loader);
                    try {
                        if (LogUtil.isLogEnable()) {
                            LogUtil.e("doInBackground : " + (loader != null ? loader.getKey() : null));
                        }
                    } catch (Throwable unused) {
                        LoaderAsyncTask.this.mCancelled.set(true);
                        LoaderAsyncTask.this.post(loader, frameSequenceDrawable);
                    }
                } catch (Throwable unused2) {
                    frameSequenceDrawable = null;
                }
                LoaderAsyncTask.this.post(loader, frameSequenceDrawable);
            }
        };
        ThreadUtils.postWorker(this.mBackground);
    }

    public final void cancel() {
        this.mCancelled.set(true);
        Runnable runnable = this.mBackground;
        if (runnable != null) {
            ThreadUtils.removeWorker(runnable);
        }
        ILoader loader = this.mFrameSequenceController.getLoader();
        release(loader);
        if (LogUtil.isLogEnable()) {
            String key = loader.getKey();
            LogUtil.e("cancel : " + key);
        }
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void post(final ILoader iLoader, final FrameSequenceDrawable frameSequenceDrawable) {
        ThreadUtils.postMain(new Runnable() { // from class: android.support.rastermill.LoaderAsyncTask.2
            @Override // java.lang.Runnable
            public void run() {
                boolean isCancelled = LoaderAsyncTask.this.isCancelled();
                Pair pair = new Pair(iLoader, frameSequenceDrawable);
                if (isCancelled) {
                    LoaderAsyncTask.this.onCancelled(pair);
                } else {
                    LoaderAsyncTask.this.onPostExecute(pair);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelled(Pair<ILoader, FrameSequenceDrawable> pair) {
        ILoader iLoader = (ILoader) pair.first;
        if (LogUtil.isLogEnable()) {
            String key = iLoader.getKey();
            LogUtil.e("onCancelled : " + key);
        }
        FrameSequenceController.removeTask(this.mFrameSequenceController.getImageView());
        FrameSequenceDrawable frameSequenceDrawable = (FrameSequenceDrawable) pair.second;
        if (frameSequenceDrawable != null) {
            FrameSequenceUtil.destroy(frameSequenceDrawable, iLoader.getKey());
        }
        release(iLoader);
    }

    private void release(ILoader iLoader) {
        if (this.mRelease) {
            return;
        }
        iLoader.release();
        this.mRelease = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPostExecute(Pair<ILoader, FrameSequenceDrawable> pair) {
        ILoader iLoader = (ILoader) pair.first;
        if (LogUtil.isLogEnable()) {
            String key = iLoader != null ? iLoader.getKey() : null;
            LogUtil.e("onPostExecute : " + key);
        }
        FrameSequenceController.removeTask(this.mFrameSequenceController.getImageView());
        this.mFrameSequenceController.applyInternal(iLoader, (FrameSequenceDrawable) pair.second, true);
        release(iLoader);
    }
}
