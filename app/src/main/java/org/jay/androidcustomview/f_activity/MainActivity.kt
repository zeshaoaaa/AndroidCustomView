package org.jay.androidcustomview.f_activity

import kotlinx.android.synthetic.main.activity_main.*
import org.jay.androidcustomview.BaseActivity
import org.jay.androidcustomview.R

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        btn_a_basic.start(ABasicActivity::class.java)
        btn_b_path.start(BPathActivity::class.java)
        btn_c_text.start(CTextActivity::class.java)
        btn_d_region.start(DRegionActivity::class.java)
        btn_e_canvas.start(ECanvasActivity::class.java)
    }

}
