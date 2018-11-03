
Android自定义数字键盘


自定义验证码输入框以及弹出自定义数字键盘；

  virtualKeyboardView =  findViewById(R.id.virtualKeyboardView);

        valueList = virtualKeyboardView.getValueList();

        //是否是阿拉伯输入格式
        password.setArCountry(false);
        initAnim();
        //设置不调用系统键盘
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            password.setInputType(InputType.TYPE_NULL);
        } else {
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(password, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        virtualKeyboardView.getLayoutBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virtualKeyboardView.startAnimation(exitAnim);
                virtualKeyboardView.setVisibility(View.GONE);
            }
        });
        GridView gridView = virtualKeyboardView.getGridView();
        gridView.setOnItemClickListener(onItemClickListener);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                virtualKeyboardView.setFocusable(true);
                virtualKeyboardView.setFocusableInTouchMode(true);
                virtualKeyboardView.startAnimation(enterAnim);
                virtualKeyboardView.setVisibility(View.VISIBLE);
            }
        });
    }

欢迎关注公众号：

![avatar](https://github.com/qxf323/-Android-/blob/master/img/gzh.jpg)
