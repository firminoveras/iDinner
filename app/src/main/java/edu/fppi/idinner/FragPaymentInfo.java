package edu.fppi.idinner;

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

public class FragPaymentInfo extends Fragment {
    private static double mPrice = 0;
    private static View root;
    private OnButtonNextClick onButtonNextClick = () -> {
    };

    public static void setPrice(double price) {
        mPrice = price;
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        ((TextView) root.findViewById(R.id.Frag_Payment_Total_Price)).setText(String.format("Total: R$ %s", twoPlaces.format(mPrice)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.layout_frag_payment, container, false);

        DecimalFormat twoPlaces = new DecimalFormat("0.00");

        ((TextView) root.findViewById(R.id.Frag_Payment_Total_Price)).setText(String.format("Total: R$ %s", twoPlaces.format(mPrice)));
        ((RadioGroup) root.findViewById(R.id.Frag_Payment_CheckGroup)).setOnCheckedChangeListener((radioGroup, i) -> {
            LinearLayout cardLayout = root.findViewById(R.id.Frag_Delivery_Layout_Card);
            LinearLayout pixLayout = root.findViewById(R.id.Frag_Delivery_Layout_Pix);

            ViewGroup.LayoutParams newLayCard = cardLayout.getLayoutParams();
            ViewGroup.LayoutParams newLayPix = pixLayout.getLayoutParams();

            if (root.findViewById(R.id.Frag_Payment_AVista) == root.findViewById(i)) {
                newLayCard.height = 2;
                newLayPix.height = 2;
            } else if (root.findViewById(R.id.Frag_Payment_CardDebit) == root.findViewById(i)) {
                newLayCard.height = (int) getResources().getDimension(R.dimen.dimen_card_extended);
                newLayPix.height = 2;
            } else if (root.findViewById(R.id.Frag_Payment_CardCredit) == root.findViewById(i)) {
                newLayCard.height = (int) getResources().getDimension(R.dimen.dimen_card_extended);
                newLayPix.height = 2;
            } else {
                newLayCard.height = 2;
                newLayPix.height = (int) getResources().getDimension(R.dimen.dimen_pix_extended);
            }
            cardLayout.setLayoutParams(newLayCard);
            pixLayout.setLayoutParams(newLayPix);

        });

        root.findViewById(R.id.Frag_Payment_NextButton).setOnClickListener(view -> onButtonNextClick.onButtonNextClick());


        return root;
    }

    public void setOnButtonNextClick(OnButtonNextClick onButtonNextClick) {
        this.onButtonNextClick = onButtonNextClick;
    }

    public interface OnButtonNextClick {

        void onButtonNextClick();
    }
}
