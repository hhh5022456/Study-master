package zdl.tianxunda.com.study;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.dialog.v2.Notification;

import java.util.ArrayList;
import java.util.List;

import zdl.tianxunda.com.study.adp.Main2Adp;
import zdl.tianxunda.com.study.adp.MainAdp;

import static com.kongzue.dialog.v2.Notification.SHOW_TIME_SHORT;
import static com.kongzue.dialog.v2.Notification.TYPE_NORMAL;

@Layout(R.layout.activity_main)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色
public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView_1;
    private RecyclerView recyclerView_2;
    private List<String> list;
    private List<String> list2;
    private MainAdp mainAdp;
    private Main2Adp main2Adp;


    @Override
    public void initViews() {
        recyclerView_1 = findViewById(R.id.recycler_1);
        recyclerView_2 = findViewById(R.id.recycler_2);
        recyclerView_1.setLayoutManager(new LinearLayoutManager(me));
        recyclerView_2.setLayoutManager(new LinearLayoutManager(me));
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        mainAdp = new MainAdp(R.layout.item_layout_main);
        main2Adp = new Main2Adp(R.layout.item_layout_main);
        recyclerView_1.setAdapter(mainAdp);
        recyclerView_2.setAdapter(main2Adp);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        for (int i = 0; i < 10; i++) {
            list.add("第" + i + "条");
        }
        mainAdp.setNewData(list);
        mainAdp.notifyDataSetChanged();
    }

    @Override
    public void setEvents() {
        mainAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                list2.clear();
                for (int i = position; i < 10; i++) {
                    list2.add("第" + i + "个");
                }
                main2Adp.setNewData(list2);
                main2Adp.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Notification.show(me, 2, R.mipmap.ico_wechat, getString(R.string.app_name), "这是一条消息", Notification.SHOW_TIME_LONG, notifactionType)
                .setOnNotificationClickListener(new Notification.OnNotificationClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void OnClick(int id) {
                        Toast.makeText(me, "点击了通知", SHOW_TIME_SHORT).show();
                    }
                })
        ;
    }

    private int notifactionType = TYPE_NORMAL;
}
