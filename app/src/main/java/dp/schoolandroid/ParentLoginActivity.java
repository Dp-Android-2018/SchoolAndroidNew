package dp.schoolandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ParentLoginActivity extends AppCompatActivity {

    Button btn_check;
    TextView signIn_textView;
    EditText teacher_phone_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);

        btn_check=(Button)findViewById(R.id.btn_parent_check);
        signIn_textView=(TextView)findViewById(R.id.signIn_textView);
        teacher_phone_text=(EditText)findViewById(R.id.teacher_phone_text);

        checkButton();
    }
   private void checkButton(){
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn_textView.setText(R.string.msg_have_sms);
                teacher_phone_text.setHint(R.string.password);
            }
        });
    }
}
