package com.gabriel.swarmintelligence.Model

data class CreateGroupModel (
    val code : Int,
    val status: String,
    var data: DataModel
)

data class DataModel(
    val GroupName: String,
    val Group: GroupModel,
    val MemeberRoleId: String,
    val AdminRoleId: String,
    val Roles: RolesModel,
    val Created: String,
    val ProfileVersion: Int
)

data class GroupModel(
    val Id: String,
    val Type: String,
    val TypeString: String
)

data class RolesModel(
    val admins: String,
    val members: String
)