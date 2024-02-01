package com.xiaopeng.montecarlo.scenes.debugscene;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoListView extends ListView {
    ArrayAdapter<String> mAdapter;
    private Object mItemObj;
    ArrayList<DebugItem> mList;

    public AutoListView(Context context) {
        super(context);
        this.mList = new ArrayList<>();
    }

    public AutoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mList = new ArrayList<>();
    }

    public AutoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mList = new ArrayList<>();
    }

    private void init() {
        init(R.layout.debug_autolist_item, 16908308);
    }

    private void init(int i, int i2) {
        try {
            this.mList.clear();
            this.mList.addAll(DebugItem.createListFromObj(getContext(), this.mItemObj));
            String[] strArr = new String[this.mList.size()];
            for (int i3 = 0; i3 < this.mList.size(); i3++) {
                strArr[i3] = this.mList.get(i3).mName;
            }
            this.mAdapter = new MyArrayAdapter(getContext(), i, i2, strArr);
            setAdapter((ListAdapter) this.mAdapter);
            setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.AutoListView.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                    try {
                        DebugItem debugItem = AutoListView.this.mList.get(i4);
                        Class<?>[] parameterTypes = debugItem.mMethod.getParameterTypes();
                        if (parameterTypes.length == 1 && parameterTypes[0] == View.class) {
                            debugItem.mMethod.invoke(AutoListView.this.mItemObj, view);
                        } else if (parameterTypes.length != 2 || parameterTypes[0] != View.class || parameterTypes[1] != Integer.TYPE) {
                            debugItem.mMethod.invoke(AutoListView.this.mItemObj, new Object[0]);
                        } else {
                            debugItem.mMethod.invoke(AutoListView.this.mItemObj, view, Integer.valueOf(i4));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            setSelector(17301605);
            setDivider(getResources().getDrawable(17301524));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyDataSetChanged() {
        this.mAdapter.notifyDataSetChanged();
    }

    public void setItemObj(Object obj) {
        this.mItemObj = obj;
        init();
    }

    public void setItemObj(Object obj, int i, int i2) {
        this.mItemObj = obj;
        init(i, i2);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class MyArrayAdapter extends ArrayAdapter<String> {
        public MyArrayAdapter(@NonNull Context context, int i) {
            super(context, i);
        }

        public MyArrayAdapter(@NonNull Context context, int i, int i2) {
            super(context, i, i2);
        }

        public MyArrayAdapter(@NonNull Context context, int i, @NonNull String[] strArr) {
            super(context, i, strArr);
        }

        public MyArrayAdapter(@NonNull Context context, int i, int i2, @NonNull String[] strArr) {
            super(context, i, i2, strArr);
        }

        public MyArrayAdapter(@NonNull Context context, int i, @NonNull List<String> list) {
            super(context, i, list);
        }

        public MyArrayAdapter(@NonNull Context context, int i, int i2, @NonNull List<String> list) {
            super(context, i, i2, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            DebugItem debugItem = AutoListView.this.mList.get(i);
            if (debugItem.mInitMethod != null) {
                try {
                    debugItem.mInitMethod.invoke(AutoListView.this.mItemObj, view2, Integer.valueOf(i));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
            return view2;
        }
    }
}
