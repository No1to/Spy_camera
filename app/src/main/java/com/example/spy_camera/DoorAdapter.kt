package com.example.spy_camera

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.spy_camera.databinding.ItemDoorBinding

class DoorAdapter() :
    RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {

    private val noteList = arrayListOf<NotesModel>(
        NotesModel(
            "Подъезд 1"
        ),
        NotesModel(
            "Выход на пожарную лестницу"
        ),
        NotesModel(
            "Подъезд 2"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }

    override fun getItemCount() = noteList.size

    inner class DoorViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: NotesModel) {
            binding.apply {
                tvTitle.text = note.title
                itemNote.setOnClickListener {
                    val visible = ivVideo.isVisible && ivPlay.isVisible
                    AlphaAnimation(if (visible) 1f else 0f, if (visible) 0f else 1f).apply {
                        duration = 600
                        ivVideo.startAnimation(this)
                        ivPlay.startAnimation(this)
                    }
                    ivVideo.isVisible = !visible
                    ivPlay.isVisible = !visible
                }
            }
        }
    }

}