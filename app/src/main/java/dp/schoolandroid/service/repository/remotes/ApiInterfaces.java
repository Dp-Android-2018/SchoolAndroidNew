package dp.schoolandroid.service.repository.remotes;

import dp.schoolandroid.service.model.request.TeacherLoginRequest;
import dp.schoolandroid.service.model.response.TeacherLoginResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterfaces {

    @POST("/api/teacher/login")
    Observable<Response<TeacherLoginResponse>> loginAsTeacher(@Header("Content-Type") String contentType, @Header("Accept") String accept , @Body TeacherLoginRequest teacherLoginRequest);
}
