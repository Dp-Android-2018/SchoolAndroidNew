package dp.schoolandroid.view.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ItemScheduleBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.global.TeacherSchedule;
import dp.schoolandroid.view.ui.viewholder.DayViewHolder;

public class DayRecyclerViewAdapter extends RecyclerView.Adapter<DayViewHolder> {

    public static TeacherSchedule weekData=new TeacherSchedule();
    private static ArrayList<SectionTimeModel> dayData = new ArrayList<>();

    private int position;

    public DayRecyclerViewAdapter(int position) {
        this.position = position;
    }

    /* public DayRecyclerViewAdapter(ArrayList<SectionTimeModel> dayData) {
        this.dayData = dayData;
    }*/

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemScheduleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_schedule, parent, false);
        return new DayViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.bindDay(dayData.get(position));
    }

    @Override
    public int getItemCount() {
        switch (position) {
            case 0:
                dayData = weekData.getSat();
                break;
            case 1:
                dayData = weekData.getSun();
                break;
            case 2:
                dayData = weekData.getMon();
                break;
            case 3:
                dayData = weekData.getTue();
                break;
            case 4:
                dayData = weekData.getWed();
                break;
            case 5:
                dayData = weekData.getThu();
                break;
            case 6:
                dayData = weekData.getFri();
                break;
        }
        if (dayData !=null){
            return dayData.size();
        }
        return 0;
    }

   /* public void setDayData(ArrayList<SectionTimeModel> dayData) {
        this.dayData = dayData;
    } */
    /*public void setDayData(ArrayList<SectionTimeModel> dayDataModel) {
        this.dayData = dayDataModel;
    }*/
    /*public void setDayData(final ArrayList<SectionTimeModel>  projectList) {
        if (this.dayData == null) {
            this.dayData = projectList;
            notifyItemRangeInserted(0, projectList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return dayData.size();
                }

                @Override
                public int getNewListSize() {
                    return projectList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return dayData.get(oldItemPosition).getArrayId() ==
                            projectList.get(newItemPosition).getArrayId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    SectionTimeModel project = dayData.get(newItemPosition);
                    SectionTimeModel old = projectList.get(oldItemPosition);
                    return project.getArrayId().equals(old.getArrayId());
                }
            });
            this.dayData = projectList;
            result.dispatchUpdatesTo(this);
        }
    }*/
    /*public void setDay() {
        this.dayData = getDummyData();
    }*/

    /*public ArrayList<SectionTimeModel> getDayData() {
        return dayData;
    }*/

    private ArrayList<SectionTimeModel> getDummyData() {
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
    }
}
