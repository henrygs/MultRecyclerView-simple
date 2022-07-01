package com.henry.multrecycler.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.henry.multrecycler.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf(
            1 to "Titulo A",
            0 to "Titulo B",
            0 to "Titulo C",
            1 to "Titulo D",
            0 to "Titulo 2",
            0 to "Titulo 3",
            0 to "Titulo 1",
        )

        val adapter = MyAdapter(items)
        findViewById<RecyclerView>(R.id.rv).adapter = adapter
    }

    class MyAdapter(private val items: List<Pair<Int, String>>) :
        RecyclerView.Adapter<MyAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return if (viewType == 0) {
                return MyContentHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_a, parent, false))
            } else MyHeadertHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_b, parent, false))

        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            return holder.bind(items[position])
        }

        override fun getItemCount(): Int = items.size

        override fun getItemViewType(position: Int): Int {
            return items[position].first
        }

        abstract class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            abstract fun bind(obj: Pair<Int, String>)
        }
    }

    class MyContentHolder(view: View) : MyAdapter.Holder(view) {
        private val text: TextView = view.findViewById(R.id.txt)
        override fun bind(obj: Pair<Int, String>) {
            text.text = obj.second
        }

    }

    class MyHeadertHolder(view: View) : MyAdapter.Holder(view) {
        override fun bind(obj: Pair<Int, String>) {
        }

    }

}

