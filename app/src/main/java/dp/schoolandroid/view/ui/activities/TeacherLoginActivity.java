package dp.schoolandroid.view.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityTeacherLoginBinding;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;

public class TeacherLoginActivity extends AppCompatActivity {


    ActivityTeacherLoginBinding binding;
    TeacherLoginActivityViewModel viewModel;
    ImageView view_done;
    Button btn_check;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_teacher_login);
        viewModel=ViewModelProviders.of(this).get(TeacherLoginActivityViewModel.class);
        binding.setViewModel(viewModel);


        setUpAnimation();

        btn_check=(Button)findViewById(R.id.btn_teacher_login);
        view_done=(ImageView)findViewById(R.id.view_done);
        checkButton();
    }
    private void checkButton(){
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_check.setVisibility(View.INVISIBLE);
                view_done.setVisibility(View.VISIBLE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation(){
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }

}
