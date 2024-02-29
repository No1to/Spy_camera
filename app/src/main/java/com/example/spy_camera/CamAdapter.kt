package com.example.spy_camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spy_camera.databinding.ItemCamBinding

class CamAdapter () :
    RecyclerView.Adapter<CamAdapter.CamViewHolder>() {

    private val noteList = arrayListOf<NotesModel>(
        NotesModel(
            "Камера 1"
        ),
        NotesModel(
            "Камера 1"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamViewHolder {
        return CamViewHolder(
            ItemCamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CamViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }

    override fun getItemCount() = noteList.size

    inner class CamViewHolder(private val binding: ItemCamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: NotesModel) {
            binding.apply {
                tvTitle.text = note.title
            }
        }
    }

}