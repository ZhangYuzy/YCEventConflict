package com.pedaily.yc.ycparallaxeffectlib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by yc on 2016/9/12.
 * 时差特效，ListView控件
 */
public class ParallaxEffectListView extends ListView {

	private int intrinsicHeight;
	private int originalHeight;
	private ValueAnimator va;

	public ParallaxEffectListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	//目的:到达ListView的上边界的时候,仍然可以向下拉
	//重写overScrollBy
	/**
	 * 滚动越界处理
	 * @param deltaX
	 * @param deltaY         dy 系统每隔一段时间检测手指的移动距离
	 * @param scrollX
	 * @param scrollY        已经滚动的y距离
	 * @param scrollRangeX
	 * @param scrollRangeY   滚动的y的范围
	 * @param maxOverScrollX
	 * @param maxOverScrollY 最大超出滚动的y的范围
	 * @param isTouchEvent   达到边界的时候为true(注:不包含惯性滑动到达的边界)
	 * @return
	 */
	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		Log.i("test", "deltaY:" + deltaY + ", isTouchEvent:" + isTouchEvent);
		if (isTouchEvent) {
			//表示已经到达上边界并向下拉
			if (deltaY < 0) {
				//获取原来的高度+dy,得到一个新的高度
				int newHeight = iv.getLayoutParams().height + Math.abs(deltaY);
				if (newHeight > intrinsicHeight * 0.75f) {
					newHeight = (int) (intrinsicHeight * 0.6f);
				}
				//1,获取ImageView
				//2,获取ImageView的布局参数
				iv.getLayoutParams().height = newHeight;
				Log.i("test", "newHeight:" + newHeight);
				//请求重写布局,这样就可以使被修改的LayoutParams生效
				iv.requestLayout();
			}
		}
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
	}

	//将视差特效需要的ImageView通过外部传入进来
	private ImageView iv;

	public void setImageView(ImageView iv) {
		this.iv = iv;
		//获取相片的属性的高度
		intrinsicHeight = iv.getDrawable().getIntrinsicHeight();
		Log.i("test", "intrinsicHeight:" + intrinsicHeight);

		//最原始的布局参数中的高度,并未发生改变
		originalHeight = iv.getLayoutParams().height;
	}


	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				//在动画执行过程中再次down,则取消之前的动画
				if (va != null) {
					//如果动画执行,则取消
					if (va.isRunning()) {
						va.cancel();
					}
				}
				break;
			case MotionEvent.ACTION_UP:
				//定义值动画,传入初始值和结束值
				va = ValueAnimator.ofInt(iv.getLayoutParams().height, originalHeight);
				//在动画执行的过程中,让iv的高度不断变化
				va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					//在动画改变的过程中调用
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						//获取变化的高度值
						int height = (int) animation.getAnimatedValue();
						iv.getLayoutParams().height = height;
						iv.requestLayout();
					}
				});
				//执行到终点后,超过一段距离再回来
				va.setInterpolator(new OvershootInterpolator());
				va.setDuration(300);
				va.start();
				break;
            case MotionEvent.ACTION_MOVE:

                break;
		}
		//表示想要处理事件
		return super.onTouchEvent(ev);
	}
}
