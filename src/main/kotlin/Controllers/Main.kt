package Controllers

import Models.Appliance
import Models.Tv
import Models.WashingMachine
import Utilities.calculateFinalPrices
import Utilities.printFinalPrices

fun main(args: Array<String>) {

    // Create array of Appliances
    val appliances: ArrayList<Appliance> = arrayListOf()

    // Regular Appliances
    val toaster: Appliance = Appliance("Toaster", 32.59f)
    toaster.setWeight(2f)
    appliances.add(toaster)

    val microwave: Appliance = Appliance("Microwave", 129.85f)
    microwave.setColor("Light Blue")
    microwave.setCons('C')
    appliances.add(microwave)

    val oven: Appliance = Appliance("Oven", 299f)
    oven.setColor("Black")
    oven.setCons('A')
    oven.setWeight(20.4f)
    appliances.add(oven)

    val fridge: Appliance = Appliance("Fridge", 599.50f, "Dark Grey", 'B', 72.3f)
    appliances.add(fridge)

    val airFrier: Appliance = Appliance("AirFrier", 79.89f, "Light Red", 'A', 4f)
    appliances.add(airFrier)

    val blender: Appliance = Appliance("Blender", 34.50f, "Black & White", 'D', 1.6f)
    appliances.add(blender)

    // Waching Machines
    val candyWM: WashingMachine = WashingMachine("Candy", 399f)
    candyWM.setLoad(6.5f)
    candyWM.setColor("Dark Grey")
    candyWM.setCons('A')
    candyWM.setWeight(56f)
    appliances.add(candyWM)

    val boschWM: WashingMachine = WashingMachine("Bosch", 679.85f, "Dark Blue", 'B', 79f, 8f)
    appliances.add(boschWM)

    // Tv's
    val sonyBravia: Tv = Tv("Sony Bravia", 815f)
    appliances.add(sonyBravia)

    val lgOled: Tv = Tv("LG OLED", 1299f, "Grey", 'A', 15.5f, 55)
    appliances.add(lgOled)

    // Execution

    for (appliance in appliances) println(appliance)

    val finalPrices: Array<Float> = calculateFinalPrices(appliances)

    printFinalPrices(finalPrices)






}