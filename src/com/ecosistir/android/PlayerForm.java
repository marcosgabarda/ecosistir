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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayerForm extends Activity
{
	private Game game = Game.getGame();
	
	private Player player = new Player();
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.player);
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/SRF2.ttf");
		TextView title = (TextView) findViewById(R.id.textView1);
		title.setText("Jugador " + (game.getPlayers().size() + 1));
		title.setTypeface(tf);
		
		TextView t1 = (TextView) findViewById(R.id.textView2);
		t1.setTypeface(tf);
		TextView t2 = (TextView) findViewById(R.id.textView3);
		t2.setTypeface(tf);
		
		final EditText txtTexto = (EditText)findViewById(R.id.editText1);
		txtTexto.setText(player.getName());
				
		final ImageButton btn = (ImageButton) findViewById(R.id.imageButton1);
		btn.setClickable(true);
		btn.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				if (game.getNumPlayers() == game.getPlayers().size() + 1)
				{
					goPreview();
				}
				else
				{
					otherPlayer();
				}
			}
		});
		
		final ImageButton btnGreen = (ImageButton) findViewById(R.id.imageButton2);
		final ImageButton btnBlue = (ImageButton) findViewById(R.id.imageButton3);
		final ImageButton btnYellow = (ImageButton) findViewById(R.id.imageButton4);
		final ImageButton btnOrange = (ImageButton) findViewById(R.id.imageButton5);
		
		OnClickListener animalsListener = new OnClickListener()
		{
			public void onClick(View v)
			{
				//TODO
			}
		};
		
		btnGreen.setOnClickListener(animalsListener);
		btnBlue.setOnClickListener(animalsListener);
		btnYellow.setOnClickListener(animalsListener);
		btnOrange.setOnClickListener(animalsListener);
	}
	
	protected void otherPlayer()
	{
		final EditText txtTexto = (EditText)findViewById(R.id.editText1);
		String texto = txtTexto.getText().toString();
		player.setName(texto);
		game.addPlayer(player);
		Intent intent = new Intent(this, PlayerForm.class);
		startActivity(intent);
	}
	
    protected void goPreview()
    {
		Intent intent = new Intent(this, ARGameView.class);
		startActivity(intent);
    }
}
