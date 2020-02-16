package com.example.canvasdemo.MaskFilter;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.canvasdemo.R;

public class MaskFilterActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private LinearLayout group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maskfilter_layout);
        radioGroup = findViewById(R.id.rdgp);
        group = findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                group.removeAllViews();
                switch (i) {
                    case R.id.rdbtn1:
                        group.addView(new BlurMaskFilterView(MaskFilterActivity.this));
                        break;
                    case R.id.rdbtn2:
                        group.addView(new EmbossMaskFilterView(MaskFilterActivity.this));
                        break;
                }
            }
        });
    }
}
