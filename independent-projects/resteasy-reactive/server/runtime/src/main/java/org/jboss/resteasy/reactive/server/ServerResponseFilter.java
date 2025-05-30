package org.jboss.resteasy.reactive.server;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.UriInfo;

/**
 * When used on a method, then an implementation of {@link jakarta.ws.rs.container.ContainerResponseContext} is generated
 * that calls the annotated method with the proper arguments
 * <p>
 * The idea behind using this is to make it much to write a {@code ServerResponseFilter} as all the necessary information
 * is passed as arguments to the method instead of forcing the author to use a mix of {@code @Context} and programmatic CDI
 * look-ups.
 * <p>
 * An example filter could look like this:
 *
 * <pre>
 * public class CustomContainerResponseFilter {
 *
 *     private final SomeBean someBean;
 *
 *     // SomeBean will be automatically injected by CDI as long as SomeBean is a bean itself
 *     public CustomContainerResponseFilter(SomeBean someBean) {
 *         this.someBean = someBean;
 *     }
 *
 *     &#64;ServerResponseFilter
 *     public void whatever(SimplifiedResourceInfo resourceInfo) {
 *         // do something
 *     }
 * }
 * </pre>
 *
 * Methods annotated with {@code ServerResponseFilter} can declare any of the following parameters (in any order)
 * <ul>
 * <li>{@link ContainerRequestContext}
 * <li>{@link ContainerResponseContext}
 * <li>{@link ResourceInfo}
 * <li>{@link UriInfo}
 * <li>{@link SimpleResourceInfo}
 * <li>{@link Throwable} - The thrown exception - or {@code null} if no exception was thrown
 * </ul>
 *
 * The return type of the method must be either be of type {@code void} or {@code Uni<Void>}.
 * <ul>
 * <li>{@code void} should be used when filtering does not need to perform any blocking operations.
 * <li>{@code Uni<Void>} should be used when filtering needs to perform a blocking operations.
 * </ul>
 *
 * Another important thing to note is that if {@link ContainerRequestContext} is used as a request parameter, calling
 * {@code abortWith}
 * is prohibited by the JAX-RS specification.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ServerResponseFilter {

    /**
     * The priority with which this response filter will be executed
     */
    int priority() default Priorities.USER;
}
