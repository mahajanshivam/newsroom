package com.shivam.newsroom.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
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
        webView.settings.builtInZoomControls = false

        webView.isFocusable = true
        webView.isFocusableInTouchMode = true
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.settings.domStorageEnabled = true
        webView.settings.databaseEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.setAppCacheEnabled(true)
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        webView.loadUrl(url)
    }
}
