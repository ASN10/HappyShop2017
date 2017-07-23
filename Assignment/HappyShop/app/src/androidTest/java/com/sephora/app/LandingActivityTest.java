package com.sephora.app;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sephora.model.Product;

import java.util.ArrayList;

/**
 * Created by Ranganathan A S on 27-Apr-16.
 */
public class LandingActivityTest extends ActivityInstrumentationTestCase2<LandingActivity> {

    LandingActivity activity;

    public LandingActivityTest() {
        super(com.sephora.app.LandingActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }



    public void testNavigationDrawerNotNull() {
        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        assertNotNull(drawerLayout);
    }

    public void testDrawerListViewNotNull() {
        ListView navListView = (ListView) activity.findViewById(R.id.list_slidermenu);
        assertNotNull(navListView);
    }

    public void testToolBarNotNull() {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        assertNotNull(toolbar);
    }

    public void testFrameContainerNotNull() {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.frame_container);
        assertNotNull(frameLayout);
    }

    public void testIsCategoryType(){
        assertTrue(activity.checkIfCategoryKeyIsPresent("Skincare"));
    }

    public void testIsNotCategoryType(){
        assertFalse(activity.checkIfCategoryKeyIsPresent(""));
    }


}
