package com.gabriel.swarmintelligence.Model

data class AuthDataModel (

    val SessionTicket: String,
    val PlayFabId: String,
    val NewlyCreated: Boolean,
    val SettingsForUser : AuthDataSettingForUser,
    val EntityToken: EntityTokenModel

)

data class EntityTokenModel(
    val EntityToken: String,
    val TokenExpiration: String,
    val Entity: EntryModel
)

data class EntryModel(
    val Id : String,
    val Type: String,
    val TypeString: String
)