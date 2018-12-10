package dp.schoolandroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import dp.schoolandroid.databinding.FragmentDayBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.global.TeacherSchedule;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherScheduleResponse;
import dp.schoolandroid.view.ui.adapter.DayRecyclerViewAdapter;
import dp.schoolandroid.viewmodel.DayFragmentViewModel;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;


public class DayFragment extends Fragment {

    FragmentDayBinding binding;
    DayRecyclerViewAdapter dayRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_day,container,false);
        binding.dayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayout.VERTICAL,false));
        dayRecyclerViewAdapter = new DayRecyclerViewAdapter();
        binding.dayRecyclerView.setAdapter(dayRecyclerViewAdapter);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_day, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final DayFragmentViewModel viewModel = ViewModelProviders.of(this).get(DayFragmentViewModel.class);

//        observeViewModel(viewModel);

    }


   /* private void observeViewModel(DayFragmentViewModel viewModel) {

        viewModel.getData().observe(this, new Observer<TeacherScheduleResponse>() {
            @Override
            public void onChanged(@Nullable TeacherScheduleResponse teacherScheduleResponse) {
                if (teacherScheduleResponse !=null){
                    dayRecyclerViewAdapter.setDayData(teacherScheduleResponse.getData().getSat());
                }
            }
        });
    }*/


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
