package com.gabriel.swarmintelligence.Model

data class BlogPost(

    var username: String,

    var image: String
//    var username: String // Author of blog post

) {
    override fun toString(): String {
        return "BlogPost("+
                "image='$image'" +
                ", username='$username')"
    }
}
























