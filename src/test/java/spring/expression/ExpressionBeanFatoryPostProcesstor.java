package spring.expression;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;

public class ExpressionBeanFatoryPostProcesstor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		StandardBeanExpressionResolver sber = (StandardBeanExpressionResolver) beanFactory.getBeanExpressionResolver();
		sber.setExpressionPrefix("%{");
		sber.setExpressionSuffix("}");
	}

}
