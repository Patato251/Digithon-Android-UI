package digithon.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultRadioButton(
    itemList: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit,
    modifier: Modifier,
) {
    CompositionLocalProvider {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxWidth()
        ) {
            itemList.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selected == item,
                        onClick = {
                            setSelected(item)
                        },
                        enabled = true,
                    )
                    Text(text = item, modifier = Modifier.padding(start = 4.dp).fillMaxWidth())
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)

private fun DefaultRadioButtonPreview() {
    val (select, setSelect) = remember { mutableStateOf("") }
    DefaultRadioButton(
        itemList = listOf("item1", "item2", "item3"),
        selected = select,
        setSelected = setSelect,
        modifier = Modifier
    )
}