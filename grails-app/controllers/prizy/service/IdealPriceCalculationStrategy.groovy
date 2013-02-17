package prizy.service

public interface IdealPriceCalculationStrategy {

    Double calculate(List<Double> doubles);
}