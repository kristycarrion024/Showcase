#! /usr/bin/python
"""
Author: Kristy Carrion
Last Modified: 02/28/2013
Program: Tokenizer
This is a program that reads input from a specified file of simple math and 
logical expressions. Then the program will create tokens from the file by
breaking the simple math and the logical expressions down.
"""

import os
""" Imported to use the isfile function for checking if file exists. """

import re
""" Imported to use the compile, and split regex functions for handling input
    files. """

import sys
""" Imported to access command line arguments. """

"""
The main function that checks the number of arguments, checks to see whether
the files have the correct permissions, then separates the proper input file
into lines, of which are broken down into separate tokens.
The program will create "statements" that are determined by ';' that mark the
end of a "statement."
The following is then written to the determined output file.
Precondition: Proper arguments must be given at runtime. See usage().
Postcondition: Writes every token in every statement of which are specified by
               the runtime arguments.
Returns: None.
"""
def main():
    if(len(sys.argv) != 3):
        print("Error: Invalid Number of Arguments")
        usage()
    """
    Checks to see that the correct number of arguments are given other will it
    will print out a message to standard output and call usage().
    """
    
    if os.path.isfile(sys.argv[2]) is True:
        var = raw_input("Error: File already exists, do you want to"
                         + " overwrite (y/n)?\n").lower()
        if(var == "n" or var == "no"):
            print("Now exiting...")
            sys.exit(1)
    """
    Checks to see that the file given for output exists, then if it does it
    prompts the user if they want to overwrite the file or exit.
    """

    count          = 0
    """ Keeps a count of the number of tokens found. """
    
    
    statement      = 1
    """ Keeps a count of the number of statements found. """
    
    
    list_of_tokens = None
    """ List to store input arguments. """
    
    
    split_line     = re.compile('[\d]+|[\(\);\^*+/\-]|[!><=][=]?')
    """
    Regular expression that will match any digit [0-9] one or more time.
    OR will match any single instance of the following: ( ) ; ^ * + / -
    OR it will look for: ! > < =   Of which may be followed by a "=".
    """

    try:
        """ 
        Uses "with" to properly open and close the file, and calls the function
        "open" which will open the file with read/write permissions.
        """
        with(open(sys.argv[1], "r")) as read_file:
            try:
                with(open(sys.argv[2], "w")) as write_file:
                    write_file.write("Statement #" + str(statement) + "\n")
                    for line in read_file:
                        list_of_tokens = re.findall(split_line, line)
                        for token in list_of_tokens:
                            write_file.write("Token " + str(count) + " is " + 
                                            token + "\n")
                            count = count + 1
                            if token == ";":
                                count     = 0
                                statement = statement + 1
                                write_file.write(("-" * 66) + "\n")
                                write_file.write("Statement #" + str(statement) 
                                                + "\n")

            except IOError:
                print("Error: Could not write file.")
                read_file.close()
                write_file.close()
                usage()

            """ 
            Catches an IOError thrown by open given if the file does not have 
            the correct write permissions. Closes both files and then calls 
            usage(). 
            """

    except IOError:
        print("Error: Could not open/read file.")
        read_file.close()
        usage()

    """
    Catches an IOError thrown by open if the file does not have the proper read
    permissions.
    Closes the file and then calls usage().
    """


"""
Function that prints the proper usage of this program, then exits.
Postconditions: Message will print to standard output and the program will exit.
Returns: None.
"""

def usage():
    print("Usage: " + sys.argv[0] + " <Input File> <Output File>")
    sys.exit(1)

""" Calls the Main Function. """
main()
