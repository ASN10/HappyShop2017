package com.sephora.app;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;

import com.paging.gridview.PagingGridView;
import com.sephora.activity.ProductsListActivity;
import com.sephora.servicehelper.ProductsServiceHelper;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ProductListActivityTest extends ActivityInstrumentationTestCase2<ProductsListActivity> {

    PagingGridView gridview;
    ProductsListActivity productsListActivity;

    public ProductListActivityTest() {
        super(com.sephora.activity.ProductsListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        productsListActivity = getActivity();

    }


    public void testGridViewNotNull(){
        gridview = (PagingGridView) productsListActivity.findViewById(R.id.paging_grid_view);
        assertNotNull(gridview);
    }


    public void testResponseNotNull(){
        productsListActivity.makeServiceCall("Makeup", 1);
        assertNotNull(productsListActivity.checkIfServiceResponseNotNull(productsListActivity.jsonresponse));
    }






}