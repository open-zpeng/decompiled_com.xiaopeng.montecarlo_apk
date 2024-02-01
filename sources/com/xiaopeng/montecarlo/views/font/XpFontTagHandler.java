package com.xiaopeng.montecarlo.views.font;

import android.text.Editable;
import android.text.Html;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.xiaopeng.montecarlo.views.span.TextAlignVerticalCenterSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Stack;
import org.xml.sax.XMLReader;
/* loaded from: classes3.dex */
public class XpFontTagHandler implements Html.TagHandler {
    private DisplayMetrics mDisplayMetrics;
    private Stack<String> mPropertyValue;
    private Stack<Integer> mStartIndex;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TagTypeString {
        public static final String XP_FACE = "xpface";
        public static final String XP_SIZE = "xpsize";
        public static final String XP_VCENTER = "xpvcenter";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TagValueString {
        public static final String XP_VALUE = "value";
    }

    public XpFontTagHandler(DisplayMetrics displayMetrics) {
        this.mDisplayMetrics = displayMetrics;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        if (z) {
            handlerStartTAG(str, editable, xMLReader);
        } else {
            handlerEndTAG(str, editable);
        }
    }

    private void handlerStartTAG(String str, Editable editable, XMLReader xMLReader) {
        if (str.equalsIgnoreCase(TagTypeString.XP_SIZE) || str.equalsIgnoreCase(TagTypeString.XP_FACE)) {
            handlerStartValue(editable, xMLReader, "value");
        } else if (str.equalsIgnoreCase(TagTypeString.XP_VCENTER)) {
            handlerStartValue(editable, xMLReader, new String[0]);
        }
    }

    private void handlerEndTAG(String str, Editable editable) {
        if (str.equalsIgnoreCase(TagTypeString.XP_SIZE)) {
            handlerEndSIZE(editable);
        } else if (str.equalsIgnoreCase(TagTypeString.XP_FACE)) {
            handlerEndFAMILY(editable);
        } else if (str.equalsIgnoreCase(TagTypeString.XP_VCENTER)) {
            handlerEndVcenter(editable);
        }
    }

    private void handlerStartValue(Editable editable, XMLReader xMLReader, String... strArr) {
        if (this.mStartIndex == null) {
            this.mStartIndex = new Stack<>();
        }
        this.mStartIndex.push(Integer.valueOf(editable.length()));
        if (this.mPropertyValue == null) {
            this.mPropertyValue = new Stack<>();
        }
        for (String str : strArr) {
            this.mPropertyValue.push(getProperty(xMLReader, str));
        }
    }

    private void handlerEndSIZE(Editable editable) {
        if (isEmpty(this.mPropertyValue)) {
            return;
        }
        try {
            editable.setSpan(new AbsoluteSizeSpan(sp2px(Integer.parseInt(this.mPropertyValue.pop()))), this.mStartIndex.pop().intValue(), editable.length(), 33);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handlerEndVcenter(Editable editable) {
        editable.setSpan(new TextAlignVerticalCenterSpan(), this.mStartIndex.pop().intValue(), editable.length(), 33);
    }

    private void handlerEndFAMILY(Editable editable) {
        if (isEmpty(this.mPropertyValue)) {
            return;
        }
        try {
            editable.setSpan(new TypefaceSpan(this.mPropertyValue.pop()), this.mStartIndex.pop().intValue(), editable.length(), 33);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getProperty(XMLReader xMLReader, String str) {
        return PropertyReaderUtil.getProperty(xMLReader, str);
    }

    public int sp2px(float f) {
        return (int) (TypedValue.applyDimension(2, f, this.mDisplayMetrics) + 0.5f);
    }
}
