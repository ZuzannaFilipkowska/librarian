package com.librarian.model;

import java.util.UUID;

public record UserDto(UUID userId, String username) {
    public static UserDto of(final User user) {
        return new UserDto(user.getUserId(), user.getName());
    }
}
