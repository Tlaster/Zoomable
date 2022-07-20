package moe.tlaster.zoomable.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SampleActivity : ComponentActivity() {
    private val sampleType: SampleType by lazy {
        intent.getSerializableExtra(SampleTypeBundleKey) as SampleType
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            when (sampleType) {
                SampleType.Normal -> {
                    NormalSample()
                }
                SampleType.HorizontalPager -> {
                    HorizontalPagerSample()
                }
            }
        }
    }

    enum class SampleType {
        Normal,
        HorizontalPager,
        ;
    }

    companion object {
        private const val SampleTypeBundleKey = "SampleTypeBundleKey"

        fun getIntent(context: Context, sampleType: SampleType): Intent {
            return Intent(context, SampleActivity::class.java).also { intent ->
                intent.putExtra(SampleTypeBundleKey, sampleType)
            }
        }
    }
}