package dp.schoolandroid.view.ui.fragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.FragmentDayBinding;
import dp.schoolandroid.service.model.global.TeacherSchedule;
import dp.schoolandroid.view.ui.adapter.DayRecyclerViewAdapter;
import dp.schoolandroid.viewmodel.DayFragmentViewModel;


public class DayFragment extends Fragment {

    private int position;
    private TeacherSchedule weekData;

    public DayFragment() {
    }

    @SuppressLint("ValidFragment")
    public DayFragment(int position , TeacherSchedule weekData) {
        this.position = position;
        this.weekData = weekData;
    }

    FragmentDayBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_day, container, false);
        DayFragmentViewModel viewModel = ViewModelProviders.of(this).get(DayFragmentViewModel.class);
        binding.setViewModel(viewModel);
        DayRecyclerViewAdapter dayRecyclerViewAdapter = new DayRecyclerViewAdapter(position , weekData);
        binding.dayRecyclerView.setAdapter(dayRecyclerViewAdapter);
        binding.dayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        observeViewModel(viewModel);
    }

    /* private void observeViewModel(DayFragmentViewModel viewModel) {

        viewModel.getData().observe(this, new Observer<TeacherScheduleResponse>() {
            @Override
            public void onChanged(@Nullable TeacherScheduleResponse teacherScheduleResponse) {
                Toast.makeText(getContext(), "data changed", Toast.LENGTH_SHORT).show();
                if (teacherScheduleResponse !=null){
                    Toast.makeText(getContext(), "Thursday"+teacherScheduleResponse.getData().getThu().get(0).getClassName(), Toast.LENGTH_SHORT).show();
                    dayRecyclerViewAdapter.setDayData(teacherScheduleResponse.getData().getThu());
                }
            }
        });
    }
*/

 /*   private ArrayList<SectionTimeModel> getDummyData() {
        ArrayList<SectionTimeModel> dummyData = new ArrayList<>();

        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1", "Mosaid1", "20", "9:15 Am", "11:15 Am"));

        return dummyData;
    }*/
}
