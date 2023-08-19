package digithon.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import digithon.R
import digithon.core.presentation.components.DefaultButton
import digithon.core.util.navigation.Routes
import digithon.presentation.util.theme.MyApplicationTheme

@Composable
fun WelcomeScreen(navController: NavController, modifier: Modifier) {
    WelcomeScreenContents(navController ,modifier)
}


@Composable
private fun WelcomeScreenContents(navController: NavController, modifier: Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) {
        paddingValues -> paddingValues.calculateTopPadding()

        Box(modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(id = R.drawable.digithon_wallpaper),
                contentScale = ContentScale.FillBounds)) {

        }

        Column() {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.digithon_updated_logo),
                    contentDescription = "Digithon Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(bottom = 15.dp, top = 120.dp))

//                Spacer(modifier = Modifier.weight(2f))

                DefaultButton(
                    text = "GET STARTED",
                    onClick = { navController.navigate(Routes.mainMenu.name) },
                    modifier = modifier
                        .padding(top = 50.dp)
                        .weight(1f, false))
            }
        }
    }
}

@Composable
@Preview
private fun WelcomeScreenContentsPreview() {
    MyApplicationTheme {
        WelcomeScreenContents(navController = rememberNavController(), modifier = Modifier.padding(16.dp))
    }
}
