package src;
import java.math.BigDecimal;

public class Desmosus {

	private String[] tokens;
	private int size;

	public Desmosus(String expression) {
		this.tokens = this.addSpaces(expression).split("\\s");
		this.size = this.tokens.length;
	}

	private String addSpaces(String expression) {
		return
			expression
			.replaceAll("(?<=[\\d])(?=[\\^*/+-])", " ")
			.replaceAll("(?<=[\\^*/+-])(?=[\\d])", " ")
			.replaceAll("(?<=[)])(?=[\\^*/+-])", " ")
			.replaceAll("(?<=[\\^*/+-])(?=[(])", " ")
			.replaceAll("(?<=[(])(?=[\\d])", " ")
			.replaceAll("(?<=[\\d])(?=[)])", " ")
			.replaceAll("(?<=[(])(?=[(])", " ")
			.replaceAll("(?<=[)])(?=[)])", " ");
	}


	private void removeAToken(int index) {
		while (index < (this.size - 1))
			this.tokens[ index ] = this.tokens[ 1 + (index++) ];

		this.size--;
	}


	private void removeAlreadyUsedTokens(int index) {
		for (byte i = 0; (i < 2); ++i)
			this.removeAToken(index);
	}


	private void addComputationValueOfTokens(int index, String value) {
		this.tokens[ index ] = value;
	}


	private String parenthesis(int index) {
		StringBuilder parenthesisValue = new StringBuilder();

		while (!(this.tokens[ index + 1 ].equals(")"))) {
			if (this.tokens[ index + 1 ].equals("(")) {
				parenthesisValue
				.append(this.parenthesis(index + 1))
				.append(" ");

				this.removeAToken(index + 1);

			} else {
				parenthesisValue
				.append(this.tokens[ index + 1 ])
				.append(" ");

				this.removeAToken(index + 1);
			}
		}
		this.removeAToken(index + 1);

		this.addComputationValueOfTokens(
			(index),

			new Desmosus(parenthesisValue.toString())
			.equals()
		);

		return this.tokens[ index ];
	}


	private void exponents(int index) {
		String value = new BigDecimal(this.tokens[ index - 1 ])

		.pow(Integer.parseInt(this.tokens[ index + 1 ]))
		.toString();

		this.addComputationValueOfTokens((index - 1), (value));
		this.removeAlreadyUsedTokens(index);
	}


	private void multiplication(int index) {
		String value = new BigDecimal(this.tokens[ index - 1 ])

		.multiply(new BigDecimal(this.tokens[ index + 1 ]))
		.toString();

		this.addComputationValueOfTokens((index - 1), (value));
		this.removeAlreadyUsedTokens(index);
	}


	private void division(int index) {
		String value = new BigDecimal(this.tokens[ index - 1 ])

		.divide(new BigDecimal(this.tokens[ index + 1 ]))
		.toString();

		this.addComputationValueOfTokens((index - 1), (value));
		this.removeAlreadyUsedTokens(index);
	}


	private void addition(int index) {
		String value = new BigDecimal(this.tokens[ index - 1 ])

		.add(new BigDecimal(this.tokens[ index + 1 ]))
		.toString();

		this.addComputationValueOfTokens((index - 1), (value));
		this.removeAlreadyUsedTokens(index);
	}


	private void subtraction(int index) {
		String value = new BigDecimal(this.tokens[ index - 1 ])

		.subtract(new BigDecimal(this.tokens[ index + 1 ]))
		.toString();

		this.addComputationValueOfTokens((index - 1), (value));
		this.removeAlreadyUsedTokens(index);
	}


	private String orderOfOperation() {
		if (this.size == 0)
			return null;

		if (this.size == 1)
			return this.tokens[ 0 ];

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("("))
				this.parenthesis(i--);

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("^"))
				this.exponents(i--);

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("*"))
				this.multiplication(i--);

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("/"))
				this.division(i--);

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("+"))
				this.addition(i--);

		for (int i = 0; (i < this.size); ++i)
			if (this.tokens[ i ].equals("-"))
				this.subtraction(i--);

		return this.tokens[ 0 ];
	}


	public String equals() {
		return new BigDecimal(this.orderOfOperation()).stripTrailingZeros().toString();
	}
}