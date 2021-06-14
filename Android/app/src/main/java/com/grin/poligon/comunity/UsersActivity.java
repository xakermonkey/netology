package com.grin.poligon.comunity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grin.poligon.R;
import com.grin.poligon.ustils.adapters.Adapter_of_many_coorces;
import com.grin.poligon.ustils.adapters.Adapter_of_user;
import com.grin.poligon.ustils.models.Model_of_cource;
import com.grin.poligon.ustils.models.Model_of_many_coorces;
import com.grin.poligon.ustils.models.Model_of_user;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends Fragment {
    RecyclerView recycler_for_name_of_many_coorces;
    Adapter_of_user adapter_of_user;
    List<Model_of_user> model_of_users;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_users, container, false);


        recycler_for_name_of_many_coorces = view.findViewById(R.id.recycler_for_name_of_many_coorces);


        model_of_users = new ArrayList<>();

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

        for (int i = 0; i < 30; i++) {
            model_of_users.add(new Model_of_user("Петинг Иванов "+i, "sosu hui", "300","sosu hui = "+i, "300"));

        }



        adapter_of_user = new Adapter_of_user(getContext(), model_of_users);

        recycler_for_name_of_many_coorces.setAdapter(adapter_of_user);



        adapter_of_user.notifyDataSetChanged();












        return view;
    }
}