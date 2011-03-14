package com.ecosistir.android;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RealWord extends SurfaceView implements SurfaceHolder.Callback
{
	private Camera camera;
	private SurfaceHolder mHolder;
	
	public RealWord(Context context)
	{
		super(context);
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height)
	{
		Camera.Parameters parameters = camera.getParameters();
		parameters.setPreviewSize(width, height);
		camera.setParameters(parameters);
		camera.startPreview();
	}

	public void surfaceCreated(SurfaceHolder holder)
	{
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(holder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		camera.stopPreview();
		camera = null;
	}
}
