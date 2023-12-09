package hr.ferit.marijaivanic.lv7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import hr.ferit.marijaivanic.lv7.ui.RecipesScreen
import hr.ferit.marijaivanic.lv7.ui.RecipeCard
import hr.ferit.marijaivanic.lv7.ui.RecipeDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationController()
        }
    }
}

data class Recipe (
    @DrawableRes val image : Int,
    val title : String,
    val category : String,
    val cookingTime : String,
    val energy : String,
    val rating : String,
    val description : String,
    val reviews : String,
    val ingredients : List<Ingredient>,
    val numberOfIngredients : String
)

data class Ingredient (
    @DrawableRes val image : Int,
    val title : String,
    val subtitle : String
)

annotation class DrawableRes

val recipes: List<Recipe> = listOf(
    Recipe(
        image = R.drawable.strawberry_pie,
        title = "Strawberry Pie",
        category = "Desserts",
        cookingTime = "50 min",
        energy = "620 kcal",
        rating = "4,9",
        description = "This dessert is very tasty and not difficult to prepare.Also, you can replace strawberries with any other berry you like.",
        reviews = "84 photos 430 comments",
        ingredients = listOf(
            Ingredient(R.drawable.flour, "Flour", "450 g"),
            Ingredient(R.drawable.eggs, "Eggs", "4"),
            Ingredient(R.drawable.juice, "Lemon juice", "150 g"),
            Ingredient(R.drawable.strawberry, "Strawberry", "200 g"),
            Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
            Ingredient(R.drawable.mint, "Mint", "20 g"),
            Ingredient(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"),
        ),
        numberOfIngredients = "7 ingredients"
    ),
    Recipe(
        image = R.drawable.baklava2,
        title = "Baklava",
        category = "Desserts",
        cookingTime = "1 hr 20 min",
        energy = "393 kcal",
        rating = "5,0",
        description = "Baklava is a delicious Greek dessert made up of layers of crispy phyllo dough, honey and nuts that's sooo easy to make.",
        reviews = "70 photos 500 comments",
        ingredients = listOf(
            Ingredient(R.drawable.phyllo_dough, "Phyllo dough", "1 pack"),
            Ingredient(R.drawable.chopped_nuts, "Chopped nuts", "450 g"),
            Ingredient(R.drawable.butter, "Butter", "250 g"),
            Ingredient(R.drawable.ground_cinnamon, "Cinnamon", "6 g"),
            Ingredient(R.drawable.water, "Water", "1 cup"),
            Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
            Ingredient(R.drawable.vanilla, "Vanilla", "1 teaspoon"),
            Ingredient(R.drawable.honey, "Honey", "1/2 cup"),
        ),
        numberOfIngredients = "8 ingredients"
    ),
    Recipe(
        image = R.drawable.pizza,
        title = "Pizza",
        category = "Meal",
        cookingTime = "30 min",
        energy = "200 kcal",
        rating = "4,8",
        description = "Make the best homemade pepperoni pizza recipe with this step by step guide. Use either a pizza stone or baking sheet and have it on the table in under 30 minutes!",
        reviews = "95 photos 450 comments",
        ingredients = listOf(
            Ingredient(R.drawable.pizza_dough, "Pizza dough", "1 pack"),
            Ingredient(R.drawable.flour, "Flour", "1/2 cup"),
            Ingredient(R.drawable.olive_oil, "Olive oil", "1 cup"),
            Ingredient(R.drawable.pizza_sauce, "Pizza sauce", "1 cup"),
            Ingredient(R.drawable.mozzarella, "Mozzarella", "230 g"),
            Ingredient(R.drawable.pepperoni_slices, "Pepperoni slices", "200 g"),
        ),
        numberOfIngredients = "6 ingredients"
    ),
    Recipe(
        image = R.drawable.burek,
        title = "Burek",
        category = "Meal",
        cookingTime = "1 hr",
        energy = "790 kcal",
        rating = "5,0",
        description = "Burek is a mouth-watering Balkan phyllo dough pie with a filling. Today, we're sharing our family recipe for Bosnian burek.",
        reviews = "100 photos 500 comments",
        ingredients = listOf(
            Ingredient(R.drawable.ground_beef, "Ground pork", "600 g"),
            Ingredient(R.drawable.flour, "Flour", "600 g"),
            Ingredient(R.drawable.water, "Water", "390 ml"),
            Ingredient(R.drawable.salt, "Salt", "2 teaspoons"),
            Ingredient(R.drawable.oil, "Oil", "2 dl"),
            Ingredient(R.drawable.onion, "Onion", "1"),
        ),
        numberOfIngredients = "6 ingredients"
    )
)
