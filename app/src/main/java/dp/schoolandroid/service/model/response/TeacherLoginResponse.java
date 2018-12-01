package dp.schoolandroid.service.model.response;

import com.google.gson.annotations.SerializedName;

import dp.schoolandroid.service.model.TeacherData;

public class TeacherLoginResponse {

    @SerializedName("data")
    private TeacherData teacherData;

    public TeacherData getTeacherData() {
        return teacherData;
    }
}
