package hr.ferit.marijaivanic.lv7.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.marijaivanic.lv7.DrawableRes
import hr.ferit.marijaivanic.lv7.Ingredient
import hr.ferit.marijaivanic.lv7.R

@Composable
fun IngredientCard(
    @DrawableRes iconResource : Int,
    title : String,
    subtitle : String
) {
    Column {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(id = iconResource),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Text(
            text = title,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )

        Text(
            text = subtitle,
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.LightGray
            ),
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )
    }
}
