package cn.edu.gdmec.s07150731.intent;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;

        import javax.net.ssl.HttpsURLConnection;

        import android.app.Activity;
        import android.content.Context;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends Activity {

    Button btn_test,btn_connect;
    TextView tv;
    EditText ed;
    HttpsURLConnection conn;
    URL url;
    InputStream is;
    String name;
    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo info = cm.getActiveNetworkInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.textView1);
        ed = (EditText) findViewById(R.id.editText1);
        btn_connect = (Button) findViewById(R.id.button2);


        btn_connect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // 连接
                name=ed.getText().toString();
                //服务器地址
                String urlDate = "http://192.168.14.229:80/home/getInfo";

                try {
                    url = new URL(urlDate);
                    try {
                        conn = (HttpsURLConnection) url.openConnection();
                        conn.connect();

                        is= conn.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        //创建sb对象储存所有数据。
                        StringBuffer sb = new StringBuffer();
                        while((line=br.readLine())!=null){
                            sb.append(line);
                        }

                        //显示

                        tv.setText(sb.toString());
                        System.out.println(sb.toString());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });


        btn_test.setOnClickListener(new OnClickListener() {



            @Override
            public void onClick(View arg0) {
                // 网络

                if(info!=null){
                    Toast.makeText(MainActivity.this, "联网正常"+info.getTypeName(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "未联网", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
