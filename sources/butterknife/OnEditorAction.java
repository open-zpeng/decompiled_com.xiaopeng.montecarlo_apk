package butterknife;

import androidx.annotation.IdRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = "false", name = "onEditorAction", parameters = {"android.widget.TextView", "int", "android.view.KeyEvent"}, returnType = TypedValues.Custom.S_BOOLEAN)}, setter = "setOnEditorActionListener", targetType = "android.widget.TextView", type = "android.widget.TextView.OnEditorActionListener")
/* loaded from: classes.dex */
public @interface OnEditorAction {
    @IdRes
    int[] value() default {-1};
}
