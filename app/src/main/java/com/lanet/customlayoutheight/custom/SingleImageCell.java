package com.lanet.customlayoutheight.custom;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lcom75 on 7/1/17.
 */

public class SingleImageCell extends ViewGroup {

    int no_of_image = 1;
    private int deviceWidth;

    public SingleImageCell(Context context) {
        super(context);
        init();
    }

    public SingleImageCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SingleImageCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SingleImageCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        deviceWidth = 1080;

    }

    public void setNo_of_image(int no_of_image) {
        this.no_of_image = no_of_image;
        if (getChildCount() == no_of_image) {

        } else {
            removeAllViews();
            for (int i = 0; i < no_of_image; i++) {
                addView(new MyImageView(getContext()));
            }
            requestLayout();
        }
    }

    int curWidth, curHeight, curLeft, curTop, maxHeight, childWidth, childHeight;

    private static final String TAG = "SingleImageCell";

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        if (b - l <= 0) {
//            Log.d(TAG, "onLayout: Ignoring");
//            return;
//        }
        final int count = getChildCount();
        //get the available size of child view
        final int childLeft = this.getPaddingLeft();
        final int childTop = this.getPaddingTop();
        final int childRight = this.getMeasuredWidth() - this.getPaddingRight();
        final int childBottom = this.getMeasuredHeight() - this.getPaddingBottom();
        childWidth = childRight - childLeft;
        childHeight = childBottom - childTop;
        maxHeight = 0;
        curLeft = childLeft;
        curTop = childTop;
        curWidth = r - l;
        curHeight = b - t;
        customChild();
//        customChildMeasure(child);
        Rect rect;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE)
                return;

//            customChildMeasure(i, child);
//            //Get the maximum size of the child
//            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
//            curWidth = child.getMeasuredWidth();
//            curHeight = child.getMeasuredHeight();
//            //wrap is reach to the end
//            if (curLeft + curWidth >= childRight) {
//                curLeft = childLeft;
//                curTop += maxHeight;
//                maxHeight = 0;
//            }
//            //do the layout
            rect = giveRectForImage(i, no_of_image);
            child.layout(rect.left, rect.top, rect.right, rect.bottom);
//            //store the max height
//            if (maxHeight < curHeight)
//                maxHeight = curHeight;
//            curLeft += curWidth;
        }
    }

    private void customChild() {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE)
                return;

        }
    }

    private Rect giveRectForImage(int position, int totalNumber) {
        Rect rect = new Rect();
        switch (totalNumber) {
            case 1:
                rect.set(curLeft, curTop, curLeft + curWidth, curTop + curHeight);
                break;
            case 2:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, curLeft + (curWidth / 2), curTop + curHeight);
                        break;
                    case 1:
                        rect.set(curLeft + (curWidth / 2), curTop, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 3:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.34)), curTop + (curHeight / 2));
                        break;
                    case 1:
                        rect.set(curLeft, curTop + (curHeight / 2), (int) (curLeft + Math.round(curWidth * 0.34)), curTop + curHeight);
                        break;
                    case 2:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.34)), curTop, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 4:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.34)), curTop + (curHeight / 2));
                        break;
                    case 1:
                        rect.set(curLeft, curTop + (curHeight / 2), (int) (curLeft + Math.round(curWidth * 0.34)), curTop + curHeight);
                        break;
                    case 2:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.34)), curTop, (int) (curLeft + Math.round(curWidth * 0.66)), curTop + curHeight);
                        break;
                    case 3:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.66)), curTop, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 5:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, curLeft + Math.round(curWidth / 4), curTop + (curHeight / 2));
                        break;
                    case 1:
                        rect.set(curLeft, curTop + (curHeight / 2), curLeft + Math.round(curWidth / 4), curTop + curHeight);
                        break;
                    case 2:
                        rect.set(curLeft + Math.round(curWidth / 4), curTop, curLeft + Math.round(curWidth / 2), curTop + (curHeight / 2));
                        break;
                    case 3:
                        rect.set(curLeft + Math.round(curWidth / 4), curTop + (curHeight / 2), curLeft + Math.round(curWidth / 2), curTop + curHeight);
                        break;
                    case 4:
                        rect.set(curLeft + curWidth / 2, curTop, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 6:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.34)), curTop + curHeight / 2);
                        break;
                    case 1:
                        rect.set(curLeft, curTop + curHeight / 2, (int) (curLeft + Math.round(curWidth * 0.34)), curTop + curHeight);
                        break;
                    case 2:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.34)), curTop, (int) (curLeft + Math.round(curWidth * 0.66)), curTop + curHeight / 2);
                        break;
                    case 3:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.34)), curTop + curHeight / 2, (int) (curLeft + Math.round(curWidth * 0.66)), curTop + curHeight);
                        break;
                    case 4:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.66)), curTop, curLeft + curWidth, curTop + curHeight / 2);
                        break;
                    case 5:
                        rect.set((int) (curLeft + Math.round(curWidth * 0.66)), curTop + curHeight / 2, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 7:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.21)), curTop + curHeight / 2);
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.21), curTop, curLeft + giveme(0.41), curTop + curHeight / 2);
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.41), curTop, curLeft + giveme(0.64), curTop + curHeight / 2);
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.64), curTop, curLeft + curWidth, curTop + curHeight / 2);
                        break;
                    case 4:
                        rect.set(curLeft, curTop + curHeight / 2, curLeft + giveme(0.30), curTop + curHeight);
                        break;
                    case 5:
                        rect.set(curLeft + giveme(0.30), curTop + curHeight / 2, curLeft + giveme(0.64), curTop + curHeight);
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.64), curTop + curHeight / 2, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 8:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.21)), curTop + curHeight / 2);
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.21), curTop, curLeft + giveme(0.41), curTop + curHeight / 2);
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.41), curTop, curLeft + giveme(0.67), curTop + curHeight / 2);
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.67), curTop, curLeft + curWidth, curTop + curHeight / 2);
                        break;
                    case 4:
                        rect.set(curLeft, curTop + curHeight / 2, curLeft + giveme(0.30), curTop + curHeight);
                        break;
                    case 5:
                        rect.set(curLeft + giveme(0.30), curTop + curHeight / 2, curLeft + giveme(0.51), curTop + curHeight);
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.51), curTop + curHeight / 2, curLeft + giveme(0.7), curTop + curHeight);
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.7), curTop + curHeight / 2, curLeft + curWidth, curTop + curHeight);
                        break;
                }
                break;
            case 9:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.21)), curTop + givemeh(0.4));
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.21), curTop, curLeft + giveme(0.40), curTop + givemeh(0.4));
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.40), curTop, curLeft + giveme(0.64), (int) (curTop + givemeh(0.4)));
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.64), curTop, curLeft + curWidth, curTop + givemeh(0.4));
                        break;
                    case 4:
                        rect.set(curLeft, curTop + givemeh(0.4), curLeft + giveme(0.31), curTop + curHeight);
                        break;
                    case 5:
                        rect.set(curLeft + giveme(0.31), curTop + givemeh(0.4), curLeft + giveme(0.53), curTop + curHeight);
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.53), curTop + givemeh(0.4), curLeft + giveme(0.72), curTop + givemeh(0.7));
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.72), curTop + givemeh(0.4), curLeft + curWidth, curTop + curHeight);
                        break;
                    case 8:
                        rect.set(curLeft + giveme(0.53), curTop + givemeh(0.7), curLeft + giveme(0.72), curTop + curHeight);
                        break;
                }
                break;
            case 10:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.22)), curTop + givemeh(0.4));
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.22), curTop, curLeft + giveme(0.41), curTop + givemeh(0.4));
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.41), curTop, curLeft + giveme(0.65), curTop + givemeh(0.4));
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.65), curTop, curLeft + curWidth, curTop + givemeh(0.4));
                        break;
                    case 4:
                        rect.set(curLeft, curTop + givemeh(0.4), curLeft + giveme(0.32), curTop + curHeight);
                        break;
                    case 5:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.4), curLeft + giveme(0.54), curTop + givemeh(0.7));
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.54), curTop + givemeh(0.4), curLeft + giveme(0.73), curTop + givemeh(0.7));
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.73), curTop + givemeh(0.4), curLeft + curWidth, curTop + curHeight);
                        break;
                    case 8:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.7), curLeft + giveme(0.54), curTop + curHeight);
                        break;
                    case 9:
                        rect.set(curLeft + giveme(0.54), curTop + givemeh(0.7), curLeft + giveme(0.73), curTop + curHeight);
                        break;
                }

                break;
            case 11:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + Math.round(curWidth * 0.22)), curTop + givemeh(0.4));
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.22), curTop, curLeft + giveme(0.41), curTop + givemeh(0.4));
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.41), curTop, curLeft + giveme(0.63), curTop + givemeh(0.4));
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.63), curTop, curLeft + giveme(0.82), curTop + givemeh(0.4));
                        break;
                    case 4:
                        rect.set(curLeft + giveme(0.82), curTop, curLeft + curWidth, curTop + givemeh(0.4));
                        break;
                    case 5:
                        rect.set(curLeft, curTop + givemeh(0.4), curLeft + giveme(0.32), curTop + curHeight);
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.4), curLeft + giveme(0.54), curTop + givemeh(0.7));
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.54), curTop + givemeh(0.4), curLeft + giveme(0.72), curTop + givemeh(0.7));
                        break;
                    case 8:
                        rect.set(curLeft + giveme(0.72), curTop + givemeh(0.4), curLeft + giveme(1), curTop + givemeh(1));
                        break;
                    case 9:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.7), curLeft + giveme(0.54), curTop + givemeh(1));
                        break;
                    case 10:
                        rect.set(curLeft + giveme(0.54), curTop + givemeh(0.7), curLeft + giveme(0.72), curTop + givemeh(1));
                        break;
                }
                break;
            case 12:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + giveme(0.21)), curTop + givemeh(0.4));
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.21), curTop, curLeft + giveme(0.40), curTop + givemeh(0.4));
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.40), curTop, curLeft + giveme(0.63), curTop + givemeh(0.4));
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.63), curTop, curLeft + giveme(0.82), curTop + givemeh(0.4));
                        break;
                    case 4:
                        rect.set(curLeft + giveme(0.82), curTop, curLeft + curWidth, curTop + givemeh(0.4));
                        break;
                    case 5:
                        rect.set(curLeft, curTop + givemeh(0.4), curLeft + giveme(0.16), curTop + curHeight);
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.16), curTop + givemeh(0.4), curLeft + giveme(0.32), curTop + givemeh(1));
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.4), curLeft + giveme(0.52), curTop + givemeh(0.7));
                        break;
                    case 8:
                        rect.set(curLeft + giveme(0.52), curTop + givemeh(0.4), curLeft + giveme(0.70), curTop + givemeh(0.7));
                        break;
                    case 9:
                        rect.set(curLeft + giveme(0.7), curTop + givemeh(0.4), curLeft + giveme(1), curTop + givemeh(1));
                        break;
                    case 10:
                        rect.set(curLeft + giveme(0.32), curTop + givemeh(0.7), curLeft + giveme(0.52), curTop + givemeh(1));
                        break;
                    case 11:
                        rect.set(curLeft + giveme(0.52), curTop + givemeh(0.7), curLeft + giveme(0.7), curTop + givemeh(1));
                        break;
                }
                break;
            case 13:
                switch (position) {
                    case 0:
                        rect.set(curLeft, curTop, (int) (curLeft + giveme(0.21)), curTop + givemeh(0.4));
                        break;
                    case 1:
                        rect.set(curLeft + giveme(0.21), curTop, curLeft + giveme(0.39), curTop + givemeh(0.4));
                        break;
                    case 2:
                        rect.set(curLeft + giveme(0.39), curTop, curLeft + giveme(0.62), curTop + givemeh(0.4));
                        break;
                    case 3:
                        rect.set(curLeft + giveme(0.62), curTop, curLeft + giveme(0.81), curTop + givemeh(0.4));
                        break;
                    case 4:
                        rect.set(curLeft + giveme(0.81), curTop, curLeft + curWidth, curTop + givemeh(0.4));
                        break;
                    case 5:
                        rect.set(curLeft, curTop + givemeh(0.4), curLeft + giveme(0.31), curTop + givemeh(0.7));
                        break;
                    case 6:
                        rect.set(curLeft + giveme(0.31), curTop + givemeh(0.4), curLeft + giveme(0.52), curTop + givemeh(0.7));
                        break;
                    case 7:
                        rect.set(curLeft + giveme(0.52), curTop + givemeh(0.4), curLeft + giveme(0.7), curTop + givemeh(0.7));
                        break;
                    case 8:
                        rect.set(curLeft + giveme(0.7), curTop + givemeh(0.4), curLeft + giveme(1), curTop + givemeh(0.7));
                        break;
                    case 9:
                        rect.set(curLeft, curTop + givemeh(0.7), curLeft + giveme(0.31), curTop + givemeh(1));
                        break;
                    case 10:
                        rect.set(curLeft + giveme(0.31), curTop + givemeh(0.7), curLeft + giveme(0.52), curTop + givemeh(1));
                        break;
                    case 11:
                        rect.set(curLeft + giveme(0.52), curTop + givemeh(0.7), curLeft + giveme(0.7), curTop + givemeh(1));
                        break;
                    case 12:
                        rect.set(curLeft + giveme(0.7), curTop + givemeh(0.7), curLeft + giveme(1), curTop + givemeh(1));
                        break;
                }
                break;
        }
        Log.d(TAG, "giveRectForImage() called with: position = [" + position + "], totalNumber = [" + totalNumber + "], RECT [ " + rect.toString() + "]");
        return rect;
    }

    private int giveme(double v) {
        return (int) (curWidth * v);
    }

    private int givemeh(double h) {
        return (int) (curHeight * h);
    }

    private void customChildMeasure(int i, View child) {
        switch (no_of_image) {
            case 1:
                child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
                curWidth = child.getMeasuredWidth();
                curHeight = child.getMeasuredHeight();
                child.layout(curLeft, curTop, curLeft + childWidth, curTop + childHeight);
                break;
            case 2:
                switch (i) {
                    case 0:
                        child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
                        curWidth = child.getMeasuredWidth();
                        curHeight = child.getMeasuredHeight();
                        child.layout(curLeft, curTop, curLeft + childWidth, curTop + childHeight);
                        break;
                    case 1:
                        child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
                        curWidth = child.getMeasuredWidth();
                        curHeight = child.getMeasuredHeight();
                        child.layout(curLeft, curTop, curLeft + childWidth, curTop + childHeight);
                        break;
                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(980, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(450, MeasureSpec.EXACTLY));
//        int count = getChildCount();
//        // Measurement will ultimately be computing these values.
//        int maxHeight = 0;
//        int maxWidth = 0;
//        int childState = 0;
//        int mLeftWidth = 0;
//        int rowCount = 0;
//        // Iterate through all children, measuring them and computing our dimensions
//        // from their size.
//        for (int i = 0; i < count; i++) {
//            final View child = getChildAt(i);
//            if (child.getVisibility() == GONE)
//                continue;
//            // Measure the child.
//            measureChild(child, widthMeasureSpec, heightMeasureSpec);
//            maxWidth += Math.max(maxWidth, child.getMeasuredWidth());
//            mLeftWidth += child.getMeasuredWidth();
//            if ((mLeftWidth / deviceWidth) > rowCount) {
//                maxHeight += child.getMeasuredHeight();
//                rowCount++;
//            } else {
//                maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
//            }
//            childState = combineMeasuredStates(childState, child.getMeasuredState());
//        }
//
//        // Check against our minimum height and width
//        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
//        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
//
//        // Report our final dimensions.
//        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
//                resolveSizeAndState(maxHeight, heightMeasureSpec, childState << MEASURED_HEIGHT_STATE_SHIFT));
    }
}
