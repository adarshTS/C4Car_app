package com.arms.c4car.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arms.c4car.DataProviders.HomeMenu;
import com.arms.c4car.R;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;



    public NavigationDrawerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_navigation_drawer, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    holder.title.setText(HomeMenu.titles[position]);
    holder.image.setImageResource(Integer.parseInt(HomeMenu.images[position]));



        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {

            return HomeMenu.titles.length;

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvNavDrawerItem);
            image= (ImageView) itemView.findViewById(R.id.DrawerimageView);

        }
    }
}
