package com.jd.cryptotraderassist

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        postToList()

        rv_recyclerView.LayoutManager = LinearLayoutManager(context:this)
        rv_recyclerView.adapter = RecyclerAdapter(titleList, descList, imageList)
    }
    private fun addToList(title:String, description: String, image: Int) {
        titleList.add(title)
        descList.add(description)
        imageList.add(image)
    }
    private fun postToList() {
        for (i:int in 1..25)
            addToList(title: "Title $i", description: "Description $i", R.mipmap.ic_launcher_round )
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
