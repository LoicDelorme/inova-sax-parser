package fr.inova.saxparser;

import static fr.inova.saxparser.parser.ContactSaxParser.parseXmlFile;

public class ContactSaxParserApplication {

    /**
     * Entry point for ContactSaxParserApplication
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) throws Exception {
        // Ensure args are well formatted
        if (args.length != 1) {
            System.out.println("`filePath` argument is missing, please refer to README.md");
            System.exit(1);
        }

        // Parse all contacts + print them all to console
        var contacts = parseXmlFile(args[0]);
        contacts.forEach(System.out::println);
    }
}
