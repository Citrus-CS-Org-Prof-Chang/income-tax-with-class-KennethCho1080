package edu.pasadena.cs.cs03b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestDummy {

    @Test
    public void testDummy() {
        assertEquals(1, Dummy.dummy());
    }

    @Test
    public void testTaxRate_10000() {
        TaxTableTools taxTool = new TaxTableTools();
        taxTool.setTaxTable(
            new int[] {0, 20000, 50000, 100000, Integer.MAX_VALUE},
            new double[] {0.0, 0.10, 0.20, 0.30, 0.40}
        );
        taxTool.setSalary(10000);
        assertEquals(0.0, taxTool.getTaxRate(), 0.0001);
    }

    @Test
    public void testTaxRate_50001() {
        TaxTableTools taxTool = new TaxTableTools();
        taxTool.setTaxTable(
            new int[] {0, 20000, 50000, 100000, Integer.MAX_VALUE},
            new double[] {0.0, 0.10, 0.20, 0.30, 0.40}
        );
        taxTool.setSalary(50001);
        assertEquals(0.20, taxTool.getTaxRate(), 0.0001); // ✅ correct rate
    }

    @Test
    public void testCalculateTax_50001() {
        TaxTableTools taxTool = new TaxTableTools();
        taxTool.setTaxTable(
            new int[] {0, 20000, 50000, 100000, Integer.MAX_VALUE},
            new double[] {0.0, 0.10, 0.20, 0.30, 0.40}
        );
        taxTool.setSalary(50001);
        assertEquals(50001 * 0.20, taxTool.calculateTax(), 0.001); // ✅ correct tax
    }
}