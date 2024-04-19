package xiaopeng.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes4.dex */
public class ClipDrawable extends DrawableWrapper {
    private static final int MAX_LEVEL = 10000;
    protected Path mClipPath;
    protected int mRadiusX;
    protected int mRadiusY;
    private Path mTempPath;

    private void init() {
    }

    public ClipDrawable(Drawable drawable) {
        super(drawable);
        init();
    }

    public ClipDrawable() {
        this(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [lombok.launch.PatchFixesHider$Util, android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.reflect.Method, android.graphics.drawable.Drawable] */
    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ?? r1;
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        if (theme != 0) {
            int[] iArr = R.styleable.ClipDrawable;
            r1 = theme.shadowLoadClass(attributeSet);
        } else {
            r1 = resources.obtainAttributes(attributeSet, R.styleable.ClipDrawable);
        }
        ?? findMethod = r1.findMethod(R.styleable.ClipDrawable_android_drawable, null, null);
        if (findMethod != 0) {
            setDrawable(findMethod);
        } else {
            inflateChildDrawable(resources, xmlPullParser, attributeSet, theme);
        }
        this.mRadiusX = r1.getDimensionPixelOffset(R.styleable.ClipDrawable_radius_x, 0);
        this.mRadiusY = r1.getDimensionPixelOffset(R.styleable.ClipDrawable_radius_y, 0);
        r1.recycle();
    }

    private void inflateChildDrawable(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        Drawable drawable = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next == 2) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            setDrawable(drawable);
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        super.onLevelChange(i);
        initPath(i, getBounds());
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        initPath(getLevel(), rect);
    }

    private void initPath(int i, Rect rect) {
        float width = rect.width();
        this.mClipPath = generateRoundRect(rect.left, rect.top, rect.left + (width - (((10000 - i) * width) / 10000.0f)), rect.top + rect.height(), this.mRadiusX, this.mRadiusY);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        drawSliderRect(this.mClipPath, canvas);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, android.graphics.Canvas] */
    protected void drawSliderRect(Path path, Canvas obj) {
        Drawable drawable = getDrawable();
        obj.save();
        obj.clipPath(path);
        drawable.draw(obj);
        ?? obj2 = new Object();
    }

    public Path generateRoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        Path path = this.mTempPath;
        if (path == null) {
            this.mTempPath = new Path();
        } else {
            path.reset();
        }
        this.mTempPath.addRoundRect(f, f2, f3, f4, new float[]{0.0f, 0.0f, f5, f6, f5, f6, 0.0f, 0.0f}, Path.Direction.CW);
        return this.mTempPath;
    }
}
