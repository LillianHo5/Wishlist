package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.ListItem.Companion.getItems
import wishlistAdapter

class MainActivity : AppCompatActivity() {
    lateinit var items: List<ListItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.itemName)
        val price = findViewById<EditText>(R.id.price)
        val url = findViewById<EditText>(R.id.itemLink)

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
        items = getItems()
        // Create adapter by passing in the list of emails
        val wishlistAdapter = wishlistAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        wishlistRv.adapter = wishlistAdapter
        // Set layout manager to position the items
        wishlistRv.layoutManager = LinearLayoutManager(this)

        //Add item every time submit button is clicked
        findViewById<Button>(R.id.submitButton).setOnClickListener {
            Log.i("test", "lawl")
            (items as MutableList<ListItem>).add(ListItem(name.text.toString(), price.text.toString(), url.text.toString()))
            wishlistAdapter.notifyDataSetChanged()
        }
    }
}

class ListItem(val name: String, val price: String, val url: String) {
    companion object {
        fun getItems(): MutableList<ListItem> {
            return ArrayList()
        }
    }
}