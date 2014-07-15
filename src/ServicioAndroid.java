package com.example.myplugin;
 
/*
 Note that in addition to the CordovaPlugin class.
 we’ll also need to import the cordova CallbackContext to use for sending back success or error messages,
 as well as the JSON classes to handle arguments passed in. 
 Add the following code to the very top of your Calendar.java class.
*/
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

//android
import android.app.Activity;
import android.content.Intent;

public class ServicioAndroid extends CordovaPlugin {
	// This is the action that we’ll pass in from the
	// JavaScript side when we want to add a ServicioAndroid entry
	// You can imagine that many plugins will have multiple actions
	// that can be performed and these could all be defined in a similar fashion
	public static final String ACTION_ADD_SERVICE_ENTRY = "addServicioAndroidEntry";

	// This method is inherited from the CordovaPlugin class
	// so we’ll add the @Override annotation as well
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
  		//
  		try {
		    if (ACTION_ADD_SERVICE_ENTRY.equals(action)) { 
		             JSONObject arg_object = args.getJSONObject(0);
		             Intent calIntent = new Intent(this, ServiceAndroid.class);
		        .setType("vnd.android.cursor.item/event")
		        .putExtra("title", arg_object.getString("title"))
		        .putExtra("eventLocation", arg_object.getString("eventLocation"));
		        .putExtra("description", arg_object.getString("description"))
		        .putExtra("beginTime", arg_object.getLong("startTimeMillis"))
		        .putExtra("endTime", arg_object.getLong("endTimeMillis"))
		        		        		 
		       this.cordova.getActivity().startService(callIntent);;
		       callbackContext.success();
		       return true;
		    }
		    callbackContext.error("Invalid action");
		    return false;
		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage());
		    return false;
		} 
	}
}