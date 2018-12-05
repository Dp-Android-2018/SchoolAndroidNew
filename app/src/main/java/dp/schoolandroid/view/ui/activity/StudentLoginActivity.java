package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityStudentLoginBinding;
import dp.schoolandroid.service.model.response.studentresponse.StudentResponse;
import dp.schoolandroid.viewmodel.StudentLoginActivityViewModel;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;

public class StudentLoginActivity extends AppCompatActivity {


    ActivityStudentLoginBinding binding;
    StudentLoginActivityViewModel viewModel;
    ImageView view_done;
    Button btn_check;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_login);
        initViewModel();
        setUpAnimation();
    }

    private void initUi() {
        btn_check = (Button) findViewById(R.id.btn_student_login);
        view_done = (ImageView) findViewById(R.id.view_done);
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(StudentLoginActivityViewModel.class);
        binding.setViewModel(viewModel);
        // ObserverViewModel(viewModel);
    }
    public void ObserverViewModel(StudentLoginActivityViewModel viewModel) {
        if (viewModel !=null) {
           /* viewModel.getStudentLoginResponseLiveData().observe(this, new Observer<StudentResponse>() {
                @Override
                public void onChanged(@Nullable StudentResponse studentResponse) {
                    Toast.makeText(StudentLoginActivity.this,"Null Value ",Toast.LENGTH_LONG).show();
                }
            });*/
        }else {
            Toast.makeText(this,"Null Value ",Toast.LENGTH_LONG).show();
        }
    }

    private void checkButton() {
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_check.setVisibility(View.INVISIBLE);
                view_done.setVisibility(View.VISIBLE);
                Intent intent = new Intent(StudentLoginActivity.this, TopStudentDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }
}
