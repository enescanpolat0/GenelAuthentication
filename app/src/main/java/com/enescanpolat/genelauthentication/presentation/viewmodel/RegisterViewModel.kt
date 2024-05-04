package com.enescanpolat.genelauthentication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.genelauthentication.domain.model.RegisterInputValidationType
import com.enescanpolat.genelauthentication.domain.repository.AuthRepository
import com.enescanpolat.genelauthentication.domain.use_case.ValidateRegisterInputUseCase
import com.enescanpolat.genelauthentication.presentation.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateRegisterInputUseCase:ValidateRegisterInputUseCase,
    private val repository: AuthRepository
):ViewModel() {

    var registerState by mutableStateOf(RegisterState())
        private set

    fun onEmailInputChange(newValue:String){
        registerState= registerState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String){
        registerState = registerState.copy(passwordInput = newValue)
        checkInputValidation()
    }
        fun onPasswordRepeatedInputChange(newValue: String){
        registerState = registerState.copy(passwordRepeatedInput = newValue)
        checkInputValidation()
    }

    fun onToggleVisualTransformationPassword(){
        registerState = registerState.copy(isPasswordShown = !registerState.isPasswordShown)
    }

    fun onToggleVisualTransformationPasswordRepeated(){
        registerState = registerState.copy(isPasswordRepeatedShown = !registerState.isPasswordShown)
    }

    fun onRegisterClick(){
        registerState = registerState.copy(isloading = true)
        viewModelScope.launch {
            registerState = try {
                val registerResult = repository.register(
                    email = registerState.emailInput,
                    password = registerState.passwordInput
                )
                registerState.copy(isSuccessfullyRegisteredIn = registerResult)

            }catch (e:Exception){

                registerState.copy(errorMessageRegisterProcess =  "Could not login")

            }finally {

               registerState = registerState.copy(isloading = false)
            }
        }
    }

    private fun checkInputValidation(){
        val validationResult = validateRegisterInputUseCase(
            registerState.emailInput,
            registerState.passwordInput,
            registerState.passwordRepeatedInput
        )
        processInputValidationType(validationResult)
    }



    private fun processInputValidationType(type:RegisterInputValidationType){
        registerState = when(type){
            RegisterInputValidationType.EmptyField -> {
                registerState.copy(errorMessageInput = "Empty fields left", isInputValid = false)
            }
            RegisterInputValidationType.NoEmail -> {
                registerState.copy(errorMessageInput = "No valid email", isInputValid = false)
            }
            RegisterInputValidationType.PasswordToShort -> {
                registerState.copy(errorMessageInput = "Password too short", isInputValid = false)
            }
            RegisterInputValidationType.PasswordDoNotMatch -> {
                registerState.copy(errorMessageInput = "Passwords do not match", isInputValid = false)
            }
            RegisterInputValidationType.PasswordUpperCaseMissing -> {
                registerState.copy(errorMessageInput = "Password needs to contain at least one upper case char", isInputValid = false)
            }
            RegisterInputValidationType.PasswordSpecialCharMissing -> {
                registerState.copy(errorMessageInput = "Password needs to contain at least one special char", isInputValid = false)
            }
            RegisterInputValidationType.PasswordNumberMissing -> {
                registerState.copy(errorMessageInput = "Password needs to contain at least one number", isInputValid = false)
            }
            RegisterInputValidationType.Valid -> {
                registerState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }
}