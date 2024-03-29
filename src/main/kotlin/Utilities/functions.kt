package Utilities

import Models.Appliance
import Models.Tv
import Models.WashingMachine

/**
 * Function that receives a list of objects, accumulates their base and final price in one variable
 * or another depending on the type of object, and finally returns the accumulated values in an array.
 * @author Max Dron
 * @since 03/02/2024
 * @param appliances List of objects
 * @return Final prices in array form
 */
fun calculateFinalPrices (appliances: ArrayList<Appliance>): Array<Float> {

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

/**
 * Function that receives an array of prices and prints their values in a very specific way
 * @author Max Dron
 * @since 03/02/2024
 * @param finalPrices Array of prices
 */
fun printFinalPrices(finalPrices: Array<Float>){
    println("""
        $GREEN_BOLD_BRIGHT- Appliances: 
            $BLUE- Base Price: $WHITE_BRIGHT${finalPrices[0]}€
            $BLUE- Final Price: $WHITE_BRIGHT${finalPrices[1]}€
        $GREEN_BOLD_BRIGHT- Washing Machines: 
            $PURPLE- Base Price: $WHITE_BRIGHT${finalPrices[2]}€
            $PURPLE- Final Price: $WHITE_BRIGHT${finalPrices[3]}€
        $GREEN_BOLD_BRIGHT- Tv's:
            $RED- Base Price: $WHITE_BRIGHT${finalPrices[4]}€
            $RED- Final Price: $WHITE_BRIGHT${finalPrices[5]}€
    """.trimIndent())
}