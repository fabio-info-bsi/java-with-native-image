package br.com.fabex.utils;

import jakarta.annotation.Nonnull;

import java.util.Objects;

public class StringUtil {

    public static int stringToInt(@Nonnull final String str) {
        Objects.requireNonNull(str, "str parameter is null");
        return Integer.parseInt(str);
    }

    public static long stringToLong(@Nonnull final String str) {
        return Long.parseLong(str);
    }

    public static long neverExecuteStringToLong(@Nonnull final String str) {
        return Long.parseLong(str);
    }

    public static class InnerStringUtil {
        public static long byPass(@Nonnull final String str) {
            return Long.parseLong(str);
        }

        public static long innerByPass(@Nonnull final String str) {
            return Long.parseLong(str);
        }
    }
}