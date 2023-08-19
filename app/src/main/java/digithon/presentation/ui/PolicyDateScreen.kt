package digithon.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.presentation.components.NavigationButton
import digithon.core.util.navigation.Routes
import digithon.presentation.util.theme.MyApplicationTheme

@Composable
fun PolicyDateScreen(navController: NavController, modifier: Modifier) {
    PolicyDateContent(navController, modifier)
}

//TODO: Setup Save state for Picked date to be stored in mutableState of/state model
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolicyDateContent(navController: NavController, modifier: Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DefaultTopAppBar(
                "POLICY START DATE",
                onClick = { navController.navigate(Routes.mainMenu.name) },
                modifier = modifier
            )
        }
    ) { paddingValues ->
        paddingValues.calculateTopPadding()

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "When would you like the policy to start?",
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Row {
                val datePickerState = rememberDatePickerState(initialSelectedDateMillis = null)
                DatePicker(
                    state = datePickerState,
                    modifier = Modifier.padding(16.dp),
                    title = null
                )
                //                Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
            }

            Column() {
                NavigationButton(
                    text = "Back",
                    onClick = { navController.navigate(Routes.mainMenu.name) },
                    modifier = modifier
                )
                NavigationButton(
                    onClick = { navController.navigate(Routes.policyDetails.name) },
                    modifier = modifier
                )
            }
        }
    }
}


@Composable
@Preview
private fun PolicyDateContentPreview() {
    MyApplicationTheme {
        PolicyDateContent(navController = rememberNavController(), modifier = Modifier)
    }
}
