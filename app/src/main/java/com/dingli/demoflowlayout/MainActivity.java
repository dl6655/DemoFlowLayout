package com.dingli.demoflowlayout;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DFlowLayout mFlowLayout;
    private View mViewIcon;
    private String mNames[] = {
            "welcome","android","TextView",
            "apple","jamy","kobe bryant",
            "jordan","dingding"
    };
    private int mScreenWidth,mScreenHeight,mSrcScreenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initView(){
        mFlowLayout=(DFlowLayout)findViewById(R.id.flowlayout);
        Point point=new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        mSrcScreenWidth=point.x;
        mScreenHeight=point.y;

        int size=3;
        int sizi1=size/2;
        if(size%2==0){
            mScreenWidth=(mSrcScreenWidth/(size/2));
        }else{
            mScreenWidth=(mSrcScreenWidth/(size/2+1));
        }
        if(size<5){
            mScreenWidth=mSrcScreenWidth/size;
        }
        for(int i=0;i<size;i++){
            TextView viewTv = new TextView(this);
            viewTv.setId(R.id.tv1);
            ImageView imageViewBig=new ImageView(this);
            imageViewBig.setId(R.id.tv2);

            ImageView imageViewIcon=new ImageView(this);
            imageViewIcon.setId(R.id.tv3);


            RelativeLayout.LayoutParams imageParms = new RelativeLayout.LayoutParams(
                    mScreenWidth,mScreenWidth*7/10);
            imageParms.setMargins(0,20,0,0);
            RelativeLayout.LayoutParams imageIconParms = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
            imageIconParms.addRule(RelativeLayout.ALIGN_RIGHT|RelativeLayout.ABOVE,R.id.tv2);

            imageViewBig.setImageResource(R.mipmap.icon_order);
            imageViewIcon.setImageResource(R.mipmap.biz_pediatrics_home_add_num_icon);


            RelativeLayout relativeLayout1=new RelativeLayout(getApplicationContext());


            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.leftMargin = 0;
            lp.rightMargin = 0;
            lp.topMargin =0;
            lp.bottomMargin = 0;

            viewTv.setText(mNames[i]);
            viewTv.setGravity(Gravity.CENTER);
            viewTv.setTextColor(Color.BLACK);

            RelativeLayout.LayoutParams reParamsTv=new RelativeLayout.LayoutParams(mScreenWidth,-2);
            reParamsTv.addRule(RelativeLayout.BELOW,R.id.tv2);

            relativeLayout1.addView(imageViewBig,imageParms);
            relativeLayout1.addView(viewTv,reParamsTv);
            relativeLayout1.addView(imageViewIcon,imageIconParms);
            mFlowLayout.addView(relativeLayout1,lp);
        }
    }
}
