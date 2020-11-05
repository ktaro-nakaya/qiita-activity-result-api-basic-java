package jp.co.casareal.activityresultapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import jp.co.casareal.activityresultapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    // 遷移先から返ってきたときの契約を登録する
    private ActivityResultLauncher launcher =

            // 遷移先からの情報を取得してTextViewに表示
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                if (result.getResultCode() == Activity.RESULT_OK) {
                    String message = result.getData().getStringExtra("replyMessage");
                    if (message != null) {
                        binding.setResultText(message);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setResultText("ここに遷移先で入力した文字列が表示される。");

        binding.button.setOnClickListener(view -> {
            // 契約した内容で実行する
            // 引数はstartActivityForResultメソッドと同じでもOK
            launcher.launch(new Intent(this, InputActivity.class));
        });
    }
}