package net.buildbox.pokeri.ui_recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.buildbox.pokeri.ui_recyclerview.R;
import net.buildbox.pokeri.ui_recyclerview.databinding.SampleListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.ViewHolder>
    implements View.OnClickListener {
    private Context mContext;
    private ArrayList<String> mDataSource;
    private LayoutInflater mInflater;
    private RecyclerView mRecyclerView;

    public SampleRecyclerAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDataSource = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        mRecyclerView = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.sample_list_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mDataSource != null) {
            String item = mDataSource.get(position);
            holder.binding.listItemView.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    public void onClick(View view) {
        int position = mRecyclerView.getChildAdapterPosition(view);
        if (position != RecyclerView.NO_POSITION) {
            String item = mDataSource.get(position);
            Toast.makeText(mContext, item + " がクリックされました", Toast.LENGTH_SHORT).show();
        }
    }

    public void addAll(List<String> items) {
        mDataSource.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        mDataSource.clear();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        SampleListItemBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            binding = SampleListItemBinding.bind(itemView);
        }
    }
}
