package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class HistoryRouteView extends XLinearLayout {
    private static final L.Tag TAG = new L.Tag("HistoryRouteView");
    private XImageView mIvRouteTimeLine;
    private HistoryRecordInfo mRecordInfo;
    private XTextView mTvDestName;
    private XTextView mTvVia1Name;
    private XTextView mTvVia2Name;
    private XTextView mTvVia3Name;

    public HistoryRouteView(Context context) {
        super(context);
        initView();
    }

    public HistoryRouteView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public HistoryRouteView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public XTextView getTvDestName() {
        return this.mTvDestName;
    }

    public XTextView getTvVia1Name() {
        return this.mTvVia1Name;
    }

    public XTextView getTvVia2Name() {
        return this.mTvVia2Name;
    }

    public XTextView getTvVia3Name() {
        return this.mTvVia3Name;
    }

    public HistoryRecordInfo getRecordInfo() {
        return this.mRecordInfo;
    }

    private void initView() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_history_route, (ViewGroup) this, true);
        this.mIvRouteTimeLine = (XImageView) viewGroup.findViewById(R.id.iv_route_time_line);
        this.mTvDestName = (XTextView) viewGroup.findViewById(R.id.tv_dest_name);
        this.mTvVia1Name = (XTextView) viewGroup.findViewById(R.id.tv_via_name1);
        this.mTvVia2Name = (XTextView) viewGroup.findViewById(R.id.tv_via_name2);
        this.mTvVia3Name = (XTextView) viewGroup.findViewById(R.id.tv_via_name3);
    }

    public void updateContent(HistoryRecordInfo historyRecordInfo) {
        if (historyRecordInfo == null || historyRecordInfo.getXPPoiInfo() == null) {
            L.Tag tag = TAG;
            L.w(tag, "updateContent data error recordInfo:" + historyRecordInfo);
            return;
        }
        this.mRecordInfo = historyRecordInfo;
        String key = historyRecordInfo.getXPPoiInfo().getKey();
        setTitle(this.mTvDestName, "", historyRecordInfo.getXPPoiInfo().getName(), key);
        List<XPPoiInfo> viaPois = historyRecordInfo.getViaPois();
        if (CollectionUtils.isEmpty(viaPois)) {
            L.Tag tag2 = TAG;
            L.w(tag2, "updateContent data error viaPois:" + viaPois);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIvRouteTimeLine.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = 0;
            this.mIvRouteTimeLine.setLayoutParams(layoutParams);
        }
        if (viaPois.size() == 1) {
            this.mTvVia1Name.setVisibility(0);
            this.mTvVia2Name.setVisibility(8);
            this.mTvVia3Name.setVisibility(8);
            if (viaPois.get(0) != null) {
                setTitle(this.mTvVia1Name, ContextUtils.getString(R.string.search_history_via1), viaPois.get(0).getName(), key);
            }
        } else if (viaPois.size() == 2) {
            this.mTvVia1Name.setVisibility(0);
            this.mTvVia2Name.setVisibility(0);
            this.mTvVia3Name.setVisibility(8);
            if (viaPois.get(1) != null) {
                setTitle(this.mTvVia1Name, ContextUtils.getString(R.string.search_history_via2), viaPois.get(1).getName(), key);
            }
            if (viaPois.get(0) != null) {
                setTitle(this.mTvVia2Name, ContextUtils.getString(R.string.search_history_via1), viaPois.get(0).getName(), key);
            }
        } else {
            this.mTvVia1Name.setVisibility(0);
            this.mTvVia2Name.setVisibility(0);
            this.mTvVia3Name.setVisibility(0);
            if (viaPois.get(2) != null) {
                setTitle(this.mTvVia1Name, ContextUtils.getString(R.string.search_history_via3), viaPois.get(2).getName(), key);
            }
            if (viaPois.get(1) != null) {
                setTitle(this.mTvVia2Name, ContextUtils.getString(R.string.search_history_via2), viaPois.get(1).getName(), key);
            }
            if (viaPois.get(0) != null) {
                setTitle(this.mTvVia3Name, ContextUtils.getString(R.string.search_history_via1), viaPois.get(0).getName(), key);
            }
        }
        drawTimeLine();
    }

    private void setTitle(TextView textView, String str, String str2, String str3) {
        if (textView == null || str == null || str2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str3) && str2.contains(str3)) {
            SpannableString spannableString = new SpannableString(str + str2);
            int color = ThemeWatcherUtil.getColor(R.color.common_blue);
            int indexOf = str2.indexOf(str3) + str.length();
            spannableString.setSpan(new ForegroundColorSpan(color), indexOf, str3.length() + indexOf, 33);
            textView.setText(spannableString);
            return;
        }
        textView.setText(str + str2);
    }

    private void drawTimeLine() {
        XTextView xTextView = this.mTvDestName;
        if (xTextView == null) {
            return;
        }
        xTextView.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.HistoryRouteView.1
            @Override // java.lang.Runnable
            public void run() {
                int bottom = HistoryRouteView.this.mTvVia1Name.getBottom();
                if (HistoryRouteView.this.mTvVia2Name.getVisibility() == 0 && HistoryRouteView.this.mTvVia2Name.getBottom() > bottom) {
                    bottom = HistoryRouteView.this.mTvVia2Name.getBottom();
                }
                if (HistoryRouteView.this.mTvVia3Name.getVisibility() == 0 && HistoryRouteView.this.mTvVia3Name.getBottom() > bottom) {
                    bottom = HistoryRouteView.this.mTvVia3Name.getBottom();
                }
                Bitmap createBitmap = Bitmap.createBitmap(HistoryRouteView.this.mIvRouteTimeLine.getWidth(), bottom, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setColor(ThemeWatcherUtil.getColor(R.color.history_route_timeline_color));
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setStrokeWidth(2.0f);
                int width = HistoryRouteView.this.mIvRouteTimeLine.getWidth() / 2;
                DashPathEffect dashPathEffect = new DashPathEffect(new float[]{2.0f, 4.0f}, 0.0f);
                paint.setStyle(Paint.Style.FILL);
                float f = width;
                canvas.drawCircle(f, HistoryRouteView.this.mTvDestName.getTop() + (HistoryRouteView.this.mTvDestName.getHeight() / 2), f, paint);
                paint.setStyle(Paint.Style.STROKE);
                paint.setPathEffect(dashPathEffect);
                canvas.drawLine(f, HistoryRouteView.this.mTvDestName.getTop() + (HistoryRouteView.this.mTvDestName.getHeight() / 2) + width, f, (HistoryRouteView.this.mTvVia1Name.getTop() + (HistoryRouteView.this.mTvVia1Name.getHeight() / 2)) - width, paint);
                paint.setPathEffect(null);
                float f2 = width - 1;
                canvas.drawCircle(f, HistoryRouteView.this.mTvVia1Name.getTop() + (HistoryRouteView.this.mTvVia1Name.getHeight() / 2), f2, paint);
                if (HistoryRouteView.this.mTvVia2Name.getVisibility() == 0) {
                    paint.setPathEffect(dashPathEffect);
                    canvas.drawLine(f, HistoryRouteView.this.mTvVia1Name.getTop() + (HistoryRouteView.this.mTvVia1Name.getHeight() / 2) + width, f, (HistoryRouteView.this.mTvVia2Name.getTop() + (HistoryRouteView.this.mTvVia2Name.getHeight() / 2)) - width, paint);
                    paint.setPathEffect(null);
                    canvas.drawCircle(f, HistoryRouteView.this.mTvVia2Name.getTop() + (HistoryRouteView.this.mTvVia2Name.getHeight() / 2), f2, paint);
                }
                if (HistoryRouteView.this.mTvVia3Name.getVisibility() == 0) {
                    paint.setPathEffect(dashPathEffect);
                    canvas.drawLine(f, HistoryRouteView.this.mTvVia2Name.getTop() + (HistoryRouteView.this.mTvVia2Name.getHeight() / 2) + width, f, (HistoryRouteView.this.mTvVia3Name.getTop() + (HistoryRouteView.this.mTvVia3Name.getHeight() / 2)) - width, paint);
                    paint.setPathEffect(null);
                    canvas.drawCircle(f, HistoryRouteView.this.mTvVia3Name.getTop() + (HistoryRouteView.this.mTvVia3Name.getHeight() / 2), f2, paint);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) HistoryRouteView.this.mIvRouteTimeLine.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = HistoryRouteView.this.getHeight();
                    HistoryRouteView.this.mIvRouteTimeLine.setLayoutParams(layoutParams);
                }
                HistoryRouteView.this.mIvRouteTimeLine.setImageBitmap(createBitmap);
            }
        });
    }
}
