package com.example.burcrehberi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position= intent.extras?.get("Etiket") as Int//gelen posiyon değerlerini alır
        var burcBilgileri= intent.extras?.get("Bilgiler") as ArrayList<Burc>

        tvBurcOzellikleri.setText(burcBilgileri.get(position).burcGenelOzellikleri)//ilgili textview ilgili yazıları sırası ile  verir
        header.setImageResource(burcBilgileri.get(position).burcBuyukResim)//imageview ilgili resimleri sırası ile verir

        setSupportActionBar(anim_toolbar)
        collapsing_toolbar.title = burcBilgileri.get(position).burcAdlari//toolbara ilgili burcun ısmını yazdirir
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//toolbardaki geri tusunu verir
        var bitmap=BitmapFactory.decodeResource(resources,burcBilgileri.get(position).burcBuyukResim)
        Palette.from(bitmap).generate( object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                var color=palette?.getVibrantColor(R.attr.colorAccent)//resimdeki ağırlıklı rengi alıyor
                collapsing_toolbar.setContentScrimColor(color!!)//toolbara koyuyuyor
                window.statusBarColor=color// benecere rengine resim ağırlıgını eklıyoruz
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean { // bir öncegi activity geri dönmesi için geri tuşuna geri dönme özelliği verir
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}


