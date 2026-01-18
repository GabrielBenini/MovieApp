package com.example.movieapp.navigation

enum class MovieScreens {

    HomeScreen,
    DetailsScreen;

    companion object {  //Companion Object -> como se fosse um static em java, permite chamar funcoes sem criar uma instancia do enum
        fun FromRoute(route: String?): MovieScreens // funcao -> recebe uma rota de navegacao e devolve qual tela isso representa, entao route: String pode ser "HomeScreen", "DetailsSreen/123", null
        = when (route?.substringBefore("/")) { // route? -> Significa que a rota pode ser nulla sem quebrar o app, substring serve para remover parametros da rota, entao DetailsScreen/42 sera recebido como "DetalisScreen/42"

            HomeScreen.name -> MovieScreens.HomeScreen // -> se a rota for HomeScreen retorna MovieScreens.HomeScreen
            DetailsScreen.name -> MovieScreens.DetailsScreen

            null -> MovieScreens.HomeScreen // Quando o app acabou de abrir e ainda nao tem rota definida ficara na home "Se nao sei a rota, comece pelo Home"

            else -> throw IllegalArgumentException("Route $route is not valid")

        }
    }
}