package dp.schoolandroid.view.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import dp.schoolandroid.databinding.ItemClassBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.viewmodel.ItemClassViewModel;
import dp.schoolandroid.viewmodel.ItemScheduleViewModel;

public class ClassViewHolder extends RecyclerView.ViewHolder {
    ItemClassBinding binding;

    public ClassViewHolder(ItemClassBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bindClass(SectionTimeModel sectionTimeModel){
        if (binding.getViewModel()==null)
        {
            binding.setViewModel(new ItemClassViewModel(sectionTimeModel));
        }else {
            binding.getViewModel().sectionTimeModel=sectionTimeModel;
        }
    }
}
