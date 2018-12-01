package dp.schoolandroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import dp.schoolandroid.R;

/**
 * Created by DELL on 28/11/2018.
 */

public class MainActiviyViewModel extends AndroidViewModel {

    public int logoImage= R.drawable.img_colored_logo;
    public int studentImageon= R.drawable.img_checked_student;
    public int studentImageoff= R.drawable.img_un_checked_student;
    public int firstTextView= R.string.title_welcome_main;
    public int secondTextView= R.string.msg_choose_main;
    public int studentTextView= R.string.label_main_student;
    public int parenttTextView= R.string.label_main_parent;
    public int teachertTextView= R.string.label_main_teacher;
    public int buttontTextView= R.string.action_choose;

    public int selectionId = 1;

    public MainActiviyViewModel(@NonNull Application application) {
        super(application);
    }
    public boolean studentSelected(){
        selectionId = 1;
        return true;
    }
}
