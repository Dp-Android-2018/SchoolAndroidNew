package dp.schoolandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopStudentDetailsActivity extends AppCompatActivity {

    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignement_describtion_layout);

        btn_send=(Button)findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TopStudentDetailsActivity.this,FeedDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

}
