package com.example.tugasuts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFKData()
        RV.layoutManager = LinearLayoutManager (this)
        RV.setHasFixedSize(true)
        RV.adapter = ResepAdapter(testData, {FKItem : fk_data -> FKItemClicked(FKItem) })
    }
    private fun FKItemClicked(FKItem : fk_data){
        val showDetailActivityIntent = Intent(this, FK_detail::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, FKItem.jdl)
        showDetailActivityIntent.putExtra(Intent.ACTION_ANSWER, FKItem.desc)
        showDetailActivityIntent.putExtra(Intent.ACTION_CHOOSER, FKItem.img.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL,FKItem.email)
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER_NAME,FKItem.link)
        startActivity(showDetailActivityIntent)
    }

    fun createFKData() : List<fk_data> {
        val partList = ArrayList<fk_data>()
        partList.add(
            fk_data("FAKULTAS ILMU KOMPUTER", "Fakultas Ilmu Komputer merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tTeknik Informatika\n" +
                    "2.\tSistem Informasi\n" +
                    "3.\tData Science\n"
                , R.drawable.fik,"","https://fik.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS TEKNIK", "Fakultas Teknik merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tTeknik Kimia\n" +
                    "2.\tTeknik Industri\n" +
                    "3.\tTeknik Sipil\n" +
                    "4.\tTeknik Lingkungan\n" +
                    "5.\tTeknologi Pangan\n"
                , R.drawable.ft,"","http://ft.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS EKONOMI DAN BISNIS", "Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tEkonomi Pembangunan\n" +
                    "2.\tAkutansi\n" +
                    "3.\tManajemen\n"
                , R.drawable.feb,"feb@upnjatim.ac.id","http://febis.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS PERTANIAN", "Fakultas Pertanian merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tAgroteknologi\n" +
                    "2.\tAgribisnis\n"
                , R.drawable.fp,"","http://faperta.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS ILMU SOSIAL DAN POLITIK", "Fakultas Ilmu Sosial dan Politik merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tAdministrasi Negara\n" +
                    "2.\tAdministrasi Bisnis\n" +
                    "3.\tIlmu Komunikasi\n" +
                    "4.\tHubungan Internasional\n"
                , R.drawable.fisip,"fisip@upnjatim.ac.id","http://fisip.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS ARSITEKTUR DAN DESAIN", "Fakultas Arsitektur dan Desain merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tArsitektur\n" +
                    "2.\tDesain Komunikasi Visual\n"
                , R.drawable.fa,"fad@upnjatim.ac.id.","http://fad.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("FAKULTAS HUKUM", "Fakultas Hukum merupakan salah satu dari 7 fakultas di UPN “Veteran” Jawa Timur. Yang terdiri dari program studi :\n\n" +
                    "1.\tIlmu Hukum\n"
                , R.drawable.fh,"","http://fhukum.upnjatim.ac.id/")
        )
        partList.add(
            fk_data("RIZKY FERDIANSYAH", "NAMA\t\t\t\t\t\t\t: RIZKY FERDIANSYAH\n\n" +
                    "TTL\t\t\t\t\t\t\t\t\t: SURABAYA, 8 APRIL 1998\n\n" +
                    "ALAMAT\t\t\t\t\t\t: DUPAK JAYA GG 5 NO 16\n\n" +
                    "NO.HP\t\t\t\t\t\t\t: 082141336644\n\n" +
                    "RIWAYAT PENDIDIKAN\t:\n\n"+
                    "\t\t\t   1. SD AL-KAUTSAR\n" +
                    "\t\t\t   2. SMPN 14 SURABAYA\n" +
                    "\t\t\t   3. SMAN 11 SURABAYA\n\n" +
                    "PENGHARGAAN\t\t\t\t:  - \n", R.drawable.foto,"rizkyferdiansyah98@gmail.com","https://github.com/rizfer")
        )
        return partList
    }
}