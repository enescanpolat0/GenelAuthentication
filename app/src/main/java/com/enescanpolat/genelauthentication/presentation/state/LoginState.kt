package com.enescanpolat.genelauthentication.presentation.state

data class LoginState(
    val emailInput :String = "",
    val passwordInput:String="",
    val isInputValid:Boolean=false,
    val isPasswordShown:Boolean=false,
    val errorMessageInput:String?=null,
    val isloading:Boolean=false,
    val isSuccessfullyLoggedIn:Boolean=false,
    val errorMessageLoginProcess:String?=null
)
