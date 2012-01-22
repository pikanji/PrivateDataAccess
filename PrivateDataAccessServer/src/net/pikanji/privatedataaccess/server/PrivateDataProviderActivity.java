package net.pikanji.privatedataaccess.server;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class PrivateDataProviderActivity extends Activity {
    private static final String KEY = "private_data";

    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        mSp = this.getSharedPreferences("server_data", MODE_PRIVATE);
        String value = mSp.getString(KEY, "Not stored, or failed to restore...");
        Log.d("PrivateDataProviderActivity", value);
        
        Intent intent = this.getIntent();
        if (null != intent) {
            Intent data = new Intent();
            data.putExtra("data", value);
            this.setResult(RESULT_OK, data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}
