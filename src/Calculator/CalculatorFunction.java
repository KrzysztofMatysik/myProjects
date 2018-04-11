/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author Kriss
 */
public interface CalculatorFunction {

    double additionNumbers(double... number);

    double subtractionNumbers(double... numbers);

    double multiplicationNumbers(double... numbers);

    double divisionNumbers(double... numbers);

    /**
     * Testing how work static method in interface
     */
//    static double divisionNumbers(double... numbers) {
//
//        double results = 0;
//        for (int i = 0; i < numbers.length; i++) {
//
//            if (i == 0) {
//                results = numbers[i];
//            } else {
//                results /= numbers[i];
//            }
//        }
//
//        double formatNumber = Double.valueOf(System.out.format("%.2d%n", results).toString());
//        return formatNumber;
//    }
//    static double g(){
//        
//        FunkcjeKalkulatora.divisionNumbers(numbers);
//        return Double.MIN_VALUE;
//    }

}
