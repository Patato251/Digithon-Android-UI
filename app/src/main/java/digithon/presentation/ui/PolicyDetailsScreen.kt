package digithon.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.core.presentation.components.DefaultTopAppBar
import digithon.core.util.navigation.Routes
import digithon.presentation.util.theme.MyApplicationTheme

@Composable
fun PolicyDetailsScreen(navController: NavController, modifier: Modifier) {
    PolicyDetailsContents(navController, modifier)
}

@Composable
fun PolicyDetailsContents(navController: NavController, modifier: Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(), topBar = {
            DefaultTopAppBar(
                pageText = "Main Driver Details",
                onClick = { navController.navigate(Routes.policyDate.name) },
                modifier = modifier)
        }
    ) { paddingValues ->
        paddingValues.calculateTopPadding()

        Column {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }

    }
}


@Composable
@Preview
fun PolicyDetailsContentsPreview() {
    MyApplicationTheme {
        PolicyDetailsContents(rememberNavController(), Modifier)
    }
}