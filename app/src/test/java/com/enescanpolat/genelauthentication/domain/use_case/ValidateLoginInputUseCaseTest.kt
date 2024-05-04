package com.enescanpolat.genelauthentication.domain.use_case

import com.enescanpolat.genelauthentication.domain.model.LoginInputValidationType
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidateLoginInputUseCaseTest {

    private val validateLoginInputUseCase = ValidateLoginInputUseCase()

    @Test
    fun `test empty email field returns validation type empty field`(){
        val result = validateLoginInputUseCase(email = "", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }

    @Test
    fun `test empty password field returns validation type empty field`(){
        val result = validateLoginInputUseCase(email = "e@gmail.com", password = "")
        assertThat(result).isEqualTo(LoginInputValidationType.EmptyField)
    }
    @Test
    fun `test empty password field returns  type no email`(){
        val result = validateLoginInputUseCase(email = "egmail.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.NoEmail)
    }
    @Test
    fun `test everything is correct return validation type valid`(){
        val result = validateLoginInputUseCase(email = "e@gmail.com", password = "password")
        assertThat(result).isEqualTo(LoginInputValidationType.Valid)
    }



}