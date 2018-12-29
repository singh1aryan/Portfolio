package com.himanshurawat.portfolio.adapterjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.himanshurawat.portfolio.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    public Context context;
    public List<Educ> list;
    public ClickListener listener;

    public Adapter(Context context, List<Educ> list, ClickListener listener){
        this.context = context;
        this.list = list;
        this.listener = listener;
    }
    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.education_recycler_view_item,parent,false);
        return new AdapterViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // for the recycler view
    public interface ClickListener {
        void onClick(View view, int position);
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        EditText school_edittext;


        public AdapterViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
