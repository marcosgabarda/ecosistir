package com.ecosistir.android;

import com.ecosistir.graphics.BoxObject;
import com.ecosistir.graphics.Renderer;

import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
<<<<<<< HEAD
import android.view.SurfaceHolder;
=======
>>>>>>> b50b597d0a382cc31dca3965e702493c0fa23905

public class ARGameView extends AndARActivity implements SurfaceHolder.Callback
{
<<<<<<< HEAD
	public static String TAG = "ecosistir";
	
	private ProgressDialog waitDialog;
	private Resources res;
	
	private BoxObject someObject1 = null;
	private BoxObject someObject2 = null;
	private BoxObject someObject3 = null;
	
=======
	//private RealWord realWorld;
	Abrelatas abrelatas;
>>>>>>> b50b597d0a382cc31dca3965e702493c0fa23905
	ARToolkit artoolkit;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
<<<<<<< HEAD
		super.setNonARRenderer(new Renderer());
		res = getResources();
		artoolkit = super.getArtoolkit();
		getSurfaceView().getHolder().addCallback(this);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		super.surfaceCreated(holder);
    	if(someObject1 == null && someObject2 == null &&
    			someObject3 == null)
    	{
    		waitDialog = ProgressDialog.show(this, "", 
	                res.getText(R.string.loading), true);
			waitDialog.show();
			new BoardLoader().execute();
=======
		
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
>>>>>>> b50b597d0a382cc31dca3965e702493c0fa23905
		}
	}

	public void uncaughtException(Thread thread, Throwable ex)
	{
<<<<<<< HEAD
		Log.e(TAG, ex.getMessage());
=======
		Log.e("AndAR EXCEPTION", ex.getMessage());
>>>>>>> b50b597d0a382cc31dca3965e702493c0fa23905
		finish();
	}
	
	private class BoardLoader extends AsyncTask<Void, Void, Void>
	{
		@Override
		protected Void doInBackground(Void... params)
		{
			someObject1 = new BoxObject("test", "patt.hiro", 80.0, new double[]{0,0});
			someObject2 = new BoxObject("test", "android.patt", 80.0, new double[]{0,0});
			someObject3 = new BoxObject("test", "barcode.patt", 80.0, new double[]{0,0});
			return null;
		}
		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			waitDialog.dismiss();
			try
			{
				artoolkit.registerARObject(someObject1);
				artoolkit.registerARObject(someObject2);
				artoolkit.registerARObject(someObject3);
			}
			catch (AndARException ex)
			{
				Log.e(TAG, ex.getMessage());
			}
			startPreview();
		}
		
	}

}
