package Models

import java.awt.Color

class Appliance {
    // Attributes
    private var name: String = ""
    private var basePrice: Float = 0.0f
    private var color: String = "white"
    private var consumption: Char = 'G'
    private var weight: Float = 5f
    private var finalPrice: Float = calculateFinalPrice(this.consumption, this.weight)

    // Methods

    // Constructors
    constructor(name: String, basePrice: Float){
        this.name = name
        this.basePrice = basePrice
    }

    constructor(name: String, basePrice: Float, color: String, consumption: Char, weight: Float){
        this.name = name
        this.basePrice = basePrice
        this.color = color
        this.consumption = consumption
        this.weight = weight
    }

    // Getters
    fun getBasePrice(): Float {
        return this.basePrice
    }
    fun getColor(): String {
        return this.color
    }
    fun getCons(): Char {
        return this.consumption
    }
    fun getWeight(): Float {
        return this.weight
    }

    // Setters
    fun setBasePrice(price: Float){
        this.basePrice = price
    }
    fun setColor(color: String){
        this.color = color
    }
    fun setCons(cons: Char){
        this.consumption = cons
    }
    fun setWeight(weight: Float){
        this.weight = weight
    }

    // Calculation Functions
    /**
     * Function that receives the consumption and weight, and based on these, calculates and returns the modified price
     * @author Max Dron
     * @since 03/02/2024
     * @param cons Consumption of the appliance
     * @param weight Weight of the appliance
     * @return output - New price
     */
    fun calculateFinalPrice (cons: Char,weight: Float): Float {
        var output: Float = getBasePrice()

        output += when (cons.uppercaseChar()){
            'A' -> 35
            'B' -> 30
            'C' -> 25
            'D' -> 20
            'E' -> 15
            'F' -> 10
            else -> 0
        }

        output += when (weight) {
            in 0f..5.99f -> 0
            in 6f..20f -> 20
            in 21f..50f -> 50
            in 51f..80f -> 80
            else -> 100
        }

        return output
    }

    override fun toString(): String {
        return "- ${this.name}\n" +
                "    - ${this.basePrice}|n" +
                "    - ${this.color}\n" +
                "    - ${this.consumption}\n" +
                "    - ${this.weight}\n" +
                "    - ${this.finalPrice}\n"
    }

}