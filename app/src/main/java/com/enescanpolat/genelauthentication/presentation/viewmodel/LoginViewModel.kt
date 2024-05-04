package com.enescanpolat.genelauthentication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.genelauthentication.domain.model.LoginInputValidationType
import com.enescanpolat.genelauthentication.domain.repository.AuthRepository
import com.enescanpolat.genelauthentication.domain.use_case.ValidateLoginInputUseCase
import com.enescanpolat.genelauthentication.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginInputUseCase:ValidateLoginInputUseCase,
    private val repository: AuthRepository
):ViewModel() {

    var loginState by mutableStateOf(LoginState())
        private set

    fun onEmailInputChange(newValue:String){
        loginState = loginState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String){
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformation(){
        loginState = loginState.copy(isPasswordShown = !loginState.isPasswordShown)
    }

    fun onLoginClick(){

        loginState = loginState.copy(isloading = true)
        viewModelScope.launch {
            loginState = try {
                val loginResult = repository.login(
                    email = loginState.emailInput,
                    password = loginState.passwordInput
                )
                loginState.copy(isSuccessfullyLoggedIn = loginResult)

            }catch (e:Exception){

                loginState.copy(errorMessageLoginProcess = "Could not login")

            }finally {

               loginState = loginState.copy(isloading = false)
            }
        }

    }

    private fun checkInputValidation(){
        val validationResult = validateLoginInputUseCase(
            loginState.emailInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type:LoginInputValidationType){
        loginState = when(type){
            LoginInputValidationType.EmptyField->{
                loginState.copy(errorMessageInput = "Empty fields left", isInputValid = false)
            }
            LoginInputValidationType.NoEmail->{
                loginState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }
            LoginInputValidationType.Valid->{
                loginState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }


}