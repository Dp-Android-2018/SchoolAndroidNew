package dp.schoolandroid.view.ui.viewholder;

import android.support.v7.widget.RecyclerView;

import dp.schoolandroid.databinding.ItemFeedBinding;
import dp.schoolandroid.service.model.global.FeedModel;
import dp.schoolandroid.viewmodel.ItemFeedViewModel;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder {
    ItemFeedBinding binding;

    public NewsFeedViewHolder(ItemFeedBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bindClass(FeedModel feedModel){
        if (binding.getViewModel()==null)
        {
            binding.setViewModel(new ItemFeedViewModel(feedModel));
        }else {
            binding.getViewModel().feedModel=feedModel;
        }
    }
}
