/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package digithon.core.util.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
//import digithon.presentation.ui.TodoScreen
import digithon.presentation.ui.MainMenuScreen
import digithon.presentation.ui.PolicyDateScreen
import digithon.presentation.ui.PolicyDetailsScreen
import digithon.presentation.ui.SummaryScreen
import digithon.presentation.ui.WelcomeScreen
import digithon.presentation.viewModel.QuoteViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.welcomePage.name) {
//        composable("TodoPage") { TodoScreen(modifier = Modifier.padding(16.dp)) }
        composable(Routes.welcomePage.name) { WelcomeScreen(navController, modifier = Modifier) }
        composable(Routes.mainMenu.name) { MainMenuScreen(navController, modifier = Modifier) }
        navigation(startDestination = Routes.policyDate.name, route = "getQuoteDetails") {
            composable(Routes.policyDate.name) {
                val quoteBackStackEntry = remember(it) {
                    navController.getBackStackEntry("getQuoteDetails")
                }
                val quoteViewModel = hiltViewModel<QuoteViewModel>(quoteBackStackEntry)
                PolicyDateScreen(
                    navController,
                    modifier = Modifier,
                    viewModel = quoteViewModel
                )
            }
            composable(Routes.policyDetails.name) {
                val quoteBackStackEntry = remember(it) {
                    navController.getBackStackEntry("getQuoteDetails")
                }
                val quoteViewModel = hiltViewModel<QuoteViewModel>(quoteBackStackEntry)
                PolicyDetailsScreen(
                    navController,
                    modifier = Modifier,
                    viewModel = quoteViewModel
                )
            }
            composable(Routes.summary.name) {
                val quoteBackStackEntry = remember(it) {
                    navController.getBackStackEntry("getQuoteDetails")
                }
                val quoteViewModel = hiltViewModel<QuoteViewModel>(quoteBackStackEntry)
                SummaryScreen(
                    navController,
                    modifier = Modifier,
                    viewModel = quoteViewModel
                )
            }
        }
    }
}
