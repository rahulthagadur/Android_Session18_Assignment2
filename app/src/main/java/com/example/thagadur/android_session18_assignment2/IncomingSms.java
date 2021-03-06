package com.example.thagadur.android_session18_assignment2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by me on 7/17/2016.
 */
public class IncomingSms extends BroadcastReceiver {

// Get the object of SmsManager
final SmsManager sms = SmsManager.getDefault();
    public void onReceive(Context context, Intent intent) {

            // Retrieves a map of extended data from the intent.
            final Bundle bundle = intent.getExtras();

            try {

                if (bundle != null) {

                    final Object[] pdusObj = (Object[]) bundle.get("pdus");

                    for (int i = 0; i < pdusObj.length; i++) {
//                        Get the Phone Number and the Sender Number and message using SmsMessage Object
                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                        String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                        String senderNum = phoneNumber;
                        String message = currentMessage.getDisplayMessageBody();

                        // Display the Message in the toast with the details sender Name , Message , Time Of received
                        Toast.makeText(context,"senderNum: "+ senderNum + ", message: " + message, Toast.LENGTH_LONG).show();

                    } // end for loop
                    } // bundle is null

                } catch (Exception e) {
                Log.e("SmsReceiver", "Exception smsReceiver" +e);

                }
            }
}
