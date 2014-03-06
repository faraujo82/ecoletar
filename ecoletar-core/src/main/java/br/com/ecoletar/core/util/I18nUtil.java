package br.com.ecoletar.core.util;

import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class I18nUtil {

	private static final Logger LOGGER = Logger.getLogger(I18nUtil.class);

	private static final String MESSAGE_FILE = "messages";
	private static final ResourceBundle bundle;
	private static final String CHARSET_UTF8 = "UTF-8";
	private static final String CHARSET_ISO = "ISO-8859-1";

	static {
		bundle = ResourceBundle.getBundle(MESSAGE_FILE, Locale.getDefault(),
				Thread.currentThread().getContextClassLoader());
	}

	private I18nUtil() {
	}

	protected static String getPattern(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("Erro ao buscar a key %s.", key));
			}
			return key;
		}
	}

	public static ResourceBundle getBundle() {
		return bundle;
	}

	public static String getTexto(String key, Object... args) {
		try {
			return MessageFormat.format(getPattern(key), args);
		} catch (Exception e) {
			LOGGER.error(String.format("Erro ao buscar a mensagem: %s.", key),
					e);
			return key;
		}
	}

	public static Locale getSystemLocale() {
		String[] locale = getTexto("system.locale").split("_");
		return new Locale(locale[0], locale[1]);
	}

	public static Charset charsetUTF8() {
		return Charset.forName(CHARSET_UTF8);
	}

	public static Charset charsetISO() {
		return Charset.forName(CHARSET_ISO);
	}

}