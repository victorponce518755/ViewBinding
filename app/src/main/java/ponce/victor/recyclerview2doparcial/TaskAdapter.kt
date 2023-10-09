package ponce.victor.recyclerview2doparcial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ponce.victor.recyclerview2doparcial.databinding.ItemTaskBinding

// ctrl+ i para implementar los metodos
class TaskAdapter (var tareas:List<Tarea>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    /*Definimos una clase interna*/

    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    /*Despues hay que hacer un data class , entonces agregamos igual otro kotlin class, donde mismo
     llamado tarea*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(layoutInflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.apply{
            taskTitle.text = tareas[position].titulo
            checkboxDone.isChecked = tareas[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return tareas.size
    }
}


// Nos vamos al codigo del main