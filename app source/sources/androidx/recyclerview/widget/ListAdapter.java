package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncListDiffer<T> mHelper;

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        AsyncListDiffer<T> asyncListDiffer;
        ListUpdateCallback listUpdateCallback;
        AsyncDifferConfig.Builder builder;
        new AdapterListUpdateCallback(this);
        new AsyncDifferConfig.Builder(diffCallback);
        new AsyncListDiffer<>(listUpdateCallback, builder.build());
        this.mHelper = asyncListDiffer;
    }

    protected ListAdapter(@NonNull AsyncDifferConfig<T> config) {
        AsyncListDiffer<T> asyncListDiffer;
        ListUpdateCallback listUpdateCallback;
        new AdapterListUpdateCallback(this);
        new AsyncListDiffer<>(listUpdateCallback, config);
        this.mHelper = asyncListDiffer;
    }

    public void submitList(@Nullable List<T> list) {
        this.mHelper.submitList(list);
    }

    /* access modifiers changed from: protected */
    public T getItem(int position) {
        return this.mHelper.getCurrentList().get(position);
    }

    public int getItemCount() {
        return this.mHelper.getCurrentList().size();
    }
}
