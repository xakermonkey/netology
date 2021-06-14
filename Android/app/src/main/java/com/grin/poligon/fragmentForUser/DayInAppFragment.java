package com.grin.poligon.fragmentForUser;

import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.grin.poligon.R;
import com.grin.poligon.ustils.adapters.AdapterPredmet2;
import com.grin.poligon.ustils.models.ModelPredmet;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.particle.ParticleView;


public class DayInAppFragment extends Fragment implements   SeekBar.OnSeekBarChangeListener
 {


    private HorizontalBarChart chart_horizontal;
     AdapterPredmet2 adapterCalllog;
     List<ModelPredmet> modelPredmet;


    ListView list_view_for_news;
    CardView second_activity_card_view_graf;
    CardView second_activity_card_view_graf2;

    public DayInAppFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_in_app, container, false);








        second_activity_card_view_graf =  view.findViewById(R.id.second_activity_card_view_graf);
        second_activity_card_view_graf2 =  view.findViewById(R.id.second_activity_card_view_graf2);























        return view;
    }


    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("");
        //  s.setSpan(new RelativeSizeSpan(1.6f), 0, 12, 0);
        //      s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        //  s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //  s.setSpan(new RelativeSizeSpan(.65f), 14, s.length() - 15, 0);
        //   s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        //   s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }



    protected final String[] parties = new String[] {
            "Логистика", "Обучение",
            "Промоутинг", "Охрана",
            "Продажи", "Управление"

    };
    protected final String[] parties2 = new String[] {
            "1000", "1450",
            "450", "3300",
            "2200", "1500"

    };



    private void setData_circule(int count) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        float all_time=0.0f;
        for (int i = 0; i < count; i++) {
            all_time +=Float.parseFloat( parties2[i]);
        }
        for (int i = 0; i < count; i++) {
            //    entries.add(new PieEntry(Float.parseFloat(parties2[i])));
            entries.add(new PieEntry((float) (Float.parseFloat( parties2[i])/all_time)));
            modelPredmet.add(new ModelPredmet(parties[i],colors.get(i), parties2[i])) ;
        }


        adapterCalllog = new AdapterPredmet2(getContext(),modelPredmet);




        adapterCalllog.notifyDataSetChanged();



        //dataSet.setSelectionShift(0f);


        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.WHITE);
        //    data.setValueTextColors(colors);

    }



    private void setData(int count, float range) {

        float barWidth = 9f;
        float spaceForBar = 10f;
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            values.add(new BarEntry(i * spaceForBar, val,
                    getResources().getDrawable(R.drawable.ic_menu_camera)));
        }

        BarDataSet set1;

        if (chart_horizontal.getData() != null &&
                chart_horizontal.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart_horizontal.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart_horizontal.getData().notifyDataChanged();
            chart_horizontal.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(values, "Статистика достижений");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            data.setValueTextColor(Color.BLACK);
            chart_horizontal.setData(data);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        setData(15, 50);

        chart_horizontal.setFitBars(true);
        chart_horizontal.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    private final RectF mOnValueSelectedRectF = new RectF();











}