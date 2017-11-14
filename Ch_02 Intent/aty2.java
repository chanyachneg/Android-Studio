package com.example.msi_alonso.ch_02intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class aty2 extends AppCompatActivity {
    //宣告第一頁元件屬性
    EditText set_drink;
    String suger;
    String ice_opt;
    Button sent_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aty2);
        //用RadioGroup監聽RadioButton的按下事件,並更改字串當作甜度資訊
        //RadioGroup用法要記得
        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio0 ://是分號結尾
                        suger = "無糖";
                        break;
                    case R.id.radio1://是分號結尾
                        suger="少糖";
                        break;
                    case R.id.radio2://是分號結尾
                        suger = "半糖";
                        break;
                    case R.id.radio3://是分號結尾
                        suger = "黃金比例";
                        break;
                }
            }
        });
        //用RadioGroup監聽RadioButton的按下事件,並更改字串當冰塊度資訊
        RadioGroup rg2=findViewById(R.id.radioGroup);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton1:
                        ice_opt="微冰";
                        break;
                    case R.id.radioButton2:
                        ice_opt = "少冰";
                        break;
                    case R.id.radioButton3:
                        ice_opt = "正常冰";
                        break;
                }
            }
        });
        //用button的事件,將甜度與冰塊資訊放入Bundle後,回傳到前一個畫面
        sent_btn=(Button)findViewById(R.id.sent);
        //對這一個button設一個監聽器
        //Button監聽器用法要記得
        sent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_drink=(EditText) findViewById(R.id.editText1);
                //取得字串的內容
                String temp=set_drink.getText().toString();
                Intent i=new Intent();
                Bundle b=new Bundle();
                //把甜度跟冰量資訊放入Bundle
                b.putString("suger_Level",suger);
                b.putString("ice_Level",ice_opt);
                b.putString("drink_level", temp);
                i.putExtras(b);
                setResult(101, i);//用101標記執行狀態並記錄intent
                finish();

            }
        });
    }
}
