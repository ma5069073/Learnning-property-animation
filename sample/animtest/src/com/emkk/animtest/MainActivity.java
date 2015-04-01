package com.emkk.animtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.imageView1);
	}

	public void onclick(View v) {

		Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
	}

	public void move(View v) {
		//视图动画
		// TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
		// animation.setDuration(200);
		// animation.setFillAfter(true);
		// imageView.startAnimation(animation);

		//一、属性动画 
//		ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f).setDuration(1000)
//				.start();
//		ObjectAnimator.ofFloat(imageView, "translationY", 0f, 200f).setDuration(1000)
//		.start();
//		ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f).setDuration(1000)
//		.start();
//		
		
		//二、属性动画
		PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0f, 200f);
		PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0f, 200f);
		PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
		ObjectAnimator.ofPropertyValuesHolder(imageView, p1,p2,p3).setDuration(1000).start();
		
		
//		//顺序播放动画
//		ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f);
//		ObjectAnimator anim2 = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 200f);
//		ObjectAnimator anim3 = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
//		
//		AnimatorSet set = new AnimatorSet();
//		
//		set.play(anim1).with(anim2);
//		set.play(anim3).after(anim2);
//		set.playSequentially(anim1,anim2,anim3);
//		set.setDuration(1000);
//		set.start();
		
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
}
