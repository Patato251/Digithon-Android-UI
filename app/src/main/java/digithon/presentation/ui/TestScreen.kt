package digithon.presentation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import digithon.presentation.util.theme.MyApplicationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestComposableComponent() {

}

@Composable
@Preview
private fun TestComposableComponentPreview() {
    MyApplicationTheme {
        TestComposableComponent()
    }
}

