package dominic.qxf.com.customview.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import dominic.qxf.com.customview.R;
import dominic.qxf.com.customview.listener.OnPasswWordInputFinish;

/**
 * Created by qxf on 2018/9/15.
 */

public class PopupPassword   extends PopupWindow {
    private PassWordView pwdView;

    private View mMenuView;

    private Activity mContext;

    public PopupPassword(Activity context) {

        super(context);

        this.mContext = context;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mMenuView = inflater.inflate(R.layout.pop_enter_password, null);

        pwdView = (PassWordView) mMenuView.findViewById(R.id.pwd_view);

        //添加密码输入完成的响应
        pwdView.setOnFinishInput(new OnPasswWordInputFinish() {
            @Override
            public void inputFinish(final String password) {

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // 模拟耗时的操作。
                        try {

                            Thread.sleep(500);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        mContext.runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                dismiss();

                                Toast.makeText(mContext, "支付成功，密码为：" + password, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }).start();
            }
        });

        // 监听X关闭按钮
        pwdView.getImgCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 监听键盘上方的返回
        pwdView.getVirtualKeyboardView().getLayoutBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.pop_add_ainm);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x66000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

    }
}
