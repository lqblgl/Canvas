package com.example.canvasdemo.Shader;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.canvasdemo.R;

public class ShaderActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private LinearLayout group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shader_layout);
        radioGroup = findViewById(R.id.rdgp);
        group = findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                group.removeAllViews();
                switch (i) {
                    case R.id.rdbtn1:
                        group.addView(new BitmapShaderView(ShaderActivity.this));
                        break;
                    case R.id.rdbtn2:
                        group.addView(new LinearGradientView(ShaderActivity.this));
                        break;
                    case R.id.rdbtn3:
                        group.addView(new SweepGradientView(ShaderActivity.this));
                        break;
                    case R.id.rdbtn4:
                        group.addView(new RadialGradientView(ShaderActivity.this));
                        break;
                    case R.id.rdbtn5:
                        group.addView(new ComposeShaderView(ShaderActivity.this));
                        break;
                }
            }
        });
    }
}
