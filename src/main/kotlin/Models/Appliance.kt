package Models

import java.awt.Color

open class Appliance {
    // Attributes
    private var name: String = ""
    private var basePrice: Float = 0.0f
    private var color: String = "white"
    private var consumption: Char = 'G'
    private var weight: Float = 5f
    private var finalPrice: Float = calculateFinalPrice(this.consumption, this.weight)

    // Methods

    // Constructors
    /**
     * Constructor that generates a new appliance with the name and price you want, and initializes the other attributes with default values.
     * @author Max Dron
     * @since 03/02/2024
     * @param name Sets the name
     * @param basePrice Sets the base price
     */
    constructor(name: String, basePrice: Float){
        this.name = name
        this.basePrice = basePrice
    }

    /**
     * Constructor that generates an appliance by passing the data for all the attributes.
     * @author Max Dron
     * @since 03/02/2024
     * @param name Sets the name
     * @param basePrice Sets the base price
     * @param color Sets the color
     * @param consumption Sets the consumption
     * @param weight Sets the weight
     */
    constructor(name: String, basePrice: Float, color: String, consumption: Char, weight: Float){
        this.name = name
        this.basePrice = basePrice
        this.color = color
        this.consumption = consumption
        this.weight = weight
    }

    // Getters
    fun getName(): String {
        return this.name
    }
    open fun getBasePrice(): Float {
        return this.basePrice
    }
    open fun getColor(): String {
        return this.color
    }
    open fun getCons(): Char {
        return this.consumption
    }
    open fun getWeight(): Float {
        return this.weight
    }

    // Setters
    open fun setBasePrice(price: Float){
        this.basePrice = price
    }
    open fun setColor(color: String){
        this.color = color
    }
    open fun setCons(cons: Char){
        this.consumption = cons
    }
    open fun setWeight(weight: Float){
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
    open fun calculateFinalPrice (cons: Char,weight: Float): Float {
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
            in 6f..20.99f -> 20
            in 21f..50.99f -> 50
            in 51f..80f -> 80
            else -> 100
        }



        /*output += when (inches) {
            in 0f..28.99f -> 0
            in 29f..31.99f -> 50
            in 32f..41.99f -> 100
            in 42f..50.99f -> 150
            else -> 200

        }*/

        return output
    }

    override fun toString(): String {
        return "- ${this.name}\n" +
                "    - Base Price: ${this.basePrice}|n" +
                "    - Color: ${this.color}\n" +
                "    - Consumption: ${this.consumption}\n" +
                "    - Weight: ${this.weight}\n" +
                "    - Final Price: ${this.finalPrice}\n"
    }



}