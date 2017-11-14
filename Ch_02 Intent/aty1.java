package com.example.msi_alonso.ch_02intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aty1 extends AppCompatActivity {
    //宣告第一頁元件屬性
    Button btn;
    TextView t_drink;
    TextView t_ice;
    TextView t_suger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aty1);
        //當按鈕按下去希望能切換到aty2,所以要對Button監聽
        //首先找到button的id
        btn = (Button) findViewById(R.id.sent);
        //然後對Button監聽
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //希望按下去會跳到aty2,需用到Intent來切換,並傳遞requestCode=0來標記發出者
                Intent i = new Intent();
                i.setClass(aty1.this, aty2.class);
                startActivityForResult(i, 0);//啟動方法有2種
                //第一種startActivity()傳過去資料
                //第二種startActivityForResult()傳過去資料後再傳回來


            }
        });

    }
    //當跳到aty2開始選擇飲料/ 冰塊/ 甜度等資訊,填完後要將結果再送回aty1,我們使用onActivityResult
    //建立另一個方法,使用onActivityResult接收資料後,將data的內容用TextView顯示出來
    public void onActionResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){//先驗證發出對象,如果是0就繼續<0是剛剛設的>
            if(resultCode==101){//當requestCode==0後,確認Min2Activity執行的狀況
                Bundle b =data.getExtras();//讀取bundle資料
                String str1 = b.getString("drink_level");//讀取飲料的資料
                String str2 = b.getString("suger_level");//讀取甜度的資料
                CharSequence str3 = b.getString("ice_level");//讀取冰塊的資料

                t_drink = (TextView) findViewById(R.id.drink);//透過TextView顯示
                t_suger = (TextView) findViewById(R.id.suger);//透過TextView顯示
                t_ice = (TextView) findViewById(R.id.ice);//透過TextView顯示


            }

        }

    }
}
