package de.gravitex.bpmtest.ejb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
@Qualifier
public @interface MyAdapter {

}
