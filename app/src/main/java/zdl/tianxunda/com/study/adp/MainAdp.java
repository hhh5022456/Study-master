package zdl.tianxunda.com.study.adp;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.study.R;

/**
 * Created by dell-pc on 2019/2/19.
 */

public class MainAdp extends BaseQuickAdapter<String,BaseViewHolder>{

    public MainAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public MainAdp(int item_layout_main) {
        super(item_layout_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView,item);
    }
}
