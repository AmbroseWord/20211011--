package com.example.f_dload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;	//
import android.os.Bundle;
import android.view.KeyEvent;

/////////////////////////////////////////////////////////////////////////////////////////////////////
//ダウンロードされたファイルの確認用プログラム
public class FDTestActivity  extends AppCompatActivity{
    /////////////////////////////////////////////////////////////
    FDTestView fdTestView;      //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        //////////////////////////////////////////////////////////////////////////////////////////
        //Activity間でデータを置け渡す、Intent処理
        Intent intent = getIntent();        //Intentの受け取り
        //////////////////////////////////////////////////////////////////////////////////////////
        //ダウンロードしたファイルのリストを取得
        FileList fileList = (FileList)getIntent().getSerializableExtra("FileList");
        ///////////////////////////////////////////////////////////////////////////////////////////
        //画像表示、音楽再生用View作成
        fdTestView = new FDTestView (this,fileList);    //画像表示のためViewを作成
        setContentView(fdTestView);                     //処理をViewに切り替え
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Backボタンで終了
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            fdTestView.bgm_player.stop();       //再生中の再生中止
            fdTestView.bgm_player.release();    //再生中の音楽を開放
            finish();
        }
        return true;
    }

}

