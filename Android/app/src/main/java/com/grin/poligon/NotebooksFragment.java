package com.grin.poligon;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.ustils.adapters.AdapterOfResultLearning;
import com.grin.poligon.ustils.models.ModelOfResultLearning;

import java.util.ArrayList;
import java.util.List;

public class NotebooksFragment extends Fragment {

    AdapterOfResultLearning adapterCalllog;
    RecyclerView recycler_for_chouse_finish_result;
    List<ModelOfResultLearning> modelPredmet;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_notebooks_layout,container,false);
        recycler_for_chouse_finish_result = view.findViewById(R.id.recycler_for_chouse_finish_result);

        modelPredmet = new ArrayList<>();

        // second_act_recycler_for_fz = findViewById(R.id.second_act_recycler_for_fz);
        recycler_for_chouse_finish_result.setNestedScrollingEnabled(false);
        recycler_for_chouse_finish_result.setLayoutManager(new GridLayoutManager(getContext(),3));

            //    entries.add(new PieEntry(Float.parseFloat(parties2[i])));
        List<String> sdf = new ArrayList<>();
        sdf.add("dasd");
        sdf.add("dasd");
        sdf.add("dasd");
        sdf.add("dasd");
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));
        modelPredmet.add(new ModelOfResultLearning("xzxz","sdsds",sdf));




        adapterCalllog = new AdapterOfResultLearning(getContext(),modelPredmet);

        recycler_for_chouse_finish_result.setAdapter(adapterCalllog);



        adapterCalllog.notifyDataSetChanged();

        return view;
    }
}
