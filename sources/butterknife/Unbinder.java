package butterknife;

import androidx.annotation.UiThread;
/* loaded from: classes.dex */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() { // from class: butterknife.-$$Lambda$Unbinder$aAZZEjRDCcxQlrGZAdKWmLXqruY
        @Override // butterknife.Unbinder
        public final void unbind() {
            Unbinder.lambda$static$0();
        }
    };

    static /* synthetic */ void lambda$static$0() {
    }

    @UiThread
    void unbind();
}
