package es.progcipfpbatoi.utils;

import java.lang.ref.PhantomReference;

public class Validator {

    private final static String VALIDAR_LETRAS = "^[a-zA-Z\\s]{5,20}";

    private final static String PRODUCT_CODE_REGEXP = "[b|e|m|p|]\\d{1,10}";

    private final static String ORDER_CODE_REGEXP = "o\\d{1,10}";

    private final static String LONGITUD_DNI = "^[0-9]{8,8}[A-Z]$";

    private final static String REGEX_EMAIL = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$";

    private final static String COD_POSTAL_REGREX = "^(?:0[1-9]|[1-4]\\d|5[0-2])\\d{3}$";

    private final static String TELEFONO_VALIDO = "^(\\+34|0034|34)?[6|7|9][0-9]{8}$";

    private final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{5,20}$";

    public static void main(String[] args) {
        String dni = "12345678H";
        String email = "ablofafaaw@gmail.com";
        String contrasenya = "efefeDA121@2S";  //Debe contener minúsculas, masyúsculas, números y algún caracter especial
        String nombre = "Pablo";
        String apellidos = "Torres Sala";
        String codPostal = "03786";
        String telefono = "609924637";
        System.out.println((validarDni(dni)));
        System.out.println(validarEmail(email));
        System.out.println(validarContrasenya(contrasenya));
        System.out.println(validarNombre(nombre));
        System.out.println(validarApellidos(apellidos));
        System.out.println(validarcodPostal(codPostal));
        System.out.println(validarTelefono(telefono));
    }


    public static boolean isValidProductCode(String productCode) {
        return productCode.matches(PRODUCT_CODE_REGEXP);
    }

    public static boolean isValidOrderCode(String orderCode) {
        return orderCode.matches(ORDER_CODE_REGEXP);
    }

    public static boolean validarDni(String dni) {
        if (dni.matches(LONGITUD_DNI)) {
            return true;
        }
        return false;
    }

    public static boolean validarEmail(String email) {
        if (email.matches(REGEX_EMAIL)) {
            return true;
        }
        return false;
    }

    public static boolean validarContrasenya(String password) {
        if (password.matches(REGEX_PASSWORD)) {
            return true;
        }
        return false;
    }

    public static boolean validarNombre(String nombre) {
        if (nombre.matches(VALIDAR_LETRAS)) {
            return true;
        }
        return false;
    }

    public static boolean validarApellidos(String apellidos) {
        if (apellidos.matches(VALIDAR_LETRAS)) {
            return true;
        }
        return false;
    }

    public static boolean validarcodPostal(String codigoPostal) {
        if (codigoPostal.matches(COD_POSTAL_REGREX)) {
            return true;
        }
        return false;
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono.matches(TELEFONO_VALIDO)) {
            return true;
        }
        return false;
    }
}
