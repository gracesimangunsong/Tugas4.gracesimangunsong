package com.example.tugas4gracesimangunsong

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var wisataRecyclerView: RecyclerView
    private lateinit var wisataAdapter: ImageAdapter
    private var wisataList = ArrayList<WisataData>()

    private lateinit var pahlawanRecyclerView: RecyclerView
    private lateinit var pahlawanAdapter: MyAdapter
    private var listPahlawan = ArrayList<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupPahlawanList()
        setupWisataList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupPahlawanList() {
        pahlawanRecyclerView = findViewById(R.id.pahlawanRv)
        pahlawanRecyclerView.layoutManager = LinearLayoutManager(this)
        pahlawanRecyclerView.setHasFixedSize(true)

        listPahlawan.add(ItemData(R.drawable.marthenindey, "Marthen Indey", "Papua"))
        listPahlawan.add(ItemData(R.drawable.ratuzaleha, "Ratu Zaleha", "Kalimantan Selatan"))
        listPahlawan.add(ItemData(R.drawable.sutansjahrir, "Sutan Sjahrir", "Sumatra Barat"))
        listPahlawan.add(ItemData(R.drawable.arnoldmononutu, "Arnold Mononutu", "Sulawesi Utara"))
        listPahlawan.add(ItemData(R.drawable.kapitanpattimura, "Kapitan Pattimura", "Maluku"))
        listPahlawan.add(ItemData(R.drawable.teukuumar, "Teuku Umar", "Aceh"))
        listPahlawan.add(ItemData(R.drawable.ismailmarzuki, "Ismail Marzuki", "Jakarta"))
        listPahlawan.add(ItemData(R.drawable.moestopo, "Moestopo", "Jawa Timur"))
        listPahlawan.add(ItemData(R.drawable.sultanhasanuddin, "Sultan Hasanuddin", "Sulawesi Selatan"))
        listPahlawan.add(ItemData(R.drawable.abdulkadir, "Abdul Kadir", "Kalimantan Tengah"))

        pahlawanAdapter = MyAdapter(listPahlawan)
        pahlawanRecyclerView.adapter = pahlawanAdapter
    }

    private fun setupWisataList() {
        wisataRecyclerView = findViewById(R.id.imageRecyleView)
        wisataRecyclerView.layoutManager = LinearLayoutManager(this)
        wisataRecyclerView.setHasFixedSize(true)

        wisataList.add(
            WisataData(
                R.drawable.danaulovee, "Danau Love",
                "Danau Love Sentani, atau dikenal juga sebagai Danau Imfote, adalah sebuah destinasi wisata alam yang menawan di Distrik Sentani Timur, Kabupaten Jayapura, Papua. Danau ini terkenal karena bentuknya yang menyerupai simbol hati jika dilihat dari ketinggian. Bentuk unik ini membuatnya sangat populer di kalangan wisatawan lokal maupun mancanegara. Di sekitar danau terdapat perbukitan hijau yang menambah keindahan pemandangan. Tempat ini sering dijadikan lokasi untuk foto prewedding dan aktivitas fotografi lainnya."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.baseg, "Base-G",
                "Pantai Base-G membentang hampir 3 km dengan pasir putih lembut dan air laut berwarna biru jernih. Pantai ini merupakan salah satu tempat favorit untuk bersantai, berenang, dan menikmati matahari terbenam. Letaknya yang tidak jauh dari pusat Kota Jayapura membuatnya mudah diakses. Selain itu, pengunjung juga bisa menikmati berbagai makanan khas Papua yang dijajakan oleh pedagang lokal di sekitar pantai."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.bukitjokowi, "Bukit Jokowi",
                "Dari puncak bukit, pengunjung disuguhi panorama Teluk Youtefa yang memukau serta hamparan laut biru yang luas. Bukit ini dinamakan ‘Bukit Jokowi’ sebagai bentuk penghargaan atas kunjungan Presiden Joko Widodo ke tempat tersebut. Jalan menuju bukit cukup menantang, namun keindahan alam yang disajikan di puncaknya sangat sepadan dengan usaha yang dikeluarkan."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.bukitjayapuracity, "Bukit Jayapura City",
                "Dari puncak Bukit Jayapura City, pengunjung dapat menikmati panorama 360 derajat kota dan laut yang indah. Bukit ini menjadi tempat favorit untuk melihat matahari terbenam dan suasana kota Jayapura di malam hari. Tersedia juga spot-spot foto yang menarik dan tempat duduk untuk bersantai menikmati pemandangan. Tempat ini sangat cocok dikunjungi bersama keluarga atau teman-teman."
            )
        )

        wisataAdapter = ImageAdapter(wisataList) { item: WisataData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("wisata", item as Serializable)
            startActivity(intent)
        }

        wisataRecyclerView.adapter = wisataAdapter
    }
}


