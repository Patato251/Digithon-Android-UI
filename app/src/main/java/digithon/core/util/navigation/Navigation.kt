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

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import digithon.presentation.ui.QuoteScreen
import digithon.presentation.ui.MainMenuScreen
import digithon.presentation.ui.PolicyDateScreen
import digithon.presentation.ui.WelcomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.welcomePage.name) {
//        composable("main") { QuoteScreen(modifier = Modifier.padding(16.dp)) }
        composable(Routes.welcomePage.name) { WelcomeScreen(navController, modifier = Modifier.padding(16.dp)) }
        composable(Routes.mainMenu.name) { MainMenuScreen(navController, modifier = Modifier.padding(16.dp)) }
        composable(Routes.policyDate.name) { PolicyDateScreen(navController, modifier = Modifier.padding(16.dp)) }
    }
}
