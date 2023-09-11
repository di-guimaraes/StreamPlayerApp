package com.codandotv.streamplayerapp.feature_list_streams.profile.presentation.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.feature_list_streams.profile.di.ProfilePickerStreamModule
import com.codandotv.streamplayerapp.feature_list_streams.profile.presentation.screens.ProfilePickerStreamScreen
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

fun NavGraphBuilder.profilePickerStreamNavGraph(navController: NavHostController) {
    composable(Routes.PROFILE_PICKER) { nav ->
        if (nav.getLifecycle().currentState == Lifecycle.State.STARTED) {
            loadKoinModules(ProfilePickerStreamModule.module)
        }
        ProfilePickerStreamScreen(
            navController = navController
        ) {
            unloadKoinModules(ProfilePickerStreamModule.module)
        }
    }
}
