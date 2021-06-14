package com.grin.poligon.adam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.grin.poligon.R;

public class EnterActivity extends AppCompatActivity {

    private Button al_dial_get_s_d_enter_btn;
    private Button al_dial_get_s_d_register_btn;
    private TextView enter_act_registration_tv;
    private TextView enter_like_guest_registration_tv;
    private TextView already_have_account_registration_tv;
    private LinearLayout lin_l_for_hide_for_registration;
    private LinearLayout lin_l_for_show_for_registration;
    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        enter_act_registration_tv = findViewById(R.id.enter_act_registration_tv);
        al_dial_get_s_d_enter_btn = findViewById(R.id.al_dial_get_s_d_enter_btn);
        enter_like_guest_registration_tv = findViewById(R.id.enter_like_guest_registration_tv);
        scroll = findViewById(R.id.scroll);
        lin_l_for_hide_for_registration = findViewById(R.id.lin_l_for_hide_for_registration);
        lin_l_for_show_for_registration = findViewById(R.id.lin_l_for_show_for_registration);
        already_have_account_registration_tv = findViewById(R.id.already_have_account_registration_tv);
        al_dial_get_s_d_register_btn = findViewById(R.id.al_dial_get_s_d_register_btn);

 //////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        GradientDrawable drawable = (GradientDrawable)scroll.getBackground();
//        drawable.setStroke(3, Color.RED);
        //////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        EditText al_dial_edit_t_name = findViewById(R.id.al_dial_edit_t_name);
        EditText al_dial_edit_t_password = findViewById(R.id.al_dial_edit_t_password);
        EditText reg_email_et = findViewById(R.id.reg_email_et);
        EditText reg_password_et_second = findViewById(R.id.reg_password_et_second);

        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);




        final Animation hold = AnimationUtils.loadAnimation(this, R.anim.hold);



        Animation poyavlenir = AnimationUtils.loadAnimation(this, R.anim.poyavlenir);
        Animation translate_scale_shift_left = AnimationUtils.loadAnimation(this, R.anim.translate_scale_shift_left);


        final Animation translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        final Animation slide_out_left = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        final Animation slide_in_right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        final Animation slide_out_right = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        final Animation slide_in_left = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);







        enter_like_guest_registration_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     startActivity(new Intent(EnterActivity.this,MainActivity.class));
            //    startActivity(new Intent(EnterActivity.this,ChouseProfileActivity.class));
                startActivity(new Intent(EnterActivity.this, com.grin.poligon.questionnaire.MainActivity.class));
             }
        });


        al_dial_get_s_d_enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = reg_email_et.getText().toString();
                String password = al_dial_edit_t_password.getText().toString();
                if (name.equals("")) {
                    reg_email_et.setError("Введите email");
                    reg_email_et.startAnimation(shake);

                }
                if (password.equals("")) {
                    al_dial_edit_t_password.setError("Введите пароль");
                    al_dial_edit_t_password.startAnimation(shake);
                }
                if (!(name.equals("") || password.equals(""))) {

                    startActivity(new Intent(EnterActivity.this,MainActivity.class));

                }
            }});


        enter_act_registration_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(EnterActivity.this, RegistrationActivity.class));
                lin_l_for_hide_for_registration.startAnimation(slide_in_right);

            }
        });
        slide_in_right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                lin_l_for_hide_for_registration.setVisibility(View.GONE);

                lin_l_for_show_for_registration.startAnimation(slide_out_left);
                lin_l_for_show_for_registration.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        already_have_account_registration_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lin_l_for_show_for_registration.startAnimation(slide_in_left);

            }
        });
               slide_in_left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                lin_l_for_hide_for_registration.setVisibility(View.VISIBLE);

                lin_l_for_hide_for_registration.startAnimation(slide_out_right);
                lin_l_for_show_for_registration.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        al_dial_get_s_d_register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean yes =true;

                String email = reg_email_et.getText().toString();
                String password = al_dial_edit_t_password.getText().toString();
                String second_password = reg_password_et_second.getText().toString();
                String name = al_dial_edit_t_name.getText().toString();
                if (email.equals("")) {
                    reg_email_et.setError("Введите email");
                    reg_email_et.startAnimation(shake);
                    yes= false;


                }
                if (password.equals("")) {
                    al_dial_edit_t_password.setError("Введите пароль");
                    al_dial_edit_t_password.startAnimation(shake);
                    yes= false;

                }
                if (second_password.equals("")) {
                    reg_password_et_second.setError("повторите пароль");
                    reg_password_et_second.startAnimation(shake);
                    yes= false;

                }
                if (name.equals("")) {
                    al_dial_edit_t_name.setError("Введите имя");
                    al_dial_edit_t_name.startAnimation(shake);
                    yes= false;

                }
                if (!second_password.equals(password) &&yes) {
                    reg_password_et_second.setError("Пароли должны совпадать");
                    reg_password_et_second.startAnimation(shake);
                    yes= false;
                }




                if (yes)
                {

                    startActivity(new Intent(EnterActivity.this,MainActivity.class));

                }
            }
        });





    }
}