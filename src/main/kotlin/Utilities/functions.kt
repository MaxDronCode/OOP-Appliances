package Utilities

import Models.Appliance
import Models.Tv
import Models.WashingMachine

fun pricesRegular(appliances: ArrayList<Appliance>): Array<Float> {

    var basePriceRegular: Float = 0.0f
    var finalPriceRegular: Float = 0.0f
    var basePriceWM: Float = 0.0f
    var finalPriceWM: Float = 0.0f
    var basePriceTv: Float = 0.0f
    var finalPriceTv: Float = 0.0f
    for (element in appliances) {
        when (element) {
            is WashingMachine -> {
                basePriceWM += element.getBasePrice()
                finalPriceWM += element.calculateFinalPrice_WM(element.getLoad())
            }
            is Tv -> {
                basePriceTv += element.getBasePrice()
                finalPriceTv += element.calculateFinalPrice_Tv(element.getInch())
            }
            else -> {
                basePriceRegular += element.getBasePrice()
                finalPriceRegular += element.calculateFinalPrice(element.getCons(), element.getWeight())
            }
        }
    }
    val output: Array<Float> = arrayOf(basePriceRegular, finalPriceRegular, basePriceWM, finalPriceWM, basePriceTv, finalPriceTv)
    return output
}