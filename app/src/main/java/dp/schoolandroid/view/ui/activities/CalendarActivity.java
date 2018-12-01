package dp.schoolandroid.view.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityCalendarBinding;
import dp.schoolandroid.viewmodel.CalendarActivityViewModel;

public class CalendarActivity extends AppCompatActivity {

    CalendarActivityViewModel viewModel;
    ActivityCalendarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_calendar);
        viewModel=ViewModelProviders.of(this).get(CalendarActivityViewModel.class);
        binding.setViewModel(viewModel);
    }
}
