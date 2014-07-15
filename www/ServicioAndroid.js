/*
The parameters will be mapped to the native Java class as follows:

the service name maps to the name of your native plugin class
the action name is passed as the first parameter of the execute() method
the arguments array is passed as a JSONArray in the second parameter of execute()
the success and error callback functions are passed as part of a CallbackContext object
   in the third parameter of execute()
*/

var servicio = {
    createEvent: function(title, location, notes, startDate, endDate, successCallback, errorCallback) {
 		cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'ServicioAndroid', // mapped to our native Java class called "Calendar"
            'addServicioAndroidEntry', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "title": title,
                "description": notes,
                "eventLocation": location,
                "startTimeMillis": startDate.getTime(),
                "endTimeMillis": endDate.getTime()
            }]
        ); 
    }
}

module.exports = servicio;