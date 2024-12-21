package es.merlinsoftware;

import es.merlinsoftware.pojo.ProductSales;
import es.merlinsoftware.pojo.ProductStock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingScoresTest {
    @Test
    public void testHappyPath() {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));


        Long[] expectedResult1 = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals(Solution.sortProductsByScores(50, 50, productStock, productSales).toArray(),
                expectedResult1);

        // Peso al 100% al stock
        Long[] expectedResult2 = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals(Solution.sortProductsByScores(100, 0, productStock, productSales).toArray(),
                expectedResult2);

        // Peso al 100% a las ventas
        Long[] expectedResult3 = {3L, 4L, 2L, 1L};
        Assert.assertArrayEquals(Solution.sortProductsByScores(0, 100, productStock, productSales).toArray(),
                expectedResult3);

        // Peso al 80% a las ventas y 20% al stock
        Long[] expectedResult4 = {2L, 3L, 4L, 1L};
        // 1: 28000, 2: 120000, 3: 120000, 4: 120000
        // Como empatan, el id mas bajo va primero
        Assert.assertArrayEquals(Solution.sortProductsByScores(20, 80, productStock, productSales).toArray(),
                expectedResult4);

        // Peso al 80% al stock y 20% a las ventas
        Long[] expectedResult5 = {2L, 4L, 3L, 1L};
        // 1: 82000, 2: 330000, 3: 180000, 4: 255000
        Assert.assertArrayEquals(Solution.sortProductsByScores(80, 20, productStock, productSales).toArray(),
                expectedResult5);
    }
}
