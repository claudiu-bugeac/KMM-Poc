package com.claudiu.kmmpoc.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.claudiu.kmmpoc.android.ui.MyApplicationTheme
import com.claudiu.kmmpoc.network.BackendApi
import com.claudiu.kmmpoc.network.resources.MostPopularPeriod
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application()
        }
    }
}

@Composable
fun Application() {
    MyApplicationTheme {
        Surface(color = MaterialTheme.colors.background) {
            val scope = rememberCoroutineScope()
            LaunchedEffect(true) {
                scope.launch {
                    try {
                        val test = BackendApi().getMostEmailed(MostPopularPeriod.DAY_1)
                        Log.d("Claudiu", "Claduiu - $test")
                    } catch (e: Exception) {
                        Log.e("ERROR", e.stackTraceToString())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    Application()
}
