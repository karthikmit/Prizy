package prizy.service

class AverageIdealPriceCalculation implements IdealPriceCalculationStrategy {

    @Override
    Double calculate(List<Double> prices) {
        double totalPrice = 0.0;

        for(double price : prices) {
            totalPrice += price;
        }

        return totalPrice / prices.size();
    }
}
