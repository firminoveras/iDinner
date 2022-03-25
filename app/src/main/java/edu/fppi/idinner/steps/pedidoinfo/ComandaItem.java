package edu.fppi.idinner.steps.pedidoinfo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.text.DecimalFormat;
import java.util.Objects;

import edu.fppi.idinner.R;

public class ComandaItem extends LinearLayout {

    private Context mContext;
    private TextView mTitle, mCountText, mTotalPrice, mUnityPrice;
    private int mCount = 1;
    private double mPrice;

    public ComandaItem(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ComandaItem(Context context, String title, double price) {
        super(context);
        mContext = context;
        init();
        mPrice = price;
        mTitle.setText(title);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        mUnityPrice.setText(String.format("R$ %s", twoPlaces.format(price)));
        setCount(mCount);
    }

    public void setCount(int newCount) {
        mCount = newCount;
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        mCountText.setText(String.valueOf(mCount));
        mTotalPrice.setText(String.format("R$ %s", twoPlaces.format(mPrice * mCount)));
    }

    public int getCount() {
        return mCount;
    }

    private void init() {
        inflate(mContext, R.layout.layout_comanda_item, this);
        mTitle = findViewById(R.id.Comanda_Item_Title);
        mCountText = findViewById(R.id.Comanda_Item_Count);
        mTotalPrice = findViewById(R.id.Comanda_Item_TotalPrice);
        mUnityPrice = findViewById(R.id.Comanda_Item_UnityPrice);
        setOnClickListener(view -> {
            View alertContent = ((Activity) mContext).getLayoutInflater().inflate(R.layout.layout_comanda_item_configs, findViewById(R.id.Comanda_item_config_main));
            AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
            alert.setView(alertContent);
            Dialog dialog = alert.show();
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            ((TextView) alertContent.findViewById(R.id.Comanda_item_config_title)).setText(mTitle.getText());
            TextView totalPrice = alertContent.findViewById(R.id.Comanda_item_config_title);
            TextView count = alertContent.findViewById(R.id.Comanda_item_config_count);

            DecimalFormat twoPlaces = new DecimalFormat("0.00");

            totalPrice.setText(String.format("TOTAL: R$ %s", twoPlaces.format(mCount * mPrice)));
            count.setText(String.valueOf(mCount));

            alertContent.findViewById(R.id.Comanda_item_config_minus).setOnClickListener(view1 -> {
                int actualCount = Integer.parseInt(count.getText().toString());
                if (actualCount > 1) actualCount = actualCount - 1;
                count.setText(String.valueOf(actualCount));
                totalPrice.setText(String.format("TOTAL: R$ %s", twoPlaces.format(actualCount * mPrice)));
            });

            alertContent.findViewById(R.id.Comanda_item_config_plus).setOnClickListener(view1 -> {
                int actualCount = Integer.parseInt(count.getText().toString());
                actualCount = actualCount + 1;
                count.setText(String.valueOf(actualCount));
                totalPrice.setText(String.format("TOTAL: R$ %s", twoPlaces.format(actualCount * mPrice)));
            });

            alertContent.findViewById(R.id.Comanda_item_config_delete).setOnClickListener(view1 -> {
                ViewGroup parent = (ViewGroup) getParent();
                parent.removeView(this);
                dialog.dismiss();
            });

            alertContent.findViewById(R.id.Comanda_item_config_confirm).setOnClickListener(view1 -> {
                setCount(Integer.parseInt(count.getText().toString()));
                dialog.dismiss();
            });


        });
    }

    public double getTotal() {
        return mPrice * mCount;
    }

    public String getTitle() {
        return mTitle.getText().toString();
    }
}
