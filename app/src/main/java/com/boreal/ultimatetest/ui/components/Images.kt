package com.boreal.ultimatetest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.boreal.ultimatetest.core.domain.START_INDEX
import com.boreal.ultimatetest.core.domain.base.cut
import com.boreal.ultimatetest.core.utils.firstItem
import com.boreal.ultimatetest.core.utils.limit
import com.boreal.ultimatetest.ui.theme.BorderColor
import com.boreal.ultimatetest.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.ui.theme.PrimaryColor
import com.boreal.ultimatetest.uisystem.R

@Composable
fun ImageFromUrl(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    shape: Shape = CardDefaults.shape,
    image: String,
    contentScale: ContentScale = ContentScale.Crop
) {
    Card(
        modifier = modifier.size(size),
        shape = shape,
        border = BorderStroke(1.dp, color = BorderColor)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .allowHardware(false)
                .build(),
            placeholder = painterResource(R.drawable.portal),
            contentDescription = stringResource(R.string.app_name),
            contentScale = contentScale
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HorizontalImageViewer(
    modifier: Modifier = Modifier,
    sizeItem: Dp = 53.dp,
    colorSelected: Color = PrimaryColor,
    zoomWhenSelected: Boolean = false,
    itemList: List<String>,
    itemClicked: ((Int, String) -> Unit)? = null,
    bottomText: Boolean = false,
    contentScale: ContentScale = ContentScale.Crop
) {
    var selected by rememberSaveable { mutableIntStateOf(START_INDEX) }
    LazyRow(
        modifier = modifier.fillMaxWidth()
    ) {
        itemsIndexed(itemList) { index, item ->
            val defaultSize =
                if (selected == index && zoomWhenSelected) sizeItem.plus(8.dp) else sizeItem
            Column(
                modifier = Modifier.width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val startPadding = if (itemList.firstItem() == index) 30.dp else 0.dp
                val endPadding = if (itemList.limit() == index) 30.dp else 15.dp
                androidx.compose.material.Card(modifier = Modifier
                    .padding(
                        start = startPadding, end = endPadding
                    )
                    .defaultMinSize(defaultSize, defaultSize),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    border = if (index == selected && !zoomWhenSelected) BorderStroke(
                        width = 1.dp, color = colorSelected
                    ) else null,
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        selected = index
                        itemClicked?.invoke(index, item)
                    }) {

                    AsyncImage(
                        modifier = Modifier.size(54.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item)
                            .crossfade(true)
                            .allowHardware(false)
                            .build(),
                        placeholder = painterResource(R.drawable.portal),
                        contentDescription = stringResource(R.string.app_name),
                        contentScale = contentScale
                    )
                }
                if (bottomText) {
                    BoldText(
                        modifier = Modifier
                            .padding(
                                start = startPadding, end = endPadding
                            )
                            .fillMaxWidth(),
                        fontSize = 10.sp,
                        text = item.cut(10),
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                }


            }


        }
    }
}