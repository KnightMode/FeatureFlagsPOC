package com.example.featureflagtest.config;

import com.google.gson.annotations.SerializedName;

public class ChatbotResponse {
    @SerializedName("chatbotResponse")
    private String chatBotResponse;

    public ChatbotResponse(String chatBotResponse) {
        this.chatBotResponse = chatBotResponse;
    }

    public String getChatBotResponse() {
        return chatBotResponse;
    }
}
