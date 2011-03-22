package com.ecosistir.android;

import com.ecosistir.game.Game;
import com.ecosistir.game.Player;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class InitTourn extends Activity 
{
	private Game game = Game.getGame();
	
	private Player player = game.getCurrentPlayer();;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inittourn);
        
        Typeface tf = Typeface.createFromAsset(getAssets(),
        		"fonts/SRF2.ttf");
        
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setText(tv1.getText() + " " + (game.getCurrentRound() + 1));
        tv1.setTypeface(tf);
        
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText(player.getName());
        tv2.setTypeface(tf);
        
		final ImageButton btnStart = (ImageButton) findViewById(R.id.imageButton1);
		btnStart.setClickable(true);
		btnStart.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				renderBoard();
			}
		});
	}
	
	protected void renderBoard()
	{
		Intent intent = new Intent(this, ARGameView.class);
		startActivity(intent);
	}
}
