package com.febatis.googlekeepdosguri.domain.listnote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.febatis.googlekeepdosguri.databinding.ActivityListNoteBinding
import com.febatis.googlekeepdosguri.domain.listnote.adapter.NoteAdapter
import com.febatis.googlekeepdosguri.domain.listnote.model.NoteModel
import com.febatis.googlekeepdosguri.domain.listnote.viewmodel.ListNoteViewModel

class ListNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListNoteBinding.inflate(layoutInflater) }

    private val viewModel: ListNoteViewModel by viewModels {ListNoteViewModel.Factory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        setupObservers()
        viewModel.getAllNote()
    }

    private fun setupObservers() {
        viewModel.noteList.observe(this) {
            setupRecyclerView(it.payload)
        }
        viewModel.error.observe(this) {
            Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupRecyclerView(list: List<NoteModel>) {
        val noteAdapter = NoteAdapter(list)

        binding.rvNoteList.apply {
            layoutManager = LinearLayoutManager(this@ListNoteActivity)
            adapter = noteAdapter
        }
    }
}