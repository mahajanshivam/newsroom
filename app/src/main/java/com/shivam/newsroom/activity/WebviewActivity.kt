package com.shivam.newsroom.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shivam.newsroom.R
import kotlinx.android.synthetic.main.activity_webview.*


class WebviewActivity : AppCompatActivity() {

    var url: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        url = intent.getStringExtra("url")

        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        webView.loadUrl(url)
    }
}
