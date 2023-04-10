package com.example.indiantour.ui.Save;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.indiantour.R;

public class SaveFragment extends Fragment {
    LinearLayout ll_loading , ll_save_plan;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_save, container, false);


        ll_loading = root.findViewById(R.id.ll_loading);
        ll_save_plan = root.findViewById(R.id.ll_save_plan);

        ll_loading.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ll_loading.setVisibility(View.INVISIBLE);
                ll_save_plan.setVisibility(View.VISIBLE);

            }
        },2000);

        return root;
    }
}