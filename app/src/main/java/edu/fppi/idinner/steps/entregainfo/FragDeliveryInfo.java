package edu.fppi.idinner.steps.entregainfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.fppi.idinner.R;

public class FragDeliveryInfo extends Fragment {
    private static double mPrice = 0;
    private static double mPedidoPreco = 0;
    private static View root;
    private OnButtonNextClick onButtonNextClick = (price) -> {};

    public static void setBasePrice(double price) {
        mPedidoPreco = price;
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        ((TextView) root.findViewById(R.id.Frag_Delivery_Delivery_Price)).setText(String.format("Frete: R$ %s", twoPlaces.format(mPrice)));
        ((TextView) root.findViewById(R.id.Frag_Delivery_Total_Price)).setText(String.format("Total: R$ %s", twoPlaces.format(mPrice + mPedidoPreco)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.layout_frag_delivery, container, false);

        DecimalFormat twoPlaces = new DecimalFormat("0.00");

        LinearLayout enderecoLayout = root.findViewById(R.id.Frag_Delivery_Layout_Endereco);

        RadioGroup checkGroup = root.findViewById(R.id.Frag_Delivery_Check_Group);

        checkGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            ViewGroup.LayoutParams newLay = enderecoLayout.getLayoutParams();
            if (root.findViewById(R.id.Frag_Delivery_Check_Local) == root.findViewById(i)) {
                newLay.height = 1;
                mPrice = 0;
            } else {
                newLay.height = (int) getResources().getDimension(R.dimen.dimen_frag_delivery_endereco_extended);
                mPrice = 4.00;
            }
            ((TextView) root.findViewById(R.id.Frag_Delivery_Delivery_Price)).setText(String.format("Frete: R$ %s", twoPlaces.format(mPrice)));
            ((TextView) root.findViewById(R.id.Frag_Delivery_Total_Price)).setText(String.format("Total: R$ %s", twoPlaces.format(mPrice + mPedidoPreco)));
            enderecoLayout.setLayoutParams(newLay);
        });

        root.findViewById(R.id.Frag_Delivery_NextButton).setOnClickListener(view -> onButtonNextClick.onButtonNextClick(mPrice+mPedidoPreco));

        return root;
    }

    public void setOnButtonNextClick(OnButtonNextClick onButtonNextClick) {
        this.onButtonNextClick = onButtonNextClick;
    }

    public interface OnButtonNextClick {
        void onButtonNextClick(double finalprice);
    }
}
