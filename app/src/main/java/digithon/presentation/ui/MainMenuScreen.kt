package digithon.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
fun MainMenuScreen(navController: NavController, modifier: Modifier) {
    MainMenuScreenContents(navController, modifier)
}

@Composable
fun MainMenuScreenContents(navController: NavController, modifier: Modifier) {
    val scrollState = rememberScrollState()

    Scaffold { paddingValues ->
        paddingValues.calculateTopPadding()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.digithon_wallpaper),
                    contentScale = ContentScale.FillBounds
                )
        ) {

        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .scrollable(state = scrollState, orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.digithon_updated_logo),
                contentDescription = "Digithon Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(top = 120.dp)
            )

            DefaultButton(
                text = "GET A NEW QUOTE",
                onClick = { navController.navigate(Routes.policyDate.name) },
                modifier = Modifier.width(200.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            DefaultButton(
                text = "CLAIM A QUOTE", onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            DefaultButton(
                text = "MAKE A CLAIM", onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            DefaultButton(
                text = "CONTACT US", onClick = { /*TODO*/ },
                modifier = Modifier.width(200.dp)
            )
        }
    }
}


@Composable
@Preview
private fun MainMenuScreenContentsPreview() {
    MyApplicationTheme {
        MainMenuScreenContents(navController = rememberNavController(), modifier = Modifier)
    }
}