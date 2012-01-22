package net.pikanji.privatedataaccess.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import android.widget.TextView;

public class PrivateDataAccessClientActivity extends Activity {
    private static final String SERVER_PKG = "net.pikanji.privatedataaccess.server";
    private static final String SERVER_CLASS = ".PrivateDataAccessServerActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textPid = (TextView) findViewById(R.id.text_pid);
        textPid.setText(String.valueOf(Process.myPid()));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_UP == event.getAction()) {
            Intent intent = new Intent();
            intent.setClassName(SERVER_PKG, SERVER_PKG + SERVER_CLASS);
            startActivity(intent);
        }
        return true;
    }
}