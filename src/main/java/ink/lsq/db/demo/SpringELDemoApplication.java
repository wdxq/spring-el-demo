package ink.lsq.db.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@SpringBootApplication
public class SpringELDemoApplication {

	private static ExpressionParser parser;

	private static ParameterNameDiscoverer parameterNameDiscoverer;

	static {
		parser = new SpelExpressionParser();
		parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringELDemoApplication.class, args);

		try {
			Expression expression = parser.parseExpression("#str");
			String[] testMethods = parameterNameDiscoverer.getParameterNames(SpringELDemoApplication.class.getMethod("testMethod", User.class, Teacher.class, String.class));
			for (String testMethod : testMethods) {
//				System.out.println(testMethod);
			}
			EvaluationContext context = new StandardEvaluationContext();
//			if (testMethods != null) {
//				for (int i = 0; i < testMethods.length; i++) {
//					context.setVariable(testMethods[i], cic.getArgs()[i]);
//				}
//			}
			context.setVariable("user", new User("123"));
			context.setVariable("t", new Teacher("456"));
			context.setVariable("str", "789");
			context.setVariable("result", "123");
			System.out.println(expression.getValue(context));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String testMethod(User user, Teacher t, String str) {
		return user.getUserId();
	}

}
