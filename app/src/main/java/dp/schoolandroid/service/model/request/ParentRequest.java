package dp.schoolandroid.service.model.request;

import com.google.gson.annotations.SerializedName;

public class ParentRequest {
    @SerializedName("phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
