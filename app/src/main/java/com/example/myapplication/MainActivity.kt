package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.Note


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nav()
            test()

        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun test() {


}

@Composable
inline fun ToDo(note: Note, crossinline onDelete: (Note) -> Unit, modifier: Modifier = Modifier) {

    val expanded = remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),

        ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {

            Row {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Text(
                        text = note.title, style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }

                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }

            if (expanded.value) {

                Column(
                    modifier = Modifier.padding(
                        bottom = extraPadding.coerceAtLeast(0.dp)
                    ).fillMaxWidth()
                ) {
                    Text(
                        text = note.body, style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(
                            onClick = {
                                val list = Util.note.value.toMutableList()
                                list.remove(note)
                                Util.note.value = list
                                onDelete(note)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete note",
                                tint = MaterialTheme.colors.onSurface
                            )
                        }
                    }


                }

            }


        }


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}

/*

        FloatingActionButton(
            onClick = { navController.navigate("window") },
            modifier = Modifier
                // .align(Alignment.BottomCenter)
                .padding(15.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Icon")
        }
 */