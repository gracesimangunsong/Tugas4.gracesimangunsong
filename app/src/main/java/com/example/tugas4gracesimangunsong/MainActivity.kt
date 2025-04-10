package com.example.tugas4gracesimangunsong

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var pahlawanRecyclerView: RecyclerView
    private lateinit var pahlawanAdapter: MyAdapter
    private var listPahlawan = ArrayList<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
