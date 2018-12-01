package dp.schoolandroid.service.model.request;

import com.google.gson.annotations.SerializedName;

public class TeacherLoginRequest {

    @SerializedName("phone")
    private String phone;

    @SerializedName("ssn")
    private String ssn;

    @SerializedName("password")
    private String password;

    @SerializedName("device_token")
    private String deviceToken;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
