package moe.tlaster.zoomable.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import moe.tlaster.zoomable.Zoomable
import moe.tlaster.zoomable.rememberZoomableState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sample()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Sample() {
    val pagerState = rememberPagerState(pageCount = 10)
    HorizontalPager(state = pagerState) { page ->
        val state = rememberZoomableState(
            minScale = 2f
        )
        var enable by remember {
            mutableStateOf(true)
        }
        Surface {
            Box {
                Zoomable(
                    state = state,
                    enable = enable,
                    doubleTapScale = {
                        if (state.scale > 32f) {
                            state.minScale
                        } else {
                            state.scale * 2
                        }
                    }
                ) {
                    // Our page content
                    Text(
                        text = "Page: $page",
                    )
                }
                Checkbox(checked = enable, onCheckedChange = { enable = it })
            }
        }
    }
}
