package edu.fppi.idinner.steps.pedidoinfo;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;

import edu.fppi.idinner.R;

public class FragPedidoInfo extends Fragment {
    private final Context mContext;
    private LinearLayout mList;
    private View root;
    private LinearLayout comandaItems;
    private TextView comandaTitle;
    private boolean mComandaExtended = false;
    private OnButtonNextClick onButtonNextClick = (price) -> {
    };
    private double mPrice;

    public FragPedidoInfo(Context context) {
        this.mContext = context;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.layout_frag_pedido, container, false);
        mList = root.findViewById(R.id.Frag_Pedido_List);


        TabLayout tabs = root.findViewById(R.id.Frag_Pedido_Tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        comandaTitle = root.findViewById(R.id.Frag_Pedido_Comanda_Button);
        LinearLayout comandaLayout = root.findViewById(R.id.Frag_Pedido_Comanda_Layout);
        comandaItems = root.findViewById(R.id.Frag_Pedido_Comanda_List);

        comandaTitle.setOnClickListener(view -> {
            ViewGroup.LayoutParams lay = comandaLayout.getLayoutParams();

            ValueAnimator anim = ValueAnimator.ofInt(lay.height, (int) (mComandaExtended ? getResources().getDimension(R.dimen.comanda_minimized) : getResources().getDimension(R.dimen.comanda_maximized)));
            anim.addUpdateListener(valueAnimator -> {
                lay.height = (int) valueAnimator.getAnimatedValue();
                comandaLayout.setLayoutParams(lay);
            });
            anim.setDuration(300);
            anim.start();

            mList.setEnabled(mComandaExtended);
            mComandaExtended = !mComandaExtended;
        });

        updateTotalPrice();
        setTab(tabs.getSelectedTabPosition());

        root.findViewById(R.id.Frag_User_NextButton).setOnClickListener(view -> {
            if (getPrice() > 0)
                onButtonNextClick.onButtonNextClick(getPrice());
            else
                Toast.makeText(mContext, "O pedido não pode estar vazio.", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    public double getPrice() {
        return mPrice;
    }


    private void setTab(int position) {
        mList.removeAllViews();
        switch (position) {
            case 0:
                mList.addView(new CardapioItem(mContext, "Batata Frita", "Porção de batatas fritas com sal e molho.", 5.75, R.mipmap.l1));
                mList.addView(new CardapioItem(mContext, "Misto", "Pão com queijo quente e requeijão.", 2.50, R.mipmap.l2));
                mList.addView(new CardapioItem(mContext, "Açaí", "Porção açaí, granola, frutas variadas.", 12.50, R.mipmap.l3));
                mList.addView(new CardapioItem(mContext, "Lanche Completo", "Hamburguer, coca e batata frita.", 10.50, R.mipmap.l3));
                break;
            case 1:
                mList.addView(new CardapioItem(mContext, "Pizza Portuguesa", "Queijo, molho, catupiry, cebola, carne seca.", 30.00, R.mipmap.p1));
                mList.addView(new CardapioItem(mContext, "Pizza Calabresa", "Queijo, molho, calabresa, cebola.", 30.00, R.mipmap.p2));
                mList.addView(new CardapioItem(mContext, "Pizza Quatro Queijos", "Queijo mussarela, parmesão, coalho e chedah.", 30.00, R.mipmap.p3));
                mList.addView(new CardapioItem(mContext, "Pizza Lombo Canadense", "Queijo mussarela, lombo, tomate.", 30.00, R.mipmap.p4));
                mList.addView(new CardapioItem(mContext, "Pizza Champingnom", "Queijo mussarela, champignon, tomate, cebola caramelizada.", 32.00, R.mipmap.p5));
                mList.addView(new CardapioItem(mContext, "Pizza Doce", "Chocolate, leite condensado e doces.", 35.00, R.mipmap.p6));
                break;
            case 2:
                mList.addView(new CardapioItem(mContext, "Coca-Cola 2l", "2L", 5.00, R.mipmap.b1));
                mList.addView(new CardapioItem(mContext, "Fanta Latinha", "300ml", 3.50, R.mipmap.b2));
                mList.addView(new CardapioItem(mContext, "Coca Latinha", "300ml", 5.50, R.mipmap.b3));
                mList.addView(new CardapioItem(mContext, "Coca Caçulinha", "300ml", 2.50, R.mipmap.b4));
                mList.addView(new CardapioItem(mContext, "Guaraná Caçulinha", "300ml", 2.50, R.mipmap.b5));
                mList.addView(new CardapioItem(mContext, "Sortida 600ml", "Fanta Uva ou Fanta Laranja ou Coca ou Soda ou Kuat", 4.50, R.mipmap.b5));
                break;
            case 3:
                mList.addView(new CardapioItem(mContext, "Coxinha de Frango", "Frango desfiado e catupury", 2.00, R.mipmap.s1));
                mList.addView(new CardapioItem(mContext, "Esfirra", "Frango desfiado, milho e ervilha.", 2.50, R.mipmap.s2));
                mList.addView(new CardapioItem(mContext, "Risole", "Queijo e Presunto.", 2.00, R.mipmap.s3));
                mList.addView(new CardapioItem(mContext, "Enroladinho de Salsicha", "Salsicha e Oregano.", 2.00, R.mipmap.s4));
                mList.addView(new CardapioItem(mContext, "Kibe", "Carne moída temperada.", 2.00, R.mipmap.s5));
                mList.addView(new CardapioItem(mContext, "Coxinha de Queijo", "Quejo mussarela com oregano.", 2.50, R.mipmap.s6));
                break;
            case 4:
                mList.addView(new CardapioItem(mContext, "Big Tudo", "Um blend de carne com chedah e molho especial.", 10.00, R.mipmap.h1));
                mList.addView(new CardapioItem(mContext, "BBQ", "Um blend de carne com chedah e molho barbecue", 12.99, R.mipmap.h2));
                mList.addView(new CardapioItem(mContext, "Nordestino", "Dois blends de carne, salada, maionese artesanal.", 15.50, R.mipmap.h3));
                mList.addView(new CardapioItem(mContext, "Imperador", "Três blends de carne com chedah.", 18.50, R.mipmap.h4));
                mList.addView(new CardapioItem(mContext, "X-Men", "Três blends de carne com chedah, molho especial, extra de bacon.", 20.99, R.mipmap.h5));
                break;
        }


        for (int index = 0; index < mList.getChildCount(); index++) {
            CardapioItem item = (CardapioItem) mList.getChildAt(index);
            item.setOnClickListener(view -> {
                if (((LinearLayout) view.getParent()).isEnabled()) {
                    boolean alreadyHas = false;
                    for (int innerIndex = 0; innerIndex < comandaItems.getChildCount(); innerIndex++) {
                        ComandaItem comandaItem = ((ComandaItem) comandaItems.getChildAt(innerIndex));

                        if (comandaItem.getTitle().equals(item.getTitle())) {
                            alreadyHas = true;
                            comandaItem.setCount(comandaItem.getCount() + 1);
                        }
                    }

                    if (!alreadyHas) {
                        comandaItems.addView(new ComandaItem(mContext, item.getTitle(), item.getPrice()));
                    }
                    updateTotalPrice();
                }
            });
        }
    }


    private void updateTotalPrice() {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        mPrice = 0;

        for (int index = 0; index < comandaItems.getChildCount(); index++) {
            mPrice += ((ComandaItem) comandaItems.getChildAt(index)).getTotal();
        }

        comandaTitle.setText(String.format("---COMANDA---    TOTAL: R$ %s", twoPlaces.format(mPrice)));
        comandaTitle.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.pop));
    }

    public void setOnButtonNextClick(OnButtonNextClick onButtonNextClick) {
        this.onButtonNextClick = onButtonNextClick;
    }

    public interface OnButtonNextClick {
        void onButtonNextClick(double price);
    }
}
