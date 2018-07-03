package com.kovacic.configs.jpa;

import com.kovacic.configs.IGenericDao;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public abstract class GenericJpaDao< T extends Serializable > extends AbstractJpaDao< T > implements IGenericDao< T >{
}