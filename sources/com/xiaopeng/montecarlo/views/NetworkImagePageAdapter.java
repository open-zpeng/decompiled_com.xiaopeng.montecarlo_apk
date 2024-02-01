package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class NetworkImagePageAdapter extends PagerAdapter {
    private static final L.Tag TAG = new L.Tag("NetworkImagePageAdapter");
    private Context mContext;
    private int mHeight;
    private LayoutInflater mInflater;
    private boolean mIsLarge;
    private NetworkImagePageAdapterListener mListener;
    private List<String> mUrls = new ArrayList();
    private Map<Integer, View> mViewMap = new HashMap();
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface NetworkImagePageAdapterListener {
        void onPageItemClickListener(int i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public NetworkImagePageAdapter(Context context, List<String> list, int i, int i2, boolean z) {
        this.mInflater = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIsLarge = false;
        this.mContext = context;
        this.mUrls.addAll(list);
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsLarge = z;
    }

    public void setListener(NetworkImagePageAdapterListener networkImagePageAdapterListener) {
        this.mListener = networkImagePageAdapterListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mUrls.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = this.mInflater.inflate(R.layout.layout_network_picture_item, (ViewGroup) null, false);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-2, -2));
        inflate.setTag(((XpNetworkImageView) inflate.findViewById(R.id.network_view)).renderPicture(this.mUrls.get(i)));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.NetworkImagePageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NetworkImagePageAdapter.this.mListener != null) {
                    NetworkImagePageAdapter.this.mListener.onPageItemClickListener(i);
                }
            }
        });
        this.mViewMap.put(Integer.valueOf(i), inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj == null) {
            return;
        }
        View view = (View) obj;
        XpNetworkImageViewTarget xpNetworkImageViewTarget = (XpNetworkImageViewTarget) view.getTag();
        if (xpNetworkImageViewTarget != null) {
            xpNetworkImageViewTarget.reset();
        }
        viewGroup.removeView(view);
    }

    public List<String> getIconsUrls() {
        return this.mUrls;
    }

    public void setIconsUrls(List<String> list) {
        this.mUrls.clear();
        this.mUrls.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i) {
        return this.mIsLarge ? 1.0f : 0.7f;
    }

    public void resetImage(int i) {
        XpNetworkImageView xpNetworkImageView;
        View view = this.mViewMap.get(Integer.valueOf(i));
        if (view == null || (xpNetworkImageView = (XpNetworkImageView) view.findViewById(R.id.network_view)) == null) {
            return;
        }
        xpNetworkImageView.resetMatrix();
    }
}
