package com.desafiolatam.prueba4.networks;

import com.desafiolatam.prueba4.model.QuoteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QuotesService {

    @Headers({
            "X-Mashape-Key: MlgSy0seZamshwXqeBhBE4FuGVr6p1BHwTwjsnAzEolaDcvVMz",
            "Accept: application/json"
    })
    @FormUrlEncoded
    @POST("/")
    Call<List<QuoteModel>> getQuotes(@Field("cat") String category, @Field("count") String count);

}
