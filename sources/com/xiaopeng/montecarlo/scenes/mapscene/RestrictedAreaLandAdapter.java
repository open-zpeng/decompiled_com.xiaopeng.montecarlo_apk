package com.xiaopeng.montecarlo.scenes.mapscene;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity;
import com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictRule;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RestrictedAreaLandAdapter extends BaseAdapter {
    private Context mContext;
    private XPGRestrictCity mGRestrictCity;
    private int mSelectIndex = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public RestrictedAreaLandAdapter(XPGRestrictCity xPGRestrictCity, Context context) {
        this.mGRestrictCity = xPGRestrictCity;
        this.mContext = context;
    }

    public void setSelectIndex(int i) {
        this.mSelectIndex = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        XPGRestrictCity xPGRestrictCity = this.mGRestrictCity;
        if (xPGRestrictCity != null) {
            return xPGRestrictCity.mRuleNums;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        XPGRestrictCity xPGRestrictCity = this.mGRestrictCity;
        if (xPGRestrictCity == null || xPGRestrictCity.mRules == null) {
            return null;
        }
        return this.mGRestrictCity.mRules.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_restricted_area_item_title, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mRuleIndicator = (XImageView) view.findViewById(R.id.restrict_area_rule_indicator);
            viewHolder.mRuleTitle = (XTextView) view.findViewById(R.id.restricted_area_rule_title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        XPGRestrictRule xPGRestrictRule = (XPGRestrictRule) getItem(i);
        if (xPGRestrictRule != null) {
            viewHolder.mRuleTitle.setText(String.format(this.mContext.getResources().getString(R.string.restrict_rule_title), Integer.valueOf(i + 1)));
            XTextView xTextView = (XTextView) view.findViewById(R.id.right_image_title);
            if (xPGRestrictRule.mEffect == 1) {
                xTextView.setVisibility(0);
            } else {
                xTextView.setVisibility(4);
            }
        }
        if (this.mSelectIndex == i) {
            viewHolder.mRuleIndicator.setVisibility(0);
            viewHolder.mRuleTitle.setSelected(true);
        } else {
            viewHolder.mRuleIndicator.setVisibility(8);
            viewHolder.mRuleTitle.setSelected(false);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    static class ViewHolder {
        public XImageView mRuleIndicator;
        public XTextView mRuleTitle;

        ViewHolder() {
        }
    }
}
