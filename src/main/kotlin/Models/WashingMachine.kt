package Models

class WashingMachine: Appliance {
    // Attributes
    private var load: Float = 5f

    // Methods

    // Contructors
    /**
     * Constructor that generates a new wahing machine with the name and price you want, and initializes the other attributes with default values. Uses the superclass constructor.
     * @author Max Dron
     * @since 03/02/2024
     * @param name Sets the name
     * @param basePrice Sets the base price
     */
    constructor(name: String, basePrice: Float): super(name, basePrice) {
    }
    /**
     * Constructor that generates an appliance by passing the data for all the attributes. Uses the superclass constructor.
     * @author Max Dron
     * @since 03/02/2024
     * @param name Sets the name
     * @param basePrice Sets the base price
     * @param color Sets the color
     * @param consumption Sets the consumption
     * @param weight Sets the weight
     * @param load Sets the load
     */
    constructor(name: String, basePrice: Float, color: String, consumption: Char, weight: Float, load: Float) : super(name, basePrice, color, consumption, weight) {
        this.load = load
    }

    // Getters
    override fun getBasePrice(): Float {
        return super.getBasePrice()
    }
    override fun getColor(): String {
        return super.getColor()
    }
    override fun getCons(): Char {
        return super.getCons()
    }
    override fun getWeight(): Float {
        return super.getWeight()
    }
    fun getLoad(): Float {
        return this.load
    }

    // Setters
    override fun setBasePrice(price: Float) {
        super.setBasePrice(price)
    }
    override fun setColor(color: String){
        super.setColor(color)
    }
    override fun setCons(cons: Char){
        super.setCons(cons)
    }
    override fun setWeight(weight: Float){
        super.setWeight(weight)
    }
    fun setLoad(load: Float) {
        this.load = load
    }

    // Calculation Functions
    /**
     * Function that receives the load of the waching machine, and based on this, calculates and returns the modified price
     * @author Max Dron
     * @since 03/02/2024
     * @param load The load of the waching machine
     * @return output - Final modified price
     */
    fun calculateFinalPrice_WM(load: Float): Float {
        var output:Float = getBasePrice()

        output += when (load) {
            in 0f..5.99f -> 0
            in 6f..7.99f -> 55
            in 8f..8.99f -> 70
            in 9f..9.99f -> 85
            else -> 100
        }
        return output
    }

    override fun toString(): String {
        return "- ${super.getName()}\n" +
                "    - Base Price: ${super.getBasePrice()}\n" +
                "    - Color: ${super.getColor()}\n" +
                "    - Consumption: ${super.getCons()}\n" +
                "    - Weight: ${super.getWeight()}\n" +
                "    - Load: ${this.load}\n" +
                "    - Final Price: ${this.calculateFinalPrice_WM(this.load)}\n"
    }
}