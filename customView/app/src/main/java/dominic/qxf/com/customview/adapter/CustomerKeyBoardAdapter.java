package dominic.qxf.com.customview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import dominic.qxf.com.customview.R;

/**
 *
 * @author qxf
 * @date 2018/9/14
 */

public class CustomerKeyBoardAdapter  extends BaseAdapter{

    private Context mContext;
    private ArrayList<Map<String, String>> valueList;

   public CustomerKeyBoardAdapter(Context context,ArrayList<Map<String ,String >> valueList){
       this.mContext = context;
       this.valueList = valueList;
   }

    @Override
    public int getCount() {
        return valueList.size();
    }

    @Override
    public Object getItem(int position) {
        return valueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item_virtual_keyboard, null);
            viewHolder = new ViewHolder();
            viewHolder.mtv = (TextView) convertView.findViewById(R.id.btn_keys);
            viewHolder.mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.imgDelete);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (position == 9) {
            viewHolder.mRelativeLayout.setVisibility(View.INVISIBLE);
            viewHolder.mtv.setVisibility(View.VISIBLE);
            viewHolder.mtv.setText(valueList.get(position).get("name"));
            viewHolder.mtv.setBackgroundColor(Color.parseColor("#e0e0e0"));
        } else if (position == 11) {
            viewHolder.mtv.setBackgroundResource(R.mipmap.keyboard_delete_img);
            viewHolder.mRelativeLayout.setVisibility(View.VISIBLE);
            viewHolder.mtv.setVisibility(View.INVISIBLE);

        } else {
            viewHolder.mRelativeLayout.setVisibility(View.INVISIBLE);
            viewHolder.mtv.setVisibility(View.VISIBLE);

            viewHolder.mtv.setText(valueList.get(position).get("name"));
        }
        return null;
    }

    class ViewHolder {
       private TextView mtv;
       private RelativeLayout mRelativeLayout;
    }
}
