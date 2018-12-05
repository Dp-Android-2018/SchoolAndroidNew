package dp.schoolandroid.global;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SectionTimeModel {
    @SerializedName("id")
    private String arrayId;

    @SerializedName("class")
    private String classObject;

    @SerializedName("teacher")
    private String teacherObject;

    @SerializedName("level")
    private String levelObject;

    @SerializedName("students_count")
    private String studentsCount;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    public String getArrayId() {
        return arrayId;
    }

    public void setArrayId(String arrayId) {
        this.arrayId = arrayId;
    }

    public String getClassObject() {
        return classObject;
    }

    public void setClassObject(String classObject) {
        this.classObject = classObject;
    }

    public String getTeacherObject() {
        return teacherObject;
    }

    public void setTeacherObject(String teacherObject) {
        this.teacherObject = teacherObject;
    }

    public String getLevelObject() {
        return levelObject;
    }

    public void setLevelObject(String levelObject) {
        this.levelObject = levelObject;
    }

    public String getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(String studentsCount) {
        this.studentsCount = studentsCount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
