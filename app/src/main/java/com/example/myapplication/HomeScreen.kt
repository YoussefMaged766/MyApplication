package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.Note
import com.example.myapplication.ui.Screen
import com.example.myapplication.ui.theme.Teal200


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController, TitleIs: String?, BodyIs: String?) {
    val notes = remember {
        Util.note
    }
    //var Title by remember { mutableStateOf(TitleIs)}
    var TitleList = mutableListOf<Note>()
    TitleList.add(Note(TitleIs!!,BodyIs!!))
    Log.e("Home: ",TitleIs.toString() )
    Log.e("Home2: ",BodyIs.toString() )

    // Title = " "

   // var Body by remember { mutableStateOf(BodyIs)}
//    var BodyList = mutableListOf<String>()
//    BodyList.add(BodyIs!!)
   // Body = " "



    Scaffold(  floatingActionButton = {
        FloatingActionButton(onClick = {navController.navigate(Screen.Window.route)},
            shape = RoundedCornerShape( 50),
            backgroundColor = Teal200) {Icon(Icons.Filled.Add,tint=Color.White,contentDescription="Add")} },

        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {  BottomAppBar(cutoutShape = RoundedCornerShape(50), content = {})},
        content = {Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {

            Column {
                Text(
                    text = "ToDo App!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(12.dp),
                )

                Box {
                    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                        items(notes.value) { item ->
                            ToDo(item, onDelete = {
                                val n = notes.value.toMutableList()
                                n.remove(it)
                                notes.value= n.toList()
                            },Modifier)
                        }

                    }
                }
            }
        }
        }

    )

}



@Composable
fun FunContint (){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {



        Column {
            Text(
                text = "ToDo App!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp),
            )

            Box {
                LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                    //items(TitleList) { item ->
                    //     ToDo(title = item, body = "$BodyIs")
                }
            }
        }
    }
}





@Composable
fun FunBottomBar () {
    BottomAppBar(cutoutShape = RoundedCornerShape(50), content = {})
}





/*
@Composable
fun FunFloatingActionButton () {


    FloatingActionButton(onClick = {navController.navigate("window")}, shape = RoundedCornerShape( 50),
        backgroundColor = Teal200
    ) {
        Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
    }


}


 */










//data class ToDoItem(val title: String, val body: String)


/*
items(items = TitlesList) { title ->
         //       ToDo(title = title,


                    body = BodysList[TitlesList.indexOf(title)])
            }

 */





/*

    var Title by remember { mutableStateOf(TitleIs.toString())}

    var TitlesList = mutableListOf<String>()

    // var Body by remember { mutableStateOf(BodyIs) }
    //  var BodysList = mutableListOf<String>()




    Column(modifier = Modifier
            .background(Color(0xFFA46DE7))
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "ToDo App",
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp))


            Box(modifier = Modifier
                .background(Color.White)
                .fillMaxSize()) {
                Divider()


                LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(13.dp))
                {

                    TitlesList.add(Title)
                   // Title = " "

                        items(items = TitlesList) { item -> ToDoListItem(name = item) }
                }


                FloatingActionButton(onClick = {navController.navigate("window")},
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(15.dp)) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Icon")
                }


                /*
                 Button(onClick = {navController.navigate("window")},
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF6200EE),
                        contentColor = Color.White),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(15.dp))

                {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Add")
                }
                 */

            }
        }

 */





























@Composable
fun ToDoListItem(name: String) {

    var isSelected by remember { mutableStateOf(false) }
    var color = MaterialTheme.colors.background

    if (isSelected){ color = MaterialTheme.colors.primary }



    Surface( color = color, modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()
        .height(50.dp)
        .clickable { isSelected = !isSelected },
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp)
    {
        Text(text = name, modifier = Modifier.padding(12.dp))
        Divider()
    }
}
