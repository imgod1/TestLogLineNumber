package com.example.gk.testloglinenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

/**
 * 项目名称：TestLogLineNumber
 * 类描述：测试可以打印输出行号的日志工具,可以自己写,也可以使用大名鼎鼎的Logger
 * 自己写的更朴素一点,创建的方法更少...
 * 创建人：gk
 * 创建时间：2016/9/18 15:55
 * 修改人：gk
 * 修改时间：2016/9/18 15:55
 * 修改备注：
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_log1;
    private Button btn_logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        btn_log1.setOnClickListener(this);
        btn_logger.setOnClickListener(this);
    }

    private void initView() {
        btn_log1 = (Button) findViewById(R.id.btn_log1);
        btn_logger = (Button) findViewById(R.id.btn_logger);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_log1:
                a();
                break;
            case R.id.btn_logger:
                logger_e();
                break;
            default:
                break;
        }
    }

    private void a() {
        b();
    }

    private void b() {
        Lg.e_debug("test", "test content");
    }

    private void logger_e() {
        Logger.t("test").e("hallo", "xixihaha");
    }
}
