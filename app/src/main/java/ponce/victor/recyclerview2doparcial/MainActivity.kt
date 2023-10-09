package ponce.victor.recyclerview2doparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Para poder usar view binding, hay que agregar lo siguiente en Gradle Scripts/build.gradle (Module: app):, dentro de andorid {} escribir buildFeatures { viewBinding = true }

// En dependencias, agregar: implementation("androidx.recyclerview:recyclerview:1.3.1")


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//definimos tareas predefinidas, para que se llene el recycler view

        var taskList = mutableListOf(Tarea("Hacer la Tarea", false),
            Tarea("Aprender Recycler View", false),
            Tarea("Aprender View Binding", false))

        // esto es lo que tengo definido en su xml

        val rvTask : RecyclerView = findViewById(R.id.rvTask)
        val buttonAdd : Button = findViewById(R.id.buttonAgregar)
        val etTask : EditText = findViewById(R.id.etTask)

        // creamos el adapter
        val adapter = TaskAdapter(taskList)
        rvTask.adapter = adapter
        rvTask.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            val title = etTask.text.toString()
            val task = Tarea(title, false)
            taskList.add(task)

            // le decimos al adapter que se actualice
            adapter.notifyItemInserted(taskList.size - 1)
        }
    }
}