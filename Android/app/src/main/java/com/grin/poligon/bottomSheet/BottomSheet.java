package com.grin.poligon.bottomSheet;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.github.mata1.simpledroidcolorpicker.dialogs.ColorPickerDialog;
import com.github.mata1.simpledroidcolorpicker.interfaces.OnColorPickedListener;
import com.github.mata1.simpledroidcolorpicker.pickers.CircleColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.RingColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.linear.HueLinearColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.linear.SaturationLinearColorPicker;
import com.github.mata1.simpledroidcolorpicker.pickers.linear.ValueLinearColorPicker;
import com.github.mata1.simpledroidcolorpicker.utils.ColorUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
 import com.grin.poligon.R;
import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;
import static com.grin.poligon.bottomSheet.Constants.D_COLOR_BTN;
import static com.grin.poligon.bottomSheet.Constants.D_COLOR_MODEL;
import static com.grin.poligon.bottomSheet.Constants.D_COLOR_PANEL;
import static com.grin.poligon.bottomSheet.Constants.D_COLOR_TV;
import static com.grin.poligon.bottomSheet.Constants.D_RADIO_BTN_NUMBER_2;
import static com.grin.poligon.bottomSheet.Constants.D_RADIO_BTN_NUMBER_3;
import static com.grin.poligon.bottomSheet.Constants.D_RADIO_BTN_NUMBER_4;
import static com.grin.poligon.adam.MainActivity.particleView;

public class BottomSheet extends BottomSheetDialogFragment {
    Window window;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    int save_value_1;
    int save_value_2;
    int save_value_3;
    int save_value_4;

   // private HueLinearColorPicker lcpHue;

    private ImageView img_view_pick_color_activity;
     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.design_setting,container,false);
        //getActivity().setTheme(R.style.green);

        RadioGroup radioGroup_models = view.findViewById(R.id.models_colors);
        RadioGroup radioGroup_button = view.findViewById(R.id.button_colors);
        RadioGroup radioGroup_panel = view.findViewById(R.id.panels_colors);
          img_view_pick_color_activity = view.findViewById(R.id.img_view_pick_color_activity);

        window = this.getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        sharedPreferences = getActivity().getSharedPreferences("design", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        save_value_2 = sharedPreferences.getInt(D_RADIO_BTN_NUMBER_2,R.id.red_l_models);
        save_value_3 = sharedPreferences.getInt(D_RADIO_BTN_NUMBER_3,R.id.red_l_btn);
        save_value_4 = sharedPreferences.getInt(D_RADIO_BTN_NUMBER_4,R.id.red_l_panels);




         img_view_pick_color_activity.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getContext(),PickColorActivity.class));
             }
         });




        // lcpHue = (HueLinearColorPicker)view.findViewById(R.id.lcp_hue);

         //rcp.setSaturationLinearColorPicker(lcpSat);
         //rcp.setValueLinearColorPicker(lcpVal);

       //  rcp.setSaturationLinearColorPicker(lcpSat);
       //  rcp.setValueLinearColorPicker(lcpVal);

//         rcp.setOnColorPickedListener(new OnColorPickedListener() {
//             @Override
//             public void colorPicked(int color) {
//                 Toast.makeText(getContext(), "Color selected: " + color, Toast.LENGTH_SHORT).show();
//              //   toolbar.setBackgroundColor(color);
//             }
//         });
//
//         // circle color picker
//         ccp = (CircleColorPicker)view.findViewById(R.id.ccp);



         //      RadioButton r1 = view.findViewById(save_value_1);
//        r1.setChecked(true);
     //   RadioButton r2 = view.findViewById(save_value_2);
      //  r2.setChecked(true);
      //  RadioButton r3 = view.findViewById(save_value_3);
     //   r3.setChecked(true);
     //   RadioButton r4 = view.findViewById(save_value_4);
      //  r4.setChecked(true);


//        radioGroup_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//
//                    case (R.id.red_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.red_l);
//
//                        editor.putInt(D_COLOR_MAIN, R.color.red_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.red_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.red_l);
//                        editor.commit();
//
//                        break;
//                    case (R.id.purpure_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.purpure_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.purpure_d));
//                         editor.putInt(D_COLOR_MAIN, R.color.purpure_l);
//                         editor.putInt(D_COLOR_STATUS_BAR, R.color.purpure_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.purpure_l);
//
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.sapphirine_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.sapphirine_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.sapphirine_d));
//                         editor.putInt(D_COLOR_MAIN, R.color.sapphirine_l);
//                         editor.putInt(D_COLOR_STATUS_BAR, R.color.sapphirine_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.sapphirine_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.blue_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.blue_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.blue_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.blue_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.blue_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.blue_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.green_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.green_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.green_d));
//                         editor.putInt(D_COLOR_MAIN, R.color.green_l);
//                         editor.putInt(D_COLOR_STATUS_BAR, R.color.green_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.green_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.yellow_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.yellow_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.yellow_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.yellow_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.yellow_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.yellow_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.orange_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.orange_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.orange_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.orange_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.orange_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.orange_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.brown_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.brown_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.brown_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.brown_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.brown_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.brown_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.grey_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.grey_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.grey_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.grey_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.grey_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.grey_l);
//
//                        editor.commit();
//
//                        break;
//                    case (R.id.indigo_l):
//                        window.findViewById(R.id.main_big_window).setBackgroundResource(R.color.indigo_l);
//                        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.indigo_d));
//                        editor.putInt(D_COLOR_MAIN, R.color.indigo_l);
//                        editor.putInt(D_COLOR_STATUS_BAR, R.color.indigo_d);
//                        editor.putInt(D_RADIO_BTN_NUMBER_1, R.id.indigo_l);
//
//                        editor.commit();
//
//                        break;
//
//
//                }
//
//            }
//        });


        radioGroup_models.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case (R.id.red_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.red_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.red_l_models);

                        break;
                    case (R.id.purpure_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.purpure_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.purpure_l_models);


                        break;
                    case (R.id.sapphirine_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.sapphirine_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.sapphirine_l_models);

                         break;
                    case (R.id.blue_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.blue_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.blue_l_models);

                         break;
                    case (R.id.green_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.green_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.green_l_models);

                         break;
                    case (R.id.yellow_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.yellow_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.yellow_l_models);

                         break;
                    case (R.id.orange_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.orange_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.orange_l_models);

                         break;
                    case (R.id.brown_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.brown_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.brown_l_models);

                         break;
                    case (R.id.grey_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.grey_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.grey_l_models);

                         break;
                    case (R.id.indigo_l_models):
                        editor.putInt(D_COLOR_MODEL, R.color.indigo_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_2, R.id.indigo_l_models);

                        break;


                }

                editor.apply();





            }
        });

        radioGroup_button.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case (R.id.red_l_btn):

                        getActivity().setTheme(R.style.red);
                        editor.putInt(D_COLOR_BTN, R.style.red);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.red_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.red_l);

                        particleView.setParticleColor(getResources().getColor(R.color.red_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.red_l));
                        break;
                    case (R.id.purpure_l_btn):

                        getActivity().setTheme(R.style.purpure);
                        editor.putInt(D_COLOR_BTN, R.style.purpure);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.purpure_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.purpure_l);
                        particleView.setParticleColor(getResources().getColor(R.color.purpure_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.purpure_l));


                        break;
                    case (R.id.sapphirine_l_btn):
                          getActivity().setTheme(R.style.sapphirine);
                        editor.putInt(D_COLOR_BTN, R.style.sapphirine);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.sapphirine_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.sapphirine_l);
                        particleView.setParticleColor(getResources().getColor(R.color.sapphirine_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.sapphirine_l));

                        break;
                    case (R.id.blue_l_btn):
                          getActivity().setTheme(R.style.blue);
                        editor.putInt(D_COLOR_BTN, R.style.blue);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.blue_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.blue_l);
                        particleView.setParticleColor(getResources().getColor(R.color.blue_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.blue_l));

                        break;
                    case (R.id.green_l_btn):

                        getActivity().setTheme(R.style.green);
                        editor.putInt(D_COLOR_BTN, R.style.green);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.green_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.green_l);
                        particleView.setParticleColor(getResources().getColor(R.color.green_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.green_l));

                        break;
                    case (R.id.yellow_l_btn):

                        getActivity().setTheme(R.style.yellow);
                        editor.putInt(D_COLOR_BTN, R.style.yellow);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.yellow_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.yellow_l);
                        particleView.setParticleColor(getResources().getColor(R.color.yellow_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.yellow_l));

                        break;
                    case (R.id.orange_l_btn):

                        getActivity().setTheme(R.style.orange);
                        editor.putInt(D_COLOR_BTN, R.style.orange);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.orange_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.orange_l);
                        particleView.setParticleColor(getResources().getColor(R.color.orange_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.orange_l));

                        break;
                    case (R.id.brown_l_btn):

                        getActivity().setTheme(R.style.brown);
                        editor.putInt(D_COLOR_BTN, R.style.brown);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.brown_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.brown_l);
                        particleView.setParticleColor(getResources().getColor(R.color.brown_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.brown_l));

                        break;
                    case (R.id.grey_l_btn):

                        getActivity().setTheme(R.style.grey);
                        editor.putInt(D_COLOR_BTN, R.style.grey);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.grey_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.grey_l);
                        particleView.setParticleColor(getResources().getColor(R.color.grey_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.grey_l));

                        break;
                    case (R.id.indigo_l_btn):

                        getActivity().setTheme(R.style.indigo);
                        editor.putInt(D_COLOR_BTN, R.style.indigo);
                        editor.putInt(D_RADIO_BTN_NUMBER_3, R.id.indigo_l_btn);
                        editor.putInt(D_COLOR_TV, R.color.indigo_l);
                        particleView.setParticleColor(getResources().getColor(R.color.indigo_l));
                        particleView.setParticleLineColor(getResources().getColor(R.color.indigo_l));

                        break;


                }
                editor.apply();

            }
        });

        radioGroup_panel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

             //   window.findViewById(R.id.cardview_main_design);
             //   CardView cardView = window.findViewById(R.id.cardview_main_design);

                switch (checkedId) {


                    case (R.id.red_l_panels):
                         editor.putInt(D_COLOR_PANEL, R.color.red_d);
                //        cardView.setCardBackgroundColor(R.color.red_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.red_l_panels);


                        break;
                    case (R.id.purpure_l_panels):
                         editor.putInt(D_COLOR_PANEL, R.color.purpure_d);
            //            cardView.setCardBackgroundColor(R.color.purpure_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.purpure_l_panels);


                        break;
                    case (R.id.sapphirine_l_panels):
              //          cardView.setCardBackgroundColor(R.color.sapphirine_d);
                        editor.putInt(D_COLOR_PANEL, R.color.sapphirine_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.sapphirine_l_panels);


                        break;
                    case (R.id.blue_l_panels):
               //         cardView.setCardBackgroundColor(R.color.blue_d);
                        editor.putInt(D_COLOR_PANEL, R.color.blue_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.blue_l_panels);


                        break;
                    case (R.id.green_l_panels):
                 //       cardView.setCardBackgroundColor(R.color.green_d);
                        editor.putInt(D_COLOR_PANEL, R.color.green_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.green_l_panels);


                        break;
                    case (R.id.yellow_l_panels):
                 //       cardView.setCardBackgroundColor(R.color.yellow_d);
                        editor.putInt(D_COLOR_PANEL, R.color.yellow_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.yellow_l_panels);


                        break;
                    case (R.id.orange_l_panels):
               //         cardView.setCardBackgroundColor(R.color.orange_d);
                        editor.putInt(D_COLOR_PANEL, R.color.orange_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.orange_l_panels);


                        break;
                    case (R.id.brown_l_panels):
               //         cardView.setCardBackgroundColor(R.color.brown_d);
                        editor.putInt(D_COLOR_PANEL, R.color.brown_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.brown_l_panels);


                        break;
                    case (R.id.grey_l_panels):
                  //      cardView.setCardBackgroundColor(R.color.grey_d);
                        editor.putInt(D_COLOR_PANEL, R.color.grey_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.grey_l_panels);


                        break;
                    case (R.id.indigo_l_panels):

                    //    cardView.setCardBackgroundColor(R.color.indigo_d);

                        editor.putInt(D_COLOR_PANEL, R.color.indigo_d);
                        editor.putInt(D_RADIO_BTN_NUMBER_4, R.id.indigo_l_panels);


                        break;
                    default:


                }
                editor.apply();

            }
        });

        return view;

     }


    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        editor.commit();


    }


    public void showDialog(final View v) {

        ColorPickerDialog dialog = new ColorPickerDialog(getContext(), ColorPickerDialog.PickerType.HSV);
        dialog.setOnColorPickedListener(new OnColorPickedListener() {
            @Override
            public void colorPicked(int color) {
                v.setBackgroundColor(color);
            }
        });

        dialog.show();
    }
}