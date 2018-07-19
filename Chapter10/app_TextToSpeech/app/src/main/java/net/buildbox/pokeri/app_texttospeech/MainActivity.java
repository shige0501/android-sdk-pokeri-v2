package net.buildbox.pokeri.app_texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String SPEECH_ID = "SAMPLE_ID";
    private TextToSpeech mTextToSpeech = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextToSpeechの初期化
        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.SUCCESS) {
                    Toast.makeText(getApplicationContext(), "音声読み上げが利用できません", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button speechButton = findViewById(R.id.speech_button);
        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 読み上げ中華どうかチェックし、読み上げ中の場合は停止する
                if (mTextToSpeech.isSpeaking()) {
                    mTextToSpeech.stop();
                }

                // テキストの読み上げ
                EditText speechMessage = findViewById(R.id.speech_message);
                mTextToSpeech.speak(speechMessage.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, SPEECH_ID);
            }
        });
    }
}
