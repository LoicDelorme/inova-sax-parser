package fr.inova.saxparser.handler;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.PrintStream;

public class ConsoleErrorHandler implements ErrorHandler {

    private static final String DEFAULT_WARNING_MESSAGE_PATTERN = "[WARN] message=[%s] at l=[%d]/c=[%d]";

    private static final String DEFAULT_ERROR_MESSAGE_PATTERN = "[ERROR] message=[%s] at l=[%d]/c=[%d]";

    private static final String DEFAULT_FATAL_MESSAGE_PATTERN = "[FATAL] message=[%s] at l=[%d]/c=[%d]";

    private final PrintStream printStream;

    public ConsoleErrorHandler(final PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        this.printStream.println(formatMessage(DEFAULT_WARNING_MESSAGE_PATTERN, exception));
    }

    @Override
    public void error(final SAXParseException exception) throws SAXException {
        this.printStream.println(formatMessage(DEFAULT_ERROR_MESSAGE_PATTERN, exception));
    }

    @Override
    public void fatalError(final SAXParseException exception) throws SAXException {
        this.printStream.println(formatMessage(DEFAULT_FATAL_MESSAGE_PATTERN, exception));
    }

    private static String formatMessage(final String messagePattern, final SAXParseException saxParseException) {
        return String.format(messagePattern, saxParseException.getMessage(), saxParseException.getLineNumber(), saxParseException.getColumnNumber());
    }
}
