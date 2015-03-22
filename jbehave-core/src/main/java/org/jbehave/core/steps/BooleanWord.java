package org.jbehave.core.steps;

/**
 * Plain English expressions convertible to booleans, to be used as parameters of
 * candidate steps.
 * <p>
 * It requires {@link ParameterConverters.FluentEnumConverter} to be configured
 * as the {@link ParameterConverters.ParameterConverter} for enums.
 * <p>
 * Example of use.
 * 
 * Given the following candidate step:
 * <pre>
 * @Given("a stock of symbol $symbol $withThreshold a threshold")
 * public void aStock(String symbol, BooleanWord withThreshold) {
 *     stock = new Stock(symbol).withThreshold(withThreshold.toBoolean());
 * }
 * </pre>
 * 
 * .. it is then possible to write the following scenarios:
 * 
 * <pre>
 * Scenario: a stock with threshold
 * 
 * Given a stock of symbol AAA <b>with</b> a threshold
 * When ..
 * Then ..
 * 
 * Scenario: a stock with no threshold
 * 
 * Given a stock of symbol AAA <b>without</b> a threshold
 * When ..
 * Then ..
 * </pre>
 */
public enum BooleanWord {

    SHOULD(true),
    SHOULDN_T(false),
    SHOULD_NOT(false),
    CAN(true),
    CANNOT(false),
    CAN_T(false),
    WITH(true),
    WITHOUT(false),
    ;
    
    private boolean boolVal;

    private BooleanWord(boolean boolValue) {
        this.boolVal = boolValue;
    }

    public boolean toBoolean() {
        return boolVal;
    }

    /**
     * Just an alias to {@link #toBoolean()}.
     */
    public boolean toBool() {
        return toBoolean();
    }

}
