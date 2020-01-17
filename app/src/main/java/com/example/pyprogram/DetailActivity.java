package com.example.pyprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.pyprogram.R;

public class DetailActivity extends AppCompatActivity {

    private TextView mTitle, mDetails, mCode, mOutput;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = findViewById(R.id.txtTitle);
        mDetails = findViewById(R.id.txtDetail);
        mCode = findViewById(R.id.txtCode);
        mOutput = findViewById(R.id.txtOutput);
        toggleButton = findViewById(R.id.myToggleButton);

        toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_favorite_border_black_24dp));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_black_24dp));
                    Toast.makeText(DetailActivity.this, "Add to Favorite", Toast.LENGTH_SHORT).show();
                }else {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border_black_24dp));
                    Toast.makeText(DetailActivity.this, "Removed from Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mTitle.setText(bundle.getString("Title"));
            mDetails.setText(bundle.getString("Definition"));
            mCode.setText(bundle.getString("Code"));
            mOutput.setText(bundle.getString("Output"));
        }

    }
}