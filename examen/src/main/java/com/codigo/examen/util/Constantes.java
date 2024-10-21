package com.codigo.examen.util;

public class Constantes {

    private Constantes() {

    }

    // ENTIDADES
    public static final String PERSON = "person: ";
    public static final String ADDRESS = "address: ";
    public static final String ORDER = "order: ";


    // ATRIBUTOS

    // ADDRESS
    public static final String AVENUE = "avenue: ";
    public static final String NUMBER = "number: ";
    public static final String DISTRICT = "district: ";
    public static final String PROVINCE = "province: ";
    public static final String DEPARTMENT = "department: ";

    // PERSON
    public static final String NAME = "name: ";
    public static final String LAST_NAME = "last_name: ";
    public static final String ID_NUMBER = "id_number: ";
    public static final String STATUS = "status: ";

    // ORDER
    public static final String DESCRIPTION = "description: ";
    public static final String QUANTITY = "quentity: ";

    // STATUS - PERSON
    public static final String PERSON_STATUS_ACTIVE = "Activo";
    public static final String PERSON_STATUS_INACTIVE = "Inactivo";
    public static final String PERSON_ALL_STATUS = "^((" +
            PERSON_STATUS_ACTIVE + "|" +
            PERSON_STATUS_INACTIVE + "))$";

    // STATUS - ORDER
    public static final String ORDER_STATUS_PENDING = "Pendiente";
    public static final String ORDER_STATUS_PROCESS = "Proceso";
    public static final String ORDER_STATUS_CONFIRMED = "Confirmado";
    public static final String ORDER_STATUS_DELETED = "Eliminado";
    public static final String ORDER_ALL_STATUS = "^((" +
            ORDER_STATUS_PENDING + "|" +
            ORDER_STATUS_PROCESS + "|" +
            ORDER_STATUS_CONFIRMED + "|" +
            ORDER_STATUS_DELETED + "))$";


    //VALIDACIONES
    public static final String VALIDATION_BLANK = "El campo no puede estar en blanco.";
    public static final String VALIDATION_NULL = "El campo no puede ser nulo.";
    public static final String VALIDATION_SIZE_200 = "El campo no puede tener más de 200 caracteres.";
    public static final String VALIDATION_SIZE_100 = "El campo no puede tener más de 100 caracteres.";
    public static final String VALIDATION_SIZE_50 = "El campo district no puede tener más de 50 caracteres.";
    public static final String VALIDATION_SIZE_20 = "El campo province no puede tener más de 20 caracteres.";
    public static final String VALIDATION_PERSON_STATUS = "El valor de status solo puede ser Activo o Inactivo.";
    public static final String VALIDATION_ORDER_STATUS = "El valor de status solo puede ser Pendiente, Proceso, Confirmado o Eliminado.";
    public static final String VALIDATION_MIN_1 = "Debe ser mayor o igual que 1.";

    public static final String VALIDATION_ID_NUMBER = "El número de documento ya está registrado. Debe ser único.";

    //EXCEPCIONES
    public static final String NOT_FOUND = "Entidad no encontrada.";
    public static final String NOT_FOUND_STATUS_ACTIVE = "Entidad no encontrada con el estado activo.";
    public static final String NOT_FOUND_STATUS_NOT_DELETED = "Entidad no encontrada o se encuentra con estado 'Eliminado'.";

    //HTTP STATUS
    public static final int STATUS_200 = 200;
    public static final int STATUS_201 = 201;
    public static final int STATUS_209 = 209;

    //MENSAJE
    public static final String ENTITY_DELETED = "Entidad eliminada con id: ";

    public static final String DATA_INTEGRITY = "Error de integridad de datos.";


}
