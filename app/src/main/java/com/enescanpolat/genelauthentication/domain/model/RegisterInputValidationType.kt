package com.enescanpolat.genelauthentication.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoEmail,
    PasswordDoNotMatch,
    PasswordUpperCaseMissing,
    PasswordNumberMissing,
    PasswordSpecialCharMissing,
    PasswordToShort,
    Valid
}