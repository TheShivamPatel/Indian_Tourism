package com.example.indiantour.ui.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.indiantour.R;
import com.example.indiantour.RecyclerViewPack.Adapter;
import com.example.indiantour.RecyclerViewPack.Model;
import com.example.indiantour.databinding.FragmentHomeBinding;

import java.util.Arrays;

public class HomeFragment extends Fragment{

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_home, container, false);

//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        Model[] model = new Model[]{
                new Model(R.drawable.himachal , "Himachal"),
                new Model(R.drawable.asam , "Assam"),
                new Model(R.drawable.rajasthan , "Rajasthan"),
                new Model(R.drawable.ladakh , "Ladakh"),
                new Model(R.drawable.see_more , "")
        };

        Adapter adapter = new Adapter(Arrays.asList(model), getContext());
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false)) ;
        binding.recyclerview.setAdapter(adapter);


        //RECYCLER VIEW FOR HOTELS ! ! !
        Model[] hotelModel = new Model[]{
                new Model(R.drawable.mumbai_h , "Mumbai"),
                new Model(R.drawable.singapore_h , "Delhi"),
                new Model(R.drawable.bali_h , "Bali"),
                new Model(R.drawable.bankok_hotel , "Goa"),
                new Model(R.drawable.see_more , "")
        };

        Adapter hotelAdapter = new Adapter(Arrays.asList(hotelModel), getContext());
        binding.hotelRv.setHasFixedSize(true);
        binding.hotelRv.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false)) ;
        binding.hotelRv.setAdapter(hotelAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}



