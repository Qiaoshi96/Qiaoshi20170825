package baway.com.qiaoshi20170825;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;



/**
 * 姓名：乔石
 * 时间：08 25
 */
public class MainActivity extends AppCompatActivity {
        private ViewPager viewPager;
        private RadioGroup radioGroup;
    private Button b1;
    private Button b2;
    private Button b3;
    private IntentFilter filter;
    private NetworkChange change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.pager);
        radioGroup= (RadioGroup) findViewById(R.id.radroid);
       b1= (Button) findViewById(R.id.one);
        b2= (Button) findViewById(R.id.two);
        b3= (Button) findViewById(R.id.three);
//        隐藏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        change = new NetworkChange();
        registerReceiver(change, filter);
//        定义一个判断当前网络状态
//        getData();

    }
//获取数据
    private void getData() {

        //        加载Fragment
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment=new Fragmnet01();
                        break;
                    case 1:

                        fragment=new Fragmnet02();
                        break;
                    case 2:

                        fragment=new Fragmnet03();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class NetworkChange extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // 连接判断
//      Toast.makeText(context, "网络连接",1).show();
            ConnectivityManager manager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null&&info.isConnected()) {
                getData();
                Toast.makeText(context, "网络连接成功",Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(context, "网络连接失败",Toast.LENGTH_SHORT).show();
//      当网络连接 成功时弹出对话框来判断是否跳转到设置网络界面
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setMessage("是否设置网络");
//                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 跳转到设置网络界面
//                        Toast.makeText(MainActivity.this, "设置网络！", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
//                        startActivity(intent);
//                        return;
//                    }
//                });
//                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // TODO Auto-generated method stub
//                        Toast.makeText(MainActivity.this, "网络连接失败",1).show();
//                    }
//                });
//                builder.create();
//                builder.show();
            }
        }

    }

}
