package com.example.featureflagtest.config;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChatbotService {

    @POST("/askChatbot")
    Call<ChatbotResponse> getChatbotResponse(@Body ChatbotRequest chatbotRequest);
}
