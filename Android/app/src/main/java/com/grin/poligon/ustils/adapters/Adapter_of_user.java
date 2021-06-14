package com.grin.poligon.ustils.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.R;
import com.grin.poligon.comunity.OtherUserActivity;
import com.grin.poligon.ustils.models.ModelPredmet;
import com.grin.poligon.ustils.models.Model_of_user;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class Adapter_of_user extends RecyclerView.Adapter<Adapter_of_user.MyHolderCallLog> {

    private Context context;
    private List<Model_of_user> userList;


    public Adapter_of_user(Context context, List<Model_of_user> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyHolderCallLog onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.model_of_user, parent,false);


        return new MyHolderCallLog(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolderCallLog myHolderCallLog, int position) {


        String name = userList.get(position).getName();
        String about = userList.get(position).getAbout();
        String count = userList.get(position).getCount_of_point();
        String image = userList.get(position).getImage();

 //        String type = calllogList.get(position).getType();





        myHolderCallLog.model_of_user_name.setText(name);
        myHolderCallLog.model_of_user_about.setText(about);
        myHolderCallLog.model_of_user_count.setText(count);
        myHolderCallLog.model_of_user_image.setImageDrawable(context.getResources().getDrawable(R.drawable.back1));







   //        myHolderCallLog.typeTv.setText(type);

        myHolderCallLog.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtherUserActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyHolderCallLog extends RecyclerView.ViewHolder{

        private TextView model_of_user_name;
        private TextView model_of_user_about;
        private TextView model_of_user_count;
        private CircleImageView model_of_user_image;

        public MyHolderCallLog(@NonNull View itemView) {
            super(itemView);
            init();




        }
        private void init() {

            model_of_user_name = itemView.findViewById(R.id.model_of_user_name);
            model_of_user_about = itemView.findViewById(R.id.model_of_user_about);
            model_of_user_count = itemView.findViewById(R.id.model_of_user_count);
            model_of_user_image = itemView.findViewById(R.id.model_of_user_image);


        }


    }




}
