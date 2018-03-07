package com.hdu.a15061103.test201801;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

public class DetailActivity extends AppCompatActivity {
    private ImageButton addButton;
    private Context mContext;
  //标题，内容，日期，天气
   static private ArrayList<String> content = new ArrayList<>();
    static private ArrayList<String> date = new ArrayList<>();
    static private ArrayList<String> weather = new ArrayList<>();

    String[] contents={"去超市购买日用品","漫步西子湖畔","社团会议","如何定制首页","2017年日志"};
    String[] dates={"2018年1月6日","2018年11月5日","2018年2月5日","2018年2月9日","2018年2月20日"};
    String[] weathers={"晴"," 雨","多云","阴天","雨"};



    private ListView listView;
    private SimpleAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        listView=(ListView)findViewById(R.id.activity_list);
        for(int i=0;i<5;i++){
            content.add(contents[i]);
        }
        for(int i=0;i<5;i++){
            date.add(dates[i]);
        }
        for(int i=0;i<5;i++){
            weather.add(weathers[i]);
        }


        final ArrayList<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i< content.size(); i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("content", content.get(i));
            map.put("date", date.get(i));
            map.put("weather", weather.get(i));
            //把列表项加进列表集合
            listItems.add(map);
        }
        showItem();
        addButton=(ImageButton)findViewById(R.id.add_Button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this,"暂未提供此功能", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showItem() {
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < content.size(); i++) {

            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("content", content.get(i));
            //Log.e("show1",Name.get(i));
            showitem.put("date", date.get(i));
            //Log.e("show1",Sex.get(i));
            showitem.put("weather", weather.get(i));
            //Log.e("show1",Age.get(i));
            listitem.add(showitem);
            //创建一个simpleAdapter
            SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.list_item, new String[]{"content", "date", "weather"}, new int[]{R.id.text_content, R.id.date, R.id.weather});
            listView = (ListView) findViewById(R.id.activity_list);
            listView.setAdapter(myAdapter);
        }
    }
}
