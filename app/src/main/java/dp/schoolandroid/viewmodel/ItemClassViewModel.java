package dp.schoolandroid.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import dp.schoolandroid.global.SectionTimeModel;

public class ItemClassViewModel  {

    public SectionTimeModel sectionTimeModel;

    public ItemClassViewModel(SectionTimeModel sectionTimeModel) {
        this.sectionTimeModel = sectionTimeModel;
    }
}
