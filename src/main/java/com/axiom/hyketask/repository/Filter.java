package com.axiom.hyketask.repository;

/**
 * This is general filtration definition, can be extended by any data filtration type, i.e.
 * database filtration (Sql, NoSql), or in memory filtration
 * @param <OUT> this is filtration criteria (can be db where condition or any type of condition)
 * @param <F> this is the filter property object
 */
public interface Filter<OUT, F>{
    OUT filter(F filter);
    boolean shouldCompute(F filter);
}
