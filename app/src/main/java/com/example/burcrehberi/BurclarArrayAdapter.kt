package com.example.burcrehberi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

// kendi adapter sınıfımızı oluşturduk. ArrayAdapter

class BurclarArrayAdapter(var gelenContext: Context, resource: Int, textViewResourceId: Int,var burcAdlari: Array<String>, var burcTarihleri: Array<String>,var burcResimleri:Array<Int>)
             : ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tek_satir_view=convertView//optimize calısın diye kullanıyoruz.
        var viewHolder:ViewHolder?=null

        if (tek_satir_view==null){

            var inflater=LayoutInflater.from(gelenContext)
            tek_satir_view= inflater.inflate(R.layout.tek_satir,parent,false)

            viewHolder=ViewHolder(tek_satir_view)
            tek_satir_view.tag=viewHolder
        }else{
            viewHolder=ViewHolder(tek_satir_view)
            viewHolder=tek_satir_view.getTag() as ViewHolder
        }

        viewHolder.burcAdi.setText(burcAdlari[position])
        viewHolder.burcTarih.setText(burcTarihleri[position])
        viewHolder.burcResim.setImageResource(burcResimleri[position])

        return tek_satir_view!!
    }

    class ViewHolder(tek_satir_view: View){// atama işlemleri yapıyoruz

        var burcAdi:TextView
        var burcResim:ImageView
        var burcTarih:TextView

        init {
            this.burcAdi=tek_satir_view.tvBurcAdi
            this.burcTarih=tek_satir_view.tvBurcTarihi
            this.burcResim=tek_satir_view.imgBurcSembol
        }

    }


}