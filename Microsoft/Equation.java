package Microsoft;

import java.util.*;

class Fraction { // Avoids floating-point trouble.
	int num, denom;

	static int gcd(int a, int b) { // Greatest common divisor.
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	Fraction(int num, int denom) { // Makes a simplified fraction.
		if (denom == 0) { // Division by zero results in
			this.num = this.denom = 0; // the fraction 0/0. We do not
		} else { // throw an error.
			int x = Fraction.gcd(num, denom);
			this.num = num / x;
			this.denom = denom / x;
		}
	}

	Fraction plus(Fraction other) {
		return new Fraction(this.num * other.denom + other.num * this.denom, this.denom * other.denom);
	}

	Fraction minus(Fraction other) {
		return this.plus(new Fraction(-other.num, other.denom));
	}

	Fraction times(Fraction other) {
		return new Fraction(this.num * other.num, this.denom * other.denom);
	}

	Fraction divide(Fraction other) {
		return new Fraction(this.num * other.denom, this.denom * other.num);
	}

	public String toString() { // Omits the denominator if possible.
		if (denom == 1) {
			return "" + num;
		}
		return num + "/" + denom;
	}
}

class Expression { // A tree node containing a value and
	Fraction value; // optionally an operator and its
	String operator; // operands.
	Expression left, right;

	static int level(String operator) {
		if (operator.compareTo("+") == 0 || operator.compareTo("-") == 0) {
			return 0; // Returns the priority of evaluation,
		} // also known as operator precedence
		return 1; // or the order of operations.
	}

	Expression(int x) { // Simplest case: a whole number.
		value = new Fraction(x, 1);
	}

	Expression(Expression left, String operator, Expression right) {
		if (operator == "+") {
			value = left.value.plus(right.value);
		} else if (operator == "-") {
			value = left.value.minus(right.value);
		} else if (operator == "*") {
			value = left.value.times(right.value);
		} else if (operator == "/") {
			value = left.value.divide(right.value);
		}
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	public String toString() { // Returns a normalized expression,
		if (operator == null) { // inserting parentheses only where
			return value.toString(); // necessary to avoid ambiguity.
		}
		int level = Expression.level(operator);
		String a = left.toString(), aOp = left.operator, b = right.toString(), bOp = right.operator;
		if (aOp != null && Expression.level(aOp) < level) {
			a = "(" + a + ")"; // Parenthesize the child only if its
		} // priority is lower than the parent's.
		if (bOp != null && Expression.level(bOp) < level) {
			b = "(" + b + ")";
		}
		return a + " " + operator + " " + b;
	}
}

public class Equation {

	// These are the parameters of the game.
	static int need = 4, min = 1, max = 9, target = 24;

	int[] terms, permutation;
	boolean[] used;
	ArrayList<String> wins = new ArrayList<String>();
	Set<String> winSet = new HashSet<String>();
	String[] operators = { "+", "-", "*", "/" };

	// Recursively break up the terms into left and right
	// portions, joining them with one of the four operators.
	ArrayList<Expression> make(int left, int right) {
		ArrayList<Expression> result = new ArrayList<Expression>();
		if (left + 1 == right) {
			result.add(new Expression(permutation[left]));
		} else {
			for (int i = left + 1; i < right; ++i) {
				ArrayList<Expression> leftSide = make(left, i);
				ArrayList<Expression> rightSide = make(i, right);
				for (int j = 0; j < leftSide.size(); ++j) {
					for (int k = 0; k < rightSide.size(); ++k) {
						for (int p = 0; p < operators.length; ++p) {
							result.add(new Expression(leftSide.get(j), operators[p], rightSide.get(k)));
						}
					}
				}
			}
		}
		return result;
	}

	// Given a permutation of terms, form all possible arithmetic
	// expressions. Inspect the results and save those that
	// have the target value.
	void formulate() {
		ArrayList<Expression> expressions = make(0, terms.length);
		for (int i = 0; i < expressions.size(); ++i) {
			Expression expression = expressions.get(i);
			Fraction value = expression.value;
			if (value.num == target && value.denom == 1) {
				String s = expressions.get(i).toString();
				if (!winSet.contains(s)) {// Check to see if an expression
					wins.add(s); // with the same normalized string
					winSet.add(s); // representation was saved earlier.
				}
			}
		}
	}

	// Permutes terms without duplication. Requires the terms to
	// be sorted. Notice how we check the next term to see if
	// it's the same. If it is, we don't return to the beginning
	// of the array.
	void permute(int termIx, int pos) {
		if (pos == terms.length) {
			return;
		}
		if (!used[pos]) {
			permutation[pos] = terms[termIx];
			if (termIx + 1 == terms.length) {
				formulate();
			} else {
				used[pos] = true;
				if (terms[termIx + 1] == terms[termIx]) {
					permute(termIx + 1, pos + 1);
				} else {
					permute(termIx + 1, 0);
				}
				used[pos] = false;
			}
		}
		permute(termIx, pos + 1);
	}

	// Start the permutation process, count the end results, display them.
	void solve(int[] terms) {
		this.terms = terms; // We must sort the terms in order for
		Arrays.sort(terms); // the permute() function to work.
		permutation = new int[terms.length];
		used = new boolean[terms.length];
		permute(0, 0);
		if (wins.size() == 0) {
			System.out.println("There are no feasible expressions.");
		} else if (wins.size() == 1) {
			System.out.println("There is one feasible expression:");
		} else {
			System.out.println("There are " + wins.size() + " feasible expressions:");
		}
		for (int i = 0; i < wins.size(); ++i) {
			System.out.println(wins.get(i) + " = " + target);
		}
	}

	// Get user input from the command line and check its validity.
	public static void main(String[] args) {
		
		int digits[] = new int[]{2,3,3,2};
		
		(new Equation()).solve(digits);
	}
}