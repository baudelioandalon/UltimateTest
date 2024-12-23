package com.boreal.ultimatetest.games.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.MediumText
import com.boreal.ultimatetest.core.components.SemiBoldText
import com.boreal.ultimatetest.core.ui.theme.CategoryBackgroundSelectorOne
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.core.ui.theme.GrayBorderLight
import com.boreal.ultimatetest.core.ui.theme.GrayLetterArrow
import com.boreal.ultimatetest.core.ui.theme.GrayLetterSeeAll
import com.boreal.ultimatetest.core.ui.theme.GraySinceTo
import com.boreal.ultimatetest.core.ui.theme.categorySelectorColors
import com.boreal.ultimatetest.core.utils.limit
import com.boreal.ultimatetest.uisystem.R

@Composable
fun CategorySelectorItem(
    modifier: Modifier = Modifier,
    category: String = "",
    size: Dp = 50.dp,
    color: Color = CategoryBackgroundSelectorOne,
    categorySelected: (String) -> Unit = {}
) {
    Column(
        modifier = modifier.clickable {
            categorySelected(category)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color, shape = RoundedCornerShape(15.dp))
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                BoldText(
                    modifier = Modifier.fillMaxWidth(),
                    text = category.first().uppercase(),
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    color = White
                )
            }

        }

        SemiBoldText(
            modifier = Modifier.padding(top = 8.dp),
            text = category,
            textAlign = TextAlign.Center,
            color = Black,
            fontSize = 12.sp
        )
    }
}


@Composable
fun SelectorDetail(
    modifier: Modifier = Modifier, text: String = "",
    onClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(White)
            .padding(horizontal = 30.dp)
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_detail_icon),
            contentDescription = "comment icon"
        )
        BoldText(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = text, fontSize = 13.sp,
            color = Black
        )
        Icon(
            modifier = Modifier
                .rotate(180f)
                .width(21.dp)
                .height(12.dp),
            tint = GrayLetterArrow,
            painter = painterResource(id = R.drawable.ic_right_arrow_simbol),
            contentDescription = "comment icon"
        )
    }
}

@Composable
fun SeparatorGray(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier, color = GrayBorderLight, thickness = 1.dp
    )
}

@Composable
fun <T> HorizontalContainerListItem(
    startText: String? = null,
    startIcon: @Composable (() -> Unit)? = null,
    endText: String? = null,
    endIcon: @Composable (() -> Unit)? = null,
    listItem: List<T> = emptyList(),
    bottomCompose: @Composable (() -> Unit)? = null,
    composeItem: @Composable ((T, Int, List<T>) -> Unit)? = null
) {
    Column(
        modifier = Modifier.background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (startIcon != null) {
                startIcon()
            } else {
                BoldText(
                    modifier = Modifier.padding(start = 30.dp, top = 10.dp),
                    text = startText.orEmpty(),
                    color = Black,
                    fontSize = 18.sp,
                )
            }
            if (endIcon != null) {
                endIcon()
            } else {
                BoldText(
                    modifier = Modifier.padding(top = 10.dp, end = 30.dp),
                    text = endText.orEmpty(),
                    fontSize = 13.sp,
                    color = GrayLetterSeeAll
                )
            }
        }
        if (listItem.isNotEmpty()) {
            LazyRow(
                modifier = Modifier.padding(
                    top = 15.dp, bottom = 35.dp
                )
            ) {
                itemsIndexed(items = listItem) { index, item ->
                    composeItem?.invoke(item, index, listItem)
                }
            }
        }
        bottomCompose?.invoke()
    }
}

@Composable
fun SellerItem(
    modifier: Modifier,
    topText: String,
    bottomText: String,
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .clickable {
                onClicked?.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Card(
            modifier = Modifier.size(53.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                modifier = Modifier.padding(horizontal = 0.dp),
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "hide shipping options",
                tint = GraySinceTo
            )
        }



        Column(
            modifier = Modifier
                .padding(start = 19.dp)
                .weight(1f)
                .fillMaxHeight()
        ) {
            BoldText(
                text = topText, color = Black,
                fontSize = 15.sp
            )
            MediumText(
                text = bottomText, color = GrayLetterSeeAll, fontSize = 15.sp
            )
        }
        RightRoundedButton(
            modifier = Modifier.padding(end = 30.dp),
        ) {

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RightRoundedButton(modifier: Modifier = Modifier, clicked: (() -> Unit)) {
    Box(
        modifier = modifier
            .size(52.dp)
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .size(40.dp),
            elevation = 0.dp,
            shape = CircleShape, onClick = { clicked?.invoke() }) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_rounded_arrow_right),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun CategoryListContainer(
    itemCategory: List<String> = emptyList(),
    categorySelected: (String, Int) -> Unit
) {
    var itemCategorySelected by rememberSaveable { mutableIntStateOf(-1) }
    val defaultSize = if (itemCategorySelected != -1) 50.dp.plus(15.dp) else 50.dp
    Column(
        modifier = Modifier.background(White)
    ) {
        LazyRow(
            modifier = Modifier.padding(
                top = 15.dp, bottom = 18.dp
            )
        ) {
            itemsIndexed(items = itemCategory) { index, item ->
                CategorySelectorItem(
                    modifier = Modifier.padding(
                        start = if (index == 0) 30.dp else 10.dp,
                        end = if (index == itemCategory.limit()) 30.dp else 10.dp
                    ),
                    size = if (itemCategorySelected == index) defaultSize else 50.dp,
                    category = item,
                    color = categorySelectorColors[index % categorySelectorColors.size]
                ) {
                    itemCategorySelected = if (index == itemCategorySelected) -1 else index
                    categorySelected(item, itemCategorySelected)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShareButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_share_icon),
            contentDescription = ""
        )
    }
}