package com.wangyu.utils.dbAssit.handler;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {

    Object handle(ResultSet rs);
}