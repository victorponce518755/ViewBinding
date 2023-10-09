package ponce.victor.recyclerview2doparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ponce.victor.recyclerview2doparcial.databinding.ActivityMainBinding

//Para poder usar view binding, hay que agregar lo siguiente en Gradle Scripts/build.gradle (Module: app):, dentro de andorid {} escribir buildFeatures { viewBinding = true }

// En dependencias, agregar: implementation("androidx.recyclerview:recyclerview:1.3.1")


class MainActivity : AppCompatActivity() {
    //declaro la variable binding esto ya es de lo NUEVO DEL BINDING
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicializo la varibale, esto ya es de lo NUEVO DEL BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        //comentamos la siguiente linea, porque ya no usamos el layout normal
        //setContentView(R.layout.activity_main)
        //ahora usamos el binding.root
        setContentView(binding.root)

//definimos tareas predefinidas, para que se llene el recycler view

        var taskList = mutableListOf(Tarea("Hacer la Tarea", false),
            Tarea("Aprender Recycler View", false),
            Tarea("Aprender View Binding", false))
// ya no necesitamos las variables de abajo, porque ya no usamos el layout normal, esto ya es de lo NUEVO DEL BINDING-----------------------------------
       /*
        // esto es lo que tengo definido en su xml

        val rvTask : RecyclerView = findViewById(R.id.rvTask)
        val buttonAdd : Button = findViewById(R.id.buttonAgregar)
        val etTask : EditText = findViewById(R.id.etTask)
        */

// hasta aqui ya no ocupamos-----------------------------------------------------------------
        // creamos el adapter
        val adapter = TaskAdapter(taskList)

        //ahora usamos el binding
        binding.rvTask.adapter = adapter
        binding.rvTask.layoutManager = LinearLayoutManager(this)
        //rvTask.adapter = adapter
        //rvTask.layoutManager = LinearLayoutManager(this)

        //ahora usamos el binding en el boton

        binding.buttonAgregar.setOnClickListener {
            val title = binding.etTask.text.toString()
            val task = Tarea(title, false)
            taskList.add(task)

            // le decimos al adapter que se actualice
            adapter.notifyItemInserted(taskList.size - 1)
        }

        /*
        buttonAdd.setOnClickListener {
            val title = etTask.text.toString()
            val task = Tarea(title, false)
            taskList.add(task)

            // le decimos al adapter que se actualice
            adapter.notifyItemInserted(taskList.size - 1)
        }*/
    }
}