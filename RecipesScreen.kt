package hr.ferit.marijaivanic.lv7.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.marijaivanic.lv7.R
import hr.ferit.marijaivanic.lv7.Recipe
import hr.ferit.marijaivanic.lv7.Routes
import hr.ferit.marijaivanic.lv7.ui.theme.DarkGray
import hr.ferit.marijaivanic.lv7.ui.theme.LightGray
import hr.ferit.marijaivanic.lv7.ui.theme.Pink
import hr.ferit.marijaivanic.lv7.ui.theme.White

@Composable
fun RecipesScreen(
    navigation : NavController,
    recipes : List<Recipe>
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenTitle(
            title="What would you like to cook today?",
            subtitle="Good morning, Marija"
        )
        SearchBar(iconResource = R.drawable.ic_search, labelText ="Search.." )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .background(Color.Transparent)
                .fillMaxWidth()
                .height(44.dp)
        ){
            CategoryButtons()
        }
        RecipeList(
            recipes = recipes,
            navigation = navigation
        )
        IconButton(iconResource = R.drawable.ic_plus, text = "Add new recipe")
    }
}

@Composable
fun ScreenTitle(
    title : String,
    subtitle : String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = subtitle,
            modifier = Modifier
                .padding(horizontal = 15.dp),
            style =  TextStyle(
                color = Color.Magenta,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 14.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText : String,
    colors : TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = Color.DarkGray,
        textColor = Color.DarkGray,
        unfocusedLabelColor = Color.DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    var textInput by remember{
        mutableStateOf("")
    }
    TextField(
        value = textInput,
        onValueChange = {textInput = it},
        label = { Text(text = labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun IconButton(
    @DrawableRes iconResource : Int,
    text : String
) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Pink,
            contentColor = Color.White
        )
    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null
            )
            Spacer(
                modifier = Modifier
                    .width(2.dp)
            )
            Text(text = text)
        }
    }
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Pink
        ) else ButtonDefaults.buttonColors(
            contentColor = DarkGray,
            containerColor = LightGray
        ),
        modifier = Modifier
            .fillMaxHeight(),
        onClick = { onClick() }
    ) {
        Text(text = text)
    }
}

@Composable
fun CategoryButtons() {
    var activeButton by remember {
        mutableStateOf(0)
    }
    TabButton(
        text = "All",
        isActive = activeButton == 0
    ) {
        activeButton = 0
    }
    TabButton(
        text = "Breakfast",
        isActive = activeButton == 1
    ) {
        activeButton = 1
    }
    TabButton(
        text = "Lunch",
        isActive = activeButton == 2
    ) {
        activeButton = 2
    }
}

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Magenta,
) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(
                horizontal = 8.dp,
                vertical = 2.dp
            )
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 12.sp
            )
        )
    }
}

@Composable
fun RecipeList(
    recipes: List<Recipe>,
    navigation: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "4 recipes",
                style = TextStyle(
                    color = DarkGray,
                    fontSize = 14.sp
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_flame),
                contentDescription = "Flame",
                tint = DarkGray,
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(recipes.size) { index ->
                val recipe = recipes.getOrNull(index)
                if (recipe != null) {
                    RecipeCard(
                        recipe = recipe,
                        onClick = {
                            navigation.navigate(
                                Routes.getRecipeDetailsPath(index)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}
