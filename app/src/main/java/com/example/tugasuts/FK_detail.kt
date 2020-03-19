package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_fakultas.*
import kotlinx.android.synthetic.main.fak_listitem.*

class FK_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fakultas)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partjdl = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partdesc = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_ANSWER)
            var partimg = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_CHOOSER).toInt()
            item_judul.text = partjdl
            item_desc.text = partdesc
            item_img.setImageResource(partimg)
        }
    }
}