package com.example.indiantour.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.indiantour.R;
import com.example.indiantour.RecyclerViewPack.Model;
import com.example.indiantour.UserProfilePack.UserAdapter;
import com.example.indiantour.databinding.FragmentNotificationsBinding;

import java.util.Arrays;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =  new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        ConstraintLayout root = binding.getRoot();


        Model[] model = new Model[]{
                new Model(R.drawable.user_profile , "Manage your account"),
                new Model(R.drawable.wallet , "Rewards & Wallet"),
                new Model(R.drawable.rating , "Review"),
        };

        UserAdapter adapter = new UserAdapter(Arrays.asList(model), getContext());
        binding.userPrfileRecyclerview.setHasFixedSize(true);
        binding.userPrfileRecyclerview.setLayoutManager(new LinearLayoutManager(getContext())) ;
        binding.userPrfileRecyclerview.setAdapter(adapter);

        Model[] model2 = new Model[]{
                new Model(R.drawable.question , "Contact Customer Service"),
                new Model(R.drawable.partnership , "Dispute resolution"),
        };

        UserAdapter adapter2 = new UserAdapter(Arrays.asList(model2), getContext());
        binding.helpSupportRv.setHasFixedSize(true);
        binding.helpSupportRv.setLayoutManager(new LinearLayoutManager(getContext())) ;
        binding.helpSupportRv.setAdapter(adapter2);


        Model[] model3 = new Model[]{
                new Model(R.drawable.settings , "Settings"),
                new Model(R.drawable.legal , "Legal"),
        };

        UserAdapter adapter3 = new UserAdapter(Arrays.asList(model3), getContext());
        binding.settingsRv.setHasFixedSize(true);
        binding.settingsRv.setLayoutManager(new LinearLayoutManager(getContext())) ;
        binding.settingsRv.setAdapter(adapter3);





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}