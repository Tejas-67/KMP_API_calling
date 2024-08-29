package com.tejasdev.kmm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.tejasdev.kmm1.data.Result

class MainActivity : ComponentActivity() {

    val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val users = viewModel.users.collectAsStateWithLifecycle()
            Home(users.value)
        }
    }
}

@Composable
fun Home(data: List<Result>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 24.dp, start = 4.dp, end = 4.dp)
    ){
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(data, key = {user -> user.login.uuid}) {
                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = 12.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = rememberAsyncImagePainter(model = it.picture.thumbnail),
                            contentDescription = null,
                            modifier = Modifier.padding(16.dp)
                                .size(50.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "${it.name.first} ${it.name.last}")
                            Text(text = it.phone)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}