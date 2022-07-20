package moe.tlaster.zoomable.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        ListItem(
                            text = "Normal Sample",
                            onClick = {
                                startActivity(
                                    SampleActivity.getIntent(
                                        this@MainActivity,
                                        SampleActivity.SampleType.Normal,
                                    )
                                )
                            }
                        )
                        Divider()
                        ListItem(
                            text = "HorizontalPager Sample",
                            onClick = {
                                startActivity(
                                    SampleActivity.getIntent(
                                        this@MainActivity,
                                        SampleActivity.SampleType.HorizontalPager,
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ListItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(32.dp),
        text = text,
        fontSize = 18.sp,
    )
}
