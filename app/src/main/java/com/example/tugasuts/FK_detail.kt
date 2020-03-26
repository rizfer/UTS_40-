package com.example.tugasuts

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_detail_fakultas.*
//import kotlinx.android.synthetic.main.fak_listitem.*
import java.lang.Exception

class FK_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fakultas)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partjdl = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partdesc = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_ANSWER)
            var partemail = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
            var partlink= intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER_NAME)
            var partimg = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_CHOOSER).toInt()
            item_judul.text = partjdl
            item_desc.text = partdesc
            link.text = partlink
            item_img.setImageResource(partimg)

            if(partemail == ""){
                email.text= ""
                email.height = 0
            }
            else{
                email.text = partemail
                email.setOnClickListener{
                    sendEmail(partemail)
                }
            }

            if(partlink == ""){
                link.text= ""
                link.height = 0
            }
            else{
                link.text = partlink
                link.setOnClickListener {
                    sendUrl(partlink)
                }
            }
        }
    }

    private fun sendEmail(pengirim:String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(pengirim))

        try{
            startActivity(Intent.createChooser(mIntent, "Choose Email Client"))
        }
        catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun sendUrl(url: String) {
        val showWebActivity = Intent(this, FK_web::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        startActivity(showWebActivity)
    }
}