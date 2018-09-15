package dominic.qxf.com.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

import dominic.qxf.com.customview.R;
import dominic.qxf.com.customview.adapter.CustomerKeyBoardAdapter;

/**
 *
 * @author qxf
 * @date 2018/9/14
 */

public class CustomKeyBoardView extends RelativeLayout {
    private Context mContext;
    //用GrideView布局键盘，其实并不是真正的键盘，只是模拟键盘的功能
    private GridView gridView;
    //存储键盘显示的数字
    private ArrayList<Map<String, String>> valueList;

    private RelativeLayout layoutBack;

    public CustomKeyBoardView(Context context) {
        super(context);
    }

    public CustomKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        View view = View.inflate(context, R.layout.layout_customview,null);
        layoutBack = (RelativeLayout) view.findViewById(R.id.layoutBack);

        gridView = (GridView) view.findViewById(R.id.gv_keybord);
        //实例化数据
        valueList  = new ArrayList<>();


        initValueList();

        setValueList();

        addView(view);      //添加view
    }

    public RelativeLayout getLayoutBack() {
        return layoutBack;
    }

    public ArrayList<Map<String, String>> getValueList() {
        return valueList;
    }
    public GridView getGridView() {
        return gridView;
    }
    //自定义的键盘显示初始化数据
    private void initValueList(){
        for (int i= 0; i< 13; i++){
          Map<String ,String > map = new HashMap<>();
          if (i<10){
              //显示数字
              map.put("value",String.valueOf(i));
          }else if(i == 10 || i ==12){
            map.put("value","");
          }else if(i == 11){
              map.put("value",String.valueOf(0));
          }
        valueList.add(map);
        }
    }
    private void setValueList (){
        CustomerKeyBoardAdapter customerKeyBoardAdapter = new CustomerKeyBoardAdapter(mContext,valueList);

    }
}
