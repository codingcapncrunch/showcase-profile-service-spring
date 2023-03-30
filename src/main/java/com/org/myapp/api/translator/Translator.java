package com.org.myapp.api.translator;

public abstract class Translator<T , K> {

    public T toApiModel(K domain){
        return null;
    }

    public K toDomainModel(T api){
        return null;
    }

}
