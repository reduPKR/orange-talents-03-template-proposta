package br.com.proposta.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ValidadorValorUnico.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ValorUnico {
    String message() default "Campo duplicado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coluna();
    Class<?> tabela();
}
