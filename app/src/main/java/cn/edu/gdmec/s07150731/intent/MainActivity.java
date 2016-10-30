package cn.edu.gdmec.s07150731.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eText;
    private Button button;
    private TextView tText;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_demo);

        eText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        tText = (TextView) findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("value",eText.getText().toString());
                Intent intent = new Intent(MainActivity.this,Intent2.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,10);

            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                tText.setText(bundle.getString("result"));
        }
    }
}
