package springcore_assignment7;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SPEL {

    /* Arithmetic Operator */
    private int num = 10;

    @Value("#{29 + 21}") // 50
    private double add;

    @Value("#{'Hello ' + 'World'}") // "Hello World"
    private String addString;

    @Value("#{29 - 1}") // 28
    private double subtract;

    @Value("#{10 * 2}") // 20
    private double multiply;

    @Value("#{36 / 2}") // 19
    private double divide;

    @Value("#{36 div 2}") // 18
    private double divideAlphabetic;

    @Value("#{37 % 10}") // 7
    private double modulo;

    @Value("#{37 mod 10}") // 7
    private double moduloAlphabetic;

    @Value("#{2 ^ 9}") // 512
    private double powerOf;

    @Value("#{(2 + 2) * 2 + 9}") // 17
    private double brackets;

    /* Relational and Logical Operators */

    @Value("#{1 == 1}") // true
    private boolean equal;

    @Value("#{1 eq 1}") // true
    private boolean equalAlphabetic;

    @Value("#{1 != 1}") // false
    private boolean notEqual;

    @Value("#{1 ne 1}") // false
    private boolean notEqualAlphabetic;

    @Value("#{1 < 1}") // false
    private boolean lessThan;

    @Value("#{1 lt 1}") // false
    private boolean lessThanAlphabetic;

    @Value("#{1 <= 1}") // true
    private boolean lessThanOrEqual;

    @Value("#{1 le 1}") // true
    private boolean lessThanOrEqualAlphabetic;

    @Value("#{1 > 1}") // false
    private boolean greaterThan;

    @Value("#{1 gt 1}") // false
    private boolean greaterThanAlphabetic;

    @Value("#{1 >= 1}") // true
    private boolean greaterThanOrEqual;

    @Value("#{1 ge 1}") // true
    private boolean greaterThanOrEqualAlphabetic;

    /* Logical Operators */

    @Value("#{250 > 200 && 200 < 4000}") // true
    private boolean and;

    @Value("#{250 > 200 and 200 < 4000}") // true
    private boolean andAlphabetic;

    @Value("#{400 > 300 || 150 < 100}") // true
    private boolean or;

    @Value("#{400 > 300 or 150 < 100}") // true
    private boolean orAlphabetic;

    @Value("#{!true}") // false
    private boolean not;

    @Value("#{not true}") // false
    private boolean notAlphabetic;

    /* Conditional Operators */

    @Value("#{2 > 1 ? 'a' : 'b'}") // "a"
    private String ternary;

//    @Value("#{someBean.someProperty ?: 'default'}") // Will inject provided string if someProperty is null
//    private String elvis;

    /* Regex */

    @Value("#{'100' matches '\\d+' }") // true
    private boolean validNumericStringResult;

    @Value("#{'100fghdjf' matches '\\d+' }") // false
    private boolean invalidNumericStringResult;

    @Value("#{'valid alphabetic string' matches '[a-zA-Z\\s]+' }") // true
    private boolean validAlphabeticStringResult;

    @Value("#{'invalid alphabetic string #$1' matches '[a-zA-Z\\s]+' }") // false
    private boolean invalidAlphabeticStringResult;





    // All Getter Functions


    public double getAdd() {
        return add;
    }

    public String getAddString() {
        return addString;
    }

    public double getSubtract() {
        return subtract;
    }

    public double getMultiply() {
        return multiply;
    }

    public double getDivide() {
        return divide;
    }

    public double getDivideAlphabetic() {
        return divideAlphabetic;
    }

    public double getModulo() {
        return modulo;
    }

    public double getModuloAlphabetic() {
        return moduloAlphabetic;
    }

    public double getPowerOf() {
        return powerOf;
    }

    public double getBrackets() {
        return brackets;
    }

    public boolean isEqual() {
        return equal;
    }

    public boolean isEqualAlphabetic() {
        return equalAlphabetic;
    }

    public boolean isNotEqual() {
        return notEqual;
    }

    public boolean isNotEqualAlphabetic() {
        return notEqualAlphabetic;
    }

    public boolean isLessThan() {
        return lessThan;
    }

    public boolean isLessThanAlphabetic() {
        return lessThanAlphabetic;
    }

    public boolean isLessThanOrEqual() {
        return lessThanOrEqual;
    }

    public boolean isLessThanOrEqualAlphabetic() {
        return lessThanOrEqualAlphabetic;
    }

    public boolean isGreaterThan() {
        return greaterThan;
    }

    public boolean isGreaterThanAlphabetic() {
        return greaterThanAlphabetic;
    }

    public boolean isGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    public boolean isGreaterThanOrEqualAlphabetic() {
        return greaterThanOrEqualAlphabetic;
    }

    public boolean isAnd() {
        return and;
    }

    public boolean isAndAlphabetic() {
        return andAlphabetic;
    }

    public boolean isOr() {
        return or;
    }

    public boolean isOrAlphabetic() {
        return orAlphabetic;
    }

    public boolean isNot() {
        return not;
    }

    public boolean isNotAlphabetic() {
        return notAlphabetic;
    }

    public String getTernary() {
        return ternary;
    }

    public boolean isValidNumericStringResult() {
        return validNumericStringResult;
    }

    public boolean isInvalidNumericStringResult() {
        return invalidNumericStringResult;
    }

    public boolean isValidAlphabeticStringResult() {
        return validAlphabeticStringResult;
    }

    public boolean isInvalidAlphabeticStringResult() {
        return invalidAlphabeticStringResult;
    }
}
