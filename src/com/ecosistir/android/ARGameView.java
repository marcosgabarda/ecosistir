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
import android.view.SurfaceHolder;


public class ARGameView extends AndARActivity implements SurfaceHolder.Callback
{
	public static String TAG = "ecosistir";

	private ProgressDialog waitDialog;
	private Resources res;

	private BoxObject someObject1 = null;
	private BoxObject someObject2 = null;
	private BoxObject someObject3 = null;

	ARToolkit artoolkit;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
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
		}
	}

	public void uncaughtException(Thread thread, Throwable ex)
	{
		Log.e(TAG, ex.getMessage());
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
