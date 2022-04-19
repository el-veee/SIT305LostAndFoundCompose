package com.lachlanvass.sit305lostandfoundcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lachlanvass.sit305lostandfoundcompose.ui.theme.SIT305LostAndFoundComposeTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = (1..50).toList()

        val db = AppDatabase.getDatabase(this)
        val posts = db.postDao().getAll()


        setContent {

            Column() {

                posts.forEach {
                        post -> Row() {

                    Card(
                        shape = MaterialTheme.shapes.medium,
                        backgroundColor = MaterialTheme.colors.surface,
                        contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.surface),
                        elevation = 10.dp,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = "${post.name} Posted on: ${post.date}" ?: "New Post" , modifier = Modifier.padding(10.dp))
                    }

                }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SIT305LostAndFoundComposeTheme {
        Greeting2("Android")
    }
}