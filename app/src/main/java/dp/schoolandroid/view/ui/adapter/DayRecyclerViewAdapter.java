package dp.schoolandroid.view.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dp.schoolandroid.R;
import dp.schoolandroid.global.SectionTimeModel;

public class DayRecyclerViewAdapter extends RecyclerView.Adapter<DayRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<SectionTimeModel> dayData;

    public DayRecyclerViewAdapter(Context context, ArrayList<SectionTimeModel> dayData) {
        this.context=context;
        this.dayData=dayData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvScheduleClassName , tvScheduleClassGrade ,tvScheduleClassNumberOfStudents ,tvItemScheduleFrom ,tvItemScheduleTo;
        public ViewHolder(View itemView) {
            super(itemView);

            tvScheduleClassName=(TextView)itemView.findViewById(R.id.tv_schedule_class_name);
            tvScheduleClassGrade=(TextView)itemView.findViewById(R.id.tv_schedule_class_grade);
            tvScheduleClassNumberOfStudents=(TextView)itemView.findViewById(R.id.tv_schedule_class_number_of_students);
            tvItemScheduleFrom=(TextView)itemView.findViewById(R.id.tv_item_schedule_from);
            tvItemScheduleTo=(TextView)itemView.findViewById(R.id.tv_item_to_from);
        }
    }

}
