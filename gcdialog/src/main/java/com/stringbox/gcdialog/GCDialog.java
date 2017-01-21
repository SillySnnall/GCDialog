package com.stringbox.gcdialog;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by StringBOX on 2016/10/20.
 */

public class GCDialog extends AlertDialog {


    private Context mContext;
    private int layoutResID;
    private final SparseArray<View> mViews;

    public GCDialog(Context context) {
        super(context, R.style.GCDialog);
        mContext = context;
        mViews = new SparseArray<>();
    }

    /**
     * 传入布局文件
     * @param layoutResID
     * @return GCDialog
     * <br/>
     * RelativeLayout <br/>
     * &nbsp match_parent <br/>
     * &nbsp match_parent <br/>
     * &nbsp&nbsp&nbsp RelativeLayout <br/>
     * &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp 在第二个Layout中写代码，类似activity中的xml文件 <br/>
     * &nbsp&nbsp&nbsp /RelativeLayout <br/>
     * /RelativeLayout
     */
    public GCDialog loadLayout(int layoutResID) {
        this.layoutResID = layoutResID;
        show();
        dismiss();
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResID);
        //按空白处是否取消Dialog
        setCanceledOnTouchOutside(true);
        matchWidth();
    }

    /**
     * 宽度填充屏幕
     */
    private void matchWidth() {
        Window dialogWindow = getWindow();
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        p.width = dm.widthPixels;
        dialogWindow.setAttributes(p);
    }

    public <TView extends View> TView getView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = findViewById(id);
            mViews.put(id, view);
        }
        return (TView) view;
    }

    public GCDialog setText(int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public GCDialog setImageURI(int viewId, Uri uri) {
        ImageView view = getView(viewId);
        view.setImageURI(uri);
        return this;
    }

    public GCDialog setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public GCDialog setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    public GCDialog setImageResource(int viewId, int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public GCDialog setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public GCDialog setBackgroundResource(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public GCDialog setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public GCDialog setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public GCDialog setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public GCDialog setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }
}
