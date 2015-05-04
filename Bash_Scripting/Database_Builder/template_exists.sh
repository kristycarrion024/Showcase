#!/bin/bash
#
# Authors: Kristy Carrion
# Date: 03/03/2013
#
# This script expects two arguments, the file name of the template definition
# file, and the name of the template to search for. If the template definition
# file does not exist, this script will continue to prompt the user for the 
# correct file name until it is found. It will then search to see if the 
# specified template exists in the template file. If it does not exist, 
# this script will exit with an error code. If more than one template exists, 
# it will also exit in error. It will exit with success if it exists and there
# is exactly one copy of it.
#
# Exit Codes:
# 0: Success. [EXIT_SUCCESS]
# 1: Incorrect arguments or invalid command. [INCORRECT_ARGS]
# 3: Files does not exist or is not a regular file. [FILE_DNE]
# 4: More than one copy of the file exists.  [MULT_COPIES]
# 
# Please see README.txt for more Exit_status.

# Checks for the correct number of arguments. Exits with error if they are 
# incorrect.

readonly EXIT_SUCCESS=0
readonly INCORRECT_ARGS=1
readonly FILE_DNE=3
readonly MULT_COPIES=4

readonly ONE_MATCHING_ENTRY=1
readonly CORRECT_ARGS=2

if ! [ "$#" -eq $CORRECT_ARGS ]; then
    echo "Incorrect number of arguments: $#"
    echo "Usage: $0 [TemplateFileName] [TemplateName]"
    exit $INCORRECT_ARGS
fi

# Checks that the template definition file name exists and is readable. It will
# not check that the template definition file is the correct template definition
# file. This section will loop until an existing file is selected.
template_file=$1
output=`./permissions_helper.sh $template_file r`
error=$?
while ! [ "$error" -eq $EXIT_SUCCESS ]
do
    echo "$output"
    echo "Please input the correct template definition file name: "
    read template_file
    output=`./permissions_helper.sh $template_file r`
    error=$?
done

# This section will search the input file for correctly formatted template 
# entries. If a matching one is found, then it will keep record of it. If 
# multiple are found, this script will print all of them and exit with error.
# If none are found, this script will exit with error. If exactly one is found,
# this script will exit success.
success=`grep "^$2 " $template_file`
count=0
temp_IFS=$IFS
IFS=$'\n'
for line in $success # Counts every line in success using \n IFS value.
do
    count=`expr $count + 1`
done
IFS=$temp_IFS # Resets the IFS value.
if [ "$count" -lt $ONE_MATCHING_ENTRY ]; then
    echo "Template $2 does not exist."
    exit $FILE_DNE #3
elif [ "$count" -gt $ONE_MATCHING_ENTRY ]; then
    echo "More than one copy of template $2 exists."
    exit $MULT_COPIES #4
else 
    echo "$2 template has been found."
    exit $EXIT_SUCCESS #0
fi
