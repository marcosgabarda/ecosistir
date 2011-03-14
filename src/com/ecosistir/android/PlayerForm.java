package com.ecosistir.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class PlayerForm extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.player);
		
		final ImageButton btn = (ImageButton) findViewById(R.id.imageButton1);
		btn.setClickable(true);
		btn.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				goPreview();
			}
		});
		
	}
	
    protected void goPreview()
    {
		Intent intent = new Intent(this, ARGameView.class);
		startActivity(intent);
    }
}
