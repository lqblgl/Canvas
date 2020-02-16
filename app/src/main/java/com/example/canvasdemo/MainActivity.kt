package com.example.canvasdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.canvasdemo.MarkPen.AlphaActivity
import com.example.canvasdemo.MaskFilter.MaskFilterActivity
import com.example.canvasdemo.PathEffect.PathEffectActivity
import com.example.canvasdemo.Shader.ShaderActivity
import com.example.canvasdemo.ShadowLayer.ShadowLayerActivity
import com.example.canvasdemo.Signature.SignatureActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shader_btn.setOnClickListener {
            startActivity(Intent(this, ShaderActivity::class.java))
        }
        shadowlayer_btn.setOnClickListener {
            startActivity(Intent(this, ShadowLayerActivity::class.java))
        }
        maskfilter_btn.setOnClickListener {
            startActivity(Intent(this, MaskFilterActivity::class.java))
        }
        patheffect_btn.setOnClickListener {
            startActivity(Intent(this, PathEffectActivity::class.java))
        }
        alpha_btn.setOnClickListener {
            startActivity(Intent(this, AlphaActivity::class.java))
        }
        signature_btn.setOnClickListener {
            startActivity(Intent(this, SignatureActivity::class.java))
        }
    }
}
