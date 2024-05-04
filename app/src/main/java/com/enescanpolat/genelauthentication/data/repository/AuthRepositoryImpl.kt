package com.enescanpolat.genelauthentication.data.repository

import com.enescanpolat.genelauthentication.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

):AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        delay(1000)
        return true
    }

    override suspend fun register(email: String, password: String): Boolean {
        delay(1000)
        return true
    }
}