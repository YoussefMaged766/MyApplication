package com.example.myapplication

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.Note
import com.example.myapplication.ui.Screen


@Composable
fun Window (navController: NavController) {
    val context = LocalContext.current


    var TitleValue by remember{ mutableStateOf("")}
    var BodyValue  by remember { mutableStateOf("")}

    var TitleTemp = " "
    var BodyTemp = " "




    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp),

        shape = RoundedCornerShape(16.dp),
        color = Color.LightGray) {

        Box(contentAlignment = Alignment.Center){

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(12.dp)
            )
            {

                Text(text = "Enter Note Title")
                OutlinedTextField( modifier = Modifier.fillMaxWidth()
                    ,value = TitleValue,
                    onValueChange = { TitleValue = it},
                    maxLines = 1,
                    singleLine = true)

                Spacer(modifier = Modifier.size(7.dp))


                Text(text = "Enter Note Body")
                //    modifier = Modifier.padding(top = 12.dp))
                OutlinedTextField(
                    value = BodyValue,
                    onValueChange = { BodyValue = it},
                    maxLines = 20,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(bottom = 12.dp),
                )
            }



            Button(onClick = {
                if (TitleValue.isNotBlank() && BodyValue.isNotBlank()) {

//                     TitleTemp = TitleValue
//                     BodyTemp =  BodyValue
//                     TitleValue = null.toString()
//                     BodyValue = null.toString()
//                    navController.navigate(Screen.Home.withArgs(TitleValue,BodyValue))
                    navController.navigate(Screen.Home.route)
                    val list = Util.note.value.toMutableList()
                    list.add(Note(TitleValue,BodyValue))
                    Util.note.value = list
                    Log.e( "Window: ",TitleValue )

                }

                else {

                    Toast.makeText(
                        context,
                        "Please add a note title and a not body",
                        Toast.LENGTH_SHORT,
                    ).show()
                }

            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(25.dp))

            {
                Text(text = "Save")
            }


            Button(onClick = {navController.navigate("home")},
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(25.dp))

            {
                Text(text = "Back")
            }

        }
    }
}