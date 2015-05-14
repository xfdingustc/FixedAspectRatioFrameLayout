package com.xfdingustc.fix_aspect_ratio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Xiaofei on 2015/5/14.
 */
public class FixedAspectRatioFrameLayout extends FrameLayout {
  private int mXRatio = 16;
  private int mYRatio = 9;
  public FixedAspectRatioFrameLayout(Context context) {
    this(context, null);
  }

  public FixedAspectRatioFrameLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public FixedAspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatioFrameLayout);
    mXRatio = a.getDimensionPixelSize(R.styleable.FixedAspectRatioFrameLayout_farfl_xratio,
        mXRatio);
    mYRatio = a.getDimensionPixelSize(R.styleable.FixedAspectRatioFrameLayout_farfl_yratio,
        mYRatio);

  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width_pixel_size = MeasureSpec.getSize(widthMeasureSpec);
    int height_measure_mode = MeasureSpec.getMode(heightMeasureSpec);

    int height_pixel_size = width_pixel_size * mYRatio / mXRatio;
    int new_height_measure_spec = MeasureSpec.makeMeasureSpec(height_pixel_size,
        height_measure_mode);
    super.onMeasure(widthMeasureSpec, new_height_measure_spec);


  }
}
