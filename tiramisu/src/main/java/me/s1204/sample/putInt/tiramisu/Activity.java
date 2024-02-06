package me.s1204.sample.putInt.tiramisu;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

public class Activity extends android.app.Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finishAndRemoveTask();
        if (Settings.System.canWrite(this)) {
            try {
                Settings.System.putInt(getContentResolver(), "dcha_state", 1);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to write value.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Please enable toggle switch.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName())).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }
}
