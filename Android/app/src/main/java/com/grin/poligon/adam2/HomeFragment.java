package com.grin.poligon.adam2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grin.poligon.R;
import com.grin.poligon.ustils.adapters.Adapter_of_many_coorces;
import com.grin.poligon.ustils.models.Model_of_cource;
import com.grin.poligon.ustils.models.Model_of_many_coorces;

import java.util.ArrayList;
import java.util.List;



public class HomeFragment extends Fragment {
    RecyclerView recycler_for_name_of_many_coorces;
    Adapter_of_many_coorces adapterCalllog;
     List<Model_of_many_coorces> modelPredmet;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recycler_for_name_of_many_coorces = view.findViewById(R.id.recycler_for_name_of_many_coorces);


        modelPredmet = new ArrayList<>();

        // second_act_recycler_for_fz = findViewById(R.id.second_act_recycler_for_fz);
        recycler_for_name_of_many_coorces.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
     //   linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recycler_for_name_of_many_coorces.setLayoutManager(new LinearLayoutManager(getContext()));



        List<Model_of_cource> sdf = new ArrayList<>();
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());
        sdf.add(new Model_of_cource());

        modelPredmet.add(new Model_of_many_coorces("xzxz",sdf,"sdf"));
        modelPredmet.add(new Model_of_many_coorces("xzxz",sdf,"sdf"));
        modelPredmet.add(new Model_of_many_coorces("xzxz",sdf,"sdf"));



        adapterCalllog = new Adapter_of_many_coorces(getContext(), modelPredmet);

        recycler_for_name_of_many_coorces.setAdapter(adapterCalllog);



        adapterCalllog.notifyDataSetChanged();








        return view;
    }
}
