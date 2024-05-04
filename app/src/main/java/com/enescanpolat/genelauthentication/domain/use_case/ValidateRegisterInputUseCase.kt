package com.enescanpolat.genelauthentication.domain.use_case

import com.enescanpolat.genelauthentication.domain.model.RegisterInputValidationType
import com.enescanpolat.genelauthentication.util.containsNumber
import com.enescanpolat.genelauthentication.util.containsSpecialChar
import com.enescanpolat.genelauthentication.util.containsUpperCase

class ValidateRegisterInputUseCase {

    operator fun invoke(
        email:String,
        password:String,
        passwordRepeated:String
    ):RegisterInputValidationType{
        if(email.isEmpty() || password.isEmpty() || passwordRepeated.isEmpty()){
            return RegisterInputValidationType.EmptyField
        }
        if ("@" in email){
            return RegisterInputValidationType.NoEmail
        }
        if (password!=passwordRepeated){
            return RegisterInputValidationType.PasswordDoNotMatch
        }
        if (password.count()<8){
            return RegisterInputValidationType.PasswordToShort
        }
        if (!password.containsNumber()){
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!password.containsUpperCase()){
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!password.containsSpecialChar()){
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }

        return RegisterInputValidationType.Valid



    }

}