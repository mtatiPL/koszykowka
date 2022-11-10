package com.example.skrypt_do_koszykwki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.skrypt_do_koszykwki.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
   // private int punkty=0;
    PunktyViewModel punktyViewModel;
    private SharedPreferences punktySharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        punktySharedPreferences=getPreferences(MODE_PRIVATE);

        punktyViewModel=new ViewModelProvider(this).get(PunktyViewModel.class);
        odczytajSharedPreferences();

        punktyViewModel.getPunkty().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.punktyTextView.setText(String.valueOf(integer));
                    }
                }
        );

        //dzięki bindowaniu widoków nie musimy uzywać findViewById
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  punkty++;
                punktyViewModel.dodajPunkty(1);

            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  punkty++;
                punktyViewModel.dodajPunkty(2);

            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  punkty++;
                punktyViewModel.dodajPunkty(3);

            }


        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        zapiszSharedPreferences();
    }

    private void zapiszSharedPreferences(){
        SharedPreferences.Editor edytor= punktySharedPreferences.edit();

        edytor.putInt("PUNKTY",punktyViewModel.getPunkty().getValue());
        edytor.apply();
    }
    private void  odczytajSharedPreferences(){
       int p= punktySharedPreferences.getInt("PUNKTY",0);
      //  Log.i("PUNKTY",Integer.toString(p));
  punktyViewModel.setPunkty(p);


    }
}