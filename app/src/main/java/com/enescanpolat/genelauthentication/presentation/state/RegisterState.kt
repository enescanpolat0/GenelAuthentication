package com.enescanpolat.genelauthentication.presentation.state

data class RegisterState(
    val emailInput:String="",
    val passwordInput:String="",
    val passwordRepeatedInput:String = "",
    val isInputValid:Boolean = false,
    val isPasswordShown:Boolean = false,
    val isPasswordRepeatedShown:Boolean = false,
    val errorMessageInput:String?=null,
    val isloading:Boolean=false,
    val isSuccessfullyRegisteredIn:Boolean=false,
    val errorMessageRegisterProcess:String?=null
)
