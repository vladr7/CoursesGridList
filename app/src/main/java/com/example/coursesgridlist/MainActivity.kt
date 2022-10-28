package com.example.coursesgridlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesgridlist.data.DataSource
import com.example.coursesgridlist.models.Topic
import com.example.coursesgridlist.ui.theme.CoursesGridListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesGridListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoursesList(coursesList = DataSource.topics)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoursesGridListTheme {
        CoursesList(coursesList = DataSource.topics)
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(id = topic.image), contentDescription = null,
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(id = topic.name))

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.grain), contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = topic.nrOfCourses.toString())
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoursesList(
    coursesList: List<Topic>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(coursesList) { topic ->
            TopicCard(topic = topic)
        }
    }
}