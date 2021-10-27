package br.com.cotemig.juliano.recyclerview_horizontal.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.juliano.recyclerview_horizontal.R
import br.com.cotemig.juliano.recyclerview_horizontal.models.Banner
import coil.load

class BannerAdapter(var context: Context, var list: List<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false)
        return BannerHolder(view)
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class BannerHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(banner: Banner) {
            var usuario = view.findViewById<TextView>(R.id.usuario)
            usuario.text = banner.usuario


            var avatar = view.findViewById<ImageView>(R.id.avatar)
            avatar.load(banner.avatar)
        }

    }

}