package digithon.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.presentation.components.NavigationButton
import digithon.core.util.navigation.Routes
import digithon.presentation.event.QuoteEvent
import digithon.presentation.util.theme.MyApplicationTheme
import digithon.presentation.viewModel.QuoteViewModel

@Composable
fun PolicyDateScreen(navController: NavController, modifier: Modifier, viewModel: QuoteViewModel) {
    PolicyDateContent(navController, modifier, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolicyDateContent(navController: NavController, modifier: Modifier, viewModel: QuoteViewModel) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val uiState = viewModel.uiState.collectAsState()
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = uiState.value.policyStartDate)

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DefaultTopAppBar(
                "POLICY START DATE",
                onClick = { navController.navigate(Routes.mainMenu.name) },
                modifier = modifier,
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            Text(
                text = "When would you like the policy to start?",
                fontWeight = FontWeight.ExtraBold
            )

            DatePicker(
                state = datePickerState,
                title = null
            )

            Column() {
                NavigationButton(
                    onClick = {
                        viewModel.onEvent(QuoteEvent.EnteredDate(datePickerState.selectedDateMillis.toString()))
                        navController.navigate(Routes.policyDetails.name)
                    },
                    isEnabled = true,
                    modifier = modifier
                )
                NavigationButton(
                    text = "Back",
                    onClick = { navController.navigate(Routes.mainMenu.name) },
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
        PolicyDateContent(
            navController = rememberNavController(),
            modifier = Modifier,
            viewModel = hiltViewModel()
        )
    }
}
