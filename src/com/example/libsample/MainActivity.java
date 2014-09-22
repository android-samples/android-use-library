package com.example.libsample;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.os.Build;

/*
 * ライブラリとして Universal Image Loader を使ってみるサンプル。
 * ・libs フォルダに *.jar と *.jar.properties を設置。
 * ・libs_meta フォルダに *-javadoc.jar と *-sources.jar を設置。
 * ・PERMISSION として INTERNET を追加
 * 
 * Universal Image Loader
 * https://github.com/nostra13/Android-Universal-Image-Loader
 */

public class MainActivity extends Activity {

	public void buttonMethod(View button){
		// ImageView取得
		ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		
		// 取得URL
		String url = "http://www.hal.ac.jp/img/index_main_def_bg.jpg";
		
		// ImageLoaderによる画像ロード
		ImageLoader.getInstance().displayImage(url, imageView);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ImageLoader初期化
		ImageLoaderConfiguration conf = 
			new ImageLoaderConfiguration.Builder(getApplicationContext())
				.memoryCache(new LruMemoryCache(2000000))
				.memoryCacheSize(2000000)
				.build();
		ImageLoader.getInstance().init(conf);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
