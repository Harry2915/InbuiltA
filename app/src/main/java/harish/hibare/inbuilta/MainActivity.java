package harish.hibare.inbuilta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

    }

    public void testing(View view) {
        switch (view.getId())
        {
            case R.id.button:
                Intent intent_set = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent_set);
                break;

            case R.id.button2:
                String s_number="9689856406";
                Intent intent_call = new Intent(Intent.ACTION_CALL);
                intent_call.setData(Uri.parse("tel:"+s_number));
                startActivity(intent_call);
                break;

            case R.id.button3:
                String sms_number="9689856406";
                String s_message="Happy World Skills Youth Day";
                //Intent
                Intent intent_SMS= new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pendingIntent_SMS=PendingIntent.getActivity(getApplicationContext(),0,intent_SMS,0);

                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(sms_number,null,s_message,pendingIntent_SMS,null);
                break;

            case R.id.button4:
                String number="+917276847050";
                String url = "https://api.whatsapp.com/send?phone="+number;
                Intent intent_whatsapp = new Intent(Intent.ACTION_VIEW);
                intent_whatsapp.setData(Uri.parse(url));
                startActivity(intent_whatsapp);
                break;
        }
    }
}