package dp.schoolandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentLoginActivity extends AppCompatActivity {
    ImageView view_done;
    Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        btn_check=(Button)findViewById(R.id.btn_student_login);
        view_done=(ImageView)findViewById(R.id.view_done);
        checkButton();
    }
    private void checkButton(){
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               btn_check.setVisibility(View.INVISIBLE);
               view_done.setVisibility(View.VISIBLE);
                Intent intent=new Intent(StudentLoginActivity.this,TopStudentDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
