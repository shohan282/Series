package com.example.series;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.series.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Double a;
    Double r;
    Double res1,sum_less,sum_great,n,number,number_result;
    Double res2;
    Double res3;
    Double res4;
    String result, getRes1, getRes2, getRes3, getRes4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(view1 -> {

            String get_a= binding.a.getText().toString();
            String get_b= binding.r.getText().toString();

            if(TextUtils.isEmpty(get_a)) {

                binding.a.setError("a ?");

            } else if (TextUtils.isEmpty(get_b)) {

                binding.r.setError("r ? ");

            } else {

                a=Double.valueOf(get_a);
                r=Double.valueOf(get_b);

                res1=a; res2=a*r ; res3=a*r*r ; res4=a*r*r*r;

                getRes1 =String.valueOf(res1);
                getRes2 =String.valueOf(res2);
                getRes3 =String.valueOf(res3);
                getRes4 =String.valueOf(res4);

                result="ধারাঃ "+ getRes1 +"+"+ getRes2 +"+"+ getRes3 +"+"+ getRes4+"+ . . . .";

                binding.result.setText(result);

                binding.totalSum.setVisibility(View.VISIBLE);
                binding.nth.setVisibility(View.VISIBLE);

            }

        });

        binding.button2.setOnClickListener(view2 -> {

            if(TextUtils.isEmpty(binding.n.getText().toString())) {

                binding.n.setError("এখানে কিছু লিখ");

            } else {

                n= Double.valueOf(binding.n.getText().toString());

                if (r<1) {

                    sum_less = (a*(1-(Math.pow(r,n))))/(1-r);

                    binding.totalSumResult.setText(n+" টি পদের সমষ্টি: "+sum_less);

                } else {

                    sum_great = (a*((Math.pow(r,n))-1))/(r-1);

                    binding.totalSumResult.setText(n+" টি পদের সমষ্টি: "+sum_great);

                }

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }

        });

        binding.button3.setOnClickListener(view12 -> {

            if(TextUtils.isEmpty(binding.number.getText().toString())) {

                binding.number.setError("এখানে কিছু লিখ");

            } else {

                number = Double.valueOf(binding.number.getText().toString());

                number_result = a*(Math.pow(r,(number-1)));

                binding.numberResult.setText(String.valueOf(number_result));

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }

        });

    }
}