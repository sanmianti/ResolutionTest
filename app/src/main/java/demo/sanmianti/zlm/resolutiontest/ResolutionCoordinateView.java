package demo.sanmianti.zlm.resolutiontest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * @author zlm
 * @description 根据像素大小画出坐标轴，以便直观看出view的大小。
 * @date 2017/4/26 17:14
 */
public class ResolutionCoordinateView extends View {

    private int screenWidth, screenHeight;
    private Point screenResolution = new Point();
    private WindowManager mWindowManager;

    public ResolutionCoordinateView(Context context) {
        super(context);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getSize(screenResolution);
        screenWidth = screenResolution.x;
        screenHeight = screenResolution.y;
    }

    public ResolutionCoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getSize(screenResolution);
        screenWidth = screenResolution.x;
        screenHeight = screenResolution.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int xPointNum = screenWidth / 50;
        int yPointNum = screenHeight / 50;

        Paint paint = new Paint();

        //画x轴
        for (int i = 0; i < xPointNum; i++) {
            canvas.drawLine((i + 1) * 50, 0, (i + 1) * 50, 10, paint);
            canvas.drawText((i + 1) * 50 + "", (i + 1) * 50, 12, paint);
        }
        //画y轴
        for (int j = 0; j < yPointNum; j++) {
            canvas.drawLine(0, (j + 1) * 50, 10, (j + 1) * 50, paint);
            canvas.drawText((j + 1) * 50 + "", 12, (j+1) * 50, paint);
        }
    }
}
