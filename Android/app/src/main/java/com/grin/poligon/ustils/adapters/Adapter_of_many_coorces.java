package com.grin.poligon.ustils.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.R;
import com.grin.poligon.ustils.models.Model_of_cource;
import com.grin.poligon.ustils.models.Model_of_many_coorces;

import java.util.ArrayList;
import java.util.List;

public class Adapter_of_many_coorces extends RecyclerView.Adapter<Adapter_of_many_coorces.MyHolder_of_many_coorces> {

    private Context context;
    private List<Model_of_many_coorces> predmetList;


    public Adapter_of_many_coorces(Context context, List<Model_of_many_coorces> predmetList) {
        this.context = context;
        this.predmetList = predmetList;
    }

    @NonNull
    @Override
    public Adapter_of_many_coorces.MyHolder_of_many_coorces onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.model_of_many_cources, parent,false);


        return new Adapter_of_many_coorces.MyHolder_of_many_coorces(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter_of_many_coorces.MyHolder_of_many_coorces myHolderCallLog, int position) {





        Adapter_of_coorce adapterCalllog;
        List<Model_of_cource> modelPredmet;

        modelPredmet = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        myHolderCallLog.recycler_for_many_coures.setLayoutManager(linearLayoutManager);





        if (position==0){

            myHolderCallLog.tv_for_name_of_many_coources_model.setText("IT-специалист");
            myHolderCallLog.tv_for_about_of_many_coources_model.setText("Станьте специалистом в области IT");
            modelPredmet.add(new Model_of_cource(R.drawable.vs2,"Пентест"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs6,"C#"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs7,"C++"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs8,"С"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs11,"Product-managment"));

        }if (position ==1){
            myHolderCallLog.tv_for_name_of_many_coources_model.setText("Mobile-разработчик");
            modelPredmet.add(new Model_of_cource(R.drawable.vs4,"Java"));

            modelPredmet.add(new Model_of_cource(R.drawable.vs12,"Android"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs3,"Web-разработка"));
            myHolderCallLog.tv_for_about_of_many_coources_model.setText("Разрабатывайте приложения на Android");

        }if (position==2){
            myHolderCallLog.tv_for_name_of_many_coources_model.setText("HTML-верстальщик");
            myHolderCallLog.tv_for_about_of_many_coources_model.setText("Создавайте лучший дизайн");
            modelPredmet.add(new Model_of_cource(R.drawable.vs1,"HTML-вёрстка"));
            modelPredmet.add(new Model_of_cource(R.drawable.vs10,"JavaScript"));

            modelPredmet.add(new Model_of_cource(R.drawable.vs9,"Ruby"));


        }




        modelPredmet.add(new Model_of_cource(R.drawable.vs5,"Python"));





        adapterCalllog = new Adapter_of_coorce(context, modelPredmet);

        myHolderCallLog.recycler_for_many_coures.setAdapter(adapterCalllog);



        adapterCalllog.notifyDataSetChanged();


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

    class MyHolder_of_many_coorces extends RecyclerView.ViewHolder{

        private TextView tv_for_name_of_many_coources_model;
        private TextView tv_for_about_of_many_coources_model;
        private RecyclerView recycler_for_many_coures;


        public MyHolder_of_many_coorces(@NonNull View itemView) {
            super(itemView);
            init();




        }
        private void init() {

            tv_for_name_of_many_coources_model = itemView.findViewById(R.id.tv_for_name_of_many_coources_model);
            tv_for_about_of_many_coources_model = itemView.findViewById(R.id.tv_for_about_of_many_coources_model);
            recycler_for_many_coures = itemView.findViewById(R.id.recycler_for_many_coures);


        }


    }




}
