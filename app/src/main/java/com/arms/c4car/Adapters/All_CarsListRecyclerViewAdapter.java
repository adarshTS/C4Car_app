package com.arms.c4car.Adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arms.c4car.Entities.DataModel;
import com.arms.c4car.R;

import java.util.List;

/**
 * Created by SHIVAA on 15-10-2016.
 */

public class All_CarsListRecyclerViewAdapter extends RecyclerView.Adapter<All_CarsListRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    public final Context context;
    private List<DataModel> items;
    private OnItemClickListener onItemClickListener;


    public All_CarsListRecyclerViewAdapter(Context context, List<DataModel> items) {
        this.context = context;
        this.items = items;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_items, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DataModel item = items.get(position);

        holder.itemCar_name.setText(context.getResources().getString(R.string.bullet)+" "+item.getCarTitle());

        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(final View v) {
        // Give some time to the ripple to finish the effect
        if (onItemClickListener != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onItemClickListener.onItemClick(v, (DataModel) v.getTag());
                }
            }, 200);
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        // public ImageView image;
        public TextView itemCar_name;



        public ViewHolder(View itemView) {
            super(itemView);

            itemCar_name = (TextView) itemView.findViewById(R.id.textViewCarname);



        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, DataModel viewModel);

    }
}



