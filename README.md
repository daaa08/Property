# Property
properties 사용법

## Preference

- Activity간의 정보교환에도 활용이 가능 


## SharedPreferences
- 간단한 값 저장을위해 사용 (ex초기 설정값이나 자동로그인여부...)
- xml형태로 파일을 저장

```java

sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);  
 // 정보를 가져올때는 getSharedPreferences 사용 

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

```
[전체소스 보기](https://github.com/daaa08/Property/blob/master/app/src/main/java/com/example/da08/property/MainActivity.java)



