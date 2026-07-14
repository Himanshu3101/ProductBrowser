package org.himanshu.productbrowser

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import org.himanshu.productbrowser.di.AppModule
import org.himanshu.productbrowser.presentation.navigation.AppNavigation

@Composable
@Preview
fun App() {

    MaterialTheme {

        AppNavigation()
    }
}