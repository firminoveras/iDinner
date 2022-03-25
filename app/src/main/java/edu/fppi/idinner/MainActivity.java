package edu.fppi.idinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import edu.fppi.idinner.steps.confirminfo.ConfirmInfo;
import edu.fppi.idinner.steps.entregainfo.FragDeliveryInfo;
import edu.fppi.idinner.steps.paymentinfo.FragPaymentInfo;
import edu.fppi.idinner.steps.pedidoinfo.FragPedidoInfo;
import edu.fppi.idinner.steps.userinfo.FragUserInfo;
import edu.fppi.idinner.steps.pedidoinfo.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private boolean viewPagerBackEnable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Main_Main).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);

        DotsIndicator dotsIndicator = findViewById(R.id.Main_Indicator);
        viewPager = findViewById(R.id.Main_Pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        FragUserInfo userFrag = new FragUserInfo();
        FragPedidoInfo pedidoFrag = new FragPedidoInfo(this);
        FragDeliveryInfo entregaFrag = new FragDeliveryInfo();
        FragPaymentInfo pagamentoFrag = new FragPaymentInfo();
        ConfirmInfo confirmFrag = new ConfirmInfo();

        userFrag.setOnButtonNextClick(() -> viewPager.setCurrentItem(viewPager.getCurrentItem() + 1));
        pedidoFrag.setOnButtonNextClick((price) -> {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            FragDeliveryInfo.setBasePrice(price);
        });
        entregaFrag.setOnButtonNextClick((price) -> {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            FragPaymentInfo.setPrice(price);
        });
        pagamentoFrag.setOnButtonNextClick(() -> viewPager.setCurrentItem(viewPager.getCurrentItem() + 1));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==4){
                    viewPagerBackEnable = false;
                }
            }
        });

        adapter.add(userFrag);
        adapter.add(pedidoFrag);
        adapter.add(entregaFrag);
        adapter.add(pagamentoFrag);
        adapter.add(confirmFrag);

        viewPager.setAdapter(adapter);
        viewPager.setUserInputEnabled(false);

        dotsIndicator.setViewPager2(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() > 0 && viewPagerBackEnable) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else {
            startActivity(new Intent(MainActivity.this, InitScreen.class));
            overridePendingTransition(R.anim.slide_down_out, R.anim.slide_down_in);
            finish();
        }
    }
}