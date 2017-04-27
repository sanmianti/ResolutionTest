package demo.sanmianti.zlm.resolutiontest;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screenInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenInfo = (TextView) findViewById(R.id.screen_info);
        initScreenInfo();
    }

    /**
     * 初始化屏幕相关信息
     */
    private void initScreenInfo() {
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        Point resolution = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        StringBuffer sb = new StringBuffer();
        wm.getDefaultDisplay().getSize(resolution);
        wm.getDefaultDisplay().getMetrics(displayMetrics);

        sb.append("一般信息：" + displayMetrics.toString() + "\n\r");
        //sb.append("尺寸：" + Math.sqrt(resolution.x * resolution.x + resolution.y * resolution.y)/ displayMetrics.xdpi + "英寸" + "\r\n");
        sb.append("屏幕密度：" + displayMetrics.density + "\r\n");
        sb.append("像素密度：" + displayMetrics.densityDpi + "\r\n");
        sb.append("分辨率：" + resolution.y + "x" + resolution.x + "\r\n");
        sb.append("物理长度：" + resolution.x / displayMetrics.xdpi + "英寸x" + resolution.y/displayMetrics.ydpi + "英寸" + "\r\n");
        sb.append("手机尺寸：" + Math.sqrt(resolution.x / displayMetrics.xdpi * resolution.x / displayMetrics.xdpi + resolution.y/displayMetrics.ydpi*resolution.y/displayMetrics.ydpi) + "英寸" + "\r\n");
        screenInfo.setText(sb.toString());

    }
}
