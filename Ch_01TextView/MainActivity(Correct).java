package com.example.msi_alonso.ch_01textview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //宣告所以的變數,宣告後就可以在java中使用
    EditText gamer;
    TextView status;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    Button button;
    TextView name;
    TextView winner;
    TextView mymora;
    TextView cpu;
    //另外再宣告一個變數與陣列字串MoraString,用途在於使用變數紀錄玩家出的拳頭
    //MoraString陣列存放剪刀,石頭,布的字串,讓程式之後可以用變數取出對應的字串做輸出
    int mora_gamer = -1;//-1表示未出拳
    String[] MoraString = {"剪刀", "石頭", "布"};//MoraString陣列


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得個元件ID
        gamer = (EditText) findViewById(R.id.gamer);
        status = (TextView) findViewById(R.id.status);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        button = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.name);
        winner = (TextView) findViewById(R.id.winner);
        mymora = (TextView) findViewById(R.id.mymora);
        cpu = (TextView) findViewById(R.id.cpu);
        //對RadioGroup設定set監聽器,也就是使用OnCheckChangeListener.Switch case中加入三個case,分別對應到3顆RadioButton.監測後依據case打mora_game設成對應的代表數
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {//自動產生方法
                //Switch case中加入三個case,分別對應到3顆RadioButton
                switch (radioGroup.getCheckedRadioButtonId()) {//switch(要使radioGroup去得到RadioButtonId)
                    case R.id.radioButton1:
                        mora_gamer = 0;//表示如果是剪刀的條件下
                        break;
                    //回想一下***************************************************
                    //int mora_gamer=-1;//-1表示未出拳
                    //String[] MoraString={"剪刀","石頭","布"};//MoraString陣列
                    //***************************************************
                    case R.id.radioButton2:
                        mora_gamer = 1;//表示如果是石頭的條件下
                        break;
                    case R.id.radioButton3:
                        mora_gamer = 2;//表示如果是布的條件下
                        break;
                }

            }
        });
        //對button設定set監聽器,也就是使用OnClickListener
        //這裡加入運算
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          if (gamer.getText().toString().equals(""))//button先去監控如果text等於空值的時候
                                              status.setText("請選擇玩家名稱");//要求玩家輸入姓名
                                          else if (mora_gamer == -1)//mora_gamer先去監控如果mora_gamer未出拳的狀況下
                                              status.setText("請選擇出拳的種類啊!你是笨蛋嗎");//要求玩家輸入

                                          else {
                                              name.setText(gamer.getText());//從gamer取出名稱顯示於name中
                                              mymora.setText(MoraString[mora_gamer]);//顯示使用者出什麼拳.從陣列裡去抓到對應的字串
                                              int mora_computer = (int) (Math.random() * 3);//定義變數mora_computer,利用Math.random產生0-2的亂數<0.000000~0.9999999*3取整數>
                                              cpu.setText(MoraString[mora_computer]);//顯示電腦出甚麼拳
                                              //***********************************************
                                              if ((mora_gamer == 0 && mora_computer == 1) || (mora_gamer == 1 && mora_computer == 2) || (mora_gamer == 2 && mora_computer == 0)) {
                                                  winner.setText("電腦");
                                                  status.setText("可惜! 電腦獲勝了");
                                              } else if (mora_computer == mora_gamer) {
                                                  winner.setText("平手");
                                                  status.setText("平手再來一局");
                                              } else {
                                                  winner.setText(gamer.getText());//抓取當初填入的名稱
                                                  status.setText("恭喜你贏了");

                                              }


                                          }

                                      }

                                  }

        );


    }


}
