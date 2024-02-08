package com.raremode.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.raremode.bankapp.navigation.SetupNavGraph
import com.raremode.bankapp.ui.screens.history.TransactionHistoryFragment
import com.raremode.bankapp.ui.theme.BankAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    TransactionHistoryFragment()
                    AppUI()
                }
            }
        }
    }
}

@Composable
fun AppUI() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}