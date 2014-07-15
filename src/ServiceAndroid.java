package com.example.myplugin;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;


public class ServiceAndroid extends IntentService{

	/**
	   * A constructor is required, and must call the super IntentService(String)
	   * constructor with a name for the worker thread.
	   */
	  public ServiceAndroid() {
	      super("HelloIntentService");
	  }

	  /**
	   * The IntentService calls this method from the default worker thread with
	   * the intent that started the service. When this method returns, IntentService
	   * stops the service, as appropriate.
	   */
	  @Override
	  protected void onHandleIntent(Intent intent) {
	      // Normally we would do some work here, like download a file.
	      
		  MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.yoshi);
		  while (true) {
	          synchronized (this) {
	              try {
	            	  mediaPlayer.start(); // no need to call prepare(); create() does that for you
	              } catch (Exception e) {
	              }
	          }
	      }
		 
	  }
}
