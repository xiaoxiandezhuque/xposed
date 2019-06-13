package com.xh.xposed.hook;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

public class HookRes implements IXposedHookInitPackageResources {
    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable {
      if (resparam.packageName.equals("com.xh.xiaoshuo")){
          resparam.res.hookLayout(2131492937, new XC_LayoutInflated() {
              @Override
              public void handleLayoutInflated(LayoutInflatedParam liparam) throws Throwable {
                  ArrayList a = new ArrayList<View>();
                  liparam.view.findViewsWithText(a,"书架",View.FIND_VIEWS_WITH_TEXT);
                  if (a.size()>0){
                      ((TextView)a.get(0)).setText("我的书架11");
                  }

              }
          });
      }
        if (resparam.packageName.equals("com.xh.game")){
            resparam.res.hookLayout(2131361835, new XC_LayoutInflated() {
                @Override
                public void handleLayoutInflated(LayoutInflatedParam liparam) throws Throwable {
                    ArrayList a = new ArrayList<View>();
                    liparam.view.findViewsWithText(a,"截图",View.FIND_VIEWS_WITH_TEXT);
                    if (a.size()>0){
                        ((TextView)a.get(0)).setText("我的书架11");
                    }

                }
            });
        }

    }
}
