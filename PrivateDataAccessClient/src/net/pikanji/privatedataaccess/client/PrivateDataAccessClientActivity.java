package net.pikanji.privatedataaccess.client;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class PrivateDataAccessClientActivity extends Activity {
    private static final String KEY = "private_data";

    private static final String SERVER_PKG = "net.pikanji.privatedataaccess.server";
    private static final String SERVER_CLASS = ".PrivateDataProviderActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textPid = (TextView) findViewById(R.id.text_pid);
        textPid.setText("PID: " + String.valueOf(Process.myPid()));
        
        SharedPreferences mSp = this.getSharedPreferences("server_data", MODE_PRIVATE);
        String value = mSp.getString(KEY, "Android currently (API lvl 15) does not support direct access to SharedPreferences of other application.");
        TextView textDirect = (TextView) findViewById(R.id.text_direct_access);
        textDirect.setText(value);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_UP == event.getAction()) {
            Intent intent = new Intent();
            intent.setClassName(SERVER_PKG, SERVER_PKG + SERVER_CLASS);
            startActivityForResult(intent, 0);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this, data.getStringExtra("data"), Toast.LENGTH_LONG).show();
    }
}