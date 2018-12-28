package com.himanshurawat.portfolio.adapterjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.himanshurawat.portfolio.R;
import com.himanshurawat.portfolio.ui.MainActivityContract;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    public Context context;
//    public List<Educ> list;
    public ClickListener listener;

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.educ_recycler_layout,parent,false);
        return new AdapterViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    // for the recycler view
    public interface ClickListener {
        void onClick(View view, int position);
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{




        public AdapterViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
