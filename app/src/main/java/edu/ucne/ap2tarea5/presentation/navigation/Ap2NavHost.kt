package edu.ucne.ap2tarea5.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.ap2tarea5.presentation.navigation.components.ModalDrawerSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ap2NavHost(
    navHostController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet (coroutineScope, drawerState, navHostController)
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("") },

                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Rounded.Menu, contentDescription = "Boton de menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navHostController,
                startDestination = Screen.Home,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<Screen.Home> {
                    Text("Home")
                }
            }
        }
    }
}