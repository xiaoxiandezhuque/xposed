package com.xh.xposed.hook;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookPackage implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("----------------------------");
        XposedBridge.log("Loaded app: " + lpparam.packageName);
        if (lpparam.packageName.equals("com.xh.xiaoshuo")) {
            XposedBridge.log("进入");

//            XC_MethodReplacement  使用这个回调，去替换原有方法的调用，而调用这个全新的方法


            XposedHelpers.findAndHookMethod("com.xh.xiaoshuo.ui.main.BookshelfFragment$initView$1",
                    lpparam.classLoader,
                    "onClick",
                    View.class,//方法参数
                    new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            ToastUtils.showLong("replaceHookedMethod");

                            return null;
                        }

//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            super.beforeHookedMethod(param);
//
//                            ToastUtils.showLong("之前");
//                        }
//
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            super.afterHookedMethod(param);
////                            ToastUtils.showLong("之后");
////                            param.method = null;
////                            这是方法返回
////                            param.setResult("1");
//
//                        }
                    });

            XposedHelpers.findAndHookMethod("com.xh.xiaoshuo.ui.main.BookshelfFragment",
                    lpparam.classLoader,
                    "initBanner",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);


                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            ToastUtils.showLong("initBanner");
//                            ToastUtils.showLong("之后");
//                            param.method = null;
//                            这是方法返回
//                            param.setResult("1");

                        }
                    });

        }

    }

    public static void hookOnClickListener(View view) {
//        try {
//            // 得到 View 的 ListenerInfo 对象
//            Method getListenerInfo = View.class.getDeclaredMethod("getListenerInfo");
//            //修改getListenerInfo为可访问(View中的getListenerInfo不是public)
//            getListenerInfo.setAccessible(true);
//            Object listenerInfo = getListenerInfo.invoke(view);
//            // 得到 原始的 OnClickListener 对象
//            Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");
//            Field mOnClickListener = listenerInfoClz.getDeclaredField("mOnClickListener");
//            mOnClickListener.setAccessible(true);
//            View.OnClickListener originOnClickListener = (View.OnClickListener) mOnClickListener.get(listenerInfo);
//            // 用自定义的 OnClickListener 替换原始的 OnClickListener
//            View.OnClickListener hookedOnClickListener = new OnClickListenerProxy(originOnClickListener);
//            mOnClickListener.set(listenerInfo, hookedOnClickListener);
//        } catch (Exception e) {
//
//        }
    }

}
