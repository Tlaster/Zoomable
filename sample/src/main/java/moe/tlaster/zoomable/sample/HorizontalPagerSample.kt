package moe.tlaster.zoomable.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import moe.tlaster.zoomable.Zoomable
import moe.tlaster.zoomable.ZoomableConsumeDirection
import moe.tlaster.zoomable.rememberZoomableState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerSample() {
    val pagerState = rememberPagerState(pageCount = 10)
    HorizontalPager(state = pagerState) { page ->
        val state = rememberZoomableState(
            minScale = 2f
        )
        Surface {
            Box {
                Zoomable(
                    state = state,
                    enable = true,
                    doubleTapScale = {
                        if (state.scale > 32f) {
                            state.minScale
                        } else {
                            state.scale * 2
                        }
                    },
                    finishDragNotConsumeDirection = ZoomableConsumeDirection.Horizontal,
                ) {
                    Text(
                        modifier = Modifier
                            .background(Color.Yellow)
                            .padding(32.dp),
                        text = "Page: $page",
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}
