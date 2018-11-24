package dp.schoolandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int TEACHER_SELECTED = 1, STUDENT_SELECTED = 2, PARENT_SELECTED = 3;
    int selectedTab = -1;
    ImageView teacherImage;
    ImageView studentImage;
    ImageView parentImage;
    View revealView;
    TextView studentTextView;
    TextView parentTextView;
    TextView teacherTextView;
    Button chooseButton;
    ImageView view_done;
    Intent intent;
//    AnimatedButtonView loginAnimatedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacherImage = (ImageView) findViewById(R.id.iv_main_teacher_image);
        studentImage = (ImageView) findViewById(R.id.iv_main_student_image);
        parentImage = (ImageView) findViewById(R.id.iv_main_parent_image);

        teacherTextView = (TextView) findViewById(R.id.tv_main_teacher_label);
        studentTextView = (TextView) findViewById(R.id.tv_main_student_label);
        parentTextView = (TextView) findViewById(R.id.tv_main_parent_label);

        chooseButton = (Button) findViewById(R.id.btn_choose);
        view_done = (ImageView) findViewById(R.id.view_done);

        enterButtonEvent();
        teacherSelected();
        parentSelected();
        studentSelected();
    }

    private void enterButtonEvent() {
        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (selectedTab != -1) {
                            chooseButton.setVisibility(View.INVISIBLE);
                            delayedStartNextActivity();
                        }
                    }
                }, 600);
                view_done.setVisibility(View.VISIBLE);
            }
        });

    }

    private void delayedStartNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (selectedTab) {
                    case 1:
                        intent = new Intent(MainActivity.this, TeacherLoginActivity.class);
                        startActivity(intent);

                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, StudentLoginActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ParentLoginActivity.class);
                        startActivity(intent);
                        break;
                }
                finish();
            }
        }, 300);

    }

    private void teacherSelected() {
        teacherImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                selectedTab = TEACHER_SELECTED;
                teacherImage.setImageResource(R.drawable.img_un_checked_teacher);
                studentImage.setImageResource(R.drawable.img_checked_student);
                parentImage.setImageResource(R.drawable.img_checked_parent);
                chooseButton.setBackgroundResource(R.drawable.btn_background_white);
            }
        });
    }

    private void parentSelected() {
        parentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                selectedTab = PARENT_SELECTED;
                teacherImage.setImageResource(R.drawable.img_checked_teacher);
                studentImage.setImageResource(R.drawable.img_checked_student);
                parentImage.setImageResource(R.drawable.img_un_checked_parent);
                chooseButton.setBackgroundResource(R.drawable.btn_background_white);
            }
        });
    }

    private void studentSelected() {
        studentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                selectedTab = STUDENT_SELECTED;
                teacherImage.setImageResource(R.drawable.img_checked_teacher);
                studentImage.setImageResource(R.drawable.img_un_checked_student);
                parentImage.setImageResource(R.drawable.img_checked_parent);
                chooseButton.setBackgroundResource(R.drawable.btn_background_white);
            }
        });
    }
}
