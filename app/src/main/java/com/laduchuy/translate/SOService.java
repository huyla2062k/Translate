package com.laduchuy.translate;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


import java.util.List;
public interface SOService {

    @GET("/demoWebApi")
    Call<SOAnswersResponse> getAnswers();

    @GET("/demoWebApi")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);
}