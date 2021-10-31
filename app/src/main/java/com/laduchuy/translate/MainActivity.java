package com.laduchuy.translate;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.laduchuy.translate.databinding.ActivityMainBinding;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SOService soService;
   List<String> key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        soService = ApiUtils.getSOService();
        loadAnswers();
//        ArrayAdapter adapter =
//                new ArrayAdapter(this, android.R.layout.simple_list_item_1,ke);
//        binding.edInput.setAdapter(adapter);


    }
    public void loadAnswers() {
        soService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
//                    for (int i=0;i<response.body().getSheet1().size();i++){
//                        key.add(response.body().getSheet1().get(i).getWord());
//                    }
                    binding.btnTranslate.setOnClickListener(view -> {
                        String word = binding.edInput.getText().toString();
                        int check = 0;

                        for (int i = 0;i<response.body().getSheet1().size();i++){
                            if (response.body().getSheet1().get(i).getWord().contains(word)){
                                binding.tvEng.setText(response.body().getSheet1().get(i).getEnligsh());
                                binding.tvVn.setText(response.body().getSheet1().get(i).getVietnamese());
                                binding.edInput.setText(response.body().getSheet1().get(i).getWord());
                                check++;
                                break;

                            }
                        }
                        if (check==0){
                            Toast.makeText(getBaseContext(),"Không tìm thấy từ ngữ bạn cần",Toast.LENGTH_SHORT).show();
                            binding.tvEng.setText("");
                            binding.tvVn.setText("");
                            binding.edInput.setText("");
                        }
                    });
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }
}