package com.example.canvasdemo.MarkPen;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.canvasdemo.R;

public class AlphaActivity extends AppCompatActivity {
    private AlphaView alphaView;
    private ColorPickerDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_layout);
        alphaView = findViewById(R.id.av);
        dialog = new ColorPickerDialog(this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(int color) {
                alphaView.setColor(color);
            }
        }, Color.parseColor("#99ff0000"));
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}
