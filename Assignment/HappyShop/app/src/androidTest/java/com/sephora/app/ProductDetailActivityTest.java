package com.sephora.app;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sephora.activity.ProductsListActivity;
import com.sephora.model.Product;

/**
 * Created by Ranganathan A S on 27-Apr-16.
 */
public class ProductDetailActivityTest extends ActivityInstrumentationTestCase2<com.sephora.activity.ProductDetailActivity> {

    com.sephora.activity.ProductDetailActivity activity;
    public ProductDetailActivityTest() {
        super(com.sephora.activity.ProductDetailActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testProductNameTextViewNotNull(){
        TextView textView = (TextView) activity.findViewById(R.id.product_name_textview);
        assertNotNull(textView);
    }

    public void testProductPriceTextViewNotNull(){
        TextView textView = (TextView) activity.findViewById(R.id.product_price_textview);
        assertNotNull(textView);
    }
    public void testProductDescriptionTextViewNotNull(){
        TextView textView = (TextView) activity.findViewById(R.id.product_description_textview);
        assertNotNull(textView);
    }
    public void testProductImageViewNotNull(){
        ImageView imageView = (ImageView) activity.findViewById(R.id.product_imageview);
        assertNotNull(imageView);
    }

    public void testAddToCartButtonNotNull(){
        Button button = (Button) activity.findViewById(R.id.add_to_cart_button);
        assertNotNull(button);

    }


}
