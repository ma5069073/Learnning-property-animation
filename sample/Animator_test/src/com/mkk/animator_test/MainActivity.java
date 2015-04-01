package com.mkk.animator_test;

import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	int[] res = { R.id.iva, R.id.ivb, R.id.ivc, R.id.ivd, R.id.ive, R.id.ivf,
			R.id.ivg, R.id.ivh }; 

	List<ImageView> list = new ArrayList<ImageView>();
	boolean falg = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		for (int i = 0; i < res.length; i++) {
			ImageView iv = (ImageView) findViewById(res[i]);
			iv.setOnClickListener(this);
			list.add(iv);
		}
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iva:
			if (falg) {
				startAnim();
			} else {
				endAnim();
			}
			falg = !falg;

			break;

		default:
			
			Toast.makeText(this, "onclick"+v.getId(), Toast.LENGTH_SHORT).show();
			break;
		}
	}

	private void endAnim() {
		for (int i = 1; i < res.length; i++) {
			ObjectAnimator animator = ObjectAnimator.ofFloat(list.get(i),
					"translationY", i * 100,0F);
			animator.setDuration(300);
			animator.setStartDelay(300*i);
			animator.setInterpolator(new AccelerateInterpolator());
			animator.start();
		}
	}

	private void startAnim() {
		for (int i = 1; i < res.length; i++) {
			ObjectAnimator animator = ObjectAnimator.ofFloat(list.get(i),
					"translationY",0F, i * 100);
			animator.setDuration(300);
			animator.setStartDelay(300*i);
			animator.setInterpolator(new BounceInterpolator());
			animator.start();
		}
	}
}
