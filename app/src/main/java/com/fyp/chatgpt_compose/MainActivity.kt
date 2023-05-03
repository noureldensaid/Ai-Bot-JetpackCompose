package com.fyp.chatgpt_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fyp.chatgpt_compose.navigation.MainNavigation
import com.fyp.chatgpt_compose.ui.theme.ChatGptComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatGptComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    MainNavigation(navController)
                }
            }
        }
    }
}

//@Composable
//fun EnterMessage(
//    modifier: Modifier = Modifier,
//    hint: String = "Send a message.",
//    icon: ImageVector = Icons.Filled.Send,
//    hideKeyboard: Boolean = false,
//    onFocusClear: () -> Unit = {},
//    onSend: (String) -> Unit
//) {
//    var newMessage by remember { mutableStateOf("") }
//    val focusManager = LocalFocusManager.current
//    Box(
//        modifier = modifier
//            .shadow(elevation = 5.dp)
//            .background(MaterialTheme.colors.surface)
//            .fillMaxWidth(), contentAlignment = Alignment.CenterStart
//    ) {
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 16.dp),
//            value = newMessage,
//            trailingIcon = {
//                Icon(
//                    imageVector = icon,
//                    tint = MaterialTheme.colors.onBackground,
//                    contentDescription = "null",
//                    modifier = Modifier.clickable {
//                        onSend(newMessage)
//                        focusManager.clearFocus()
//                    }
//                )
//            },
//            onValueChange = { newMessage = it },
//            // Use the hint text as the placeholder for the TextField
//            placeholder = {
//                Text(
//                    text = hint.capitalize(),
//                    color = MaterialTheme.colors.onBackground,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Light,
//                )
//            },
//            singleLine = true,
//            // Set the text color of the TextField to black
//            textStyle = MaterialTheme.typography.body1.copy(
//                color = MaterialTheme.colors.onBackground,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Light,
//            ),
//            // Use transparent colors for the TextField background and indicators
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            ),
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//            keyboardActions = KeyboardActions(onSearch = {
//                onSend(newMessage)
//                focusManager.clearFocus()
//            }),
//        )
//    }
//    if (hideKeyboard) {
//        focusManager.clearFocus()
//        // Call onFocusClear to reset hideKeyboard state to false
//        onFocusClear()
//    }
//}
