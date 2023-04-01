package project.Interfaces;

import project.Services.Exceptions.LocaleNotSupportedException;

public interface Locale_If {
    void set(String locale) throws LocaleNotSupportedException;
    java.util.Locale get();
}
