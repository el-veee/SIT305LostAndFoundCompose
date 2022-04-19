package com.lachlanvass.sit305lostandfoundcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lachlanvass.sit305lostandfoundcompose.ui.theme.SIT305LostAndFoundComposeTheme
import kotlin.random.Random

class CreateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val db = AppDatabase.getDatabase(this)

        setContent {

            val context = LocalContext.current

            var name by remember {mutableStateOf("")}
            var phone by remember {mutableStateOf("")}
            var description by remember {mutableStateOf("")}
            var date by remember {mutableStateOf("")}
            var location by remember {mutableStateOf("")}

            Column {
                OutlinedTextField(
                    value = name ,
                    onValueChange = {name = it},
                    singleLine = true,
                )

                OutlinedTextField(
                    value = phone ,
                    onValueChange = {phone = it},
                    singleLine = true,
                )

                OutlinedTextField(
                    value = description ,
                    onValueChange = {description = it},
                    singleLine = true,
                )

                OutlinedTextField(
                    value = date ,
                    onValueChange = {date = it},
                    singleLine = true,
                )

                OutlinedTextField(
                    value = location ,
                    onValueChange = {location = it},
                    singleLine = true,
                )

                Button(onClick = {

                    val post = Post(
                        Random.nextInt(),
                        name,
                        phone,
                        description,
                        date,
                        location
                    )

                    db.postDao().insert(post)

                    Toast.makeText(context, "Post Saved", Toast.LENGTH_SHORT).show()

                    val intent = Intent(context, ListActivity::class.java)
                    context.startActivity(intent)
                }) {
                    
                    Text(text = "Save Post")
                }

            }
        }

    }

}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun InputAndLabel(fieldName: String) {
    var name by remember {
        mutableStateOf<String>("")
    }

    Text(text = fieldName)
    return OutlinedTextField(value = name, onValueChange = { name = it}, singleLine = true )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {

    Column {
        InputAndLabel("Name")
        InputAndLabel("Phone")
        InputAndLabel("Description")
        InputAndLabel("Date")
        InputAndLabel("Location")
    }


}