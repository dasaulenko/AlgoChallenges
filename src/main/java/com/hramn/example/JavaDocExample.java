package com.hramn.example;
/**
 * Title
 * 
 * <p>New paragraph
 * 
 * <strong>Important text</strong>
 * 
 * <ul>
 *   <li>bulleted list item</li>
 *   <li>bulleted list item</li>
 * </ul>
 * 
 * <ol>
 *   <li>nummered list item 1</li>
 *   <li>nummered list item 2</li>
 * </ol>
 * 
 * n⁰ n¹ n² n³ n⁴ n⁵ n⁶ n⁷ n⁸ n⁹ nⁿ nⁱ
 * 
 * <pre>
 * Preformatted
 * text
 * block
 * </pre>
 * 
 * {@code cache.get(10)}
 * 
 * @see <a href="https://hramn.com">
 * 		Link to source
 * </a>
 * 
 */
public class JavaDocExample {

/**
 * Method name
 * 
 * <p>Method description
 * 
 * <p>Example:
 * {@code jdexample.test(10)}
 * 
 * @param value test value
 * @return test value or {@code -1} if test value < 0
 */
	public int test(int value) {
		System.out.println("Test value: " + value);
		return value < 0 ? -1 : value;
	}
}
