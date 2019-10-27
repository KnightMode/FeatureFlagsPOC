package com.example.featureflagtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.featureflagtest.config.BuildConfigWrapper;
import com.example.featureflagtest.config.ChatbotRequest;
import com.example.featureflagtest.config.ChatbotResponse;
import com.example.featureflagtest.config.ChatbotService;
import com.example.featureflagtest.config.DemoApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static Retrofit retrofit;

    private static final String BASE_URL = "http://192.168.0.141:8080/";
    @Inject
    BuildConfigWrapper buildConfigWrapper;
    private Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ((DemoApplication) getApplication()).component().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        TextView textView = findViewById(R.id.text_field);
        editText = findViewById(R.id.input_field);
        button = findViewById(R.id.button);
        if (buildConfigWrapper.isChatBotEnabled()) {
            textView.setText("This is the text with feature flag enabled");
        }
        onResume();
    }

    @Override
    public void onResume() {
        super.onResume();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatbotService chatbotService = getRetrofitInstance().create(ChatbotService.class);
                Call<ChatbotResponse> hi = chatbotService.getChatbotResponse(new ChatbotRequest(editText.getText().toString()));
                editText.setText("");
                hi.enqueue(new Callback<ChatbotResponse>() {
                    @Override
                    public void onResponse(Call<ChatbotResponse> call, Response<ChatbotResponse> response) {
                        TextView textView = findViewById(R.id.text_field);
                        textView.setText(response.body().getChatBotResponse());
                    }

                    @Override
                    public void onFailure(Call<ChatbotResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

    }

    public Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
