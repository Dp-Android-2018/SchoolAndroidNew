package dp.schoolandroid.view.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityAssignementDescribtionLayoutBinding;
import dp.schoolandroid.viewmodel.TopStudentDetailsActivityViewModel;

public class TopStudentDetailsActivity extends AppCompatActivity {

    ActivityAssignementDescribtionLayoutBinding binding;
    TopStudentDetailsActivityViewModel viewModel;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_assignement_describtion_layout);
        viewModel=ViewModelProviders.of(this).get(TopStudentDetailsActivityViewModel.class);
        binding.setViewModel(viewModel);

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
