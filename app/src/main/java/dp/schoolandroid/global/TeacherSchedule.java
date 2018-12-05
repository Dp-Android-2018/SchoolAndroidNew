package dp.schoolandroid.global;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeacherSchedule {
    @SerializedName("saturday")
    ArrayList<SectionTimeModel> sat;

    @SerializedName("sunday")
    ArrayList<SectionTimeModel> sun;

    @SerializedName("monday")
    ArrayList<SectionTimeModel> mon;

    @SerializedName("tuesday")
    ArrayList<SectionTimeModel> tue;

    @SerializedName("wednesday")
    ArrayList<SectionTimeModel> wed;

    @SerializedName("thursday")
    ArrayList<SectionTimeModel> thu;

    @SerializedName("friday")
    ArrayList<SectionTimeModel> fri;

    public ArrayList<SectionTimeModel> getSat() {
        return sat;
    }

    public ArrayList<SectionTimeModel> getSun() {
        return sun;
    }

    public ArrayList<SectionTimeModel> getMon() {
        return mon;
    }

    public ArrayList<SectionTimeModel> getTue() {
        return tue;
    }

    public ArrayList<SectionTimeModel> getWed() {
        return wed;
    }

    public ArrayList<SectionTimeModel> getThu() {
        return thu;
    }

    public ArrayList<SectionTimeModel> getFri() {
        return fri;
    }
}
