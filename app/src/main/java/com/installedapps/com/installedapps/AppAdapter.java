package com.installedapps.com.installedapps;

/*
 *  ****************************************************************************
 *  * Created by : Md. Moniruzzaman Monir on 11/16/2018 at 6:52 PM.
 *  * Email : moniruzzaman@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md. Moniruzzaman Monir on 11/16/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder>{
    private List<AppModel> arrayList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AppAdapter( List<AppModel> myDataset) {
        arrayList = myDataset;
    }

    @NonNull
    @Override
    public AppAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mAppName.setText(arrayList.get(position).getName());
        holder.mImageView.setImageDrawable(arrayList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mAppName;
        public ImageView mImageView;
        public MyViewHolder(View v) {
            super(v);
            mAppName = v.findViewById(R.id.list_app_name);
            mImageView = v.findViewById(R.id.app_icon);
        }
    }
}