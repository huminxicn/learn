package com.huminxi.service;

import com.huminxi.model.User;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/09 16:00
 */
public interface UserService {
    User createUser(String firstName, String lastName, int age);

    User queryUser();

}
