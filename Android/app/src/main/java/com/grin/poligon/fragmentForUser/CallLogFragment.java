package com.grin.poligon.fragmentForUser;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.grin.poligon.R;
import com.grin.poligon.ustils.adapters.AdapterPredmet2;
import com.grin.poligon.ustils.models.ModelPredmet;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.particle.ParticleView;


public class CallLogFragment extends Fragment implements
        OnChartValueSelectedListener {
    private ParticleView particleView;

    public static ScrollView mainScrollView ;
    public static ImageView transparentImageView ;
    public static ImageView back_image_for_predlozenie ;

      private PieChart chart;
    AdapterPredmet2 adapterCalllog;
    RecyclerView recycler_for_diagramma_chemistry;
    List<ModelPredmet> modelPredmet;


    ListView list_view_for_news;
    CardView second_activity_card_view_graf;
    CardView second_activity_card_view_graf2;

    public CallLogFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call_log, container, false);








        second_activity_card_view_graf =  view.findViewById(R.id.second_activity_card_view_graf);
        second_activity_card_view_graf2 =  view.findViewById(R.id.second_activity_card_view_graf2);



        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            float val = (float) (Math.random() * (40 + 1)) + 20;
            values.add(new Entry(i, val));
        }




        //////////////////////////////

        recycler_for_diagramma_chemistry = view.findViewById(R.id.recycler_for_diagramma_chemistry);



        modelPredmet = new ArrayList<>();

        // second_act_recycler_for_fz = findViewById(R.id.second_act_recycler_for_fz);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recycler_for_diagramma_chemistry.setLayoutManager(linearLayoutManager);




        chart = view.findViewById(R.id.chart11);
        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);
        chart.setExtraOffsets(5, 10, 5, 5);

        chart.setDragDecelerationFrictionCoef(0.95f);


        chart.setCenterText(generateCenterSpannableText());


        chart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.WHITE);

        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);

        chart.setHoleRadius(48f);
        chart.setTransparentCircleRadius(51f);

        chart.setDrawCenterText(true);

        chart.setRotationAngle(0);
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        chart.setOnChartValueSelectedListener(this);

        chart.setNoDataTextColor(Color.BLACK);
        chart.setEntryLabelColor(Color.BLACK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            chart.setOutlineSpotShadowColor(Color.BLACK);
            chart.setOutlineAmbientShadowColor(Color.BLACK);

        }

        setData_circule(6 );

        chart.animateY(1600, Easing.EaseInOutQuad);
        // chart.spin(2000, 0, 360);

        Legend l1 = chart.getLegend();
        l1.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l1.setOrientation(Legend.LegendOrientation.VERTICAL);
        l1.setDrawInside(false);
        l1.setEnabled(false);






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
        recycler_for_diagramma_chemistry.setAdapter(adapterCalllog);



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
        chart.setData(data);

        // undo all highlights
        chart.highlightValues(null);

        chart.invalidate();
    }



    @Override
    public void onValueSelected(Entry e, Highlight h) {
        recycler_for_diagramma_chemistry.smoothScrollToPosition((int) h.getX());


    }
    @Override
    public void onNothingSelected() {

    }




}