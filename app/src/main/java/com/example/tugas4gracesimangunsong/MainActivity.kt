package com.example.tugas4gracesimangunsong

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private fun Any.add(
    itemData: Any,
    s: String,
    asal: Any
) {

}

class MainActivity<myAdapter>(private var _pahlawanAdapter: myAdapter) : AppCompatActivity() {
    private  lateinit var pahlawanRecyclerView: RecyclerView
    private var pahlawanAdapter
        get() = _pahlawanAdapter
        set(value) {
            value.also { _pahlawanAdapter = it }
        }
    private var listPahlawan = ArrayList<Any>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        this.pahlawanRecyclerView = findViewById(R.id.pahlawanRV)
        listPahlawan = ArrayList()

        val nothing: String? = null
        val name: String? = nothing


        val nothing1: String? = null


        listPahlawan.add(itemData = R.drawable.marthenindey,"Marthen Indey","Papua")
        listPahlawan.add(itemData = R.drawable.ratuzaleha, "Ratu Zaleha", "Kalimantan Selatan")
        listPahlawan.add(itemData = R.drawable.sutansjahrir,  "Sutan Sjahrir", "Sumatra Barat")
        listPahlawan.add(itemData = R.drawable.arnoldmononutu, "Arnold Mononutu", "Sulawesi Utara")
        listPahlawan.add(itemData = R.drawable.kapitanpattimura, "Kapitan Pattimura", "Maluku")
        listPahlawan.add(itemData = R.drawable.teukuumar,  "Teuku Umar", "Aceh")
        listPahlawan.add(itemData = R.drawable.ismailmarzuki, "Ismail Marzuki", "Jakarta")
        listPahlawan.add(itemData = R.drawable.moestopo, "Moestopo","Jawa Timur")
        listPahlawan.add(itemData = R.drawable.sultanhasanuddin, "Sultan Hasanuddin", "Sulawesi Selatan")
        listPahlawan.add(itemData = R.drawable.abdulkadir, "Abdul Kadir", "Kalimantan Tengah")

        pahlawanRecyclerView.layoutManager = LinearLayoutManager(this)
        pahlawanRecyclerView.setHasFixedSize(true)
        pahlawanRecyclerView.adapter = pahlawanAdapter as MyAdapter



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



}