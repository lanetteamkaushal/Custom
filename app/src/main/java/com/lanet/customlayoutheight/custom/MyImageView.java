package com.lanet.customlayoutheight.custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lanet.customlayoutheight.R;

/**
 * Created by lcom75 on 7/1/17.
 */

public class MyImageView extends ImageView {
    public MyImageView(Context context) {
        super(context);
        init();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(getContext().getResources().getDrawable(R.drawable.img_background));
        } else {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.img_background));
        }
        setImageDrawable(getContext().getResources().getDrawable(R.mipmap.ic_launcher));
    }
}
