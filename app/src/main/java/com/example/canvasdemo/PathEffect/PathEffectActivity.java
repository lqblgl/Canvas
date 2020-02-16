package com.example.canvasdemo.PathEffect;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.canvasdemo.R;

public class PathEffectActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private LinearLayout group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patheffect_layout);
        radioGroup = findViewById(R.id.rdgp);
        group = findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                group.removeAllViews();
                switch (i) {
                    case R.id.rdbtn1:
                        group.addView(new CornerPathEffectView(PathEffectActivity.this));
                        break;
                    case R.id.rdbtn2:
                        group.addView(new DashPathEffectView(PathEffectActivity.this));
                        break;
                    case R.id.rdbtn3:
                        group.addView(new DiscretePathEffectView(PathEffectActivity.this));
                        break;
                    case R.id.rdbtn4:
                        group.addView(new PathDashPathEffectView(PathEffectActivity.this));
                        break;
                    case R.id.rdbtn5:
                        group.addView(new ComposePathEffectView(PathEffectActivity.this));
                        break;
                    case R.id.rdbtn6:
                        group.addView(new SumPathEffectView(PathEffectActivity.this));
                        break;
                }
            }
        });
    }
}
