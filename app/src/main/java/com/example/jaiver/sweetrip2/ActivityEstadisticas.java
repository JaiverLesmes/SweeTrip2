package com.example.jaiver.sweetrip2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ActivityEstadisticas extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        webView = (WebView) findViewById(R.id.webview);
        String url = "https://app.powerbi.com/view?r=eyJrIjoiZjhiOGNiZTMtMTE3Ny00NGQ1LWFhZDgtNGM3YTg4ODNjMGVlIiwidCI6ImUzMmNmMTIxLTcwMjYtNDU4Ni1iYWRjLTg0MDMzYzU5ZDM1OSIsImMiOjR9";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        getSupportActionBar().hide();

        /*String html = "<iframe width=\"800\" height=\"600\" style=\"border: 1px solid #cccccc;\" src=\"https://app.powerbi.com/view?r=eyJrIjoiZjhiOGNiZTMtMTE3Ny00NGQ1LWFhZDgtNGM3YTg4ODNjMGVlIiwidCI6ImUzMmNmMTIxLTcwMjYtNDU4Ni1iYWRjLTg0MDMzYzU5ZDM1OSIsImMiOjR9\" ></iframe>";
        webView.loadData(html, "text/html", null);*/
    }
}
