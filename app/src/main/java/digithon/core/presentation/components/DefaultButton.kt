package digithon.core.presentation.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digithon.presentation.util.theme.Purple40

@Composable
fun DefaultButton(
    text: String,
    color: Color = Purple40,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = color), shape = RoundedCornerShape(4.dp), modifier = modifier) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun NavigationButton(text: String = "Next", onClick: () -> Unit, modifier: Modifier) {
    DefaultButton(text = text, onClick = onClick, modifier = modifier.width(300.dp))
}

@Composable
@Preview
private fun DefaultButtonPreview() {
    DefaultButton(text = "Test button", onClick = { }, modifier = Modifier)
}

@Composable
@Preview
private fun NavigationButtonPreview() {
    NavigationButton(onClick = { }, modifier = Modifier)
}