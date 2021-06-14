package com.grin.poligon.ustils.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.R;
import com.grin.poligon.adaptation.CourseActivity;
import com.grin.poligon.ustils.models.Model_of_cource;

import java.util.List;

public class Adapter_of_coorce extends RecyclerView.Adapter<Adapter_of_coorce.MyHolder_of_coorce> {

    private Context context;
    private List<Model_of_cource> predmetList;


    public Adapter_of_coorce(Context context, List<Model_of_cource> predmetList) {
        this.context = context;
        this.predmetList = predmetList;
    }

    @NonNull
    @Override
    public Adapter_of_coorce.MyHolder_of_coorce onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.model_of_obozn, parent,false);


        return new Adapter_of_coorce.MyHolder_of_coorce(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter_of_coorce.MyHolder_of_coorce myHolderCallLog, int position) {


         myHolderCallLog.img_for_model_of_course_image.setImageDrawable(context.getResources().getDrawable(predmetList.get(position).getImage_res()));
        myHolderCallLog.tv_for_model_of_course_name.setText(predmetList.get(position).getName());
        myHolderCallLog.lin_l_model_of_course_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CourseActivity.class));

            //      context.startActivity(new Intent(context, MainActivity.class));
           //       context.startActivity(new Intent(context, PlayerActivity.class));

            }
        });


//        String name = predmetList.get(position).getName();
//        String time = predmetList.get(position).getTime()+" минут";
//        Integer color = predmetList.get(position).getColor();
        //        String type = calllogList.get(position).getType();

//        myHolderCallLog.lin_l_model_of_result_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (myHolderCallLog.card_view_model_of_result_is_selected.getVisibility()==View.VISIBLE){
//                    myHolderCallLog.card_view_model_of_result_is_selected.setVisibility(View.INVISIBLE);
//                }else
//                    myHolderCallLog.card_view_model_of_result_is_selected.setVisibility(View.VISIBLE);
//
//            }
//        });




//        myHolderCallLog.name_tv.setText(String.valueOf(name));
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

    class MyHolder_of_coorce extends RecyclerView.ViewHolder{

        private TextView tv_for_model_of_course_name;
        private TextView tv_for_about_of_many_coources_model;
        private RecyclerView recycler_for_many_coures;
        private LinearLayout lin_l_model_of_course_main;
        private ImageView img_for_model_of_course_image;


        public MyHolder_of_coorce(@NonNull View itemView) {
            super(itemView);
            init();




        }
        private void init() {
            lin_l_model_of_course_main = itemView.findViewById(R.id.lin_l_model_of_course_main);
            img_for_model_of_course_image = itemView.findViewById(R.id.img_for_model_of_course_image);
            tv_for_model_of_course_name = itemView.findViewById(R.id.tv_for_model_of_course_name);



        }


    }



}
