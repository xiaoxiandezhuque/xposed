package com.xh.xposed.hook;

import android.os.Environment;

import com.blankj.utilcode.util.FileIOUtils;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookWX implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (lpparam.packageName.equals("com.tencent.mm")) {
            XposedBridge.log("进入");

//            XC_MethodReplacement  使用这个回调，去替换原有方法的调用，而调用这个全新的方法


            XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.bo",
                    lpparam.classLoader,
                    "hC",
                    Integer.TYPE, Integer.TYPE,//方法参数
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
//                            ToastUtils.showLong("参数1=" + ((int) param.args[0]) + "---参数2=" + param.args[1] +
//                                    "返回=" + param.getResult());
                            int type = (int) param.args[0];
                            switch (type) {
                                //猜拳
                                case 2:
                                    param.setResult(Integer.valueOf(FileIOUtils.readFile2String(
                                            Environment.getExternalStorageDirectory().getAbsolutePath()
                                                    + "/zzxposed/caiquan")));

//                                    2布 1石头  0剪刀
                                    break;
                                //骰子
                                case 5:
//                                    0-5 对应1到6
                                    param.setResult(Integer.valueOf(FileIOUtils.readFile2String(
                                            Environment.getExternalStorageDirectory().getAbsolutePath()
                                                    + "/zzxposed/saizi")));


                                    break;

                            }
                        }
                    });


        }

    }


}

