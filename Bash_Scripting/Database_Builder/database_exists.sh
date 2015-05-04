#!/bin/bash

# Author: Kristy Carrion
# Date: 03/03/2013
#
# This script expects two arguments, the name of the database file, and the
# name of the database list file which contains a list of databases in which
# to search for the specified database name. If the database file does not
# exist this program will create one and exit. If it does exist, it makes
# sure that the file has read permissions. Then if the database list file does
# exist then the program will search though it for the given database file name.
# If it finds an instance of that database then it will exit with success. 
# If it does not find the database file then it will print a message telling
# the user that no such file was found and exit unsuccessfully.
#
# Exit Codes:
# 0: Success! [EXIT_SUCCESS]
# 1: Incorrect arguments or invalid command. [INCORRECT_ARGS]
# 2: File exists, but has incorrect permissions. [FILE_EXISTS_PERMISSIONS]
# 3: File does not exist or is not a regular file. [FILE_DNE]
#
# Please see README.txt for more information on exit statuses.

readonly EXIT_SUCCESS=0
readonly INCORRECT_ARGS=1
readonly FILE_EXISTS_PERMISSIONS=2
readonly FILE_DNE=3


readonly CORRECT_ARGS=2

# If the incorrect number of arguments is given then the script will print to
# standard output a message to the user telling them, and a usage message
# showing them what arguments this script takes.
if ! [ "$#" -eq $CORRECT_ARGS ]; then
    echo "Incorrect number of arguments: $#"
    echo "Usage: $0 [DATABASE TO SEARCH FOR] [DATABASE LIST FILE]"
    exit $INCORRECT_ARGS
fi

# Calls a helper script that checks permissions on given files and catches the
# output.
output=`./permissions_helper.sh $2 r`
error=$?
# Checks the last exit status  
if ! [ "$error" = $EXIT_SUCCESS ]; then
    if [ "$error" = $FILE_DNE ]; then
        echo "$2 does not exist. Creating $2..."
        touch "$2"
        exit $FILE_DNE
    fi
    if [ "$error" = $FILE_EXISTS_PERMISSIONS ]; then
        echo "Error: $2 exists but is not readable. "
        exit $FILE_EXISTS_PERMISSIONS
    fi
else
    success=`grep "^$1 " $2`
    count=0
    temp_IFS=$IFS
    IFS=$'\n'
    for line in $success 
    do
        count=`expr $count + 1`
        if [ "$count" = 1 ]; then
            echo "Found the database \"$1\" in $2."
            IFS=$temp_IFS
            exit $EXIT_SUCCESS
        fi
    done
fi
IFS=$temp_IFS
echo "Database \"$1\" not found in $2."
exit $FILE_DNE
