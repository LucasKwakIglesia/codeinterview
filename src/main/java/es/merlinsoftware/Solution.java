package es.merlinsoftware;

import es.merlinsoftware.pojo.ProductSales;
import es.merlinsoftware.pojo.ProductStock;
import es.merlinsoftware.pojo.ProductWeight;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {

        List<ProductWeight> productWeights = new ArrayList<>();

        for (int i = 0; i < productsStockInformation.size(); i++) {

            Double weight = productsSalesInformation.get(i).getSalesAmount() * (salesWeight/100.0) + productsStockInformation.get(i).getAvailableStock() * (stockWeight/100.0);

            productWeights.add(new ProductWeight(productsSalesInformation.get(i).getProductId(), weight));
        }

        productWeights.sort(
                (p1, p2) -> {
                    int result = Double.compare(p2.getWeight(), p1.getWeight());
                    return result == 0 ? Long.compare(p1.getProductId(), p2.getProductId()) : result;
                }
        );

        return productWeights.stream().map(
                productWeight -> productWeight.getProductId()).collect(Collectors.toList());
    }
}
