#!/bin/bash

# Author: Kristy Carrion
# Date: 03/03/2013
# 
# The purpose of this program is to act as a make shift user interface.
# This program expects no command-line arguments and will print out a warning
# to the user to standard output.
# The program will prompt the user to enter "create", "template", or 
# "search". If an invalid command is given the script will tell the user and
# then exit, unsuccessfully.
# 
# Exit Status:
# INCORRECT_COMMAND = 1: Invalid Command or incorrect command given.
#
# Please see readme for full list of exit statuses not used in this file.

# Named constant for exit status 1.
readonly INCORRECT_COMMAND=1

#Variable to hold the exit status returned by the script called.
EXIT=0

# Quick warning that command line arguments will be ignored.
if [ $# -gt 0 ]; then
    echo "Warning: Command line arguments will be ignored."
fi

echo "Please enter 'create' to create a database,"
echo "'template' to create a template for a database,"
echo  "or 'search' to check if a specifed template exists."
read name
echo ""

# If create is selected, the user is prompted for two input values. Incorrect
# values will be met with a usage message from the corresponding script.
if [ "$name" = "create" ]; then
    echo "Please enter a template name and the name of the new database, "
    echo "seperated by spaces."
    read dname dlist
    echo ""
    ./create_database.sh $dname $dlist
    EXIT=$?
# If template is selected, the user is prompted for at least 2, but up to 9 
# input values. Incorrect values will be met with a usage message from the 
# corresponding script.
elif [ "$name" = "template" ]; then
    echo "Please enter a new template name and up to 8 field names (each"
    echo "divided by spaces)"
    read tname field
    echo ""
    ./create_template.sh $tname $field
    EXIT=$?
# If search is selected, the user is prompted for two input values. Incorrect
# values will be met with a usage message from the corresponding script.
elif [ "$name" = "search" ]; then
    echo "Please enter a template definition file and a template to search for,"
    echo "seperated by a space."
    read template_file search
    echo ""
    ./template_exists.sh $template_file $search
    EXIT=$?
# If incorrect input is entered, the script will exit unsuccesfully.
else
    echo "That is an invalid command."
    echo "Now exiting ..."
    exit $INCORRECT_COMMAND
fi

exit $EXIT
