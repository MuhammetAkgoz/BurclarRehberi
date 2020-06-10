package com.example.burcrehberi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.*
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var tumBurclarBilgileri:ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor=resources.getColor(R.color.statusColor)

        veriKaynagiHazırla()

        /*var adapter1=BurclarArrayAdapter(this,R.layout.tek_satir,R.id.tvBurcAdi,burclar,burclarTarih,burcResimleri)// kendi yazdiğimiz sınıf
        ListBurclar.adapter=adapter1*/

            var myAdapter= BurclarBaseAdapter(this,tumBurclarBilgileri)
            ListBurclar.adapter=myAdapter

            ListBurclar.setOnItemClickListener { parent, view, position, id ->//tek_satir layout ıteme tıklanınca yonlendırmesi için

                var intent= Intent(this,DetayActivity::class.java)// neredesiniz ve nereye gitmek istiyoryz onu belirtik
                intent.putExtra("Etiket",position)
                intent.putExtra("Bilgiler",tumBurclarBilgileri)
                startActivity(intent)

            }


    }

    private fun veriKaynagiHazırla() {
        tumBurclarBilgileri= ArrayList<Burc>(12)
        var burclar=resources.getStringArray(R.array.Burclar) //varlues/array dosyasındaki burcları degişkene atamayi sağlar.
        var burclarTarih=resources.getStringArray(R.array.burcTarih)
        var burcResimleri= arrayOf(//resimleri atamayi sağlar
            R.drawable.koc,
            R.drawable.boga,
            R.drawable.ikizler,
            R.drawable.yengec,
            R.drawable.aslan,
            R.drawable.basak,
            R.drawable.terazi,
            R.drawable.akrep,
            R.drawable.yay,
            R.drawable.oglak,
            R.drawable.kova,
            R.drawable.balik)
        var burcBuyukResimler= arrayOf( R.drawable.koc_header,
                                        R.drawable.boga_header,
                                        R.drawable.ikizler_header,
                                        R.drawable.yengec_header,
                                        R.drawable.aslan_header,
                                        R.drawable.basak_header,
                                        R.drawable.terazi_header,
                                        R.drawable.akrep_header,
                                        R.drawable.yay_header,
                                        R.drawable.oglak_header,
                                        R.drawable.kova_header,
                                        R.drawable.balik_header)

        var burcGenelOzellikler=resources.getStringArray(R.array.burcGenelOzellikler)

        for(i in 0..11){

            var arrayListAtanacakBurc=Burc(burclar[i],burclarTarih[i],burcResimleri[i],burcBuyukResimler[i],burcGenelOzellikler[i])
            tumBurclarBilgileri.add(arrayListAtanacakBurc)

        }

    }
}
