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
					startTourn();
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



		btnGreen.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
				btn1.setImageResource(R.drawable.ic_green_sel);
				final ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton3);
				btn2.setImageResource(R.drawable.ic_blue);
				final ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton4);
				btn3.setImageResource(R.drawable.ic_yellow);
				final ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton5);
				btn4.setImageResource(R.drawable.ic_orange);
			}
		});

		btnBlue.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
				btn1.setImageResource(R.drawable.ic_green);
				final ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton3);
				btn2.setImageResource(R.drawable.ic_blue_sel);
				final ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton4);
				btn3.setImageResource(R.drawable.ic_yellow);
				final ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton5);
				btn4.setImageResource(R.drawable.ic_orange);
			}
		});

		btnYellow.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
				btn1.setImageResource(R.drawable.ic_green);
				final ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton3);
				btn2.setImageResource(R.drawable.ic_blue);
				final ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton4);
				btn3.setImageResource(R.drawable.ic_yellow_sel);
				final ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton5);
				btn4.setImageResource(R.drawable.ic_orange);
			}
		});

		btnOrange.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				final ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton2);
				btn1.setImageResource(R.drawable.ic_green);
				final ImageButton btn2 = (ImageButton) findViewById(R.id.imageButton3);
				btn2.setImageResource(R.drawable.ic_blue);
				final ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton4);
				btn3.setImageResource(R.drawable.ic_yellow);
				final ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton5);
				btn4.setImageResource(R.drawable.ic_orange_sel);
			}
		});
	}

	protected void otherPlayer()
	{
		final EditText txtTexto = (EditText)findViewById(R.id.editText1);
		String texto = txtTexto.getText().toString();
		if (texto.trim().compareTo("") == 0)
		{
			texto = "Jugador " + (game.getPlayers().size() + 1);
		}
		player.setName(texto);
		player.setNumber(game.getPlayers().size() + 1);
		game.addPlayer(player);
		Intent intent = new Intent(this, PlayerForm.class);
		startActivity(intent);
	}

    protected void startTourn()
    {
		Intent intent = new Intent(this, InitTourn.class);
		startActivity(intent);
    }
}
