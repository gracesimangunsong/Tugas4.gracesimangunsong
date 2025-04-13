package com.example.tugas4gracesimangunsong

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        pahlawanRecyclerView = findViewById(R.id.pahlawanRV)
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
                "Danau Love Sentani, atau dikenal juga sebagai Danau Imfote, adalah sebuah destinasi wisata alam yang menawan di Distrik Sentani Timur, Kabupaten Jayapura, Papua. Danau ini terkenal karena bentuknya yang menyerupai simbol hati jika dilihat dari ketinggian."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.baseg, "Base-G",
                "Pantai Base-G membentang hampir 3 km dengan pasir putih lembut dan air laut berwarna biru jernih. Dikelilingi oleh pepohonan rindang, pantai ini cocok untuk bersantai, berenang, atau berjemur."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.bukitjokowii, "Bukit Jokowi",
                "Dari puncak bukit, pengunjung disuguhi panorama Teluk Youtefa yang memukau. Cocok untuk fotografi dan relaksasi, terutama saat matahari terbit atau terbenam."
            )
        )
        wisataList.add(
            WisataData(
                R.drawable.bukitjayapuracity, "Bukit Jayapura City",
                "Dari puncak Bukit Jayapura City, pengunjung dapat menikmati panorama 360 derajat kota dan laut. Pemandangan siang dan malam hari sangat menakjubkan."
            )
        )

        wisataAdapter = ImageAdapter(wisataList)
        wisataRecyclerView.adapter = wisataAdapter

        wisataAdapter.onItemClick = { item ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("wisata", item)
            }
            startActivity(intent)
        }
    }
}

