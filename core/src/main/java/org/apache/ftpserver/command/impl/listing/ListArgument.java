/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ftpserver.command.impl.listing;

/**
 * Contains the parsed argument for a list command (e.g. LIST or NLST)
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Rev$, $Date$
 */
public class ListArgument {

    private String file;

    private String pattern;

    private char[] options;

    /**
     * @param file
     *            The file path including the directory
     * @param pattern
     *            A regular expression pattern that files must match
     * @param options
     *            List options, such as -la
     */
    public ListArgument(String file, String pattern, char[] options) {
        this.file = file;
        this.pattern = pattern;
        if (options == null) {
            this.options = new char[0];
        } else {
            this.options = options.clone();
        }
    }

    /**
     * The listing options,
     * 
     * @return All options
     */
    public char[] getOptions() {
        return options.clone();
    }

    /**
     * The regular expression pattern that files must match
     * 
     * @return The regular expression
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Checks if a certain option is set
     * 
     * @param option
     *            The option to check
     * @return true if the option is set
     */
    public boolean hasOption(char option) {
        for (int i = 0; i < options.length; i++) {
            if (option == options[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * The file path including the directory
     * 
     * @return The file path
     */
    public String getFile() {
        return file;
    }

}