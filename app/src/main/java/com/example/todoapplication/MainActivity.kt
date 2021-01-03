package com.example.todoapplication

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.ListView as ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton = findViewById<Button>(R.id.add_button)
        val deleteButton = findViewById<Button>(R.id.add_button)


        val toDoList = findViewById<ListView>(R.id.to_do_list_view)
        val addItemEdit = findViewById<EditText>(R.id.add_item_edit)
        val errorMessageText = findViewById<TextView>(R.id.error_message_text)

        val listItems = arrayListOf<String>()
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this, android.R.layout.select_dialog_multichoice, listItems)
        toDoList.adapter = arrayAdapter

        addButton.setOnClickListener {
            val itemText: String = addItemEdit.text.toString()
            if (!itemText.equals("") && itemText.length >= 3) {
                listItems.add(itemText)
                arrayAdapter.notifyDataSetChanged()
                addItemEdit.setText("")
                errorMessageText.visibility = View.GONE
                Toast.makeText(this, itemText + " added", Toast.LENGTH_LONG).show()
            }  else {
                errorMessageText.visibility = View.GONE
                errorMessageText.text = "Please, write something..."
                errorMessageText.visibility = View.VISIBLE
                Toast.makeText(this, "Please, fill the gap", Toast.LENGTH_LONG).show()
            }
                  val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                  imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }

//        addButton.setOnClickListener { addItemButton(it) }
//        deleteButton.setOnClickListener { deleteItemButton(it) }
    }

//    private fun addItemButton(view: View) {
//
//        val toDoList = findViewById<ListView>(R.id.to_do_list_view)
//        val addItemEdit = findViewById<EditText>(R.id.add_item_edit)
//        val errorMessageText = findViewById<TextView>(R.id.error_message_text)
//
//        val listItems = arrayListOf<String>()
//        val arrayAdapter: ArrayAdapter<*>
//        arrayAdapter = ArrayAdapter(this, android.R.layout.select_dialog_multichoice, listItems)
//        toDoList.adapter = arrayAdapter
//
//        val itemText: String = addItemEdit.text.toString()
//        if (!itemText.equals("") && itemText.length >= 3) {
//            listItems.add(itemText)
//            arrayAdapter.notifyDataSetChanged()
//            addItemEdit.setText("")
//            Toast.makeText(this, itemText + " added", Toast.LENGTH_LONG).show()
//        } else {
//            errorMessageText.visibility = View.GONE
//            errorMessageText.text = "Please, write something..."
//            errorMessageText.visibility = View.VISIBLE
//            Toast.makeText(this, "Please, fill the gap", Toast.LENGTH_LONG).show()
//        }
//
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken, 0)
//    }

//    private fun deleteItemButton(view: View) {
//        val toDoList = findViewById<ListView>(R.id.to_do_list_view)
//        toDoList.setOnItemClickListener((adapterView, view, position, id) -> {
//
//        })
//    }
}