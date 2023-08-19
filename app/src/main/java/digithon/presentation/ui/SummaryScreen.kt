package digithon.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.R
import digithon.core.presentation.components.DefaultButton
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.presentation.components.NavigationButton
import digithon.core.util.navigation.Routes
import digithon.presentation.util.theme.MyApplicationTheme

@OptIn(ExperimentalComposeApi::class)
@Composable
fun SummaryScreen(navController: NavController, modifier: Modifier) {
    SummaryScreenContents(navController, modifier)
}

@ExperimentalComposeApi
@Composable
fun SummaryScreenContents(navController: NavController, modifier: Modifier) {
    val scrollState = rememberScrollState()

    Scaffold(topBar = {
        DefaultTopAppBar(
            "Summary",
            onClick = {},
            modifier = modifier
        )
    }) { paddingValues ->
        paddingValues.calculateTopPadding()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(state = scrollState, orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Policy Start Date",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 100.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Insert policy start date")

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Driver Details", fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Insert Driver Details")

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Most Recent Insurance Provider", fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Insert Most Recent Insurance Details")

//                Spacer(modifier = Modifier.weight(1f))

            Column() {
                NavigationButton(
                    text = "SUBMIT", onClick = { /*TODO*/ },
                    modifier = Modifier
                )
            }
        }
    }
}


@OptIn(ExperimentalComposeApi::class)
@Composable
@Preview
private fun SummaryScreenContentsPreview() {
    MyApplicationTheme {
        SummaryScreenContents(rememberNavController(), Modifier)
    }
}