#!/bin/bash
# Author: Kristy Carrion
# Date: 03/03/2012
# This script receives two arguments, the name of the new template, and up
# to 8 arguments specifying the fields of that database template. It then
# checks that the template file exists, and creates it if it does not or
# prints a warning message if there are more than one template definition file.
# (Most of that work is exported to template_file_exists.sh). This script
# will then try to add the new template to the template definition file. 
#
# Exit Codes:
# 0: Success! [EXIT_SUCCESS]
# 1: Invalid number of arguments or incorrect command. [INCORRECT_ARGS]
# 3: File does not exists or is not a regular file. [FILE_DNE]
# 4: More than one instance of specified file has been found. [MULT_COPIES]
# 5: Unable to find or create the specified file. [FILE_DNE]
#
# Please see README.txt for more information on exist status.

readonly EXIT_SUCCESS=0
readonly INCORRECT_ARGS=1 
readonly FILE_DNE=3
readonly MULTI_COPIES=4
readonly UNABLE_FIND_CREATE=5


readonly MIN_ARGS=2
readonly MAX_ARGS=9

if [ $# -lt $MIN_ARGS ]; then
    echo "Too few arguments: $#"
    echo "Usage: $0 [TemplateName] [FieldNames...]"
    exit $INCORRECT_ARGS
fi

if [ $# -gt $MAX_ARGS ]; then
    echo "Too many arguments: $#"
    echo "Usage: $0 [FILENAME] [FIELD_NAMES...]"
    exit $INCORRECT_ARGS
fi

# Calls find_template_file to get the file name of the template definitions 
# file. If it is not a success, we print the received error message and exit.
template_file_name=`./find_template_file.sh`
if ! [ "$?" = $EXIT_SUCCESS ]; then
    echo "$template_file_name"
    exit $UNABLE_FIND_CREATE
fi

# This block quickly searches through the input received by template_file_name.
# It prints any error messages, and saves the last line (the name of the 
# template file).
temp_IFS=$IFS
IFS=$'\n'
error_message=""
next_part=""
count=0
for line in $template_file_name
do
    error_message="$error_message $next_part"
    next_part="$line"
    count=`expr $count + 1`
done
if [ $count -gt 1 ]; then
    #Special quick awk script specifically for removing the leading whitespace.
    echo "$error_message" | awk '{print substr($0, 3, 1000)}'
fi
IFS=$temp_IFS
template_file_name=$next_part

# Checks that the template does not already exist.
exists=`./template_exists.sh $template_file_name $1`
success="$?"
if ! [ "$success" -eq $FILE_DNE ]; then
    echo "Error: Template \"$1\" already exists."
    exit $MULTI_COPIES
fi

new_template="$1"
template_name="$1"
shift
for arg in $@
do
    new_template="$new_template $arg"
done

echo "$new_template" >> "$template_file_name"
echo "Template \"$template_name\" has been added to the \"$template_file_name\""
echo "template definition file."
exit $EXIT_SUCCESS

