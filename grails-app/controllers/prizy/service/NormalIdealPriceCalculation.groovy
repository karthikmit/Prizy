package prizy.service

class NormalIdealPriceCalculation implements IdealPriceCalculationStrategy{
    @Override
    Double calculate(List<Double> prices) {
        // Idea is to remove first two highest and lowest prices and take average of remaining and add 20% to it.
        List<Double> copyPrices = new LinkedList<>();
        copyPrices.addAll(prices);

        if (copyPrices.size() >= 5) {
            copyPrices.removeFirst();
            copyPrices.removeFirst();
            copyPrices.removeLast();
            copyPrices.removeLast();

            double totalPrice = 0
            for(double price : copyPrices) {
                totalPrice += price;
            }

            def avgprice = totalPrice / copyPrices.size()
            return avgprice + (0.2 * avgprice);
        }
    }
}
