package service;

import junit.framework.Assert;
import org.junit.Test;
import prizy.service.AverageIdealPriceCalculation;
import prizy.service.IdealPriceCalculationStrategy;
import prizy.service.NormalIdealPriceCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdealPriceCalculationTests
{

    @Test
    public void idealPriceAvgPriceCalculationsTest() {
        IdealPriceCalculationStrategy priceStrategy = new AverageIdealPriceCalculation();

        List<Double> prices = new ArrayList<Double>();
        long count = 10000;

        double avgExpected = 100.0;
        populatePrices(avgExpected, prices, count);

        Double idealPrice = priceStrategy.calculate(prices);
        Assert.assertTrue(Math.abs(avgExpected - idealPrice) < 10);
    }

    @Test
    public void idealPriceNormalPrice10000SamplesCalculationTest() {

        long count = 10000;
        double avgExpected = 100.0;

        assertForNormalIdealPrice(count, avgExpected);
    }

    private void assertForNormalIdealPrice(long count, double avgExpected) {
        double idealPrice = getIdealPriceFor(count, avgExpected);

        double diff = Math.abs(1.2 * avgExpected - idealPrice);
        System.out.println(diff);
        Assert.assertTrue(diff < 0.05 * avgExpected);
    }

    @Test
    public void idealPriceNormalPriceHugeSamplesHugePriceCalculationTest() {
        long count = 100000;
        double avgExpected = 10000000.0;

        assertForNormalIdealPrice(count, avgExpected);
    }

    @Test
    public void idealPriceNormalPrice2SamplesCalculationTest() {
        long count = 2;
        double avgExpected = 100.0;

        Double idealPrice = getIdealPriceFor(count, avgExpected);
        Assert.assertTrue(idealPrice == null);
    }

    private Double getIdealPriceFor(long count, double avgExpected) {
        IdealPriceCalculationStrategy priceStrategy = new NormalIdealPriceCalculation();

        List<Double> prices = new ArrayList<Double>();

        populatePrices(avgExpected, prices, count);
        Double idealPrice = priceStrategy.calculate(prices);
        return idealPrice;
    }

    private void populatePrices(double avgExpected, List<Double> prices, long count) {
        // Generate Prices around avgExpected.

        for(int i = 0; i < count; i++) {
            double newVal = new Random().nextDouble();
            double newPrice = newVal * (2 * avgExpected);
            prices.add(newPrice);
        }
    }
}
