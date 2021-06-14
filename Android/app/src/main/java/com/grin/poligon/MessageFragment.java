package com.grin.poligon;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grin.poligon.ustils.adapters.AdapterPredmet;
import com.grin.poligon.ustils.models.Predmet;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    AdapterPredmet adapterCalllog;
    RecyclerView recycler_for_diagramma_chemistry;
    List<Predmet> modelPredmet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_message_layout,container,false);




        recycler_for_diagramma_chemistry = view.findViewById(R.id.recycler_for_diagramma_chemistry);



        modelPredmet = new ArrayList<>();

        // second_act_recycler_for_fz = findViewById(R.id.second_act_recycler_for_fz);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recycler_for_diagramma_chemistry.setLayoutManager(linearLayoutManager);

         String[] parties = new String[] {
                "Математика", "Физика",
                "Химия", "Литература",
                "Бокс", "Музыка"

        };
          String[] parties2 = new String[] {
                "60", "45",
                "45", "30",
                "60", "120"

        };

        for (int i = 0; i < parties2.length; i++) {
            //    entries.add(new PieEntry(Float.parseFloat(parties2[i])));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                modelPredmet.add(new Predmet(parties[i],getContext().getColor(R.color.blue_d), parties2[i])) ;
            }
        }
        adapterCalllog = new AdapterPredmet(getContext(),modelPredmet);
        recycler_for_diagramma_chemistry.setAdapter(adapterCalllog);



        adapterCalllog.notifyDataSetChanged();
        return view;

    }
}
