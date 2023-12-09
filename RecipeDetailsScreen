package hr.ferit.marijaivanic.lv7.ui


import androidx.compose.runtime.Composable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.marijaivanic.lv7.R
import hr.ferit.marijaivanic.lv7.Recipe
import hr.ferit.marijaivanic.lv7.recipes
import hr.ferit.marijaivanic.lv7.ui.theme.DarkGray
import hr.ferit.marijaivanic.lv7.ui.theme.Gray
import hr.ferit.marijaivanic.lv7.ui.theme.LightGray
import hr.ferit.marijaivanic.lv7.ui.theme.Pink
import hr.ferit.marijaivanic.lv7.ui.theme.Purple500
import hr.ferit.marijaivanic.lv7.ui.theme.White

@Composable
fun RecipeDetailsScreen(
    navigation : NavController,
    recipeId : Int
) {
    val recipe = recipes[recipeId]
    val scrollState = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            TopImageAndBar(recipe.image, navigation)
            ScreenInfo(recipe.title, recipe.category)
            BasicInfo(recipe)
            Description(recipe)
            Servings()
            IngredientHeader()
            IngredientsList(recipe)
            ShoppingListButton()
            Reviews(recipe)
            OtherRecipes()
        }
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResource : Int,
    containerColor : Color,
    contentColor : Color,
    elevation : ButtonElevation = ButtonDefaults.buttonElevation(12.dp),
    onClick : () -> Unit = {}
    ) {
    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
        )
    }
}

@Composable
fun TopImageAndBar(
    @DrawableRes coverImage : Int,
    navigation: NavController
) {
    var containerArrow by remember {
        mutableStateOf(LightGray)
    }

    var contentArrow by remember {
        mutableStateOf(Pink)
    }

    var containerHeart by remember {
        mutableStateOf(LightGray)
    }

    var contentHeart by remember {
        mutableStateOf(Pink)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = coverImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .height(56.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CircularButton(
                    R.drawable.ic_arrow_back,
                    containerColor = containerArrow,
                    contentColor = contentArrow,
                    onClick = {
                        containerArrow = Pink
                        contentArrow = LightGray
                        navigation.navigateUp()
                    }
                )
                CircularButton(
                    R.drawable.ic_favorite,
                    containerColor = containerHeart,
                    contentColor = contentHeart,
                    onClick = {
                        containerHeart = Pink
                        contentHeart = LightGray
                    }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White
                            ),
                            startY = 100f
                        )
                    )
            )
        }
    }
}

@Composable
fun ScreenInfo(
    title : String,
    category : String
) {
    Column {
        Text(
            text = category,
            style = TextStyle(
                color = Purple500,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun InfoColumn(
    @DrawableRes iconResource : Int,
    text : String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            tint = Pink,
            modifier = Modifier
                .height(24.dp)
        )

        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BasicInfo(
    recipe: Recipe,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_clock, recipe.cookingTime)
        InfoColumn(R.drawable.ic_flame, recipe.energy)
        InfoColumn(R.drawable.ic_star, recipe.rating)
    }
}

@Composable
fun Description(
    recipe: Recipe,
) {
    Text(
        text = recipe.description,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 16.dp)
    )
}

@Composable
fun <T> EasyGrid(
    nColumns : Int,
    items : List<T>,
    content : @Composable (T) -> Unit
) {
    Column(
        Modifier.padding(16.dp)
    ) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            content(items[i+j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Composable
fun IngredientsList(
    recipe: Recipe
) {
    EasyGrid(
        nColumns = 3,
        items = recipe.ingredients
    ) {
        IngredientCard(it.image, it.title, it.subtitle)
    }
}

@Composable
fun ShoppingListButton() {
    Button(
        onClick = { /*TODO*/ },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Add to shopping list",
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun Reviews(
    recipe: Recipe
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(
                text = "Reviews",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = recipe.reviews,
                color = Color.DarkGray
            )
        }
        IconButton(
            iconResource = R.drawable.ic_arrow_right,
            text = "See all"
        )
    }

}

@Composable
fun OtherRecipes() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.chocolate_cake),
            contentDescription = "Chocolate cake",
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(12.dp))
                .fillMaxSize()
        )

        Spacer(
            modifier = Modifier
                .width(16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.apple_crumble_pie),
            contentDescription = "Apple crumble pie",
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(12.dp))
                .fillMaxSize()
        )
    }
}

@Composable
fun Servings() {
    var value by remember {
        mutableStateOf(6)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Servings",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )
        CircularButton(
            iconResource = R.drawable.ic_minus,
            contentColor = Pink,
            containerColor = LightGray
        ) {
            value--
        }
        Text(
            text = "$value",
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(16.dp)
        )
        CircularButton(iconResource = R.drawable.ic_plus,
            contentColor = Pink,
            containerColor = LightGray
        ) {
            value++
        }
    }
}

@Composable
fun IngredientHeader() {
    var activeButton by remember {
        mutableStateOf(0)
    }
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)

    ){
        TabButton(
            text = "Ingredients",
            isActive = activeButton == 0
        ) {
            activeButton = 0
        }
        TabButton(
            text = "Tools",
            isActive = activeButton == 1
        ) {
            activeButton = 1
        }
        TabButton(
            text = "Steps",
            isActive = activeButton == 2
        ) {
            activeButton = 2
        }
    }
}
