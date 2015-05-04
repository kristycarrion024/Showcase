#!/bin/bash

# Authors: Kristy Carrion
# Date: 02/03/2013
#
# This is a quick script with the purpose of checking permissions. This script
# receives a file name and optionally a set of permissions to check. It will
# check every permission and exit with an error status based on the findings
# of the checks. This script will always check if a file exists, regardless
# of the submitted arguments, and will not check permissions on a file that
# does not exist.
#
# Permitted Arguments:
# r: This adds a check for the read permission.
# w: This adds a check for the write permission.
# e: This adds a check for the execute permission.
# Any additional/invalid arguments will be ignored without error.

 
readonly EXIT_SUCCESS=0
readonly INVALID_ARGS=1
readonly FILE_EXISTS_PERMISSIONS=2
readonly FILE_DNE=3

readonly MIN_ARGS=1

if [ $# -lt $MIN_ARGS ]; then
    echo "Invalid number of arguments."
    echo "Usage: $0 <FileName> [OPTIONS...]"
    exit $INVALID_ARGS
fi

filename=$1
fail=0
if ! [ -f $filename ]; then
    echo "$filename does not exist or is not a regular file."
    exit $FILE_DNE
fi
shift

while [ $# -gt 0 ]
do
    if [ $1 = 'r' ]; then
        if ! [ -r $filename ]; then
            echo "Insufficient permissions to read $filename."
            fail=1
        fi
    elif [ $1 = 'w' ]; then
        if ! [ -w $filename ]; then
            echo "Insufficient permissions to write to $filename."
            fail=1
        fi
    elif [ $1 = 'x' ]; then
        if ! [ -e $filename ]; then
            echo "Insufficient permissions to execute $filename."
            fail=1
        fi
    fi
    shift
done
if [ $fail -eq 1 ]; then
    exit $FILE_EXISTS_PERMISSIONS
fi
exit $EXIT_SUCCESS
