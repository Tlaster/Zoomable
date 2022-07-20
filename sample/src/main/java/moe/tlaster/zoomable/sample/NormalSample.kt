package moe.tlaster.zoomable.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import moe.tlaster.zoomable.Zoomable
import moe.tlaster.zoomable.rememberZoomableState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NormalSample() {
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
