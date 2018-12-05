package dp.schoolandroid.view.ui.activity;

import android.app.ActivityOptions;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityMainBinding;
import dp.schoolandroid.viewmodel.MainActiviyViewModel;


public class MainActivity extends AppCompatActivity {
    //data binding
    ActivityMainBinding mBinding;
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
    ActivityOptions options;
    Intent i;
    MainActiviyViewModel dataviewModel;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataviewModel=ViewModelProviders.of(this).get(MainActiviyViewModel.class);
        mBinding.setMainActivityData(dataviewModel);

        teacherImage = (ImageView) findViewById(R.id.iv_main_teacher_image);
        studentImage = (ImageView) findViewById(R.id.iv_main_student_image);
        parentImage = (ImageView) findViewById(R.id.iv_main_parent_image);

        teacherTextView = (TextView) findViewById(R.id.tv_main_teacher_label);
        studentTextView = (TextView) findViewById(R.id.tv_main_student_label);
        parentTextView = (TextView) findViewById(R.id.tv_main_parent_label);

        chooseButton = (Button) findViewById(R.id.btn_choose);
        view_done = (ImageView) findViewById(R.id.view_done);

//        setupWindowAnimations();

        enterButtonEvent();
        teacherSelected();
        parentSelected();
        studentSelected();
    }

    private void enterButtonEvent() {
        chooseButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (selectedTab != -1) {
                    StartNextActivity();
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void StartNextActivity() {
        switch (selectedTab) {
            case 1:
                options = ActivityOptions.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, TeacherLoginActivity.class);
                startActivity(i, options.toBundle());
                break;
            case 2:
                options = ActivityOptions.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(i, options.toBundle());
                break;
            case 3:
                options = ActivityOptions.makeSceneTransitionAnimation(this);
                i = new Intent(MainActivity.this, ParentLoginActivity.class);
                startActivity(i, options.toBundle());
                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
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
