package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.xiaopeng.montecarlo.GlideApp;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class IconPageAdapter extends PagerAdapter {
    private ITrafficEventContract.ITrafficEventPopView.ICallBack mCallback;
    private Context mContext;
    private int mIconHeight;
    private int mIconWidth;
    private LayoutInflater mInflater;
    private List<String> mUrls = new ArrayList();

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public IconPageAdapter(Context context, int i, int i2) {
        this.mContext = context;
        this.mIconWidth = i;
        this.mIconHeight = i2;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public void setCallback(ITrafficEventContract.ITrafficEventPopView.ICallBack iCallBack) {
        this.mCallback = iCallBack;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mUrls.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mInflater.inflate(R.layout.layout_traffic_view_pop_icon_item, (ViewGroup) null);
        updateTheme(inflate);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        TrafficIconViewTarget trafficIconViewTarget = new TrafficIconViewTarget((XImageView) inflate.findViewById(R.id.traffic_event_icon), this.mIconWidth, this.mIconHeight, inflate);
        Glide.with(this.mContext).asBitmap().load(this.mUrls.get(i)).apply(RequestOptions.bitmapTransform(new RoundedCorners(16))).into((RequestBuilder<Bitmap>) trafficIconViewTarget);
        inflate.setTag(trafficIconViewTarget);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.IconPageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IconPageAdapter.this.mCallback != null) {
                    IconPageAdapter.this.mCallback.onShowLargePic();
                }
            }
        });
        return inflate;
    }

    private void updateTheme(View view) {
        ((ImageView) view.findViewById(R.id.traffic_failed)).setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.icon_64_normal_ic_failedtoload));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (obj == null) {
            return;
        }
        GlideApp.with(this.mContext).clear((TrafficIconViewTarget) view.getTag());
        viewGroup.removeView(view);
    }

    public void setIconsUrls(List<String> list) {
        this.mUrls = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i) {
        return (getCount() == 1 || i == getCount() - 1) ? 1.0f : 0.7f;
    }

    /* loaded from: classes3.dex */
    private static class TrafficIconViewTarget extends ImageViewTarget<Bitmap> {
        private View mErrorView;
        private int mHeight;
        private ImageView mIcon;
        private View mPlaceHolder;
        private int mWidth;

        public TrafficIconViewTarget(@NonNull ImageView imageView, int i, int i2, View view) {
            super(imageView);
            this.mIcon = imageView;
            this.mPlaceHolder = view.findViewById(R.id.traffic_progress_container);
            this.mErrorView = view.findViewById(R.id.traffic_failed);
            this.mWidth = i;
            this.mHeight = i2;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition transition) {
            this.mIcon.setImageBitmap(bitmap);
            this.mIcon.setVisibility(0);
            this.mPlaceHolder.setVisibility(8);
            this.mErrorView.setVisibility(8);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
            this.mIcon.setVisibility(8);
            this.mPlaceHolder.setVisibility(8);
            this.mErrorView.setVisibility(0);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
            super.onLoadStarted(drawable);
            this.mIcon.setVisibility(8);
            this.mPlaceHolder.setVisibility(0);
            this.mErrorView.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Bitmap bitmap) {
            this.mIcon.setImageBitmap(bitmap);
        }

        @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback) {
            int i;
            int i2 = this.mWidth;
            if (i2 > 0 && (i = this.mHeight) > 0) {
                sizeReadyCallback.onSizeReady(i2, i);
            } else {
                super.getSize(sizeReadyCallback);
            }
        }
    }
}
