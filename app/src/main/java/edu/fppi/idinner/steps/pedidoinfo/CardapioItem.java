package edu.fppi.idinner.steps.pedidoinfo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.text.DecimalFormat;

import edu.fppi.idinner.R;

public class CardapioItem extends LinearLayout {
    private TextView mTitle, mDescription, mPrice;
    private ImageView mImage;
    private double mDoublePrice;


    public CardapioItem(Context context) {
        super(context);
    }

    public CardapioItem(Context context, String title, String description, double price, int imageId) {
        super(context);
        inflate(getContext(), R.layout.layout_cardapio_item, this);
        mTitle = findViewById(R.id.CardapioItem_Titulo);
        mDescription = findViewById(R.id.CardapioItem_Descricao);
        mPrice = findViewById(R.id.CardapioItem_Preco);
        mImage = findViewById(R.id.CardapioItem_Imagem);

        mDoublePrice = price;

        mImage.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), imageId, null));
        mTitle.setText(title);
        mDescription.setText(description);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        mPrice.setText(String.format("R$ %s", twoPlaces.format(price)));
    }

    public String getTitle() {
        return mTitle.getText().toString();
    }

    public double getPrice() {
        return mDoublePrice;
    }


}
