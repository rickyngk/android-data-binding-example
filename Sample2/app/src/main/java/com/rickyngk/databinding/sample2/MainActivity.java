package com.rickyngk.databinding.sample2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rickyngk.databinding.sample2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements SampleViewModel.ISampleViewModelEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new SampleViewModel(this, this));
    }

    public void onClickButton() {
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
    }
}
