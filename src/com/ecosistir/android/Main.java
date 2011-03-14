package com.ecosistir.android;

import com.ecosistir.game.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        final ImageButton btnNewGame = (ImageButton) findViewById(R.id.imageButton1);
        btnNewGame.setClickable(true);
        btnNewGame.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				Game.newGame();
				launchNewGame();
			}
		});
    }
    
    protected void launchNewGame()
    {
		Intent intent = new Intent(this, GameForm.class);
		startActivity(intent);
    }
}