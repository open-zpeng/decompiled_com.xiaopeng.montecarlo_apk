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
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [void, android.graphics.drawable.Drawable] */
    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ?? obj;
        ?? r2;
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        if (theme != null) {
            obj = theme.obtainStyledAttributes(attributeSet, R.styleable.ClipDrawable, 0, 0);
        } else {
            obj = resources.obtainAttributes(attributeSet, R.styleable.ClipDrawable);
        }
        int i = R.styleable.ClipDrawable_android_drawable;
        obj = new Object();
        if (r2 != 0) {
            setDrawable(r2);
        } else {
            inflateChildDrawable(resources, xmlPullParser, attributeSet, theme);
        }
        this.mRadiusX = obj.getDimensionPixelOffset(R.styleable.ClipDrawable_radius_x, 0);
        this.mRadiusY = obj.getDimensionPixelOffset(R.styleable.ClipDrawable_radius_y, 0);
        obj.recycle();
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

    protected void drawSliderRect(Path path, Canvas canvas) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.clipPath(path);
        drawable.draw(canvas);
        canvas.restore();
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
