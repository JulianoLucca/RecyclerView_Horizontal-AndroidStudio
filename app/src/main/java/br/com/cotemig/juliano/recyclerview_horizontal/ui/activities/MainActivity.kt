package br.com.cotemig.juliano.recyclerview_horizontal.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.juliano.recyclerview_horizontal.R
import br.com.cotemig.juliano.recyclerview_horizontal.models.Banner
import br.com.cotemig.juliano.recyclerview_horizontal.services.RetrofitInitializer
import br.com.cotemig.juliano.recyclerview_horizontal.ui.adapters.BannerAdapter
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBanners()
    }
    fun getBanners() {
        val s = RetrofitInitializer().serviceBanner()
        val call = s.getBanners()

        call.enqueue(object : retrofit2.Callback<List<Banner>> {

            override fun onResponse(call: Call<List<Banner>>, response: Response<List<Banner>>) {
                if (response.code() == 200) {
//                    Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_LONG).show()

                    response.body()?.let { list ->
                        showBanners(list)
                    }

                }

            }

            override fun onFailure(call: Call<List<Banner>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showBanners(list: List<Banner>) {

        var banners = findViewById<RecyclerView>(R.id.banners)
        banners.adapter = BannerAdapter(this, list)

        banners.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }


}