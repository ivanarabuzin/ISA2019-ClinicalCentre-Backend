package com.main.app.config;

/**
 * System constants.
 *
 */
public class Constants {

    public static final String EMAIL_LENGTH_REGEX = "{64}@{255}";

    public static final String EMAIL_REGEX = "([a-zA-Z0-9]+(?:[. _+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";

    // minimum 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

}
