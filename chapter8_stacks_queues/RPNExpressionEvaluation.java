public class RPNExpressionEvaluation {

    public RPNExpressionEvaluation() {
    }

    public static float evaluate(String expression) {

	float result = 0;

	MyStack<Float> valueSt = new MyStack<Float>();

	String[] exps = expression.split(",");

	float a, b, r;

	for (String ex : exps) {

	    if (ex.length() == 1 && isOperand(ex.charAt(0))) {

		if (valueSt.size() < 2)
		    throw new RuntimeException("Parse Error!");

		b = valueSt.pop();
		a = valueSt.pop();
		r = operate(a, b, ex.charAt(0));

		valueSt.push(r);

	    } else {

		valueSt.push(Float.parseFloat(ex));
	    }
	}

	if (valueSt.size() != 1) {
	    throw new RuntimeException("Parse Error!");
	}

	return valueSt.pop();
    }

    private static float operate(float a, float b, char op) {
	float r = 0;

	switch (op) {
	case '+':
	    r = a + b;
	    break;
	case '-':
	    r = a - b;
	    break;
	case '*':
	    r = a * b;
	    break;
	case '/':
	    r = a / b;
	    break;
	default:
	    throw new RuntimeException("Parse Error!");

	}

	return r;
    }

    private static boolean isOperand(Character ch) {
	boolean isOperand = false;

	switch (ch) {
	case '+':
	case '-':
	case '*':
	case '/':
	    isOperand = true;
	    break;
	default:
	    isOperand = false;
	    break;
	}

	return isOperand;
    }

    public static void main(String[] args) {
	log(evaluate("3,4,*,1,2,+,+"));
	log(evaluate("1,1,+,-2,*"));
	log(evaluate("4,6,/,-2,/"));
	// log (evaluate("4,6"));
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
