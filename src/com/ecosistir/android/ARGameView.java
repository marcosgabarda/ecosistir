package com.ecosistir.android;

import com.ecosistir.animals.Abrelatas;
import com.ecosistir.examples.CustomRenderer;

import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;
import android.os.Bundle;
import android.util.Log;

public class ARGameView extends AndARActivity
{
	//private RealWord realWorld;
	Abrelatas abrelatas;
	ARToolkit artoolkit;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		//		WindowManager.LayoutParams.FLAG_FULLSCREEN);

		//setContentView(R.layout.aboard);
		//realWorld = new RealWord(this);
		//((FrameLayout) findViewById(R.id.frameLayout1)).addView(realWorld);
		
		CustomRenderer renderer = new CustomRenderer();//optional, may be set to null
		super.setNonARRenderer(renderer);//or might be omited
		
		try {
			//register a object for each marker type
			artoolkit = super.getArtoolkit();
			
			//abrelatas = Abrelatas.getInstance();
			abrelatas = new Abrelatas("abrelatas", "patt.hiro", 80.0, 
					new double[]{0.0});
			artoolkit.registerARObject(abrelatas);
			
		
		} catch (AndARException ex){
			//handle the exception, that means: show the user what happened
			Log.e("AndAR EXCEPTION", ex.getMessage());
		}
		
		startPreview();
	}

	public void uncaughtException(Thread thread, Throwable ex)
	{
		Log.e("AndAR EXCEPTION", ex.getMessage());
		finish();
	}

}
