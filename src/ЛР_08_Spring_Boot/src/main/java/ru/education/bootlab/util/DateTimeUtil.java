package ru.education.bootlab.util;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
public final class DateTimeUtil {
 private DateTimeUtil() {}
 /** Новый экземпляр на вызов: SimpleDateFormat не является потокобезопасным. */
 public static SimpleDateFormat getCustomFormat() {
  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
  format.setTimeZone(TimeZone.getTimeZone("UTC")); return format;
 }
}
