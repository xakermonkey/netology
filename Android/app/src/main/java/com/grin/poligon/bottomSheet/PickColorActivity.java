package com.grin.poligon.bottomSheet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.github.mata1.simpledroidcolorpicker.interfaces.OnColorPickedListener;
import com.github.mata1.simpledroidcolorpicker.pickers.CircleColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.ColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.RingColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.linear.SaturationLinearColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.linear.ValueLinearColorPicker;
import com.google.android.material.snackbar.Snackbar;
import com.grin.poligon.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.ibrahimsn.particle.ParticleView;

import static com.grin.poligon.adam.MainActivity.particleView;
import static com.grin.poligon.bottomSheet.Constants.D_COLOR_TV;
import static java.security.AccessController.getContext;

public class PickColorActivity extends AppCompatActivity  {
    public static ParticleView particleView;


    private RingColorPicker rcp;
    private CircleColorPicker ccp;
    // private HueLinearColorPicker lcpHue;

    private Animation hide_down_anim,show_down_anim ;


     ImageView hide_show_imv;

     CardView  list_of_poligone, hide_show_imv_up;


      SharedPreferences sharedPreferences;



    RadioGroup radioGroup_models;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_color);

        hide_down_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hide_down_anim);
        show_down_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.show_down_anim);

        particleView = findViewById(R.id.particleView);
        sharedPreferences = getSharedPreferences("design", MODE_PRIVATE);

        particleView.setParticleColor((sharedPreferences.getInt(D_COLOR_TV,R.color.red_l)));
        particleView.setParticleLineColor((sharedPreferences.getInt(D_COLOR_TV,R.color.red_l)));


        hide_show_imv = findViewById(R.id.activity_map_hide_show_list_of_polygone_down);
        hide_show_imv_up = findViewById(R.id.activity_map_hide_show_list_of_polygone_up);

         list_of_poligone = findViewById(R.id.activity_map_list_polygone_cardview);

        radioGroup_models = findViewById(R.id.models_colors);


        hide_show_imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    hide_show_imv_up.startAnimation(show_down_anim);
                    list_of_poligone.startAnimation(hide_down_anim);
                    list_of_poligone.setVisibility(View.GONE);
                    hide_show_imv_up.setVisibility(View.VISIBLE);


            }});

        hide_show_imv_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                hide_show_imv_up.startAnimation(hide_down_anim);
                list_of_poligone.startAnimation(show_down_anim);
                list_of_poligone.setVisibility(View.VISIBLE);
                hide_show_imv_up.setVisibility(View.GONE);
            }
        });



        // ring color picker
        rcp = (RingColorPicker)findViewById(R.id.rcp);


         rcp.setOnColorPickedListener(new OnColorPickedListener() {

             @Override
             public void colorPicked(int color) {
                 particleView.setParticleColor(color);
                 particleView.setParticleLineColor(color);

                 SharedPreferences.Editor editor = sharedPreferences.edit();
                 editor.putInt(D_COLOR_TV, color);
                 editor.apply();
             }
         });

         // circle color picker
         ccp = (CircleColorPicker)findViewById(R.id.ccp);





    }


}