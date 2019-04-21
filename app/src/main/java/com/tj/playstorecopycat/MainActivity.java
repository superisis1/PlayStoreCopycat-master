package com.tj.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tj.playstorecopycat.adapters.AppAdapter;
import com.tj.playstorecopycat.databinding.ActivityMainBinding;
import com.tj.playstorecopycat.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppAdapter mAppAdapter;

    List<App> appList = new ArrayList<>();

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();

        mAppAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankListView.setAdapter(mAppAdapter);
/*
//        확인 버튼 토스트 (지난수업 복습용)
        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
*/

//        아이템 클릭 이벤트
        act.appRankListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // 이벤트의 position은 몇번째 줄이 눌렸는지 알려줌. onItem에는 position이 따라옴
//                Toast.makeText(MainActivity.this, String.format("%d번째 줄이 클릭됨",position), Toast.LENGTH_SHORT).show();

                App clickedAppData = appList.get(position);

                Intent intent = new Intent(MainActivity.this, AppDetailActivity.class);
                intent.putExtra("제목", clickedAppData.title);
                intent.putExtra("회사이름", clickedAppData.companyName);
                startActivity(intent);
            }
        });

//        아이템 롱클릭 이벤트
        act.appRankListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, String.format("%d번째 줄이 오래 클릭됨",position), Toast.LENGTH_SHORT).show();
                return true; // false 일 때는 눌렀다 떼면 실행 후 짧게 눌러지는 애가 뒷따라 실행되는데, return true; 하면 다른 이벤트 무시하고 롱클릭 이벤트만 발생함. -> 보통 true 많이 씀.
            }
        });

    }


    void fillApps() {

        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));

    }


}













