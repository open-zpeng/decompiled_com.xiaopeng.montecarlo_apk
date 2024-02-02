package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class ChargePriceAdapter extends BaseAdapter {
    private Context mContext;
    private int mIndex = -1;
    private LayoutInflater mInflater;
    private List<String[]> mList;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ChargePriceAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public void setData(List<String[]> list) {
        this.mList = list;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (CollectionUtils.isEmpty(this.mList)) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (CollectionUtils.isEmpty(this.mList)) {
            return null;
        }
        return this.mList.get(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010a  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.ChargePriceAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private void updateTextAppearance(Context context, XTextView xTextView, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            xTextView.setTextAppearance(context, i);
        } else {
            xTextView.setTextAppearance(i);
        }
    }

    /* loaded from: classes3.dex */
    private class ViewHolder {
        XTextView mTvPrice;
        XTextView mTvPriceExternal;
        XTextView mTvTime;

        private ViewHolder() {
        }
    }
}
