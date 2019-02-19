package zdl.tianxunda.com.study.adp;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.study.R;

/**
 * Created by dell-pc on 2019/2/19.
 */

public class Main2Adp extends BaseQuickAdapter<String,BaseViewHolder>{

    public Main2Adp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public Main2Adp(int item_layout_main) {
        super(item_layout_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView textView = helper.itemView.findViewById(R.id.textView);
        textView.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        textView.setText(item);
    }
}
