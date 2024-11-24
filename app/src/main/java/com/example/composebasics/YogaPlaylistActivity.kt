package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.components.AlignYourBodyRow
import com.example.composebasics.components.FavoriteCollectionsGrid
import com.example.composebasics.components.SearchBarComposable
import com.example.composebasics.components.YogaBottomBar
import com.example.composebasics.components.YogaNavigationRail
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class YogaPlaylistActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                SetupView(windowSizeClass)
            }
        }
    }
}

@Composable
fun SetupView(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            HomeScreenPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            HomeScreenLandscape()
        }
    }
}

@Composable
fun HomeScreenPortrait() {
    ComposeBasicsTheme {
        Scaffold(
            bottomBar = { YogaBottomBar() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun HomeScreenLandscape() {
    ComposeBasicsTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row(Modifier.fillMaxSize()) {
                YogaNavigationRail()
                HomeScreen(Modifier)
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(R.color.bg_yoga_home_color))
    ) {
        Spacer(modifier = modifier.height(16.dp))
        SearchBarComposable(modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier.height(16.dp))
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeScreenPortraitPreview() {
    ComposeBasicsTheme {
        HomeScreenPortrait()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeScreenLandScapePreview() {
    ComposeBasicsTheme {
        HomeScreenLandscape()
    }
}