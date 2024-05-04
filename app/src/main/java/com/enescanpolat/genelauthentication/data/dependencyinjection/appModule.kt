package com.enescanpolat.genelauthentication.data.dependencyinjection

import com.enescanpolat.genelauthentication.data.repository.AuthRepositoryImpl
import com.enescanpolat.genelauthentication.domain.repository.AuthRepository
import com.enescanpolat.genelauthentication.domain.use_case.ValidateLoginInputUseCase
import com.enescanpolat.genelauthentication.domain.use_case.ValidateRegisterInputUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {

    @Singleton
    @Provides
    fun injectValidateLoginInputUseCase():ValidateLoginInputUseCase{
        return ValidateLoginInputUseCase()
    }

    @Singleton
    @Provides
    fun injectValidateRegisterInputUseCase():ValidateRegisterInputUseCase{
        return ValidateRegisterInputUseCase()
    }

    @Singleton
    @Provides
    fun injectAuthRepository():AuthRepository{
        return AuthRepositoryImpl()
    }




}