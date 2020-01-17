package com.example.pyprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class DetailsConceptActivity extends AppCompatActivity {

    TextView conceptTitle,conceptAnswer,conceptExample,conceptDefinition;
    String key = "";
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_concept);

        conceptTitle = findViewById(R.id.txt_concept_Title);
        conceptDefinition = findViewById(R.id.txt_concept_Definition);
        conceptAnswer = findViewById(R.id.txt_concept_Answer);
        conceptExample = findViewById(R.id.txt_concept_Example);
        toggleButton = findViewById(R.id.Fav_btn);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null){
            conceptTitle.setText(mBundle.getString("ConceptTitle"));
            conceptDefinition.setText(mBundle.getString("ConceptDefinition"));
            conceptAnswer.setText(mBundle.getString("ConceptAnswer"));
            conceptExample.setText(mBundle.getString("ConceptExample"));

            key = mBundle.getString("keyValue"); //Delete
        }


        toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_favorite_border_black_24dp));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_black_24dp));
                    Toast.makeText(DetailsConceptActivity.this, "Add to Favorite", Toast.LENGTH_SHORT).show();
                }else {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border_black_24dp));
                    Toast.makeText(DetailsConceptActivity.this, "Removed from Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
