package dp.schoolandroid.view.ui.fragment;

import android.app.ActivityOptions;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.FragmentDayBinding;
import dp.schoolandroid.databinding.FragmentScheduleBinding;
import dp.schoolandroid.view.ui.activity.ChatActivity;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import dp.schoolandroid.view.ui.adapter.TeacherSchedulePageViewAdapter;
import dp.schoolandroid.viewmodel.DayFragmentViewModel;
import dp.schoolandroid.viewmodel.MyCustomBarViewModel;
import dp.schoolandroid.viewmodel.ScheduleFragmentViewModel;


public class ScheduleFragment extends Fragment {

    ScheduleFragmentViewModel viewModel;
    FragmentScheduleBinding binding;
    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        ScheduleFragment fragment = new ScheduleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        viewModel = ViewModelProviders.of(this).get(ScheduleFragmentViewModel.class);
        binding.setViewModel(viewModel);
        View view = binding.getRoot();
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        binding.actionBar.setViewModel(new MyCustomBarViewModel(getContext()));
        ViewPager viewPager = binding.viewpagerSchedule;
        TeacherSchedulePageViewAdapter adapter = new TeacherSchedulePageViewAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout =binding.tlScheduleClass;
        tabLayout.setupWithViewPager(viewPager);
    }
}
