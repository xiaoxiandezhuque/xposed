package com.xh.xposed

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.FileIOUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
//        ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        for (i in 0 until ll_1.childCount) {
            ll_1.getChildAt(i).setTag(i)
            ll_1.getChildAt(i).setOnClickListener {

                FileIOUtils.writeFileFromString(
                        Environment.getExternalStorageDirectory().absolutePath+"/zzxposed/caiquan",
                        it.getTag().toString())
//                SPUtils.getInstance("config").put("caiquan", it.getTag() as Int)
                tv_1.setText("猜拳-----${it.getTag() as Int + 1}")
            }

        }
        for (i in 0 until ll_2.childCount) {
            ll_2.getChildAt(i).setTag(i)
            ll_2.getChildAt(i).setOnClickListener {
                FileIOUtils.writeFileFromString(
                        Environment.getExternalStorageDirectory().absolutePath+"/zzxposed/saizi",
                        it.getTag().toString())

                tv_2.setText("骰子-----${it.getTag() as Int + 1}")
            }
        }
    }
}
