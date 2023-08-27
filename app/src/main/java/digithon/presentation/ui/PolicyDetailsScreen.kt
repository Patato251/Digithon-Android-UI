package digithon.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.core.presentation.components.DefaultRadioButton
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.presentation.components.NavigationButton
import digithon.core.util.navigation.Routes
import digithon.presentation.event.QuoteEvent
import digithon.presentation.util.stateModels.QuoteUiState
import digithon.presentation.util.theme.MyApplicationTheme
import digithon.presentation.viewModel.QuoteViewModel

@Composable
fun PolicyDetailsScreen(
    navController: NavController,
    modifier: Modifier,
    viewModel: QuoteViewModel
) {
    PolicyDetailsContents(navController, modifier, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolicyDetailsContents(
    navController: NavController,
    modifier: Modifier,
    viewModel: QuoteViewModel
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val uiState = viewModel.uiState.collectAsState()
    val insurerList = listOf<String>("AAMI", "GIO", "Suncorp")

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DefaultTopAppBar(
                pageText = "MAIN DRIVER DETAILS",
                onClick = { navController.navigate(Routes.policyDate.name) },
                modifier = modifier,
                scrollBehavior = scrollBehavior
            )
        },
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding(), start = 15.dp, end = 15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "More details about the main driver",
                    fontWeight = FontWeight.ExtraBold
                )
            }

            // TODO: Button option layout for title
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = "Title",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = uiState.value.title,
                        onValueChange = { viewModel.onEvent(QuoteEvent.EnteredTitle(sanitizedValue(it))) },
                        label = { Text("e.g. Mr., Mrs., Miss, Ms., Dr., Sir") },
                        isError = uiState.value.titleErrors.isNotEmpty(),
                        modifier = modifier.fillMaxWidth()
                    )
                    uiState.value.titleErrors.forEach { error ->
                        Text(
                            text = error,
                            modifier = modifier.padding(vertical = 8.dp),
                            color = Color.Red
                        )
                    }
                    Spacer(modifier = modifier.padding(4.dp))
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "First Name",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = uiState.value.firstName,
                        onValueChange = { viewModel.onEvent(QuoteEvent.EnteredFirstName(sanitizedValue(it))) },
                        label = { Text("First Name") },
                        isError = uiState.value.firstNameErrors.isNotEmpty(),
                        modifier = modifier.fillMaxWidth()
                    )
                    uiState.value.firstNameErrors.forEach { error ->
                        Text(
                            text = error,
                            modifier = modifier.padding(vertical = 8.dp),
                            color = Color.Red
                        )
                    }
                    Spacer(modifier = modifier.padding(4.dp))
                    Text(
                        text = "Surname",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = uiState.value.surname,
                        onValueChange = { viewModel.onEvent(QuoteEvent.EnteredSurname(sanitizedValue(it))) },
                        label = { Text("Surname") },
                        isError = uiState.value.surnameErrors.isNotEmpty(),
                        modifier = modifier.fillMaxWidth()
                    )
                    uiState.value.surnameErrors.forEach { error ->
                        Text(
                            text = error,
                            modifier = modifier.padding(vertical = 8.dp),
                            color = Color.Red
                        )
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Who is your current or most recent insurance provider?",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        softWrap = true,
                    )

                    DefaultRadioButton(
                        itemList = insurerList,
                        selected = uiState.value.recentInsurer,
                        setSelected = { viewModel.onEvent(QuoteEvent.EnteredInsurer(it)) },
                        modifier = modifier
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    NavigationButton(
                        onClick = { navController.navigate(Routes.summary.name) },
                        isEnabled = (isNotEmpty(uiState) && isErrorFree(uiState)),
                        modifier = modifier
                    )
                    NavigationButton(
                        text = "Back",
                        onClick = { navController.navigate(Routes.policyDate.name) },
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PolicyDetailsContentsPreview() {
    MyApplicationTheme {
        PolicyDetailsContents(rememberNavController(), Modifier, viewModel())
    }
}
private fun sanitizedValue(textValue: String): String {
    return textValue.replace("\n", "")
}

private fun isNotEmpty(state: State<QuoteUiState>): Boolean {
    return state.value.title.isNotEmpty()
            && state.value.firstName.isNotEmpty()
            && state.value.surname.isNotEmpty()
            && state.value.recentInsurer.isNotEmpty()
}

private fun isErrorFree(state: State<QuoteUiState>): Boolean {
    return state.value.titleErrors.isEmpty()
            && state.value.firstNameErrors.isEmpty()
            && state.value.surnameErrors.isEmpty()
}
