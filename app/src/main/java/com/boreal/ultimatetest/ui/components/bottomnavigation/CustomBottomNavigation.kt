package com.boreal.ultimatetest.ui.components.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.domain.NavigationScreen
import com.boreal.ultimatetest.ui.components.BoldText
import com.boreal.ultimatetest.ui.theme.GrayLetterShipping
import com.boreal.ultimatetest.ui.theme.PrimaryColor

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: (NavigationScreen) -> Unit
) {
    val items = listOf(
        NavigationScreen.HomeScreen,
        NavigationScreen.LocationsScreen,
        NavigationScreen.EpisodesScreen
    )

    Card(elevation = 5.dp) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
                .height(80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                CustomBottomNavigationItem(
                    item = item,
                    isSelected = item.route == currentScreenId
                ) {
                    onItemSelected(item)
                }
            }
        }
    }

}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(item: NavigationScreen, isSelected: Boolean, onClick: () -> Unit) {

    val background =
        if (isSelected) PrimaryColor.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isSelected) PrimaryColor else GrayLetterShipping

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            if (item.title.isEmpty() && isSelected) {
                Image(painter = painterResource(id = item.icon), contentDescription = null)
            } else {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = null,
                    tint = contentColor
                )

            }
            AnimatedVisibility(visible = isSelected) {
                BoldText(
                    text = item.title,
                    color = contentColor,
                    fontSize = 12.sp
                )
            }

        }
    }


}