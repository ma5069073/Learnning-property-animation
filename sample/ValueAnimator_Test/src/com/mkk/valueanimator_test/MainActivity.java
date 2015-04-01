package com.mkk.valueanimator_test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v){
		//获取按钮组件
		final Button b = (Button)v;
		// 生成ValueAnimator对象
		final ValueAnimator animator = ValueAnimator.ofInt(0,30);
		animator.setDuration(30*1000);
		//添加Interpolator
		animator.setInterpolator(new LinearInterpolator());
		//为动画添加update监听
		animator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Integer i = (Integer) animator.getAnimatedValue();
				b.setEnabled(false);
				b.setText(" "+i);
			}
		});
		//为动画添加监听 重写动画结束方法
		animator.addListener(new AnimatorListenerAdapter(){
			
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				b.setEnabled(true);
			}
		});
		//启动动画
		animator.start();
	}
}
