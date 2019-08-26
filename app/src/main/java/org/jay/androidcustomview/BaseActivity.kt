package org.jay.androidcustomview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init()
    }

    abstract fun getLayoutId(): Int

    abstract fun init()

    private fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    fun View.start(clazz: Class<out Activity>) {
        this@start.setOnClickListener {
            startActivity(clazz)
        }
    }


}
