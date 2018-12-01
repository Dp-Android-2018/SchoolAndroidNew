package dp.schoolandroid.service.repository.remotes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaces {
    @GET("/api/unknown")
    Call<String> doGetListResources();
}
