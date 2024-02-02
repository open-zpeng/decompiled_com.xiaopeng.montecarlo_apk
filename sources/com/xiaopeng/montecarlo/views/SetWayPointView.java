package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SetWayPointView extends XLinearLayout implements View.OnClickListener {
    private static final int HORIZONTAL = 0;
    private static final L.Tag TAG = new L.Tag("SetWayPointView");
    private static final int VERTICAL = 1;
    private XLinearLayout mContainerAddWayPoint;
    private XLinearLayout mContainerDeleteWayPoint;
    private XLinearLayout mContainerGotoWayPoint;
    private LayoutInflater mInflater;
    private int mInterval;
    private WayPointClickListener mListener;
    private int mOrientation;
    private XTextView mTvAddWayPoint;
    private XTextView mTvDeleteWayPoint;
    private XTextView mTvGotoWayPoint;

    /* loaded from: classes3.dex */
    public interface WayPointClickListener {
        void onClickAddWayPoint(View view);

        void onClickDeleteWayPoint(View view);

        void onClickGotoWayPoint(View view);
    }

    public XLinearLayout getContainerAddWayPoint() {
        return this.mContainerAddWayPoint;
    }

    public XLinearLayout getContainerDeleteWayPoint() {
        return this.mContainerDeleteWayPoint;
    }

    public XLinearLayout getContainerGotoWayPoint() {
        return this.mContainerGotoWayPoint;
    }

    public String getAddWaypointText() {
        XTextView xTextView = this.mTvAddWayPoint;
        if (xTextView != null) {
            return xTextView.getText().toString();
        }
        return null;
    }

    public String getDeleteWaypointText() {
        XTextView xTextView = this.mTvDeleteWayPoint;
        if (xTextView != null) {
            return xTextView.getText().toString();
        }
        return null;
    }

    public String getGotoWaypointText() {
        XTextView xTextView = this.mTvGotoWayPoint;
        if (xTextView != null) {
            return xTextView.getText().toString();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mListener == null) {
            return;
        }
        int id = view.getId();
        if (id != R.id.container_add_waypoint) {
            if (id == R.id.container_delete_waypoint) {
                this.mListener.onClickDeleteWayPoint(view);
                return;
            } else if (id != R.id.container_goto_waypoint) {
                return;
            } else {
                this.mListener.onClickGotoWayPoint(view);
                return;
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onClick this:" + this);
        }
        this.mListener.onClickAddWayPoint(view);
    }

    public SetWayPointView(Context context) {
        super(context);
    }

    public SetWayPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SetWayPointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet, i);
    }

    public void setListener(WayPointClickListener wayPointClickListener) {
        this.mListener = wayPointClickListener;
    }

    private void initView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this.mInflater = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SetWayPointView, i, 0);
        if (obtainStyledAttributes != null) {
            this.mOrientation = obtainStyledAttributes.getInt(1, 0);
            this.mInterval = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
        this.mContainerAddWayPoint = (XLinearLayout) this.mInflater.inflate(R.layout.layout_add_waypoint, (ViewGroup) this, false);
        this.mTvAddWayPoint = (XTextView) this.mContainerAddWayPoint.findViewById(R.id.tv_add_waypoint);
        this.mContainerDeleteWayPoint = (XLinearLayout) this.mInflater.inflate(R.layout.layout_delete_waypoint, (ViewGroup) this, false);
        this.mTvDeleteWayPoint = (XTextView) this.mContainerDeleteWayPoint.findViewById(R.id.tv_delete_waypoint);
        this.mContainerGotoWayPoint = (XLinearLayout) this.mInflater.inflate(R.layout.layout_goto_waypoint, (ViewGroup) this, false);
        this.mTvGotoWayPoint = (XTextView) this.mContainerGotoWayPoint.findViewById(R.id.tv_goto_waypoint);
        this.mContainerAddWayPoint.setOnClickListener(this);
        this.mContainerDeleteWayPoint.setOnClickListener(this);
        this.mContainerGotoWayPoint.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainerGotoWayPoint.getLayoutParams();
        if (this.mOrientation == 0) {
            setOrientation(0);
            layoutParams.leftMargin = this.mInterval;
        } else {
            setOrientation(1);
            layoutParams.topMargin = this.mInterval;
        }
        removeAllViews();
        addView(this.mContainerAddWayPoint);
        addView(this.mContainerDeleteWayPoint);
        addView(this.mContainerGotoWayPoint, layoutParams);
    }
}
