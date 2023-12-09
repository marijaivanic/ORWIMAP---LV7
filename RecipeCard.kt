package hr.ferit.marijaivanic.lv7.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import hr.ferit.marijaivanic.lv7.Recipe

@Composable
fun RecipeCard(
    onClick: () -> Unit,
    recipe: Recipe
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .width(215.dp)
                .height(326.dp)
        ) {
            Image(
                painter = painterResource(id = recipe.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 3.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = recipe.title,
                    style = TextStyle(color = White),
                    modifier = Modifier
                        .padding(2.dp)
                )
                Row {
                    Chip(text = recipe.cookingTime)
                    Chip(text = recipe.numberOfIngredients)
                }
            }
        }
    }
}
