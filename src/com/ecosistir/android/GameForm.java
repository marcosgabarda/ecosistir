package com.ecosistir.android;

import com.ecosistir.game.Duration;
import com.ecosistir.game.Game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class GameForm extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.game);

		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/SRF2.ttf");
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		tv1.setTypeface(tf);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		tv2.setTypeface(tf);

		final Spinner cmbOpciones = (Spinner)findViewById(R.id.spinner1);

		final String[] datos = new String[] {"2","3","4"};

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, datos);

		adaptador.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);

		cmbOpciones.setAdapter(adaptador);

		final ImageButton btnShort = (ImageButton) findViewById(R.id.imageButton1);
		btnShort.setClickable(true);
		btnShort.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				Game game = Game.getGame();
				game.setDuration(Duration.SHORT);
				createPlayers();
			}
		});

		final ImageButton btnMedium = (ImageButton) findViewById(R.id.imageButton2);
		btnMedium.setClickable(true);
		btnMedium.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				Game game = Game.getGame();
				game.setDuration(Duration.MEDIUM);
				createPlayers();
			}
		});

		final ImageButton btnLong = (ImageButton) findViewById(R.id.imageButton3);
		btnLong.setClickable(true);
		btnLong.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				Game game = Game.getGame();
				game.setDuration(Duration.LONG);
				createPlayers();
			}
		});
	}

	protected void createPlayers()
	{
		Game game = Game.getGame();
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		int players = Integer.valueOf((String)spinner.getSelectedItem());
		game.setNumPlayers(players);
		Intent intent = new Intent(this, PlayerForm.class);
		startActivity(intent);
	}
}
