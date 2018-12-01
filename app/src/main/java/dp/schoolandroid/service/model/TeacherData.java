package dp.schoolandroid.service.model;

import com.google.gson.annotations.SerializedName;

public class TeacherData {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("api_token")
    private String apiToken;

    @SerializedName("device_token")
    private String deviceToken;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getApiToken() {
        return apiToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }
}
