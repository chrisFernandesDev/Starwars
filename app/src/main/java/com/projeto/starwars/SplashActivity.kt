package com.projeto.starwars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    lateinit var splash: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splash = findViewById(R.id.image_logo)

        splash.alpha = 0f
        splash.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}