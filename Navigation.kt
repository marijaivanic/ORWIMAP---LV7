package hr.ferit.marijaivanic.lv7

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.marijaivanic.lv7.ui.RecipeDetailsScreen
import hr.ferit.marijaivanic.lv7.ui.RecipesScreen

object Routes {
    const val SCREEN_ALL_RECIPES = "recipesList"
    const val SCREEN_RECIPE_DETAILS ="recipeDetails/{recipeId}"

    fun getRecipeDetailsPath(recipeId : Int?) : String {
        if (recipeId != null && recipeId != -1) {
            return "recipeDetails/$recipeId"
        }
        return "recipeDetails/$recipeId"
    }
}

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SCREEN_ALL_RECIPES
    ) {
        composable(Routes.SCREEN_ALL_RECIPES) {
            RecipesScreen(
                navigation = navController,
                recipes = recipes
            )
        }
        composable(
            Routes.SCREEN_RECIPE_DETAILS,
            arguments = listOf(
                navArgument("recipeId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("recipeId")?.let {
                RecipeDetailsScreen(navController, it)
            }
        }
    }
}
