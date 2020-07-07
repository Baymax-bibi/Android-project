package com.gabriel.swarmintelligence.Utils

import com.gabriel.swarmintelligence.Model.AssModel

class DataAss {
    companion object{
        fun createDataSet(): ArrayList<AssModel>{
            val list = ArrayList<AssModel>()
            list.add(
                AssModel("Assistance name 1")
            )
            list.add(
                AssModel("Assistance name 2")
            )
            list.add(
                AssModel("Assistance name 3")
            )
            list.add(
                AssModel("Assistance name 4")
            )
            return list
        }
    }
}