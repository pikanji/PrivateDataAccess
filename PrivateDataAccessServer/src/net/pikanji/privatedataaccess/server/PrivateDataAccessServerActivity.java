package net.pikanji.privatedataaccess.server;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrivateDataAccessServerActivity extends Activity implements View.OnClickListener {
    private static final String KEY = "private_data";
    private Button mButtonSave;
    private Button mButtonLoad;
    private EditText mEditSave;
    private TextView mTextLoad;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textPid = (TextView) findViewById(R.id.text_pid);
        textPid.setText(String.valueOf(Process.myPid()));
        
        mButtonSave = (Button) findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(this);
        mButtonLoad = (Button) findViewById(R.id.button_load);
        mButtonLoad.setOnClickListener(this);

        mEditSave = (EditText) findViewById(R.id.edit_save);
        mTextLoad = (TextView) findViewById(R.id.text_load);
        
        mSp = this.getPreferences(MODE_PRIVATE);
        mEditor = mSp.edit();
        
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.button_save == id) {
            mEditor.putString(KEY, mEditSave.getText().toString());
            mEditor.commit();
        } else if (R.id.button_load == id) {
            mTextLoad.setText(mSp.getString(KEY, "Not loaded..."));
        }
    }
}