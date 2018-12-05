package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityTeacherLoginBinding;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;

public class TeacherLoginActivity extends AppCompatActivity {


    ActivityTeacherLoginBinding binding;
    ImageView view_done;
    Button btn_check;
    TeacherLoginActivityViewModel viewModel;

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
       // ObserverViewModel(viewModel);
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

    public void startNewActivity(){
        Intent intent=new Intent(this,TopStudentDetailsActivity.class);
        startActivity(intent);
    }
    public void ObserverViewModel(TeacherLoginActivityViewModel viewModel) {
        if (viewModel !=null) {
            /*viewModel.getTeacherLoginResponseLiveData().observe(this, new Observer<LoginResponse>() {
                @Override
                public void onChanged(@Nullable LoginResponse teacherLoginResponse) {
                    if (teacherLoginResponse != null) {
                        System.out.println("Teacher Data :" + new Gson().toJson(teacherLoginResponse.getTeacherData()));
                        Toast.makeText(TeacherLoginActivity.this, "Teacher Data :" + new Gson().toJson(teacherLoginResponse.getTeacherData()), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(TeacherLoginActivity.this, "Observe Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/
        }else {
            Toast.makeText(TeacherLoginActivity.this,"Null Value ",Toast.LENGTH_LONG).show();
        }
    }

}
