package com.example.da08.property;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    Preference preference;
    SharedPreferences sharedPreferences;  // 값을 저장해 줌 (xml파일로)

    // 위젯 연결
    EditText editname, editid, editpw;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        preference = new Preference(this);  // 액티비티가 단독으로 사용하고 공유하지 않을때만 사용 (거의 사용하지 않는 기능)
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);  // 파일명

        editname = (EditText)findViewById(R.id.editname);
        editid = (EditText)findViewById(R.id.editid);
        editpw = (EditText)findViewById(R.id.editpw);

        loadPreference();

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePres("name", editname.getText().toString());
                savePres("id", editid.getText().toString());
                savePres("pw", editpw.getText().toString());
            }
        });

    }

    // 불러오기
    private void loadPreference(){
        String name = sharedPreferences.getString("name", "");
        String id = sharedPreferences.getString("id", "");
        String pw = sharedPreferences.getString("pw", "");

        editname.setText(name);
        editid.setText(id);
        editpw.setText(pw);
    }

    // 저장하기
    public void savePres(String key, String value){
        // 1. editor 꺼내기
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 2. editor를 통해서 키값을 저장
        editor.putString(key, value);
        // 3. editor commit
        editor.commit();
    }

    // 삭제하기
    private void removePreferences(String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    // 전체 삭제하기
    private void removeAllPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}