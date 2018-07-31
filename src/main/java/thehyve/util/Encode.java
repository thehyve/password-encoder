/**
 * Copyright (c) 2018 The Hyve
 * This file is distributed under the MIT License (see accompanying file LICENSE).
 */
package thehyve.util;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


/**
 * Command-line utility to encode passwords.
 * 
 * @author gijs@thehyve.nl
 */
public class Encode {

    public static final String USAGE = "Usage: Encode <passwd>";

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h", "help", false, "Help");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cl = parser.parse(options, args);
            if (cl.hasOption("help")) {
                System.err.printf(USAGE + "\n");
                return;
            }
            List<String> argList = cl.getArgList();
            if (argList.size() < 1) {
                System.err.printf("Too few parameters.\n" + USAGE + "\n");
                return;
            }
            String passwd = argList.get(0);
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            System.out.printf(encoder.encode(passwd) + "\n");
        } catch (ParseException e) {
            System.err.printf(USAGE + "\n");
            e.printStackTrace();
        }
    }

}
