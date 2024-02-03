package Models

class Tv : Appliance {
    // Atributtes
    private var inch: Short = 28

    // Methods

    // Constructors
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
     * Constructor that generates an appliance by passing the data for all the attributes.
     * @author Max Dron
     * @since 03/02/2024
     * @param name Sets the name
     * @param basePrice Sets the base price
     * @param color Sets the color
     * @param consumption Sets the consumption
     * @param weight Sets the weight
     * @param inch Sets the inch
     */
    constructor(name: String, basePrice: Float, color: String, consumption: Char, weight: Float, inch: Short) : super(name, basePrice, color, consumption, weight) {
        this.inch = inch
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
    fun getInch(): Short {
        return this.inch
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
    fun setInch(inch: Short) {
        this.inch = inch
    }

    // Calculation Functions
    /**
     * Function that receives the inches of the tv, and based on this, calculates and returns the modified price
     * @author Max Dron
     * @since 03/02/2024
     * @param inch The inches of the tv
     * @return output - Final modified price
     */
    fun calculateFinalPrice_Tv(inch: Short): Float {
        var output:Float = getBasePrice()

        output += when (inch) {
            in 29..32 -> 0
            in 33..42 -> 55
            in 43..50 -> 70
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
                "    - Inch: ${this.inch}\n" +
                "    - Final Price: ${this.calculateFinalPrice_Tv(this.inch)}\n"
    }
}