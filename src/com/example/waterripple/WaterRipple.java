package com.example.waterripple;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WaterRipple extends Activity {


	private ImageView ivRipple;

	private RelativeLayout relativeLayout;

	private Animation anim; 
	private AnimationListener animListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterripple);

		relativeLayout = (RelativeLayout) findViewById(R.id.rootLayout);
		animListener = new AnimListener(relativeLayout);

		relativeLayout.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int eventAction = event.getAction();

				switch(eventAction) {
				case MotionEvent.ACTION_DOWN: {
					/* Get x and y co-ordinates from the touch on screen */
					float TouchX = event.getX();
					float TouchY = event.getY();

					/* Create a new ripple image view everytime a touch occurs */
					ivRipple = new ImageView(WaterRipple.this);
					ivRipple.setLayoutParams(new ViewGroup.LayoutParams(
							ViewGroup.LayoutParams.MATCH_PARENT,
							ViewGroup.LayoutParams.MATCH_PARENT));
					ivRipple.setImageResource(R.drawable.ripplering4);

					/* Set the imageview to the touch co-ordinates */
					RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50,50);
					params.leftMargin = (int) TouchX;
					params.topMargin = (int) TouchY;
					relativeLayout.addView(ivRipple, params);

					/* Create new animation object everytime a touch occurs  */
					anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ripplescale);
					ivRipple.setAnimation(anim);

					/* Animation listener to clear the image view once animation is complete  */
					anim.setAnimationListener(animListener);
					break;
				}
				}   
				return true;
			}
		});



	}

}

class AnimListener implements AnimationListener {

	private RelativeLayout relativeLayout;

	public AnimListener(RelativeLayout rl) {
		relativeLayout = rl;
	}

	@Override
	public void onAnimationEnd(Animation animation) {

	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}

	@Override
	public void onAnimationStart(Animation animation) {
		try{
			relativeLayout.removeAllViews();
		} catch(Exception e){}
	}

}