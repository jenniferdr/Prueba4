package com.desafiolatam.prueba4.networks;

import com.desafiolatam.prueba4.model.QuoteModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteInterceptor {

    public static final String BASE_URL = "https://andruxnet-random-famous-quotes.p.mashape.com/";

    public QuotesService get() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder()
                        .header("X-Mashape-Key", "MlgSy0seZamshwXqeBhBE4FuGVr6p1BHwTwjsnAzEolaDcvVMz")
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .build();

                Response response = chain.proceed(request);

                /*If the request fail then you get 3 retrys*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(client)
                .build();

        QuotesService request = interceptor.create(QuotesService.class);

        return request;
    }
}
