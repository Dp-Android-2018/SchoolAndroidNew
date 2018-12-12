package dp.schoolandroid.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ItemClassBinding;
import dp.schoolandroid.databinding.ItemScheduleBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.view.ui.viewholder.ClassViewHolder;
import dp.schoolandroid.view.ui.viewholder.DayViewHolder;

public class ClassRecyclerViewAdapter extends RecyclerView.Adapter<ClassViewHolder> {
    private ArrayList<SectionTimeModel> dayData=getDummyData();

    public ClassRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemClassBinding binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_class,parent,false);
        return new ClassViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.bindClass(dayData.get(position));
    }

    @Override
    public int getItemCount() {
        if (dayData !=null){
            return dayData.size();
        }else {
            return 0;
        }
    }

    public void setDayData(ArrayList<SectionTimeModel> dayData) {
        this.dayData = dayData;
    }

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
