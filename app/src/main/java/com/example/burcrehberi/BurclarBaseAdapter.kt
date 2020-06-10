package com.example.burcrehberi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(context: Context, tumBurcBigileri:ArrayList<Burc>): BaseAdapter() {

    var tumBurclar:ArrayList<Burc>
    var context: Context

    init {
       this.tumBurclar= tumBurcBigileri
        this.context= context

        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var tek_satir_view=convertView
        var viewHolder2:ViewHolder2
        if (tek_satir_view==null){

            var inflater=LayoutInflater.from(context)
            tek_satir_view=inflater.inflate(R.layout.tek_satir,parent,false)//xml al java koduna cevir ve kullan

            viewHolder2=ViewHolder2(tek_satir_view)
            tek_satir_view.tag=viewHolder2
        }else{

            viewHolder2=tek_satir_view.getTag() as ViewHolder2
        }

        //alt kısımda imageview ve textview içine atama yaptık.Atamayı daha once bilgilerini tutugumuz tumBurclar kısmından aldık.
        viewHolder2.imgResim.setImageResource(tumBurclar.get(position).burcResimleri)
        viewHolder2.burcAd.setText(tumBurclar.get(position).burcAdlari)
        viewHolder2.burcTarih.setText(tumBurclar.get(position).burcTarihleri)

        return tek_satir_view!!

    }

    override fun getItem(position: Int): Any {
        return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
     return tumBurclar.size
    }
}

class ViewHolder2 (tek_satir_view: View){

    var imgResim:ImageView
    var burcAd:TextView
    var burcTarih:TextView

    init {

     this.imgResim=tek_satir_view.imgBurcSembol
      this.burcAd=tek_satir_view.tvBurcAdi
        this.burcTarih=tek_satir_view.tvBurcTarihi
    }
}