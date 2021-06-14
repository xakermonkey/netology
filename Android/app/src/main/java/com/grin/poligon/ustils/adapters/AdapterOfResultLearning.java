package com.grin.poligon.ustils.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.R;
import com.grin.poligon.ustils.models.ModelOfResultLearning;

import java.util.List;

public class AdapterOfResultLearning  extends RecyclerView.Adapter<AdapterOfResultLearning.MyHolderOfResultLearning> {

    private Context context;
    private List<ModelOfResultLearning> predmetList;


    public AdapterOfResultLearning(Context context, List<ModelOfResultLearning> predmetList) {
        this.context = context;
        this.predmetList = predmetList;
    }

    @NonNull
    @Override
    public AdapterOfResultLearning.MyHolderOfResultLearning onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.model_of_result_learning, parent,false);


        return new AdapterOfResultLearning.MyHolderOfResultLearning(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterOfResultLearning.MyHolderOfResultLearning myHolderCallLog, int position) {


        String name = predmetList.get(position).getName_of_result();
//        String time = predmetList.get(position).getTime()+" минут";
//        Integer color = predmetList.get(position).getColor();
        //        String type = calllogList.get(position).getType();

        myHolderCallLog.lin_l_model_of_result_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myHolderCallLog.card_view_model_of_result_is_selected.getVisibility()==View.VISIBLE){
                    myHolderCallLog.card_view_model_of_result_is_selected.setVisibility(View.INVISIBLE);
                }else
                    myHolderCallLog.card_view_model_of_result_is_selected.setVisibility(View.VISIBLE);

            }
        });



        myHolderCallLog.name_tv.setText(String.valueOf(name));
//        myHolderCallLog.time_tv.setText(String.valueOf(time));
//        myHolderCallLog.cardView.setCardBackgroundColor(color);
//        //        myHolderCallLog.typeTv.setText(type);

//        MyHolderOfResultLearning.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return predmetList.size();
    }

    class MyHolderOfResultLearning extends RecyclerView.ViewHolder{

         private TextView name_tv;
   //     private TextView time_tv;
        CardView card_view_model_of_result_is_selected;
        LinearLayout lin_l_model_of_result_main;

        public MyHolderOfResultLearning(@NonNull View itemView) {
            super(itemView);
            init();




        }
        private void init() {

            name_tv = itemView.findViewById(R.id.main_text_of_model_of_predlozenie);
         //   time_tv = itemView.findViewById(R.id.model_of_obozn_time_tv);
            card_view_model_of_result_is_selected = itemView.findViewById(R.id.card_view_model_of_result_is_selected);
            lin_l_model_of_result_main = itemView.findViewById(R.id.lin_l_model_of_result_main);


        }


    }




}
