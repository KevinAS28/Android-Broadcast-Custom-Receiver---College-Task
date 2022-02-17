package com.example.broadcastcustomreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level * 100 / (float)scale;

        String msg = "";
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                if (batteryPct>=99){
                    msg = "It's a good idea to disconnect your charger now";
                }else{
                    msg = "Charging " + String.valueOf((batteryPct));
                }
                msg = "Charging " + String.valueOf((batteryPct)) + "|" + ;
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                if (batteryPct<=30){
                    msg = "It's a good idea to enable power saver now";
                } else{
                    msg = "Discharged"  + String.valueOf((batteryPct));
                }
                break;
            case MainActivity.ACTION_CUSTOM_BROADCAST:
                msg = intent.getStringExtra("msg_to_custom0");
                break;
            default:
                msg = "Default msgnya belum diganti...";
                break;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}