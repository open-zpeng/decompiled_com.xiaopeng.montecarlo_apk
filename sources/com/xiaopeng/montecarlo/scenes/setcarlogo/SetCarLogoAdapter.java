package com.xiaopeng.montecarlo.scenes.setcarlogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SetCarLogoAdapter extends BaseAdapter {
    private ArrayList<CarLogo> mCarLogos;
    private Context mContext;
    private int mSelectPosition;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public SetCarLogoAdapter(ArrayList<CarLogo> arrayList, Context context, int i) {
        this.mCarLogos = arrayList;
        this.mContext = context;
        this.mSelectPosition = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mCarLogos.size();
    }

    @Override // android.widget.Adapter
    public CarLogo getItem(int i) {
        return this.mCarLogos.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_setting_car_logo_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (XTextView) view.findViewById(R.id.setting_car_logo_item_title);
            viewHolder.mImageview = (XImageView) view.findViewById(R.id.setting_car_logo_item_icon);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CarLogo carLogo = this.mCarLogos.get(i);
        if (i == this.mSelectPosition) {
            view.setSelected(true);
            viewHolder.mTextView.setSelected(true);
            viewHolder.mTextView.setText(this.mContext.getString(R.string.current_selected_car_logo));
            viewHolder.mTextView.setTextColor(ThemeWatcherUtil.getColor(R.color.setting_car_logo_name_select));
            view.setBackground(ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.layer_bg_setting_car_logo_pressed)));
            viewHolder.mImageview.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_bg_xlarge_setting_selected));
        } else {
            viewHolder.mTextView.setText(carLogo.getTitle());
            view.setSelected(false);
            viewHolder.mTextView.setSelected(false);
            viewHolder.mTextView.setTextColor(ThemeWatcherUtil.getColor(R.color.setting_car_logo_name));
            view.setBackground(ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.selector_setting_car_location_icon_bg)));
            viewHolder.mImageview.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_bg_xlarge_setting_normal));
        }
        viewHolder.mImageview.setImageDrawable(ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getDrawableResId(carLogo.getLogoSrc())));
        return view;
    }

    public void update(int i) {
        this.mSelectPosition = i;
        for (int i2 = 0; i2 < this.mCarLogos.size(); i2++) {
            if (this.mCarLogos.get(i2).isSelected() && i2 == i) {
                return;
            }
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    private static class ViewHolder {
        XImageView mImageview;
        XTextView mTextView;

        private ViewHolder() {
        }
    }
}
