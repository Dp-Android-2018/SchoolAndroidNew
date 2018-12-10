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
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import dp.schoolandroid.DayFragment;
import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityTeacherLoginBinding;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;

public class TeacherLoginActivity extends AppCompatActivity {


    ActivityTeacherLoginBinding binding;
    ImageView view_done;
    Button btn_check;
    TeacherLoginActivityViewModel viewModel;
    DayFragment dayFragment=new DayFragment();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_login);
        initViewModel();
        setUpAnimation();

    }

    public void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(TeacherLoginActivityViewModel.class);
        binding.setViewModel(viewModel);
//        ObserverViewModel(viewModel);
    }

    public void initUi() {
        btn_check = (Button) findViewById(R.id.btn_teacher_login);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }


    public void ObserverViewModel(final TeacherLoginActivityViewModel viewModel) {


            /*.observe(this, new Observer<TeacherResponse>() {
                @Override
                public void onChanged(@Nullable TeacherResponse teacherResponse) {
                    if (teacherResponse != null) {
                        Toast.makeText(TeacherLoginActivity.this, "value changed", Toast.LENGTH_SHORT).show();
                        dayFragment.setBearerToken(teacherResponse.getTeacherData().getApiToken());
//                            startNewActivity();
                    }
                }
            });*/

    }

    public void startNewActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
