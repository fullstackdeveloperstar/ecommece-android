package com.it.spot.spotit;


import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {


    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_my_profile, container, false);

        ImageView mimageView = (ImageView) rootview.findViewById(R.id.account_image);

        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.myprofile_account_image)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())),mbitmap.getWidth() , mbitmap.getWidth(), mpaint);// Round Image Corner 100 100 100 100
        mimageView.setImageBitmap(imageRounded);

        LinearLayout shipping_address_item = (LinearLayout)rootview.findViewById(R.id.shipping_address_item);
        LinearLayout personal_data_item = (LinearLayout)rootview.findViewById(R.id.personal_data_item);
        LinearLayout the_cart_item = (LinearLayout)rootview.findViewById(R.id.the_cart_item);

        shipping_address_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewShippingAddresses();
            }
        });

        personal_data_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPersonalData();
            }
        });

        the_cart_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMyCart();
            }
        });
        return rootview;
    }

    public void viewShippingAddresses()
    {
        ShippingAddressesFragment main_fragement = new ShippingAddressesFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.profilecontent, main_fragement).commit();
    }

    public void viewPersonalData()
    {
        PersonalDataFragment main_fragement = new PersonalDataFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.profilecontent, main_fragement).commit();
    }

    public void viewMyCart()
    {
        MyCartFragment main_fragement = new MyCartFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.profilecontent, main_fragement).commit();
    }

}
