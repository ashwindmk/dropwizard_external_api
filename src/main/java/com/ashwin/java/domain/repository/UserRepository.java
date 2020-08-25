package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.User;

public interface UserRepository {
    User get() throws Exception;
}
