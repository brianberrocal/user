package com.example.user.utils;

import java.util.regex.Pattern;

public class Constants {

    public static final String STATUS_CREATED = "CREATED";
    public static final String STATUS_OK = "OK";
    public static final String STATUS_ERROR = "ERROR";
    public static final String MSG_EMAIL_EXIST = "El correo electrónico ya está en uso.";
    public static final String ID = "Id:";
    public static final String CREATED = "Created:";
    public static final String MODIFIED = "Modified:";
    public static final String LAST_LOGIN = "Last_login:";
    public static final String TOKEN = "Token:";
    public static final String ISACTIVE = "Isactive:";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@dominio\\.cl$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public static final String MSG_EMAIL_INVALID = "El formato del correo electrónico no es válido.";
    public static final String PASSWORD_INVALID= "La clave no cumple con los requisitos de formato.";
    public static final String MSG_PASSWORD_INVALID = "La contraseña no es válida. Debe contener al menos una letra mayúscula, una letra minúscula, un número y un carácter especial.";

}
