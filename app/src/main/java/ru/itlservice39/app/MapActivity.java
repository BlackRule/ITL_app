package ru.itlservice39.app;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
//import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

//public class SecondActivity extends ActionBarActivity {
public class MapActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		String url = getIntent().getStringExtra("url");
		WebView myWebView = (WebView) findViewById(R.id.webview);

		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
//		webSettings.setUseWideViewPort(true);
//		webSettings.setLoadWithOverviewMode(true);

//		myWebView.setWebViewClient(new MyWebViewClient());
		myWebView.loadUrl(url);
	}

	private class MyWebViewClient extends WebViewClient {
		/*@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url);

			return true;
		}*/

		/*@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			Toast.makeText(MapActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			Toast.makeText(MapActivity.this, "started! "+url, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			Toast.makeText(MapActivity.this, "finished! "+url, Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
			super.onReceivedHttpError(view, request, errorResponse);
			Toast.makeText(MapActivity.this, "Oherr", Toast.LENGTH_SHORT).show();

		}*/
	}
}