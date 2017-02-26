package com.github.vlshat.epam.unit02.task07;

import java.lang.annotation.Documented;

/**
 * Created by wladislaw on 26.02.17.
 */
@Documented
public @interface SubmarineAnnotation {
    String creator() default "unknown";
    int projectNumber();
    String reactorType();
    double maxSpeed();
}
