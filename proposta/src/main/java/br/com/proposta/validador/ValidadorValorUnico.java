package br.com.proposta.validador;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidadorValorUnico implements ConstraintValidator<ValorUnico, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ValorUnico params) {
        domainAttribute = params.coluna();
        klass = params.tabela();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        Assert.isTrue(list.size() <=1,"Este "+value+" já foi cadastrado no "+klass.getSimpleName());

        return list.isEmpty();
    }
}


