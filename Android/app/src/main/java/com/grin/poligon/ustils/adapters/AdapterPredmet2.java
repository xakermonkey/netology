package com.grin.poligon.ustils.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.grin.poligon.R;
import com.grin.poligon.ustils.models.ModelPredmet;

import java.util.List;


public class AdapterPredmet2 extends RecyclerView.Adapter<AdapterPredmet2.MyHolderCallLog> {

    private Context context;
    private List<ModelPredmet> predmetList;


    public AdapterPredmet2(Context context, List<ModelPredmet> predmetList) {
        this.context = context;
        this.predmetList = predmetList;
    }

    @NonNull
    @Override
    public MyHolderCallLog onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.model_of_obozn2, parent,false);


        return new MyHolderCallLog(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolderCallLog myHolderCallLog, int position) {


        String name = predmetList.get(position).getName();
        String time = predmetList.get(position).getTime()+" руб/час";
        Integer color = predmetList.get(position).getColor();
 //        String type = calllogList.get(position).getType();




        myHolderCallLog.name_tv.setText(String.valueOf(name));
        myHolderCallLog.time_tv.setText(String.valueOf(time));
        myHolderCallLog.cardView.setCardBackgroundColor(color);
 //        myHolderCallLog.typeTv.setText(type);

        myHolderCallLog.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return predmetList.size();
    }

    class MyHolderCallLog extends RecyclerView.ViewHolder{

        private TextView name_tv;
        private TextView time_tv;
        CardView cardView;

        public MyHolderCallLog(@NonNull View itemView) {
            super(itemView);
            init();




        }
        private void init() {

            name_tv = itemView.findViewById(R.id.model_of_obozn_name_tv);
            time_tv = itemView.findViewById(R.id.model_of_obozn_time_tv);
            cardView = itemView.findViewById(R.id.model_of_obozn_cv);


        }


    }




}
