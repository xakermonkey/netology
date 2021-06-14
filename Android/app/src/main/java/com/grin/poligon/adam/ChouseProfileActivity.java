package com.grin.poligon.adam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.grin.poligon.R;
import com.grin.poligon.ustils.adapters.AdapterOfResultLearning;
import com.grin.poligon.ustils.models.ModelOfResultLearning;

import java.util.ArrayList;
import java.util.List;

public class ChouseProfileActivity extends AppCompatActivity {
    AdapterOfResultLearning adapterCalllog;
    RecyclerView recycler_for_chouse_finish_result;
    List<ModelOfResultLearning> modelPredmet;
    Button btn_enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chouse_profile);

        recycler_for_chouse_finish_result = findViewById(R.id.recycler_for_chouse_finish_result);
        btn_enter = findViewById(R.id.btn_enter);

        modelPredmet = new ArrayList<>();

        // second_act_recycler_for_fz = findViewById(R.id.second_act_recycler_for_fz);
        recycler_for_chouse_finish_result.setNestedScrollingEnabled(false);
        recycler_for_chouse_finish_result.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        //    entries.add(new PieEntry(Float.parseFloat(parties2[i])));
        List<String> sdf = new ArrayList<>();
        sdf.add("dasd");
        sdf.add("dasd");
        sdf.add("dasd");
        sdf.add("dasd");
        modelPredmet.add(new ModelOfResultLearning("Программист","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Тестировщик","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Web разработчик","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Java","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Python","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("C++","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("C#","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("C","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Ruby","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("JavaScript","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Дизайн","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("Android","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("IOS","sdsds",sdf));


        adapterCalllog = new AdapterOfResultLearning(getApplicationContext(),modelPredmet);

        recycler_for_chouse_finish_result.setAdapter(adapterCalllog);



        adapterCalllog.notifyDataSetChanged();


        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter_aler_dialog(new Intent(ChouseProfileActivity.this,MainActivity.class));
             }
        });
    }
    private void enter_aler_dialog(Intent intent_act) {

         AlertDialog.Builder builder = new AlertDialog.Builder(ChouseProfileActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(ChouseProfileActivity.this).inflate(R.layout.alert_dialog_1, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();
         Button al_dial_get_s_d_start_test_btn = dialogView.findViewById(R.id.al_dial_get_s_d_start_test_btn);
         TextView al_dial_get_s_d_start_test_tv = dialogView.findViewById(R.id.al_dial_get_s_d_start_test_tv);










        al_dial_get_s_d_start_test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChouseProfileActivity.this, com.grin.poligon.questionnaire.MainActivity.class));
            }
        });
        al_dial_get_s_d_start_test_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ChouseProfileActivity.this,MainActivity.class));
                }
            });




    }
}