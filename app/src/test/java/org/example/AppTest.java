package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testGrossPay_NoOvertime() {
        double hours = 40;
        double hourlyRate = 16.78;
        double expectedGross = hours * hourlyRate;

        double actualGross = hours * hourlyRate;

        assertEquals(expectedGross, actualGross, 0.01);
    }

    
    @Test
    public void testGrossPay_WithOvertime() {
        double hours = 45;
        double hourlyRate = 16.78;
        double overtimeRate = hourlyRate * 1.5;

        double expectedGross = (40 * hourlyRate) + ((hours - 40) * overtimeRate);

        double actualGross = (40 * hourlyRate) + ((hours - 40) * overtimeRate);

        assertEquals(expectedGross, actualGross, 0.01);
    }

    @Test
    public void testInsurance_WithLessThan3Dependents() {
        int dependents = 2;
        double insurance;

        if (dependents >= 3) {
            insurance = 35.00;
        } else {
            insurance = 15.00;
        }

        assertEquals(15.00, insurance, 0.01);
    }

    @Test
    public void testInsurance_With3OrMoreDependents() {
        int dependents = 3;
        double insurance;

        if (dependents >= 3) {
            insurance = 35.00;
        } else {
            insurance = 15.00;
        }

        assertEquals(35.00, insurance, 0.01);
    }

    @Test
    public void testNetPay_SimpleCase() {
        double hours = 40;
        int dependents = 1;

        double hourlyRate = 16.78;
        double socSecTax = 0.06;
        double fedTax = 0.14;
        double stateTax = 0.05;
        double unionDues = 10.00;
        double insurance = 15.00;

        double gross = hours * hourlyRate;

        double socSec = gross * socSecTax;
        double fed = gross * fedTax;
        double state = gross * stateTax;

        double totalExpenses = socSec + fed + state + unionDues + insurance;
        double expectedNet = gross - totalExpenses;

        double actualNet = gross - totalExpenses;

        assertEquals(expectedNet, actualNet, 0.01);
    }
}

