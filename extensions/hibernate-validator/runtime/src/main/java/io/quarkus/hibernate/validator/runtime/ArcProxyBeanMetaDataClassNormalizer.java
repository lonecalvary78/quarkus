package io.quarkus.hibernate.validator.runtime;

import org.hibernate.validator.metadata.BeanMetaDataClassNormalizer;

import io.quarkus.arc.ClientProxy;
import io.quarkus.arc.Subclass;

/**
 * In the case of a proxy generated by Arc, return the parent class.
 * <br />
 * This can have more than one level of hierarchy, for example:
 * <ul>
 * <li>When using {@code io.quarkus.test.InjectMock} or {@code io.quarkus.test.junit.mockito.InjectSpy}</li>
 * </ul>
 */
public class ArcProxyBeanMetaDataClassNormalizer implements BeanMetaDataClassNormalizer {

    @Override
    public <T> Class<? super T> normalize(Class<T> beanClass) {
        Class<? super T> targetClass = beanClass;
        while (Subclass.class.isAssignableFrom(targetClass)) {
            targetClass = targetClass.getSuperclass();
        }
        while (ClientProxy.class.isAssignableFrom(targetClass)) {
            targetClass = targetClass.getSuperclass();
        }
        return targetClass;
    }

}
