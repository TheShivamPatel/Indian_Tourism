package com.example.indiantour;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.indiantour.RecyclerViewPack.Adapter;
import com.example.indiantour.RecyclerViewPack.Model;
import com.example.indiantour.databinding.ActivityPlanBinding;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class PlanActivity extends AppCompatActivity {

    ActivityPlanBinding binding;
    int day,month, year;
    String finalDate,startingDate , dayDifference;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();
        // gradient status bar!
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        android.graphics.drawable.Drawable background = PlanActivity.this.getResources().getDrawable(R.drawable.toolbarbg);
        getWindow().setBackgroundDrawable(background);

        dialog = new Dialog(this);

        binding.txtDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                binding.txtDestination.setText("Himachal");
            }
        });

        binding.dateFormate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog();
            }
        });

        binding.finalDateFormate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalDatePickerDialog();
            }
        });


        binding.cardBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.llLoading.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.llLoading.setVisibility(View.INVISIBLE);
                        binding.llHotelDetail.setVisibility(View.VISIBLE);
                    }
                },2000);
            }
        });


        //RECYCLER VIEW FOR HOTELS ! ! !
        Model[] hotelModel = new Model[]{
                new Model(R.drawable.mumbai_h , "Grand view"),
                new Model(R.drawable.singapore_h , "The Orchard"),
                new Model(R.drawable.bali_h , "Dreamland Cottages"),
                new Model(R.drawable.bankok_hotel , "Sun Park Resort")
        };

        Adapter hotelAdapter = new Adapter(Arrays.asList(hotelModel), this);
        binding.hotelRv.setHasFixedSize(true);
        binding.hotelRv.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)) ;
        binding.hotelRv.setAdapter(hotelAdapter);


        binding.cardSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDoneDialog();
            }
        });

    }

    // DIALOG BOX FOR PICK DESTINATION ! ! !
    private void openDoneDialog(){
        dialog.setContentView(R.layout.done_animation);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }


    // DIALOG BOX FOR PICK DESTINATION ! ! !
    private void openDialog(){
        dialog.setContentView(R.layout.location_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    // DATE PICKER DIALOG ! ! !
    private void datePickerDialog() {

        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(PlanActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                binding.dateFormate.setText(i2 + "/" + (i1 + 1) + "/" + i);
                startingDate = (i2 + "/" + (i1 + 1) + "/" + i);
            }
        }, year, month, day);
        dialog.show();

    }


    // DATE PICKER DIALOG ! ! !
    private void finalDatePickerDialog() {

        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(PlanActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i3, int i4, int i5) {
                binding.finalDateFormate.setText(i5 + "/" + (i4 + 1) + "/" + i3);
                finalDate = (i5 + "/" + (i4 + 1) + "/" + i3);
            }
        }, year, month, day);
        dialog.show();

    }

    //  DATE CALCULATION ! ! !
    private void differenceDate() {

        try {
            Date date1;
            Date date2;
            SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
            date1 = dates.parse(startingDate);
            date2 = dates.parse(finalDate);
            Long difference = Math.abs(date1.getTime() - date2.getTime());
            Long differenceDates = difference / (24 * 60 * 60 * 1000);
            dayDifference = Long.toString(differenceDates + 1);
        } catch (Exception exception) {

        }

    }


}