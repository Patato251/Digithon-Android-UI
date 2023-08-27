package digithon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.presentation.components.NavigationButton
import digithon.core.util.navigation.Routes
import digithon.presentation.event.QuoteEvent
import digithon.presentation.util.theme.MyApplicationTheme
import digithon.presentation.util.theme.Purple80
import digithon.presentation.viewModel.QuoteViewModel
import java.text.DateFormat
import java.util.Locale

@OptIn(ExperimentalComposeApi::class)
@Composable
fun SummaryScreen(navController: NavController, modifier: Modifier, viewModel: QuoteViewModel) {
    SummaryScreenContents(navController, modifier, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeApi
@Composable
fun SummaryScreenContents(
    navController: NavController,
    modifier: Modifier,
    viewModel: QuoteViewModel
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = Purple80)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DefaultTopAppBar(
                "SUMMARY",
                onClick = { navController.navigate(Routes.policyDetails.name) },
                modifier = modifier,
                scrollBehavior = scrollBehavior
            )
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(it.calculateTopPadding())
                .scrollable(state = scrollState, orientation = Orientation.Vertical)
        ) {
            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Policy Start Date",
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = convertMillsToDate(uiState.value.policyStartDate),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(text = "Driver Details", fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = (uiState.value.title + ' ' + uiState.value.firstName + ' ' + uiState.value.surname),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(text = "Most Recent Insurance Provider", fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = uiState.value.recentInsurer,
                        textAlign = TextAlign.Center
                    )
                }
            }

//                Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    NavigationButton(
                        text = "SUBMIT",
                        onClick = {
                            viewModel.onEvent(QuoteEvent.SaveQuote)
                            navController.navigate(Routes.mainMenu.name)
                        },
                        modifier = Modifier.weight(2f, false)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalComposeApi::class)
@Composable
@Preview
private fun SummaryScreenContentsPreview() {
    MyApplicationTheme {
        SummaryScreenContents(rememberNavController(), Modifier, hiltViewModel())
    }
}

private fun convertMillsToDate(time: Long): String {
    val dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault())
    return dateFormat.format(time)
}