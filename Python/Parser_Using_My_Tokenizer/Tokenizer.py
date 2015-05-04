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
def main(line_to_tokenize):
    count          = 0   
    list_of_tokens = None   
    split_line     = re.compile('[\d]+|[\(\);\^*+/\-]|[!><=][=]?')
    try:
        for line in line_to_tokenize:
            list_of_tokens = re.findall(split_line, line)
            for token in list_of_tokens:
                print("Token " + str(count) + " is " + token)
                count = count + 1

    except IOError:
        print("Error")
