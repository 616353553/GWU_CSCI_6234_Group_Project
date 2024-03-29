package com.group8.pizzaOrderSystem.foundation.model;

import java.math.BigDecimal;

public class PizzaDTO {
    private String name;
    private String doughName;
    private String doughSizeName;
    private String cheeseName1;
    private String cheeseLevelName1;
    private String cheeseName2;
    private String cheeseLevelName2;
    private String sauceName;
    private String sauceIntensityName;
    private String toppingName1;
    private String toppingName2;
    private String toppingName3;
    private BigDecimal retailPrice;

    // standard constructors


    // standard getters and setters
    public PizzaDTO() {

    }

    public PizzaDTO(String name, String doughName, String doughSizeName, String cheeseName1, String cheeseLevelName1,
                    String cheeseName2, String cheeseLevelName2, String sauceName, String sauceIntensityName,
                    String toppingName1, String toppingName2, String toppingName3, BigDecimal retailPrice) {
        this.name = name;
        this.doughName = doughName;
        this.doughSizeName = doughSizeName;
        this.cheeseName1 = cheeseName1;
        this.cheeseLevelName1 = cheeseLevelName1;
        this.cheeseName2 = cheeseName2;
        this.cheeseLevelName2 = cheeseLevelName2;
        this.sauceName = sauceName;
        this.sauceIntensityName = sauceIntensityName;
        this.toppingName1 = toppingName1;
        this.toppingName2 = toppingName2;
        this.toppingName3 = toppingName3;
        this.retailPrice = retailPrice;
    }

    public String getName() {
        return name;
    }

    public String getDoughName() {
        return doughName;
    }

    public String getDoughSizeName() {
        return doughSizeName;
    }

    public String getCheeseName1() {
        return cheeseName1;
    }

    public String getCheeseLevelName1() {
        return cheeseLevelName1;
    }

    public String getCheeseName2() {
        return cheeseName2;
    }

    public String getCheeseLevelName2() {
        return cheeseLevelName2;
    }

    public String getSauceName() {
        return sauceName;
    }

    public String getSauceIntensityName() {
        return sauceIntensityName;
    }

    public String getToppingName1() {
        return toppingName1;
    }

    public String getToppingName2() {
        return toppingName2;
    }

    public String getToppingName3() {
        return toppingName3;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public BigDecimal getPrice(BigDecimal doughPrice, BigDecimal doughSizeMultiplier, BigDecimal cheesePrice1,
                               BigDecimal cheeseLevelMultiplier1, BigDecimal cheesePrice2,
                               BigDecimal cheeseLevelMultiplier2, BigDecimal saucePrice,
                               BigDecimal sauceIntensityMultiplier, BigDecimal toppingPrice1, BigDecimal toppingPrice2,
                               BigDecimal toppingPrice3) {
        BigDecimal doughCost = doughPrice.multiply(doughSizeMultiplier);
        BigDecimal cheeseCost1 = cheesePrice1.multiply(cheeseLevelMultiplier1);
        BigDecimal cheeseCost2 = cheesePrice2.multiply(cheeseLevelMultiplier2);
        BigDecimal sauceCost = saucePrice.multiply(sauceIntensityMultiplier);
        BigDecimal toppingCost = toppingPrice1.add(toppingPrice2).add(toppingPrice3);
        return doughCost.add(cheeseCost1).add(cheeseCost2).add(sauceCost).add(toppingCost);
    }

    @Override
    public String toString() {
        return String.format("[Pizza %s - $%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s]",
                name, retailPrice.toString(), doughName, doughSizeName, cheeseName1, cheeseLevelName1, cheeseName2,
                cheeseLevelName2, sauceName, sauceIntensityName, toppingName1, toppingName2, toppingName3);
    }
}