package com.febatis.googlekeepdosguri.domain.listnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.febatis.googlekeepdosguri.databinding.ActivityListNoteBinding

class ListNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListNoteBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val dataset = arrayOf("January", "February", "March")
        val noteAdapter = NoteAdapter(dataset)

        binding.rvNoteList.apply {
            layoutManager = LinearLayoutManager(this@ListNoteActivity)
            adapter = noteAdapter
        }
    }
}