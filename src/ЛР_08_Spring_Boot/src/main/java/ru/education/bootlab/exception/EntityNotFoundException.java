package ru.education.bootlab.exception;
public class EntityNotFoundException extends RuntimeException {
 public EntityNotFoundException(String entity,Long id) {super(entity+" с id="+id+" не найден");}
}
