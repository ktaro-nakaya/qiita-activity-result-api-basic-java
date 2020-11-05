package jp.co.casareal.activityresultapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import jp.co.casareal.activityresultapi.databinding.ActivityInputBinding;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInputBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_input);
        binding.setLifecycleOwner(this);

        binding.buttonReply.setOnClickListener(view -> {

            Intent result = new Intent();
            result.putExtra("replyMessage", binding.editTextInputText.getText().toString());

            setResult(Activity.RESULT_OK, result);

            finish();
        });
    }
}