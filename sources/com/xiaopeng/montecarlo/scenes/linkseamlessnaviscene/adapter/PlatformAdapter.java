package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.bean.PlatformItem;
import com.xiaopeng.xui.widget.XImageView;
import java.util.List;
/* loaded from: classes2.dex */
public class PlatformAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnClickListener mOnClickListener;
    private List<PlatformItem> mPlatformList;

    /* loaded from: classes2.dex */
    public interface OnClickListener {
        void onClick(int i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public XImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (XImageView) view.findViewById(R.id.iv_platform);
        }
    }

    public PlatformAdapter(List<PlatformItem> list) {
        this.mPlatformList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_platform, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.imageView.setImageResource(this.mPlatformList.get(i).mResId);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.adapter.PlatformAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PlatformAdapter.this.mOnClickListener != null) {
                    PlatformAdapter.this.mOnClickListener.onClick(((PlatformItem) PlatformAdapter.this.mPlatformList.get(i)).mPlatformType);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<PlatformItem> list = this.mPlatformList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
