package dp.schoolandroid.view.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.schoolandroid.R;


public class StudentGradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade);
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_student_grade);
//        viewModel=ViewModelProviders.of(this).get(StudentGradeActivityViewModel.class);
//        binding.setViewModel(viewModel);
    }
}
