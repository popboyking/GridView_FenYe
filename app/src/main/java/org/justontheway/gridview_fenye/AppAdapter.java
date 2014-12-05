package org.justontheway.gridview_fenye;
  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
  
import android.content.Context;  
import android.content.pm.PackageManager;  
import android.content.pm.ResolveInfo;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;  
  
import org.justontheway.gridview_fenye.R;

public class AppAdapter extends BaseAdapter {
    private List<Map> mList;
    private Context mContext;
    public static final int APP_PAGE_SIZE = 25;
    private PackageManager pm;

    public AppAdapter(Context context, List<Map> list, int page) {
        mContext = context;
        pm = context.getPackageManager();

        mList = new ArrayList<Map>();
        int i = page * APP_PAGE_SIZE;
        int iEnd = i+APP_PAGE_SIZE;
        while ((i<list.size()) && (i<iEnd)) {
            mList.add(list.get(i));
            i++;
        }
    }
    public int getCount() {
        // TODO Auto-generated method stub  
        return mList.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub  
        return mList.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub  
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub  
        Map appInfo = mList.get(position);
        AppItem appItem;
        if (convertView == null) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.cartitem, null);

            appItem = new AppItem();
            appItem.medicineImage = (ImageView)v.findViewById(R.id.medicineImage);
            appItem.mname = (TextView)v.findViewById(R.id.mname);
            appItem.mprice = (TextView)v.findViewById(R.id.mprice);
            v.setTag(appItem);
            convertView = v;
        } else {
            appItem = (AppItem)convertView.getTag();
        }
        // set the icon  
        appItem.medicineImage.setImageResource(R.drawable.ic_launcher);
        // set the app name  
        appItem.mname.setText(appInfo.get("mname").toString());
        appItem.mname.setText(appInfo.get("mprice").toString());
        return convertView;
    }

    /**
     * 每个应用显示的内容，包括图标和名称
     * @author Yao.GUET
     *
     */
    class AppItem {
        //ImageView mAppIcon;
        //TextView mAppName;
        ImageView medicineImage;
        TextView mname;
        TextView mprice;
    }
}  
