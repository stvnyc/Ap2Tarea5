package edu.ucne.ap2tarea5.presentation.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.ucne.ap2tarea5.presentation.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ModalDrawerSheet(
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    navHostController: NavHostController
) {
    androidx.compose.material3.ModalDrawerSheet {
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Text("")
        }
        Spacer(modifier = Modifier.padding(20.dp))
        NavigationDrawerItem(
            label = { Text(text = "Home") },
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                navHostController.navigate(Screen.Home) {
                    popUpTo(0)
                }
            },
        )
    }
}