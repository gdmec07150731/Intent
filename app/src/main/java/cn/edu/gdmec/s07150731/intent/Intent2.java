package cn.edu.gdmec.s07150731.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intent2 extends AppCompatActivity {

    private Button button;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        button = (Button) findViewById(R.id.button2);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        value = bundle.getString("value");
        value = value.toUpperCase();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result",value);
                Intent2.this.setResult(RESULT_OK,intent);
                Intent2.this.finish();
            }
        });


    }
}
