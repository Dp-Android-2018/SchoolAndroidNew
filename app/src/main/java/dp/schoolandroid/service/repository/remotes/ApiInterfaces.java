package dp.schoolandroid.service.repository.remotes;

import dp.schoolandroid.service.model.request.ParentRequest;
import dp.schoolandroid.service.model.request.StudentRequest;
import dp.schoolandroid.service.model.request.TeacherRequest;
import dp.schoolandroid.service.model.response.parentresponse.ParentResponse;
import dp.schoolandroid.service.model.response.studentresponse.StudentResponse;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherScheduleResponse;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterfaces {

    @POST("/api/teacher/login")
    Observable<Response<TeacherResponse>> loginAsTeacher(@Header("Content-Type") String contentType, @Header("Accept") String accept , @Body TeacherRequest teacherLoginRequest);

    @POST("/api/student/login")
    Observable<Response<StudentResponse>> loginAsStudent(@Header("Content-Type") String contentType, @Header("Accept") String accept , @Body StudentRequest studentLoginRequest);

    @POST("/api/parent/login")
    Observable<Response<ParentResponse>> loginAsParent(@Header("Content-Type") String contentType, @Header("Accept") String accept , @Body ParentRequest parentLoginRequest);

    @GET("/api/teacher/schedule")
    Observable<Response<TeacherScheduleResponse>> getTeacherSchedule(@Header("Authorization") String authorization, @Header("Content-Type") String contentType, @Header("Accept") String accept);

}
