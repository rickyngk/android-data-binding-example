package com.rickyngk.databinding.sample5.inject.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by duynk on 4/5/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerDataManager {
}
