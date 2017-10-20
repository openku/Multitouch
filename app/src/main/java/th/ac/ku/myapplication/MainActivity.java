package th.ac.ku.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        Paint paint = new Paint();

        @Override
        protected void onDraw(Canvas canvas) {
//            Log.i("ii", "onDraw: ");
//            canvas.drawLine(0,0, 500, 500, paint);
            canvas.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.max(x2, x1), Math.max(y2,y1), paint);
        }
    }

    int state = 0;
    int x1, x2, y1, y2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() >= 2) {
            x1 = (int) event.getX(0);
            y1 = (int) event.getY(0);
            x2 = (int) event.getX(1);
            y2 = (int) event.getY(1);
            Log.w("ii", String.format("onTouchEvent: %d %d (%d %d) (%d %d)", state, event.getPointerCount(), x1, y2, x2, y2));
            myView.invalidate();
        }
//        switch (state) {
//            case 0:
//                if (event.getPointerCount() > 1) {
//                    state = 1;
//                }
//                break;
//            case 1:
//                if (event.getPointerCount() >= 2) {
//                    x1 = (int) event.getX(0);
//                    y1 = (int) event.getY(0);
//                    x2 = (int) event.getX(1);
//                    y2 = (int) event.getY(1);
//                    Log.w("ii", String.format("onTouchEvent: %d %d (%d %d) (%d %d)", state, event.getPointerCount(), x1, y2, x2, y2));
//                    myView.invalidate();
//                } else {
//                    state = 0;
//                }
//                break;
//
//        }
        return super.onTouchEvent(event);
    }

    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
    }
}
